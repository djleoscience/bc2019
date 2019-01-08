

public class MyRobot extends BCAbstractRobot {

    public Action turn() {
    	int unit_type = me.unit;
    	switch(unit_type) {
    	case 0:
    		return runCastle();
    		break;
    	case 1:
    		return runChurch();
    		break;
    	case 2:
    		return runPilgrim();
    		break;
    	case 3:
    		return runCrusader();
    		break;
    	case 4:
    		return runProphet();
    		break;
    	case 5:
    		return runPreacher();
    		break;
    	default:
    		return;
    	}
    }
    
    public Action runCastle() {
		Castle c = new Castle();
		return c.turn();
    }
    
    public Action runChurch() {
		Church c = new Church();
		return c.turn();
    }
    

//    	There are four classes of robots: Pilgrims, Crusaders, Prophets, 
//    	and Preachers. Pilgrims are scouting, mining, and building robots, 
//    	while the other robots are only capable of combat and resource 
//    	transportation. 
    public Action runPilgrim() {
    	Pilgrim p = new Pilgrim();
    	return p.turn();
    }
    
    public Action runCrusader() {
    	Crusader c = new Crusader();
    	return c.turn();
    }
    
    public Action runProphet() {
    	Prophet p = new Prophet();
    	return p.turn();
    }
    
    public Action runPreacher() {
    	Preacher p = new Preacher();
    	return p.turn();
    }
    
    
}