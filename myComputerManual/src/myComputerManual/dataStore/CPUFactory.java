package myComputerManual.dataStore;

public class CPUFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("INTEL".equalsIgnoreCase(componentType)){
			return new Intel();
		}else if("AMD".equalsIgnoreCase(componentType)){
			return new AMD();
		}
		return null;
	}
	
}
