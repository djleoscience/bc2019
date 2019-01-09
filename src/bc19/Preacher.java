package bc19;

// Preachers deal AOE damage.

public class Preacher extends RobotController {

  // Inherits protected member BCAbstractRobot robot

  public Preacher(BCAbstractRobot robot){
    super(robot, 5,
        30, // Karb Construction Cost
        50, // Fuel Construction Cost
        60, // Starting Health
        16, // Vision Radius (squared)
        20, // Karb carrying capacity
        100, // Fuel carrying capacity
        4, // movement speed (max squared move distance)
        3, // Movement fuel cost (per distance squared)
        20, // Attack damage (THIS UNIT SPLASHES)
        1, // Attack minimum range (squared)
        16, // Attack Maximum range (squared)
        15); // Attack fuel cost

  }

  public Action turn(){
    robot.log("Action from Preacher");
    return null;
  }
}