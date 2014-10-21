package myComputerManual.util;

import java.util.*;

public class UserMenu
{
    private String greet;
    private String[] mandatoryMenu = {"---------<!Choose CPU!>----------",
                                      "---------<!Choose Memory!>----------",
                                      "---------<!Choose Disk!>----------",
                                      "---------<!Choose Graphics Card!>----------",
                                } ;
    private String[] optionalMenu = {"---------<!Choose Optical Drive!>----------",
                                     "---------<!Choose Operating System!>----------",
                                     "---------<!Choose Monitor!>----------",
                                     "---------<!Choose Support!>----------"
                                };
    
    /**
	* Accepts the input from the user
	* Returns the Hashmap based on the user choices
	*/
    Map<Integer, String[]> mandatoryComponents = new HashMap<Integer, String[]>();
    Map<Integer, String[]> optionalComponents = new HashMap<Integer, String[]>();
    
    public UserMenu()
    {
        greet = "         Order A Computer        \n";
        greet += "---------------------------------\n";
        System.out.println(greet);
        
        mandatoryComponents.put(1, new String[] {"AMD", "Intel"});
        mandatoryComponents.put(2, new String[] {"DDR2", "DDR3"});
        mandatoryComponents.put(3, new String[] {"500GB", "1TB"});
        mandatoryComponents.put(4, new String[] {"AMD-Graphics", "Nvidia"});
        
        optionalComponents.put(1, new String[] {"DVD", "BluRay"});
        optionalComponents.put(2, new String[] {"Windows", "Linux"});
        optionalComponents.put(3, new String[] {"WQHD", "LED"});
        optionalComponents.put(4, new String[] {"Limited", "LifeTime"});
    }
    
    public void display(String type, int component_id)
    {
        if (type.equals("mandatory"))
        {
            System.out.println(mandatoryMenu[component_id]);
            System.out.println("1 " + mandatoryComponents.get(component_id + 1)[0]);
            System.out.println("2 " + mandatoryComponents.get(component_id + 1)[1]);
        }
        else
        {
            System.out.println(optionalMenu[component_id]);
            System.out.println("1 " + optionalComponents.get(component_id + 1)[0]);
            System.out.println("2 " + optionalComponents.get(component_id + 1)[1]);
        }
    }
    
    public String getSelection(String type, int component_id)
    {
        int selectedOption;
        
        Scanner scan = new Scanner(System.in);
        selectedOption = scan.nextInt();
        
        if (type.equals("mandatory"))
        {
            
        	if(selectedOption > 2){
        	    System.out.println("Invalid Entry... Try Again!!!");
        	    getSelection(type,component_id);
        		return null;
        	}else{
        		String s = mandatoryComponents.get(component_id + 1)[selectedOption - 1];
            	if(selectedOption == 1) 
            	{
            		System.out.println(s);
            		System.out.println(".................................");
            		return s;
            	}
            	else if(selectedOption == 2)
            	{
            		System.out.println(s);
            		System.out.println(".................................");
            		return s;
            	}
            	return null;
        	}
        }
        else
        {
        	if(selectedOption > 2){
        		System.out.println("Skipped. No choice given.");
        		System.out.println(".................................");
        		return "";
        	}else{
        		String s = optionalComponents.get(component_id + 1)[selectedOption - 1];
            	if(selectedOption == 1) 
            	{
            		System.out.println(s);
            		System.out.println(".................................");
            		return s;
            	}
            	else if(selectedOption == 2)
            	{
            		System.out.println(s);
            		System.out.println(".................................");
            		return s;
            	}
            	return null;
        	}
        }
    }
}
