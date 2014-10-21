package myComputerManual.dataStore;

public class MemoryFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("DDR2".equalsIgnoreCase(componentType)){
			return new DDR2();
		}else if("DDR3".equalsIgnoreCase(componentType)){
			return new DDR3();
		}
		return null;
	}
	
}