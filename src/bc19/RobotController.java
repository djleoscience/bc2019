package bc19;

import bc19.*;

public abstract class RobotController {


  protected BCAbstractRobot robot;

  protected final int UNIT_TYPE;
  // 0 stands for Castle
  // 1 stands for Church
  // 2 stands for Pilgrim
  // 3 stands for Crusader
  // 4 stands for Prophet
  // 5 stands for Preacher


  // Fields for all robots
  protected final int KARB_CONSTRUCTION_COST;
  protected final int FUEL_CONSTRUCTION_COST;
  protected final int STARTING_HEALTH;
  protected final int VISION_RADIUS_SQ;

  //fields only for moving robots
  protected final int KARB_CAPACITY;
  protected final int FUEL_CAPACITY;
  protected final int MOVEMENT_SPEED_SQ;
  protected final int MOVEMENT_FUEL_COST_SQ;
  protected final int ATTACK_DAMAGE;
  protected final int ATTACK_RANGE_MIN_SQ;
  protected final int ATTACK_RANGE_MAX_SQ;
  protected final int ATTACK_FUEL_COST;

  protected RobotController(BCAbstractRobot robot, int UNIT_TYPE,
                            int KARB_CONSTRUCTION_COST, int FUEL_CONSTRUCTION_COST, int STARTING_HEALTH,
                            int VISION_RADIUS_SQ, int KARB_CAPACITY, int FUEL_CAPACITY, int MOVEMENT_SPEED_SQ,
                            int MOVEMENT_FUEL_COST_SQ, int ATTACK_DAMAGE, int ATTACK_RANGE_MIN_SQ,
                            int ATTACK_RANGE_MAX_SQ, int ATTACK_FUEL_COST) {
    this.robot = robot;

    this.UNIT_TYPE = UNIT_TYPE;


    this.KARB_CONSTRUCTION_COST = KARB_CONSTRUCTION_COST;
    this.FUEL_CONSTRUCTION_COST = FUEL_CONSTRUCTION_COST;
    this.STARTING_HEALTH = STARTING_HEALTH;
    this.VISION_RADIUS_SQ = VISION_RADIUS_SQ;
    this.KARB_CAPACITY = KARB_CAPACITY;
    this.FUEL_CAPACITY = FUEL_CAPACITY;
    this.MOVEMENT_SPEED_SQ = MOVEMENT_SPEED_SQ;
    this.MOVEMENT_FUEL_COST_SQ = MOVEMENT_FUEL_COST_SQ;
    this.ATTACK_DAMAGE = ATTACK_DAMAGE;
    this.ATTACK_RANGE_MIN_SQ = ATTACK_RANGE_MIN_SQ;
    this.ATTACK_RANGE_MAX_SQ = ATTACK_RANGE_MAX_SQ;
    this.ATTACK_FUEL_COST = ATTACK_FUEL_COST;
  }

  public Action turn() {
    robot.log("Error - turn method was not overridden from RobotController");
    return null;
  }

}
