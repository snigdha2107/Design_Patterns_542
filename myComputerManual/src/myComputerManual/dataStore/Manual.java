package myComputerManual.dataStore;

public abstract class Manual {
    
    Component[] mandatory = new Component[4];
    Component[] optional = new Component[4];
    
    public abstract void buildManual();
    public abstract void createManual();
    public abstract void print();

}
