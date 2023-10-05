package th1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AgentProgram {
	Map<Integer, Action> moveMap = new HashMap<>();
    Random random = new Random();
	int randomNumber ;
	int score =0;
	public Action execute(Percept p) {// location, status
		
        
        moveMap.put(0, Environment.MOVE_LEFT);
        moveMap.put(1, Environment.MOVE_RIGHT);
        moveMap.put(2, Environment.MOVE_UP);
        moveMap.put(3, Environment.MOVE_DOWN);
		
		if(p.getLocationState().equals(Environment.LocationState.CLEAN)) {

			randomNumber = random.nextInt(4);
			switch (p.getAgentLocation()) {
			case Environment.LOCATION_A:
				return moveMap.get(randomNumber);
			case Environment.LOCATION_B:
				return moveMap.get(randomNumber);
			case Environment.LOCATION_C:
				return moveMap.get(randomNumber);				
			case Environment.LOCATION_D:
				return moveMap.get(randomNumber);				
			}
		} else
			
			return Environment.SUCK_DIRT;
		System.out.println("SUCK_DIRT");
		
		return NoOpAction.NO_OP;
		
	}
}