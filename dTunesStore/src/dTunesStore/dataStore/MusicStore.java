
package dTunesStore.dataStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import dTunesStore.util.Logger;

/**
 * stores musicInfo records
 */
public class MusicStore implements Store {
	private List<MusicInfo> musicList = Collections.synchronizedList(new ArrayList<MusicInfo>());	// thread safe
	private Map<String, HashSet<MusicInfo>> keywordMap = new ConcurrentHashMap<String, HashSet<MusicInfo>>();
	
	public MusicStore()
	{
		if (Logger.getDebugValue() == 4)
			System.out.println("Inside constructor of MusicStore Class.");		
	}
	
	@Override
	public void displayData() {	// display all the elements in the list
		for(int i=0; i<musicList.size(); i++){
			System.out.println(musicList.get(i));
		}
	}
	
	@Override
	public Set<MusicInfo> find(String word){
		Set<MusicInfo> tmp = null;
		if(keywordMap.containsKey(word)){
			tmp = keywordMap.get(word);
		} 
		return tmp;
	}
	
	/**
	 * add elements to musicList
	 */
	public void add(MusicInfo info){
		musicList.add(info);
		HashSet<MusicInfo> sameSongName = null;
		if(keywordMap.containsKey(info.getSongName())) {
			sameSongName = keywordMap.get(info.getSongName());
		} else {
			sameSongName = new HashSet<MusicInfo>();			
		}
		sameSongName.add(info);
		keywordMap.put(info.getSongName(), sameSongName);
		
		HashSet<MusicInfo> sameAlbumName = null;
		if(keywordMap.containsKey(info.getAlbumName())) {
			sameAlbumName = keywordMap.get(info.getAlbumName());
		} else {
			sameAlbumName = new HashSet<MusicInfo>();			
		}			
		sameAlbumName.add(info);
		keywordMap.put(info.getAlbumName(), sameAlbumName);
		
		HashSet<MusicInfo> sameSingerName = null;
		if(keywordMap.containsKey(info.getSingerName())) {
			sameSingerName = keywordMap.get(info.getSingerName());
		} else {
			sameSingerName = new HashSet<MusicInfo>();
		}
		sameSingerName.add(info);
		keywordMap.put(info.getSingerName(), sameSingerName);
	}


	
	public String toString() {
		return "MusicStore [musicList=" + musicList + "]";
	}
	
	
} // end class MusicStore





