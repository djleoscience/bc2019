package bc19;

public class Prophet extends RobotType{

    public Prophet(){
        super();
        KARB_CONSTRUCTION_COST = 25;
        MOVEMENT_SPEED_SQ = 4;
        MOVEMENT_FUEL_COST_SQ = 2;
        STARTING_HEALTH = 20;
        VISION_RANGE = 64;
        ATTACK_DAMAGE = 10;
        ATTACK_RANGE_MIN = 4;
        ATTACK_RANGE_MAX = 8;
        ATTACK_FUEL_COST = 25;
    }

    public Action turn(){

    }
}