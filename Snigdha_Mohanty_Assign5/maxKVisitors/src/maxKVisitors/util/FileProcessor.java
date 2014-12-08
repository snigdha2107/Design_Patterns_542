package maxKVisitors.util;

import java.io.BufferedReader;
import java.io.FileReader;

import maxKVisitors.util.Logger;

/**
 * @author Snigdha & Pratik
 *
 */
public class FileProcessor implements FileProcessorIntf{

	private String fileName;
	
	BufferedReader br;
	
	public FileProcessor(String inputFile){
		this.fileName = inputFile;
		 Logger.write(1, getClass().getName()+": Constructor is called."+"\n");
	}

	// Opening a file
	/* (non-Javadoc)
	 * @see maxKVisitors.util.FileProcessorIntf#openFile()
	 */
	public void openFile(){
		
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (Exception e) {
			
			System.out.println("Problem occured while opening a file");
			System.exit(1);
		}		
	}

	// Reading one integer at a time from file
	/* (non-Javadoc)
	 * @see maxKVisitors.util.FileProcessorIntf#nextInt()
	 */
	public Integer nextInt(){
		
		String line;
		try {
			line = br.readLine();		
			if(line!=null){
				String[] numInt = line.split(" ");
				if(!(numInt[0].equals(""))){
					Integer num= Integer.parseInt(numInt[0]);
					return num;
				}
				else{					
					System.out.println("Check format of input file");
					System.exit(1);
				}
			}		
		} catch (Exception e) {
			System.out.println("Problem occured while reading nextline");
			System.exit(1);
		}		
		return null;
	}	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(System.getProperty("line.separator"));
		return result.toString();
	}
}
