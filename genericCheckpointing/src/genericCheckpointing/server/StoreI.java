package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;


/**
 * @author Snigdha
 * This interface will be derived from StoreRestoreI and will have
 *  writeObj method which will be implemented to serialize 
 *  contents to file.
 */
public interface StoreI extends StoreRestoreI {
    void writeObj(MyAllTypesFirst aRecord);
    void writeObj(MyAllTypesSecond aRecord);
}
