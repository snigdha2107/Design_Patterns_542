package myComputerManual.util;


/**
 * @author Snigdha Mohanty
 *  Debugger class that maintains logging information
 */

public class Logger {
    public static int DEBUG_VALUE;
	private static Logger logger = null;

	/**
	* Singleton logger getInstance method
	* returns the only one copy of itself across the whole project duting run-time
	*/
	public static Logger getInstance(){
		if( logger == null){
			logger = new Logger();
		}
		return logger;
	}
	
	/**
	 * setLoggerValue() : Takes the debug value and sets the DEBUG_VALUE
	 * return type : void
	 */
	public void setLoggerValue( int debugValue){
		DEBUG_VALUE = debugValue;
	}

	/**
	 * setLoggerValue() : Takes the debug value and sets the DEBUG_VALUE
	 * return type : void
	 */
	public int getLoggerValue( ){
		return DEBUG_VALUE ;
	}


	/**
	 * write() : Takes the debug value and prints the message accordingly
	 * return type : void
	 */
	public void write( int debugValue, String message){
		if( debugValue == DEBUG_VALUE)
			System.out.print(message);
	}
	
	public void write(String message){
		//if( debugValue == DEBUG_VALUE)
			System.out.print(message);
	}

    // accessor and mutator for DEBUG_VALUE

    // write(...) method 

}
