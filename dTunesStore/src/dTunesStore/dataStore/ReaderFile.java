package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dTunesStore.util.Logger;

/**
 *	read data from dataFile and searchFile
 */
public class ReaderFile implements Reader {
	private File dataFile;
	private BufferedReader br;
	
	/**
	 * constructor
	 */
	public ReaderFile(String fileName) throws FileNotFoundException {
		if(Logger.getDebugValue()==4){
			System.out.println("ReaderFile constructor is called.");
		}
		dataFile = new File(fileName);
		br = new BufferedReader(new FileReader(dataFile));
	}
	
	@Override
	// read music records from dataFile
	public synchronized List<MusicInfo> readInfoFromDataFile() { // synchronized method: thread safe
		List<MusicInfo> new_MusicInfo = new ArrayList<MusicInfo>();
		try {
			String newLine;
			while ((newLine = br.readLine()) != null) { // read line from file
				if (newLine != null) {
					// split a record into 3 strings
					String[] musicInfoLine = newLine.split(" ");
					if (musicInfoLine.length == 3) {
						new_MusicInfo.add(new MusicInfo(musicInfoLine[0],
								musicInfoLine[1], musicInfoLine[2]));
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		return new_MusicInfo;
	}

	@Override
	public synchronized String readWordFromSearchFile(){	// synchronized method: thread safe
		String new_Word = null;
		try{
				String newLine = br.readLine();
				if(newLine!=null){
					new_Word = newLine;
				}
		}
		catch(IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		return new_Word;
	}


	@Override
	public String toString() {
		return "ReaderFile [dataFile=" + dataFile + ", br=" + br;
	}
}
