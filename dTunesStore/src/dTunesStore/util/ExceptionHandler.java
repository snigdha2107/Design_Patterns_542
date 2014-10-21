package dTunesStore.util;



import java.io.FileNotFoundException;

import dTunesStore.dataStore.Reader;
import dTunesStore.dataStore.ReaderFile;

/**
 * class ExceptionHandler
 */
public class ExceptionHandler {

	
	public Reader handleIO(String filename) {
		Reader reader = null;
		try {
			reader = new ReaderFile(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return reader;
	}
	
	
	public int handle(String value){
		int v = -1;
		try {
			v = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			System.err.println("N and debug value must be integer.");
			System.exit(1);
		}
		return v;
	}
	
	public void handle(int arg_num){
		if(arg_num!=4){
			throw new IllegalArgumentException("Usage: inputDataFileName searchFileName N DEBUG_VALUE");
		}
	}

	
}
