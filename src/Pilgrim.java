package bc19;

public class Pilgrim extends RobotType{

    public Pilgrim(){
        super();
        KARB_CONSTRUCTION_COST = 10;
        MOVEMENT_SPEED_SQ = 4;
        MOVEMENT_FUEL_COST_SQ = 1;
        STARTING_HEALTH = 10;
        VISION_RANGE = 100;
        ATTACK_DAMAGE = 0;
        ATTACK_RANGE_MIN = 0;
        ATTACK_RANGE_MAX = 0;
        ATTACK_FUEL_COST = 0;
    }

    public Action turn(){

    }
}