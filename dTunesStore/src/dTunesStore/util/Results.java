package dTunesStore.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import dTunesStore.dataStore.MusicInfo;
import dTunesStore.dataStore.Store;

/**
 * store results
 */

public class Results implements Store {
	private List<MusicInfo> results_arr = Collections.synchronizedList(new ArrayList<MusicInfo>());	// thread safe

	public Results()
	{
		int dg = Logger.getDebugValue();
		if(dg>3)
			System.out.println("Inside constructor of Results Class.");		
	}
	@Override
	public void displayData() {
		for(int i=0; i<results_arr.size(); i++){
			System.out.println(results_arr.get(i));
		}
	}

	@Override
	public void add(MusicInfo info) {
		try
		{
		results_arr.add(info);
		if(Logger.getDebugValue()==2)
			System.out.println("An entry is added to results List."+info.toString());
		}
		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
		}
		
		}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		int i;
		for(i=0; i<results_arr.size() - 1; i++){
			sb.append(results_arr.get(i));
			sb.append(System.getProperty("line.separator"));
		}
		sb.append(results_arr.get(i));
		return sb.toString();
	}

	@Override
	public Set<MusicInfo> find(String word) {
		throw new UnsupportedOperationException("Illegal invocation.");
	}


}


