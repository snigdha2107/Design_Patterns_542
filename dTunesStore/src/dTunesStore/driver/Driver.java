package dTunesStore.driver;

import dTunesStore.dataStore.Reader;
import dTunesStore.dataStore.PopulateWorker;
import dTunesStore.dataStore.MusicStore;
import dTunesStore.dataStore.SearchWorker;
import dTunesStore.dataStore.Store;
import dTunesStore.util.ExceptionHandler;
import dTunesStore.util.Logger;
import dTunesStore.util.Results;

/**
 * driver
 */
public class Driver {
	public static void main(String[] args){
		
		ExceptionHandler handler = new ExceptionHandler();	// new exception hander
		
		handler.handle(args.length);	// make sure the arguments are in proper format
		
		// handle and pass arguments
		String inputDataFileName = args[0];
		String SearchFileName = args[1];
		int MM = handler.handle(args[2]);
		int debug_value = Integer.parseInt(args[3]);
		
		Logger.setDebug_value(debug_value);	// set debug value
		
		
		Store store = new MusicStore();	// to store data from dataFile
		Reader reader = handler.handleIO(inputDataFileName);	// reader to read dataFile
		PopulateWorker pop = new PopulateWorker(store, reader);	// create a PopulateWorker instance
		/*pop.spawnThread(NN);	// spawn NN threads and read from file
		pop.join();	// join on the threads that are created*/
		pop.populateData();
		
		
		Reader srch_reader = handler.handleIO(SearchFileName);	// reader to read searchFile
		Store results = new Results();	// to store search results
		
		// create a searchWorker instance
		SearchWorker search = new SearchWorker(results, store, srch_reader);	
		search.spawnThread(MM);	// spawn MM threads to read from file
		search.join();	// join on the threads that are created
		
		
		// if debug value is 1, print search results
		if(Logger.getDebugValue()==1){
			System.out.println("search results"+results.toString());
		}
		
		System.out.println("Results from Driver");
		
		results.displayData();	// print search results
}
}