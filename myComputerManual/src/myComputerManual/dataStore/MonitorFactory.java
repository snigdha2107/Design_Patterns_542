package myComputerManual.dataStore;

public class MonitorFactory implements AbstractFactory {
		
	@Override
	public Component getComponent(String componentType){
		
		if("WQHD".equalsIgnoreCase(componentType)){
			return new WQHD();
		}else if("LED".equalsIgnoreCase(componentType)){
			return new LED();
		}
		return null;
	}
	
}

