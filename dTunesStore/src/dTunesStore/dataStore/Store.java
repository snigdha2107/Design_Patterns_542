package dTunesStore.dataStore;

import java.util.Set;

/**
* interface that
* stores data read from file
*/

public interface Store {

/**
	 * print all the data  to stdout
	 */
	void displayData();
/** 
* add an info to arrayList
*/
	void add(MusicInfo info);
/**
	 * search to find if words from searchFile
	 * matches the records in MusicStore
	 * @param word
	 */
	Set<MusicInfo> find(String word);
}
