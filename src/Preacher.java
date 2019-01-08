package bc19;

public class Preacher extends RobotType{

    public Preacher(){
        super();
        KARB_CONSTRUCTION_COST = 30;
        MOVEMENT_SPEED_SQ = 4;
        MOVEMENT_FUEL_COST_SQ = 3;
        STARTING_HEALTH = 60;
        VISION_RANGE = 16;
        ATTACK_DAMAGE = 20;
        ATTACK_RANGE_MIN = 1;
        ATTACK_RANGE_MAX = 4;
        ATTACK_FUEL_COST = 15;
    }

    public Action turn(){

    }
}