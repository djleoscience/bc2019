package bc19;

public class Crusader extends RobotController {

  // Inherits protected member BCAbstractRobot robot

  public Crusader(BCAbstractRobot robot){
    super(robot,3,
        20, // Karb Construction Cost
        50, // Fuel Construction Cost
        40, // Starting Health
        36, // Vision Radius (squared)
        20, // Karb carrying capacity
        100, // Fuel carrying capacity
        9, // movement speed (max squared move distance)
        1, // Movement fuel cost (per distance squared)
        10, // Attack damage
        1, // Attack minimum range (squared)
        16, // Attack Maximum range (squared)
        10); // Attack fuel cost

  }

  public Action turn(){
    robot.log("Action from Crusader");
    return null;
  }
}