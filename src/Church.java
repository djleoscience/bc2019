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

public class Church extends BuildType {

	public ChurchRobot() {
		BuildType();
		KARB_CONSTRUCTION_COST = 50;
		FUEL_CONSTRUCTION_COST = 200;
		STARTING_HEALTH = 50;
		VISION_RANGE = 100;
	}

	public Action turn(){

	}
}
