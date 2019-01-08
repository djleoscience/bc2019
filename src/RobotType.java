package bc19;

public abstract class RobotType extends BuildType{
    private final int KARB_CAPACITY;
    private final int FUEL_CAPACITY;
    private final int MOVEMENT_SPEED_SQ;
    private final int MOVEMENT_FUEL_COST_SQ;
    private final int ATTACK_DAMAGE;
    private final int ATTACK_RANGE_MIN;
    private final int ATTACK_RANGE_MAX;
    private final int ATTACK_FUEL_COST;

    public RobotType() {
        super();
        FUEL_CONSTRUCTION_COST = 50;
        KARB_CAPACITY = 20;
        FUEL_CAPACITY = 100;
    }

    public int getKarbCapacity(){
        return KARB_CAPACITY;
    }

    public int getFuelCarryingCapacity(){
        return FUEL_CARRYING_CAPACITY;
    }

    public int getMovementSpeedSq(){
        return MOVEMENT_SPEED_SQ;
    }

    public int getMovementFuelCostSq(){
        return MOVEMENT_FUEL_COST_SQ;
    }

    public int getAttackDamage(){
        return ATTACK_DAMAGE;
    }

    public int getAttackRange(){
        return ATTACK_RANGE;
    }

    public int getAttackFuelCost(){
        return ATTACK_FUEL_COST;
    }
}