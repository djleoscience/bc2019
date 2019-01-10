package bc19;

import java.util.*;

// Worker unit, can't attack
// Unit number 2

public class Pilgrim extends RobotController {

  private Coord parentCastle;
  private int parentCastleID;

  boolean initialized = false; // Has performed first-time setup

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

    parentCastle = new Coord(-12, -12);
    parentCastleID = -5;
  }

  public Action turn(){

    //robot.log("Action from Pilgrim");

    if (!initialized) {

      initialize();
      initialized = true;
    }

    return null;
  }

  private void initialize() {

    Robot[] visible = robot.getVisibleRobots();
    List<Coord> castleList = new ArrayList<Coord>();

    // Try to find the closest friendly castle
    for (Robot r : visible) {
      if (r.unit == 0 && r.team == robot.me.team) {

        // Found a friendly castle, add it to the list (just in case all three friendly castles are visible from spawn

        //robot.log("Castle coords I see right now: x:"+r.x+" y:"+r.y);

        castleList.add(new Coord(r.x, r.y));
      }
    }

    parentCastle = Utils.getClosest(new Coord(robot.me.x, robot.me.y), castleList, robot);

    parentCastleID = robot.getVisibleRobotMap()[parentCastle.y][parentCastle.x];

    //robot.log("Pilgrim thinks parent castle is at => x:"+parentCastle.x+" y:"+parentCastle.y);
    //robot.log("Pilgrim thinks parent castle ID is "+parentCastleID);

  }
}