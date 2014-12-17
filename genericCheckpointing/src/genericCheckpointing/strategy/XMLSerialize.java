package genericCheckpointing.strategy;

import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Field;

/*Serialize class that Serialize data and generate checkpoint.txt */
public class XMLSerialize implements MSerialize{

	@Override
	public void serialize(PrintWriter pWriter, Object obj)throws Exception {
		pWriter.println ("<DPSerialization>");
		pWriter.println (" <complexType xsi:type=\""+obj.getClass().getName()+"\">");
		for (Field field : obj.getClass().getDeclaredFields()) {

			field.setAccessible(true); // You might want to set modifier to public first.
			Object value = field.get(obj); 

			String typeName = field.getGenericType().toString();

			if(typeName.equals("class java.lang.String")){
				typeName = "string";
			}

			if (value != null) {
				pWriter.println ("  <"+field.getName()+" xsi:type=\"xsd:"+typeName+"\">"+value+"</"+field.getName()+">");
			}
		}
		pWriter.println (" </complexType>");
		pWriter.println ("</DPSerialization>");		
	}

}
