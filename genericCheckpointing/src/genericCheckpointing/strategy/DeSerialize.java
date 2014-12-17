package genericCheckpointing.strategy;

import genericCheckpointing.util.SerializableObject;

import java.util.Vector;
/* Interface for XMLDeSerialize */
public interface DeSerialize {

/**
	 * @throws IOException
	 */
	public Vector<SerializableObject> deSerialize()throws Exception;
}
