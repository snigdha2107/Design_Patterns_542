package dTunesStore.dataStore;

import java.util.List;

/**
 * interface for Reader
 * read data from files
 */
public interface Reader {
	/**
	 * read from dataFile
	 * @return
	 */
	public List<MusicInfo> readInfoFromDataFile();
	/**
	 * read from search file
	 * @return
	 */
	public String readWordFromSearchFile();
}

