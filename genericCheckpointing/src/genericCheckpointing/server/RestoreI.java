package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

/**
 * @author Snigdha
 * This interface will be derived from StoreRestoreI and will have
 *  readObj method which will be implemented to deserialize 
 *  contents from file.
 */
public interface RestoreI extends StoreRestoreI {
	Object readObj();
}
