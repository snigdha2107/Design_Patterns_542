package myComputerManual.dataStore;

public class SupportFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("LIMITED".equalsIgnoreCase(componentType)){
			return new SupportLimited();
		}else if("LIFETIME".equalsIgnoreCase(componentType)){
			return new SupportLifetime();
		}
		return null;
	}
	
}
