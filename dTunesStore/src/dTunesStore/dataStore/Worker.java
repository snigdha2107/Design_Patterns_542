package dTunesStore.dataStore;



/**
 * generate threads to read file
 */
public interface Worker extends Runnable{
	/**
	 * spawn multiple threads to read file
	 * @param thread_no
	 */
	void spawnThread(int thread_no);
	/**
	 * waits for all the threads to die
	 */
	void join();	
}
