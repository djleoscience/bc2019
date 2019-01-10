package bc19;


import java.util.*;


import bc19.*;


public abstract class RobotController {

  List<Coord> fuelCoords = new LinkedList<Coord>();
  List<Coord> karboniteCoords = new LinkedList<Coord>();
  public boolean resourceCoordsComputed = false;

    protected BCAbstractRobot robot;

    protected final int UNIT_TYPE;
    // 0 stands for Castle
    // 1 stands for Church
    // 2 stands for Pilgrim
    // 3 stands for Crusader
    // 4 stands for Prophet
    // 5 stands for Preacher


    // Fields for all robots
    protected final int KARB_CONSTRUCTION_COST;
    protected final int FUEL_CONSTRUCTION_COST;
    protected final int STARTING_HEALTH;
    protected final int VISION_RADIUS_SQ;

    //fields only for moving robots
    protected final int KARB_CAPACITY;
    protected final int FUEL_CAPACITY;
    protected final int MOVEMENT_SPEED_SQ;
    protected final int MOVEMENT_FUEL_COST_SQ;
    protected final int ATTACK_DAMAGE;
    protected final int ATTACK_RANGE_MIN_SQ;
    protected final int ATTACK_RANGE_MAX_SQ;
    protected final int ATTACK_FUEL_COST;

    protected RobotController(BCAbstractRobot robot, int UNIT_TYPE,
                              int KARB_CONSTRUCTION_COST, int FUEL_CONSTRUCTION_COST, int STARTING_HEALTH,
                              int VISION_RADIUS_SQ, int KARB_CAPACITY, int FUEL_CAPACITY, int MOVEMENT_SPEED_SQ,
                              int MOVEMENT_FUEL_COST_SQ, int ATTACK_DAMAGE, int ATTACK_RANGE_MIN_SQ,
                              int ATTACK_RANGE_MAX_SQ, int ATTACK_FUEL_COST) {
        this.robot = robot;

        this.UNIT_TYPE = UNIT_TYPE;


        this.KARB_CONSTRUCTION_COST = KARB_CONSTRUCTION_COST;
        this.FUEL_CONSTRUCTION_COST = FUEL_CONSTRUCTION_COST;
        this.STARTING_HEALTH = STARTING_HEALTH;
        this.VISION_RADIUS_SQ = VISION_RADIUS_SQ;
        this.KARB_CAPACITY = KARB_CAPACITY;
        this.FUEL_CAPACITY = FUEL_CAPACITY;
        this.MOVEMENT_SPEED_SQ = MOVEMENT_SPEED_SQ;
        this.MOVEMENT_FUEL_COST_SQ = MOVEMENT_FUEL_COST_SQ;
        this.ATTACK_DAMAGE = ATTACK_DAMAGE;
        this.ATTACK_RANGE_MIN_SQ = ATTACK_RANGE_MIN_SQ;
        this.ATTACK_RANGE_MAX_SQ = ATTACK_RANGE_MAX_SQ;
        this.ATTACK_FUEL_COST = ATTACK_FUEL_COST;
    }

    public Action turn() {
        robot.log("Error - turn method was not overridden from RobotController");
        return null;
    }

    public Node getDirectionsTo(int fromX, int fromY, int toX, int toY) {
        //get map
        boolean[][] map = robot.getPassableMap();

        //make list for openList, need to find min each time so O(n) to get find min and O(1) to append
        //make boolean matrix for closedList, need to find if spot has been taken so O(1) to find and O(1) to "append"
        ArrayList<Node> openList = new ArrayList<Node>();
        boolean[][] closedList = new boolean[map.length][map[0].length];


        //add first node
        openList.add(new Node(fromX, fromY, toX, toY));

        //keep going while openList has stuff in it
        while (openList.size() != 0) {
            //get the minimum value of f within the openList
            Node selected = openList.get(0);
            int minSpot = 0;
            for(int i = 0; i < openList.size(); i++){
                if(openList.get(i).getF() < selected.getF()){
                    selected = openList.get(i);
                    minSpot = i;
                }
            }
            //remove the min, add it to the closedList
            openList.remove(minSpot);
            closedList[selected.getX()][selected.getY()] = true;

            //if this value is our ending point, return the final node
            if(selected.getX() == toX && selected.getY() == toY){
                return selected;
            }

            //for each of the possible next paths from this point
            for(int i = 0; i * i < MOVEMENT_SPEED_SQ; i++){
                int j = 0;
                while(j * j + i * i < MOVEMENT_SPEED_SQ){
                    for(int m = -1; m < 2; m += 2){
                        for(int n = -1; n < 2; n += 2){
                            //add difference to x and y values
                            int newX = selected.getX() + (i * m);
                            int newY = selected.getY() + (j * n);

                            //if the spot isn't the same and the place is transversable (lol is that a word)
                            //and if it's not in the closed list
                            if((!(i == 0 && j == 0)) && newX < map.length && newY < map.length && newX > -1 && newY > -1 &&  map[newY][newX]){
                                //if it's not on the closedList, see if it's on the open list but better
                                if(!closedList[newX][newY]){
                                    boolean foundOneGreater = false;
                                    for(int x = 0; x < openList.size(); i++){
                                        if(openList.get(x).equals(newX, newY)){
                                            //if the count is less than one on the open list that's at the same position
                                            if(selected.getCount() + 1 < openList.get(x).getCount()){
                                                //remove that Node and get it replaced
                                                openList.remove(x);
                                            }
                                            else {
                                                //else set a flag that we shouldn't add this one in
                                                foundOneGreater = true;
                                            }
                                            //stop the for loop
                                            x = openList.size();
                                        }
                                    }
                                    //if not found one greater then add it to the open list
                                    if(!foundOneGreater){
                                        openList.add(new Node(newX, newY, selected, toX, toY));
                                    }
                                }
                            }
                        }
                    }
                    //increment j
                    j++;
                }
            }
        }
        return null;
    }

  protected boolean validCoord(int x, int y) {
    int mapSize = robot.getPassableMap().length;
    return ( x >=0 && x < mapSize && y >= 0 && y < mapSize );
  }



  protected int churchScore(int x, int y) {

    if (!resourceCoordsComputed) {
      robot.log("Can't calculate score - no precomputations done");
    }

    double fuelScore = 0;

    for (Coord c : fuelCoords) {
      int xDif = x - c.x;
      int yDif = y - c.y;
      fuelScore += Math.log(xDif * xDif + yDif * yDif);
      //fuelScore += xDif * xDif + yDif * yDif;

    }

    double karbScore = 0;

    for (Coord c : karboniteCoords) {
      int xDif = x - c.x;
      int yDif = y - c.y;
      karbScore += Math.log(xDif * xDif + yDif * yDif);
      //karbScore += xDif * xDif + yDif * yDif;

    }


    int result = (int) (2.0d * karbScore + 2.0d * fuelScore);

    return result;

  }

  protected void precomputeResourceCoords() {

    if (resourceCoordsComputed) return;

    boolean[][] fuelMap = robot.getFuelMap();
    boolean[][] karboniteMap = robot.getKarboniteMap();

    for (int i = 0; i < fuelMap.length; i++) {
      for (int j = 0; j < fuelMap[i].length; j++) {
        if (fuelMap[j][i]) {
          // Found fuel
          fuelCoords.add(new Coord(i, j));
        } else if (karboniteMap[j][i]) {
          // Found karbonite
          karboniteCoords.add(new Coord(i, j));
        }

      }
    }

    resourceCoordsComputed = true;
  }

}
