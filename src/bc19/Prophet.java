package bc19;

// Long Range attacking unit

public class Prophet extends RobotController {

  // Inherits protected member BCAbstractRobot robot

    public Prophet(BCAbstractRobot robot){
        super(robot, 4,
            25, // Karb Construction Cost
            50, // Fuel Construction Cost
            20, // Starting Health
            64, // Vision Radius (squared)
            20, // Karb carrying capacity
            100, // Fuel carrying capacity
            4, // movement speed (max squared move distance)
            2, // Movement fuel cost (per distance squared)
            10, // Attack damage
            16, // Attack minimum range (squared)
            64, // Attack Maximum range (squared)
            25); // Attack fuel cost

    }

    public Action turn(){
      robot.log("Action from Prophet");
      return null;
    }
}