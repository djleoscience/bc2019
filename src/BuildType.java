package bc19;

public abstract class BuildType {
	final private int KARB_CONSTRUCTION_COST;
	final private int FUEL_CONSTRUCTION_COST;
	final private int STARTING_HEALTH;
	final private int VISION_RANGE;
	
	public BuildType() {

	}
	
	public int getKarbConstructionCost() {
		return KARB_CONSTRUCTION_COST;
	}

	public int getFuelConstructionCost() {
		return FUEL_CONSTRUCTION_COST;
	}
	
	public int getStartingHealth() {
		return STARTING_HEALTH;
	}
	
	public int getVisionRange() {
		return VISION_RANGE;
	}
	
	public abstract Action turn();
}
