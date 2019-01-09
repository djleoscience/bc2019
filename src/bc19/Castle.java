package bc19;

// Each team starts with 1-3 castles on the map, each with initial health 100 and vision radius 100.
// Castles have all the abilities of Churches, but cannot be built, and have greater health.
// Castles also have unique communication abilities; not only can all units send messages to Castles
// for free (discussed in the Communication section), but Castles can also trade Karbonite and Fuel
// with opposing team castles.

public class Castle extends RobotController {

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
    robot.log("Action from Castle");
    return null;
  }
}