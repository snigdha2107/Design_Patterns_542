package dTunesStore.dataStore;
import java.util.ArrayList;
import java.util.List;
import dTunesStore.util.Logger;


public class PopulateWorker {
	private List<Thread> thrd_arr = new ArrayList<Thread>();
	private static Reader readFile;
	private int thread_no;
	private static Store store; 

    // Constructor takes a handle to the FileStream or the name of the file 

    //  helper class that reads from the dataFile and populates
    // the MusicStore
public PopulateWorker(Store store,Reader readFile) {
		if(Logger.getDebugValue()==4){
			System.out.println(" Populate Worker constructor is called.");
		}
		PopulateWorker.store = store;
		PopulateWorker.readFile = readFile;
	}

	@Override
	public String toString() {
		return "PopulateWorker [thrd_arr=" + thrd_arr + ", thread_no="
				+ thread_no + "]";
	}

	public void populateData() {
		List<MusicInfo> readInfoFromDataFile = readFile.readInfoFromDataFile();
		for(MusicInfo musicInfoLine : readInfoFromDataFile){
			store.add(musicInfoLine);
		}
	}


} // end class PopulateWorker