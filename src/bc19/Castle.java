package bc19;

// Each team starts with 1-3 castles on the map, each with initial health 100 and vision radius 100.
// Castles have all the abilities of Churches, but cannot be built, and have greater health.
// Castles also have unique communication abilities; not only can all units send messages to Castles
// for free (discussed in the Communication section), but Castles can also trade Karbonite and Fuel
// with opposing team castles.

public class Castle extends RobotController {

  boolean initialized = false; // Has performed first-time setup

  boolean verticalSymetry = false; // False for horizontal

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

  }

  public Action turn(){

    if (!initialized) {

      initialize();
      initialized = true;
    }

    return null;
  }

  private void initialize() {

    int mapSize = robot.getPassableMap().length;

    if (robot.me.team == 0) {
      // Red Team
      robot.log("Castle on red team");
    } else {
      // Blue Team
      robot.log("Castle on blue team");
    }

    robot.log("My location is => x:"+robot.me.x + " y:"+robot.me.y);

    verticalSymetry = isVerticallySymmetric();

    if (verticalSymetry) {
      robot.log("Believe map is vertically symmetric");
      robot.log("Believe enemy Castle is at position => x:"+(mapSize - 1 - robot.me.x)+" y:"+robot.me.y);
    } else {
      robot.log("Believe map is horizontally symmetric");
      robot.log("Believe enemy Castle is at position => x:"+robot.me.x+" y:"+(mapSize - 1 -robot.me.y));
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
}