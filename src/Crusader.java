package bc19;

public class Crusader extends RobotType{

    public Crusader(){
        super();
        KARB_CONSTRUCTION_COST = 20;
        MOVEMENT_SPEED_SQ = 9;
        MOVEMENT_FUEL_COST_SQ = 1;
        STARTING_HEALTH = 40;
        VISION_RANGE = 36;
        ATTACK_DAMAGE = 10;
        ATTACK_RANGE_MIN = 1;
        ATTACK_RANGE_MAX = 4;
        ATTACK_FUEL_COST = 10;
    }

    public Action turn(){

    }
}