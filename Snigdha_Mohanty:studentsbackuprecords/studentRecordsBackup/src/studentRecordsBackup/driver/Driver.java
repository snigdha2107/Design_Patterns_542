package studentRecordsBackup.driver;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.observer.Observer;
import studentRecordsBackup.observer.Subject;
import studentRecordsBackup.util.BSTBuilder;
import studentRecordsBackup.operations.Operation;
import studentRecordsBackup.operations.Sum;
import studentRecordsBackup.operations.Update;

public class Driver
{
	public static void main(String[] args)
	{
	
			System.out.println(args);
		System.out.println(args.length);
		System.out.println(args[0]);
		System.out.println(args[1]);
	
		if(args.length < 2)
		{                
			System.out.println("Please provide two arguments i.e.input filename and update value");                
			return;           
		}
		if(args.length == 2){
			if(args[0].isEmpty() || args[1].isEmpty() || "${arg1}".equals(args[1]) || "${arg0}".equals(args[0])){
				System.out.println("Please provide two arguments i.e.input filename and update value");                
				return;           
			
			}
		}
		try
		{
			String fName = args[0];
			int updateValue = Integer.parseInt(args[1]);
			BSTBuilder treeBuilder = new BSTBuilder(fName);
			treeBuilder.buildTree();
			BST mainTree = treeBuilder.getMainBST();
			BST backup1 = treeBuilder.getBackupBST1();
			BST backup2 = treeBuilder.getBackupBST2();

			Operation sum = new Sum();
			Operation update = new Update(updateValue);

			Subject subjectTree = mainTree;
			Observer observer1 = backup1;
			Observer observer2 = backup2;
			subjectTree.registerObserver(observer1);
			subjectTree.registerObserver(observer2);

            // Printing before updating the UPDATE_VALUE
			System.out.println("\nMain Tree inorder traversal");
			mainTree.printInorder(mainTree.getRoot());
			System.out.println("\n\nBackup1 inorder traversal");
			backup1.printInorder(backup1.getRoot());
			System.out.println("\n\nBackup2 inorder traversal");
			backup2.printInorder(backup2.getRoot());

			// Printing the sum of elements in the BSTs
			sum.op(mainTree);
			sum.op(backup1);
			sum.op(backup2);
			
			// Updating the UPDATE_VALUE to the main BST
			update.op(mainTree);

			// Printing after updating the UPDATE_VALUE
			System.out.println("\nMain Tree inorder traversal");
			mainTree.printInorder(mainTree.getRoot());
			System.out.println("\n\nBackup1 inorder traversal");
			backup1.printInorder(backup1.getRoot());
			System.out.println("\n\nBackup2 inorder traversal");
			backup2.printInorder(backup2.getRoot());
			
			// Printing the sum of elements in the BSTs
						sum.op(mainTree);
						sum.op(backup1);
						sum.op(backup2);

		}

		catch (Exception e)
		{
			System.err.println("***Exception***");
			System.err.println(e);
			e.printStackTrace();
			System.exit(1);
		}
		
		
	}
}