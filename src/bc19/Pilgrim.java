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

    return gradientDescent();
  }

  private Action gradientDescent() {

    int minScore = 1999999999;

    int bestXOffset = 0;
    int bestYOffset = 0;

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {

        // 3 by 3 grid

        int x = robot.me.x + i;
        int y = robot.me.y + j;

        if ( !validCoord(x, y) || !robot.getPassableMap()[y][x] || robot.getVisibleRobotMap()[y][x] != 0 ||
            (i == 0 && j == 0) ) {
          continue;
        }

        int score = churchScore(x, y);

        if (score < minScore) {
          bestXOffset = i;
          bestYOffset = j;
          minScore = score;
        }

      }
    }

    if (bestXOffset != 0 || bestYOffset != 0) {
      return robot.move(bestXOffset, bestYOffset);
    }

    // We are either already at a minimum, or something went wrong

    // TODO: finish
    // For now, just stay in place

    //robot.log("Already at min");

    return null;


  }

  private int[][] getChurchScores() {

    int[][] scores = new int[3][3];

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {

        // 3 by 3 grid

        int x = robot.me.x + i;
        int y = robot.me.y + j;

        scores[j+1][i+1] = churchScore(x, y);
      }
    }
    return scores;
  }

  private void initialize() {

    precomputeResourceCoords();

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