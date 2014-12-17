package genericCheckpointing.util;



/**
 * @author Snigdha
 * General class having setter and getter methods
 * to play around with objects in use
 */
public class MyAllTypesFirst extends SerializableObject{
	
	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;
	
	// empty constructor is needed for reflection
	public MyAllTypesFirst(){
		
	}

	public MyAllTypesFirst(int myInt, String myString, double myDouble, long myLong, char myChar){
		this.myInt = myInt;
		this.myString = myString;
		this.myDouble = myDouble;
		this.myLong = myLong;
		this.myChar = myChar;
	}
	
		// FIXME: rest of the set_X methods
	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public double getMyDouble() {
		return myDouble;
	}
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public char getMyChar() {
		return myChar;
	}
	public void setMyChar(char myChar) {
		this.myChar = myChar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myChar;
		long temp;
		temp = Double.doubleToLongBits(myDouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result
				+ ((myString == null) ? 0 : myString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myChar != other.myChar)
			return false;
		if (Double.doubleToLongBits(myDouble) != Double
				.doubleToLongBits(other.myDouble))
			return false;
		if (myInt != other.myInt)
			return false;
		if (myLong != other.myLong)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myString=" + myString
				+ ", myDouble=" + myDouble + ", myLong=" + myLong + ", myChar="
				+ myChar + "]";
	}
	
}
