package myComputerManual.dataStore;

public class OpticalDriveFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("DVD".equalsIgnoreCase(componentType)){
			return new DVD();
		}else if("BluRay".equalsIgnoreCase(componentType)){
			return new BluRay();
		}
		return null;
	}
	
}
