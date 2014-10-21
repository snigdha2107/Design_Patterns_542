package myComputerManual.dataStore;

public interface AbstractFactory {

	abstract Component getComponent(String componentType);
}
