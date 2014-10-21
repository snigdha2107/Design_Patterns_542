package myComputerManual.driver;

import myComputerManual.dataStore.Manual;
import myComputerManual.dataStore.ManualStore;

import myComputerManual.util.Logger;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if( args.length != 1){
			System.out.println("Please enter value for debugger between 0 and 2");
			System.exit(1);
		}
		//Check for the null parameters
		if( !args[0].matches("[0-9]+") ){
			System.out.println(" Please enter the valid arguments");
			System.exit(1);
		}

		Logger logger = Logger.getInstance();
		logger.setLoggerValue( Integer.parseInt( args[0]));
		
                // instantiate the manual
		Manual man = new ManualStore();
                
                // build it up by user data
		man.buildManual();
                
                // create the printable manual
		man.createManual();
                
                // print
                man.print();
		
	}

}
