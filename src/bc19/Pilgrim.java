package bc19;

// Worker unit, can't attack

public class Pilgrim extends RobotController {

  // Inherits protected member BCAbstractRobot robot

  public Pilgrim(BCAbstractRobot robot){
    super(robot, 2,
        10, // Karb Construction Cost
        50, // Fuel Construction Cost
        10, // Starting Health
        100, // Vision Radius (squared)
        20, // Karb carrying capacity
        100, // Fuel carrying capacity
        4, // movement speed (max squared move distance)
        1, // Movement fuel cost (per distance squared)
        -1, // Attack damage
        -1, // Attack minimum range (squared)
        -1, // Attack Maximum range (squared)
        -1); // Attack fuel cost
    // Invalid values set for attack specs (this unit can't attack)

  }

  public Action turn(){
    robot.log("Action from Pilgrim");
    return null;
  }
}