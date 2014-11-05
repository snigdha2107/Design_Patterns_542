package studentRecordsBackup.bst;

import java.util.ArrayList;
import studentRecordsBackup.observer.Observer;
import studentRecordsBackup.observer.Subject;


public class BST implements Subject, Observer
{
	private Node root = null;
	private int count = 0, position=0, value=0;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String desc ;
	

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Node getRoot()
	{
		return root;
	}

	public void setRoot(Node root)
	{
		this.root = root;
	}

	public Node insert(int value)
	{
		root = insertNode(root, value);
		return root;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	/**
	 * 
	 * @return Node
	 */
	private Node insertNode(Node node, int value)
	{

		if (node == null)
		{
			node = new Node(value);
			node.setDescription(desc);
			node.setLeft(null);
			node.setRight(null);
		}
		else if (value < node.getBNumber())
			node.setLeft(insertNode(node.getLeft(), value));
		else if (value == node.getBNumber())
			node.setRight(insertNode(node.getRight(), value));
		else if (value > node.getBNumber())
			node.setRight(insertNode(node.getRight(), value));

		return node;

	}

	/**
	 * 
	 * @return void
	 */
	public void printInorder(Node item)
	{
		try
		{
			if (item == null)
				return;

			printInorder(item.getLeft());
			System.out.print(item.getBNumber() + "\t");

			printInorder(item.getRight());
		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}



	/**
	 * 
	 * @return void
	 */
	@Override
	public void update(int pos, int val)
	{
		count = 0;
		updateAtPosition(this.getRoot(), pos, val);

	}

	/**
	 * 
	 * @return void
	 */
	private void updateAtPosition(Node item, int pos, int val)
	{
		try
		{
			if (item == null)
				return;

			updateAtPosition(item.getLeft(), pos, val);
			count++;
			if (count == pos)
			{
				item.setBNumber(val);
				return;
			}
			updateAtPosition(item.getRight(), pos, val);
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void registerObserver(Observer newObserver)
	{

		observers.add(newObserver);

	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void removeObserver(Observer deleteObserver)
	{
		int observerIndex = observers.indexOf(deleteObserver);
		observers.remove(observerIndex);
	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void notifyObservers()
	{
		for (int i = 0; i < observers.size(); i++)
		{
			Observer o = observers.get(i);
			o.update(position, value);
		}
	}

	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "Root of string is " + root.getBNumber();
	}

}