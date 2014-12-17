package genericCheckpointing.driver;

import java.io.PrintWriter;
import java.util.Vector;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.strategy.MSerialize;
import genericCheckpointing.strategy.XMLDeSerialize;
import genericCheckpointing.strategy.XMLSerialize;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;


/**
 * @author Snigdha
 * This is the main driver code 
 */
public class Driver {
	
	
	/**
	 * @param args
	 */
	public static int NUM_OF_OBJECTS = 10;
	
	static Vector<SerializableObject> serList = null;
	
	public static void main(String[] args)throws Exception {

		// FIXME: read the value of checkpointFile from the command line

		
		if(args ==null || args.length < 1 || args[0].trim().isEmpty()){
			System.out.println("Please provide a ser deser oprtion");
			return;
		}
		
		ProxyCreator pc = new ProxyCreator();

		// create an instance of StoreRestoreHandler (which implements
		// the InvocationHandler

		// create a proxy
		
		StoreRestoreHandler srt = new StoreRestoreHandler();
		srt.setDeSerializer(new XMLDeSerialize("checkpoint.txt"));
		srt.setSerializer(new XMLSerialize());
		
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
				new Class[] {
						StoreI.class, RestoreI.class
				}, 
				srt
				);
		
		
		if(args[0].equals("ser")){
			serList = ser(cpointRef,srt);
			System.out.println("Vector serialized to file");			
		}else if(args[0].equals("deser")){
			Vector<SerializableObject> deSerList = deser(cpointRef,false);
			System.out.println("File desrialized to below list--");
			
			System.out.println(deSerList);
			
		}else if(args[0].equals("serdeser")){
			serList = ser(cpointRef,srt);
			Vector<SerializableObject> deSerList = deser(cpointRef,true);
			boolean b = areSerDeSerVectorsEqual(serList,deSerList);
			
			System.out.println("No of mismatched objects->"+getNoOfMismatchedObjects(serList, deSerList));
			
			System.out.println("Comparing serialized and esereialized objects, are they equal->"+b);
			
			
		}		

	}
	
	public static Vector<SerializableObject> ser(StoreRestoreI cpointRef,StoreRestoreHandler srt)throws Exception{
		MyAllTypesFirst myFirst;
		MyAllTypesSecond  mySecond;

		//Vector<SerializableObject> serList = new Vector<SerializableObject>();
		
		srt.openFile();
		
		// create a vector to store the objects being serialized
		
		Vector<SerializableObject> serList = getSerializedData();
		
		srt.openFile();
		
		for (int i=0; i< serList.size(); i++) {
			
			SerializableObject temp = serList.get(i);
			
			if(temp.getClass() == MyAllTypesFirst.class){
				((StoreI) cpointRef).writeObj((MyAllTypesFirst)serList.get(i));
			}else if(temp.getClass() == MyAllTypesSecond.class){
				((StoreI) cpointRef).writeObj((MyAllTypesSecond)serList.get(i));
			}
			
		}
		
		srt.closeFile();
		
		return serList;
	}
	
	private static Vector<SerializableObject> getSerializedData() {
		
		Vector<SerializableObject> serList = new Vector<SerializableObject>();
		
		serList.add(new MyAllTypesFirst(10,"TestStringFirst10",3.34,6L,'a'));
		serList.add(new MyAllTypesFirst(20,"TestStringFirst20",13.34,16L,'b'));
		serList.add(new MyAllTypesFirst(30,"TestStringFirst30",23.34,26L,'c'));
		serList.add(new MyAllTypesFirst(40,"TestStringFirst40",33.34,36L,'d'));
		serList.add(new MyAllTypesFirst(50,"TestStringFirst50",43.34,46L,'e'));
		serList.add(new MyAllTypesFirst(60,"TestStringFirst60",53.34,56L,'f'));
		serList.add(new MyAllTypesFirst(70,"TestStringFirst70",63.34,66L,'g'));
		serList.add(new MyAllTypesFirst(80,"TestStringFirst80",73.34,76L,'h'));
		serList.add(new MyAllTypesFirst(90,"TestStringFirst90",83.34,86L,'i'));
		serList.add(new MyAllTypesFirst(100,"TestStringFirst100",93.34,96L,'j'));
		
		serList.add(new MyAllTypesSecond(110,"TestStringSecond110",13.34,16L,'k'));
		serList.add(new MyAllTypesSecond(120,"TestStringSecond120",113.34,116L,'l'));
		serList.add(new MyAllTypesSecond(130,"TestStringSecond130",123.34,126L,'m'));
		serList.add(new MyAllTypesSecond(140,"TestStringSecond140",133.34,136L,'n'));
		serList.add(new MyAllTypesSecond(150,"TestStringSecond150",143.34,146L,'o'));
		serList.add(new MyAllTypesSecond(160,"TestStringSecond160",153.34,156L,'p'));
		serList.add(new MyAllTypesSecond(170,"TestStringSecond170",163.34,166L,'q'));
		serList.add(new MyAllTypesSecond(180,"TestStringSecond180",173.34,176L,'r'));
		serList.add(new MyAllTypesSecond(190,"TestStringSecond190",183.34,186L,'s'));
		serList.add(new MyAllTypesSecond(200,"TestStringSecond200",193.34,196L,'t'));

		
		return serList;
	}

	public static Vector<SerializableObject> deser(StoreRestoreI cpointRef,boolean serdeser){
		
		
		Vector<SerializableObject> deSerList = (Vector)((RestoreI) cpointRef).readObj();
		
		if(!serdeser) {
			Vector<SerializableObject> serList = getSerializedData();
			//System.out.println("Comparing serialized data and deserialized data, if true they are equal if false not equal");
			//System.out.println(areSerDeSerVectorsEqual(serList,deSerList));
			
			System.out.println("Desearialization, No of mismatched objects->"+getNoOfMismatchedObjects(serList, deSerList));
			
		}
		
		return deSerList;
	}

	private static boolean areSerDeSerVectorsEqual(
			Vector<SerializableObject> serList,
			Vector<SerializableObject> deSerList) {
		// TODO Auto-generated method stub
		
		if(serList == null || deSerList == null){
			return false;
		}
		
		if(serList.size() != deSerList.size()){
			return false;
		}
		
		for(int i=0;i<serList.size();i++){
			
			SerializableObject serObj = serList.get(i);
			SerializableObject deSerObj = deSerList.get(i);
			
			MyAllTypesFirst serObjF = null;
			MyAllTypesFirst deSerObjF = null;
			MyAllTypesSecond serObjS = null;
			MyAllTypesSecond deSerObjS = null;
			
			if(serObj.getClass().getName() != deSerObj.getClass().getName()){
				return false;
			}else{
				if(serObj instanceof MyAllTypesFirst){
					serObjF = (MyAllTypesFirst)serObj;
					deSerObjF = (MyAllTypesFirst)deSerObj;
					
					if(!serObjF.equals(deSerObjF)){
						return false;
					}
					
				}else if(serObj instanceof MyAllTypesSecond){
					serObjS = (MyAllTypesSecond)serObj;
					deSerObjS = (MyAllTypesSecond)deSerObj;

					if(!serObjS.equals(deSerObjS)){
						return false;
					}
				}
			}
		}
		return true;
		
	}
	
	
	private static int getNoOfMismatchedObjects(
			Vector<SerializableObject> serList,
			Vector<SerializableObject> deSerList) {
		
		int mismatchedCount = 0;
		
		// TODO Auto-generated method stub
		
		if(serList == null || deSerList == null){
			return -1;
		}
		
		if(serList.size() != deSerList.size()){
			return -1;
		}
		
		for(int i=0;i<serList.size();i++){
			
			SerializableObject serObj = serList.get(i);
			SerializableObject deSerObj = deSerList.get(i);
			
			MyAllTypesFirst serObjF = null;
			MyAllTypesFirst deSerObjF = null;
			MyAllTypesSecond serObjS = null;
			MyAllTypesSecond deSerObjS = null;
			
			if(serObj.getClass().getName() != deSerObj.getClass().getName()){
				return -1;
			}else{
				if(serObj instanceof MyAllTypesFirst){
					serObjF = (MyAllTypesFirst)serObj;
					deSerObjF = (MyAllTypesFirst)deSerObj;
					
					if(!serObjF.equals(deSerObjF)){
						mismatchedCount++;
					}
					
				}else if(serObj instanceof MyAllTypesSecond){
					serObjS = (MyAllTypesSecond)serObj;
					deSerObjS = (MyAllTypesSecond)deSerObj;

					if(!serObjS.equals(deSerObjS)){
						mismatchedCount++;
					}
				}
			}
		}
		return mismatchedCount;
		
	}
	
}
