
package dTunesStore.dataStore;

import dTunesStore.util.Logger;


public class MusicInfo {

	private String songName, albumName, singerName;
	
	/**
	 * parameterized constructor
	 */
	public MusicInfo(String songName, String albumName, String singerName) {
		if(Logger.getDebugValue()==4){
			System.out.println("Music Info parameterized constructor is called");
		}
		this.songName = songName;
		this.albumName = albumName;
		this.singerName = singerName;
	}
	/**
	 * 
	 * @return String
	 */
	public String getSongName()
	{
		return songName;
	}
	/**
	 * 
	 * @return void
	 */
	public void setSongName(String songName)
	{
		this.songName = songName;
	}
	/**
	 * 
	 * @return String
	 */
	public String getAlbumName()
	{
		return albumName;
	}
	/**
	 * 
	 * @return void
	 */
	public void setAlbumName(String albumName)
	{
		this.albumName = albumName;
	}
	/**
	 * 
	 * @return String
	 */
	public String getSingerName()
	{
		return singerName;
	}
	/**
	 * 
	 * @return void
	 */
	public void setSingerName(String singerName)
	{
		this.singerName = singerName;
	}

	public String toString() 
	{
	return "songName=" + songName + ", albumName=" +albumName + ", singerName=" + singerName;
	} 
} // end class MusicInfo



