package genericCheckpointing.strategy;

import genericCheckpointing.util.SerializableObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDeSerialize implements DeSerialize {

	private String fileName;
	
	public XMLDeSerialize(){
		
	}
	
	public XMLDeSerialize(String fileName){
		this.fileName = fileName;
	}
	
	@Override
	public Vector<SerializableObject> deSerialize()throws Exception {
		
		Vector<SerializableObject> deSerList = new Vector<SerializableObject>();
		
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();
		//Load and Parse the XML document
		//document contains the complete XML as a Tree.
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(fileName);
			
			/*Scanner reader = new Scanner(fis);
			while(reader.hasNext()){
				System.out.println(reader.nextLine());
			}*/
			
		}catch(FileNotFoundException fnfe){
			System.out.println("File not found.If you did not run ser option first please run it first before running deser option");
			return null;
		}
		Document document = builder.parse(fis);
		//Iterating through the nodes and extracting the data.

		NodeList nodeList = document.getElementsByTagName("DPSerialization");

		for (int i = 0; i < nodeList.getLength(); i++) {
			//We have encountered an <DPSerialization> tag.
			Node node = nodeList.item(i);
			if (node instanceof Element) {

				Class<? extends SerializableObject> classDefinition = null;
				Object instance = null;
				
				Node complexTypeNode = ((Element) node).getElementsByTagName("complexType").item(0);
				String className = "";
				if(complexTypeNode instanceof Element){
					Element e = (Element)complexTypeNode;
					className = e.getAttribute("xsi:type");
					//System.out.println("className->"+className);
					
					classDefinition = Class.forName(className).asSubclass(SerializableObject.class);
					instance = classDefinition.newInstance();
				}
				
				NodeList childNodes = complexTypeNode.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = childNodes.item(j);
					if (cNode instanceof Element) {
						String content = cNode.getLastChild().
								getTextContent().trim();
						
						Element propNode = (Element)cNode;
						String propType = propNode.getAttribute("xsi:type");
						
						
						String propName = cNode.getNodeName();
						
						Field field = classDefinition.getDeclaredField(propName);
						field.setAccessible(true);
						
						switch(propType){
							case "xsd:int":
								field.setInt(instance, Integer.parseInt(content));
								break;
							case "xsd:string":
								field.set(instance, content);
								break;
							case "xsd:double":
								field.setDouble(instance, Double.parseDouble(content));
								break;
							case "xsd:long":
								field.setLong(instance, Long.parseLong(content));
								break;
							case "xsd:char":
								
								if(content.length() > 1){
									System.out.println("character should be of length only 1");
									return null;
								}
								
								field.setChar(instance, content.charAt(0));
						}
						
					}
				}
				deSerList.add((SerializableObject)instance);
			}
		}
		
		return deSerList;
	}

}
