package studentRecordsBackup.bst;

public class Node {
	
	private int bNumber;
	private Node left;
	private Node right;
	private String description;
	

	public Node(int value) {
		bNumber = value;
	}
	
	  /**
     * Getter for the description.
     *
     * @return a description
     */
	public String getDescription() {
		return description;
	}

	/**
     * Setter for the description.
     *
     * @return a description
     */
	public void setDescription(String description) {
		this.description = description;
	}

	

    /**
     * Getter for the bNumber.
     *
     * @return a bNumber
     */
	public int getBNumber() {
		return bNumber;
	}

    /**
     * Getter for the left child node.
     *
     * @return a Node
     */
	public Node getLeft() {
		return left;
	}

    /**
     * Getter for the right child node.
     *
     * @return a Node
     */
	public Node getRight() {
		return right;
	}

    /**
     * Setter for the bNumber.
     *
     * @return a bNumber
     */
	public void setBNumber(int val) {
		bNumber = val;
	}

    /**
     * Setter for the left child node.
     *
     * @param a node
     */
	public void setLeft(Node n) {
		left = n;
	}

    /**
     * Setter for the right child node.
     *
     * @param a node
     */
	public void setRight(Node n) {
		right = n;
	}
	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "value of node is " + getBNumber();
	}
}