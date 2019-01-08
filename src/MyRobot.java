package bc19;

public class MyRobot extends BCAbstractRobot {
	BuildType unit;
	int unit_type;

	public MyRobot(){
		 unit_type = me.unit;
		 switch(unit_type){
			 case 0:
				 unit = new Castle();
			 	 break;
			 case 1:
				 unit = new Church();
			 	 break;
			 case 2:
				 unit = new Pilgrim();
				 break;
			 case 3:
				 unit = new Crusader();
				 break;
			 case 4:
			 	unit = new Prophet();
			 	break;
			 case 5:
			 	unit = new Preacher();
			 	break;
			 default:
				 return;
		 }
	}

	public Action turn() {
		switch(unit_type){
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
		return unit.turn();
    }
    
    public Action runChurch() {
		return unit.turn();
    }
    

//    	There are four classes of robots: Pilgrims, Crusaders, Prophets, 
//    	and Preachers. Pilgrims are scouting, mining, and building robots, 
//    	while the other robots are only capable of combat and resource 
//    	transportation. 
    public Action runPilgrim() {
    	return unit.turn();
    }
    
    public Action runCrusader() {
    	return unit.turn();
    }
    
    public Action runProphet() {
    	return unit.turn();
    }
    
    public Action runPreacher() {
    	return unit.turn();
    }
    
    
}