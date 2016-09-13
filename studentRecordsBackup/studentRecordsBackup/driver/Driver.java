package studentRecordsBackup.driver;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.extra.BSTCollection;
import studentRecordsBackup.util.BSTBuilder;
import studentRecordsBackup.util.Logger;


/**
 * @author Hari
 *
 */
public class Driver {
	
	static BSTCollection bstCollection;
	
	
	/**
	 * This method reads all the command line arguments and call the specific 
	 * methods to display tree information
	 * @param command line arguments
	 * @return No return value but prints the necessary output
	 */
	public static void main(String[] args) {
		if (args.length !=2){
			Logger.writeMessage("Incorrect command line arguments. Please give only 2 valid arguments");
			System.exit(0);
		}
		else{
			try {
				String fileName = args[0];
				int updateValue = Integer.parseInt(args[1]);
				BSTBuilder bstBuilder = new BSTBuilder();
				BST subjectBst = new BST();
				BST observerBst1 = new BST();
				BST observerBst2 = new BST();
				
				bstCollection = bstBuilder.readLineFromFileAndInsertIntoAllTrees(
						fileName, subjectBst, observerBst1, observerBst2);
				if (bstCollection.getRootOfSubject()!=null){
					Logger.writeMessage("***************Inorder of all the trees before the update******************");
					Logger.writeMessage(" ");
					subjectBst.storeInorderOfAllTrees(bstCollection.getRootOfSubject());
					subjectBst.printInorder();
					subjectBst.printBSum();
					bstCollection = bstBuilder.findMaxNodesOfAllTreesAndSetTheFlag(bstCollection.getRootOfSubject());
					bstCollection = bstBuilder.updateSubjectAndObservers(bstCollection.getRootOfSubject(), updateValue);
					subjectBst.storeInorderOfAllTrees(bstCollection.getRootOfSubject());
					Logger.writeMessage(" ");
					Logger.writeMessage("***************Inorder of all the trees after the update*******************");
					Logger.writeMessage(" ");
					subjectBst.printInorder();
					subjectBst.printBSum();
					Logger.writeMessage(" ");
				}
				else {
					Logger.writeMessage("Error: The given input file is empty. " +
							"Please enter some numbers into file to test Observer pattern.");
					System.exit(0);
				}
			}
			catch (NumberFormatException e) {
				Logger.writeMessage("Error : Invalid Update Value");
				System.exit(0);
			}
			
			
		}
	}

}
