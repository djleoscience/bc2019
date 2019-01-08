package bc19;

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
    		return 
    	}
    }
    
    public Action runCastle() {
//    	Each team starts with 1-3 castles on the map, each 
//    	with initial health 100 and vision radius 100. Castles 
//    	have all the abilities of Churches, but cannot be built, 
//    	and have greater health. Castles also have unique 
//    	communication abilities; not only can all units send 
//    	messages to Castles for free (discussed in the Communication 
//    	section), but Castles can also trade Karbonite and Fuel 
//    	with opposing team castles.
//
//   	Each turn, a castle can offer a Barter to a castle of the 
//    	opposing team. Barters are offers to trade X Karbonite for 
//    	Y Fuel (or vice versa). Players can use this functionality 
//    	to collaborate with the opposing team for mutual benefit.
//
//    	When all of a team’s castles are destroyed, the team is 
//    	considered defeated.
    }
    
    public Action runChurch() {
    	
    }
    
    public Action runPilgrim() {
    	
    }
    
    public Action runCrusader() {
    	
    }
    
    public Action runProphet() {
    	
    }
    
    public Action runPreacher() {
    	
    }
    
    
}