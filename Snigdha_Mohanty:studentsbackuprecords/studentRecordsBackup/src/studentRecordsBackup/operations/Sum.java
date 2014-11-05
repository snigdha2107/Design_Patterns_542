package studentRecordsBackup.operations;


import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;

public class Sum implements Operation {

	private static int sum = 0;

	public static int getSum()
	{
		return sum;
	}

	public static void setSum(int sum)
	{
		Sum.sum = sum;
	}

	/**
	 * 
	 * @return void
	 */
	@Override
	public void op(BST tree)
	{
		sum = 0;
		getSum(tree.getRoot());
		System.out.println("\n\nSum = " + sum);
	}


	/**
	 * 
	 * @return void
	 */
	private void getSum(Node item)
	{
		if (item == null)
			return;

		getSum(item.getLeft());
		sum = sum + item.getBNumber();
		getSum(item.getRight());
	}
	
	/**
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return "Sum = "+ sum;
	}

}


