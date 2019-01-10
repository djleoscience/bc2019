package bc19;

import java.util.*;

// Each team starts with 1-3 castles on the map, each with initial health 100 and vision radius 100.
// Castles have all the abilities of Churches, but cannot be built, and have greater health.
// Castles also have unique communication abilities; not only can all units send messages to Castles
// for free (discussed in the Communication section), but Castles can also trade Karbonite and Fuel
// with opposing team castles.

public class Castle extends RobotController {

  int timesCreated = 0; // Temp var to limit number of initial pilgrims

  boolean initialized = false; // Has performed first-time setup

  boolean verticalSymetry = false; // False for horizontal

  private final Coord enemyCastle;

  public Castle(BCAbstractRobot robot){
    super(robot, 0,
        -1, // Karb Construction Cost
        -1, // Fuel Construction Cost
        100, // Starting Health
        100 * 100, // Vision Radius (squared)
        -1, // Karb carrying capacity
        -1, // Fuel carrying capacity
        -1, // movement speed (max squared move distance)
        -1, // Movement fuel cost (per distance squared)
        -1, // Attack damage
        -1, // Attack minimum range (squared)
        -1, // Attack Maximum range (squared)
        -1); // Attack fuel cost
    // Invalid values used for impossible actions

    enemyCastle = new Coord();
  }

  public Action turn(){

    if (!initialized) {

      initialize();
      initialized = true;
    }

    if (timesCreated < 20) {
      timesCreated++;
      return placeRandomPilgrim();
    }

    return null;
  }

  private void initialize() {

    int mapSize = robot.getPassableMap().length;

    robot.log("Castle location is => x:"+robot.me.x + " y:"+robot.me.y);
    robot.log("Castle ID is "+robot.me.id);

    verticalSymetry = isVerticallySymmetric();

    if (verticalSymetry) {
      //robot.log("Believe map is vertically symmetric");
      //robot.log("Believe enemy Castle is at position => x:"+(mapSize - 1 - robot.me.x)+" y:"+robot.me.y);
      enemyCastle.x = mapSize - 1 - robot.me.x;
      enemyCastle.y = robot.me.y;
    } else {
      //robot.log("Believe map is horizontally symmetric");
      //robot.log("Believe enemy Castle is at position => x:"+robot.me.x+" y:"+(mapSize - 1 -robot.me.y));
      enemyCastle.x = robot.me.x;
      enemyCastle.y = mapSize - 1 - robot.me.y;
    }




  }

  private boolean isVerticallySymmetric() {

    boolean[][] passableMap = robot.getPassableMap();
    int mapSize = passableMap.length;

    for (int i = 0; i < mapSize / 2; i++) {
      for (int j = 0; j < mapSize / 2; j++) {
        if (passableMap[j][i] != passableMap[mapSize - 1 - j][i]) {
          // Has to be vertical
          return true;
        }
        if (passableMap[j][i] != passableMap[j][mapSize - 1 - i]) {
          // Has to be horizontal
          return false;
        }
      }
    }

    // As far as we can tell, map is both horizontally and vertically symmetric
    // NOTE: this does not mean that the map is both horizontally and vertically symmetric, because the enemy castle
    // will still only be placed across from us either horizontally or vertically.
    // TODO: further thought on what to do. Search party?

    // For now, just assume one way

    return true;

  }

  /**
   * For testing purposes only, randomly places pilgrims until it runs out of fuel;
   */
  private Action placeRandomPilgrim() {


    int numOpenSpaces = 0;
    List<Coord> validCoordDiff = new LinkedList<Coord>();

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {

        int x = robot.me.x + i;
        int y = robot.me.y + j;

        /*  THIS IS RIGHT, I AM JUST SPLITTING IT UP FOR DEBUGGING
        if ( !validCoord(x, y) || !robot.getPassableMap()[x][y] || robot.getVisibleRobotMap()[x][y] != 0 ||
            (i == 0 && x == 0) ) {
          continue;
        }*/

        robot.log("Checking validity of => x:"+x+" y:"+y);

        if ( !validCoord(x, y)) {
          robot.log("Skipping because invalid coord");
          continue;
        }
        if (!robot.getPassableMap()[y][x]) {
          robot.log("Skipping bc obstacle");
          continue;
        }
        if (robot.getVisibleRobotMap()[y][x] != 0) {
          robot.log("Skipping bc robot in the way");
          continue;
        }
        if ((i == 0 && j == 0)) {
          robot.log("Skipping bc center tile");
          continue;
        }

        robot.log("Valid spot found");

        numOpenSpaces++;
        validCoordDiff.add(new Coord(i, j));

      }
    }

    if (numOpenSpaces == 0) {
      robot.log("No open spaces");
      // Can't place a new pilgrim. For now, do nothing
      return null;
    }

    Coord diff = validCoordDiff.get(Utils.randRange(0, numOpenSpaces));

    robot.log("Decided to build pilgrim at => xDif:"+diff.x+" yDif:"+diff.y);

    return robot.buildUnit(2, diff.x, diff.y);



  }
}