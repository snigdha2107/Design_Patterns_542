package myComputerManual.dataStore;

public class OSFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("WINDOWS".equalsIgnoreCase(componentType)){
			return new Windows();
		}else if("LINUX".equalsIgnoreCase(componentType)){
			return new Linux();
		}
		return null;
	}
	
}

