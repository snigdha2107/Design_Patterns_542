package myComputerManual.dataStore;

public class GraphicsCardFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("AMD-Graphics".equalsIgnoreCase(componentType)){
			return new GraphicsAMD();
		}else if("NVIDIA".equalsIgnoreCase(componentType)){
			return new GraphicsNvidia();
		}
		return null;
	}
	
}

