package bc19;

//    	Churches are structures with the ability to produce robots
//    	for their Karbonite and Fuel cost. In any given turn a church
//    	can spawn a robot in any adjacent square, with that robot
//    	added to the end of the turn queue. Robots adjacent to churches
//    	in their turn can deposit Fuel and Karbonite, adding those
//    	resources to the team's global stores.
//
//    	Churches can be constructed by Pilgrims for 50 Karbonite and 200
//    	Fuel, and have an initial starting health of 50 and a vision
//    	radius of 100.

public class Church extends RobotController {

  public Church(BCAbstractRobot robot){
    super(robot, 1,
        50, // Karb Construction Cost
        200, // Fuel Construction Cost
        50, // Starting Health
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
    robot.log("Action from Church");
    return null;
  }
}
