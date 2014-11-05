package studentRecordsBackup.operations;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;

public class Update implements Operation
{
	private int updateValue, count = 0;

	public Update(int value)
	{
		updateValue = value;
	}

	public int getUpdateValue()
	{
		return updateValue;
	}

	public void setUpdateValue(int updateValue)
	{
		this.updateValue = updateValue;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int cnt)
	{
		this.count = count;
	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void op(BST tree)
	{
		count = 0;
		addNo(tree.getRoot(), this.getUpdateValue(), tree);

	}

	/**
	 * 
	 * @return void
	 */
	private void addNo(Node item, int val, BST tree)
	{
		try
		{
			if (item == null)
				return;

			addNo(item.getLeft(), val, tree);
			item.setBNumber(item.getBNumber() + val);
			count++;
			tree.setPosition(count);
			tree.setValue(item.getBNumber());
			tree.notifyObservers();

			addNo(item.getRight(), val, tree);
		}
		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public String toString()
	{
		return "Update Value = "+updateValue;
	}
}
