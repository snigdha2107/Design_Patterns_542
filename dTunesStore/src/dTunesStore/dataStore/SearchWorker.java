package dTunesStore.dataStore;

import dTunesStore.util.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SearchWorker implements Worker {

private List<Thread> thrd_arr = new ArrayList<Thread>();
	private static final int SIZE = 5;
	private int thread_no;
	private static Reader readFile;
	private static Store store;
	private static Store results;
	
	
	/**
	 * @param readFile
	 * default constructor
	 */
	public SearchWorker() {
		if(Logger.getDebugValue()==4){
			System.out.println("SearchWorker default constructor");
		}
	}

	/**
	 * public constructor
	 */
	public SearchWorker(Store results, Store store, Reader readFile) {
		if(Logger.getDebugValue()==4){
			System.out.println("SearchWorker parameterized constructor");
		}
		SearchWorker.results = results;
		SearchWorker.store = store;
		SearchWorker.readFile = readFile;
	}

	@Override
	public void spawnThread(int thread_no) {
		this.thread_no = thread_no;
		Runnable runner = null;
		Thread t = null;
		
		if(thread_no<1||thread_no>SIZE){
			throw new IllegalArgumentException("thread number should be between 1 and 5");
		}
		
		for(int i=0; i<thread_no; i++){
			runner = new SearchWorker();
			t = new Thread(runner);
			thrd_arr.add(t);
			
		}
		
		for(int i=0; i<thread_no; i++){
			thrd_arr.get(i).start();
		}
	}

    public void run() {
	// PLACEHOLDER
    	if(Logger.getDebugValue()==3){
    		System.out.println("run() of " + Thread.currentThread().getName() +" is called.");
		}

		String word;
		Set<MusicInfo> info_found;
		while((word=readFile.readWordFromSearchFile())!=null){
			info_found=store.find(word);
			if(info_found!=null) {
				Iterator<MusicInfo> iter = info_found.iterator();
				while (iter.hasNext()) {
					results.add(iter.next());
				}					
			}				
		}
    } // end run(...)

@Override
	public void join() {
		for(int i=0; i<thread_no; i++){
			try {
				thrd_arr.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}


	@Override
	public String toString() {
		return "SearchWorker [thrd_arr=" + thrd_arr + ", thread_no="
				+ thread_no + "]";
	}

} // end class SearchWorker



