package genericCheckpointing.strategy;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * 
 * Interface for XMLSerialize class
 */
public interface MSerialize {

/**
	 * @throws IOException
	 */
	public void serialize(PrintWriter w,Object obj)throws Exception;
}
