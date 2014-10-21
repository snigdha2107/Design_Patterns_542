package myComputerManual.dataStore;

public class DiskFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("500GB".equalsIgnoreCase(componentType)){
			return new HD500gb();
		}else if("1TB".equalsIgnoreCase(componentType)){
			return new HD1TB();
		}
		return null;
	}
	
}

