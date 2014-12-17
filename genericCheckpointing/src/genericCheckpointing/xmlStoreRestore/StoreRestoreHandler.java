package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.strategy.DeSerialize;
import genericCheckpointing.strategy.MSerialize;
import genericCheckpointing.util.SerializableObject;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Vector;


/**
 * @author Snigdha
 * This is a handler class which will have operations to open and close file
 * and the invoke method will be use to serialize and deserialize objects 
 */
public class StoreRestoreHandler implements InvocationHandler{


	public static String fileName = "checkpoint.txt";
	File outFile;
	FileWriter fWriter;
	PrintWriter pWriter;
	
	private DeSerialize deSerializer;
	private MSerialize serializer;

	public void openFile() throws Exception{
		outFile = new File (fileName);
		fWriter = new FileWriter (outFile);
		pWriter = new PrintWriter (fWriter);
		pWriter.println("<root>");
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Vector<SerializableObject> deSerList = new Vector<SerializableObject>();
		
		if("writeObj".equals(method.getName())){

			Object obj =  args[0];
			
			serializer.serialize(pWriter,obj);
			
			}else if("readObj".equals(method.getName())){
			
			deSerList = deSerializer.deSerialize();
			return deSerList;
			
		}

		return null;
	}

	public void closeFile() throws Exception{
		pWriter.println("</root>");

		fWriter.close();
		pWriter.close();
	}


	public DeSerialize getDeSerializer() {
		return deSerializer;
	}


	public void setDeSerializer(DeSerialize deSerializer) {
		this.deSerializer = deSerializer;
	}


	public MSerialize getSerializer() {
		return serializer;
	}


	public void setSerializer(MSerialize serializer) {
		this.serializer = serializer;
	}

}
