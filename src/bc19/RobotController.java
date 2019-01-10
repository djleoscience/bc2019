package bc19;

import java.util.*;

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
