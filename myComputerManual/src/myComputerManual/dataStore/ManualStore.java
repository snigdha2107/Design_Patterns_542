package myComputerManual.dataStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import myComputerManual.util.Logger;
import myComputerManual.util.UserManual;
import myComputerManual.util.UserMenu;

public class ManualStore extends Manual {
    
    StringBuilder manual;
    
    private List<AbstractFactory> mandatoryFactories;
    private List<AbstractFactory> optionalFactories;
    UserMenu menu;
    Logger log;
    
    public ManualStore()
    {
        manual = new StringBuilder();
        mandatoryFactories = new ArrayList<AbstractFactory>();
        optionalFactories = new ArrayList<AbstractFactory>();
        
        mandatoryFactories.add(new CPUFactory());
        mandatoryFactories.add(new MemoryFactory());
        mandatoryFactories.add(new DiskFactory());
        mandatoryFactories.add(new GraphicsCardFactory());
        
        optionalFactories.add(new OpticalDriveFactory());
        optionalFactories.add(new OSFactory());
        optionalFactories.add(new MonitorFactory());
        optionalFactories.add(new SupportFactory());
        
        menu = new UserMenu();
        
        log = Logger.getInstance();
    }
    
    public void buildManual()
    {
        String selection;
        int i = 0;
        Iterator<AbstractFactory> itr = mandatoryFactories.iterator();
        
        while (itr.hasNext())
        {
            menu.display("mandatory", i);
            selection = menu.getSelection("mandatory", i);
            mandatory[i] = itr.next().getComponent(selection);
            i++;
        }
        
        i = 0;
        
        itr = optionalFactories.iterator();
        while (itr.hasNext())
        {
            menu.display("optional", i);
            selection = menu.getSelection("optional", i);
            optional[i] = itr.next().getComponent(selection);
            i++;
        }
    }
    
    public void createManual()
    {
        String[] manToc = {"Processor", "Memory", "Disk", "Graphics"};
        String[] optToc = {"Optical Drive", "OS", "Monitor", "Support"};
        
        manual.append("System Manual:\n");
        manual.append("\n\n----------Table Of Contents----------\n");
        
        manual.append("\n---Mandatory Components---\n");
        for (int i = 0; i < mandatory.length; i++)
        {
        	if(null != mandatory[i])
            manual.append("\n" + manToc[i] + ": " + mandatory[i].getName() + "\n");
        }
        
        manual.append("\n---Optional Components---\n");
        for (int i = 0; i < optional.length; i++)
        {
        	if(null != optional[i])
        	manual.append("\n" + optToc[i] + ": " + optional[i].getName() + "\n");
        }
        
        manual.append("\n\n----------Description----------\n");
        manual.append("\n---Mandatory Components---\n");
        for (int i = 0; i < mandatory.length; i++)
        {
        	if(null != mandatory[i])
            manual.append("\n" + manToc[i] + ": " + mandatory[i].getDescription() + "\n");
        }
        
        manual.append("\n---Optional Components---\n");
        for (int i = 0; i < optional.length; i++)
        {
        	if(null != optional[i])
            manual.append("\n" + optToc[i] + ": " + optional[i].getDescription() + "\n");
        }
        
        manual.append("\n\n----------Glossary----------\n");
        manual.append("\n---Mandatory Components---\n");
        for (int i = 0; i < mandatory.length; i++)
        {
        	if(null != mandatory[i])
            manual.append("\n" + manToc[i] + ": " + mandatory[i].getGlossary() + "\n");
        }
        
        manual.append("\n---Optional Components---\n");
        for (int i = 0; i < optional.length; i++)
        {
        	if(null != optional[i])
        		manual.append("\n" + optToc[i] + ": " + optional[i].getGlossary() + "\n");
        }
    }
    
    public void print()
    {
        //System.out.println(manual);
        
        System.out.println("----");
    	
    	Vector<Component> allComp = new Vector<Component>();
    	
        for (int i = 0; i < optional.length; i++)
        {
        	if(null != optional[i])
        	allComp.add(optional[i]);
        }
        for (int i = 0; i < mandatory.length; i++)
        {
        	if(null != mandatory[i])
        	allComp.add(mandatory[i]);
        }
    	
    	UserManual userman=new UserManual(allComp);
    	
    	if(1==Logger.DEBUG_VALUE)
    	{
    		userman.printTableContent();
    	}else if (2==Logger.DEBUG_VALUE) {
    		userman.printActualManual();
    	} else if (3==Logger.DEBUG_VALUE) {
    		userman.printGlossary();
    	}
    	
    	
    	//log.write(manual);
    }
			
}

