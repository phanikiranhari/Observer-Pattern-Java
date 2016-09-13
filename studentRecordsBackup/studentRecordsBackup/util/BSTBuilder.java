package studentRecordsBackup.util;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.extra.BSTCollection;


/**
 * @author Hari
 *
 */
public class BSTBuilder {

	private static Node rootOfBst;
	BSTCollection bstCollection = new BSTCollection();
	private static int maxCounter = 0;

	/**
	 * This method reads a BNumber line by line and stores into all the 3 trees
	 * @param fileName where set of numbers are stored
	 * @param subjectBst Instance of main BST
	 * @param observerBst1 Copy 1 of main BST
	 * @param observerBst2 Copy 2 of main BST
	 * @return Insert into all trees and populate BST collection (Class that has all root nodes for 3 trees)
	 */
	public BSTCollection readLineFromFileAndInsertIntoAllTrees(String fileName,
			BST subjectBst, BST observerBst1, BST observerBst2) {
		BSTCollection bstCollection = new BSTCollection();
		FileProcessor fp = new FileProcessor(fileName);
		String currentLine;
		while ((currentLine = fp.readLineFromFile()) != null) {
			try {
				rootOfBst = subjectBst.insertIntoTree(subjectBst.getNode(),
						observerBst1.getNode(), observerBst2.getNode(),
						Integer.parseInt(currentLine));
			} catch (NumberFormatException e) {
				Logger.writeMessage("Error: Please give only integers in the input file");
				System.exit(0);
			}
			subjectBst.setNode(rootOfBst);
			observerBst1.setNode(rootOfBst.getObservers().get(0));
			observerBst2.setNode(rootOfBst.getObservers().get(1));

		}
		if (subjectBst.getNode() !=null){
			bstCollection.setRootOfSubject(subjectBst.getNode());
			bstCollection.setRootOfObserver1(observerBst1.getNode());
			bstCollection.setRootOfObserver2(observerBst2.getNode());
		}
		return bstCollection;
	}


	public BSTCollection updateSubjectAndObservers(Node mainNode, int updateValue) {
		if (mainNode != null) {
			updateSubjectAndObservers(mainNode.getLeft(), updateValue);
			if (mainNode.isMaxValue())
				mainNode.setbNumber(mainNode.getbNumber() + 2 * updateValue);
			else
				mainNode.setbNumber(mainNode.getbNumber() + updateValue);	
			mainNode.setUpdate(updateValue);
			updateSubjectAndObservers(mainNode.getRight(), updateValue);
		}
		bstCollection.setRootOfSubject(mainNode);
		rootOfBst = mainNode;
		return bstCollection;

	}


	public BSTCollection findMaxNodesOfAllTreesAndSetTheFlag(Node rootOfSubject) {
	        // loop down to find the rightmost leaf 
	        if (rootOfSubject.getRight()!= null) {
	            findMaxNodesOfAllTreesAndSetTheFlag(rootOfSubject.getRight());
	        }
	        if (maxCounter ==0){
	        	rootOfSubject.setMaxValue(true);
		        rootOfSubject.getObservers().get(0).setMaxValue(true);
		        rootOfSubject.getObservers().get(1).setMaxValue(true);
		        maxCounter = maxCounter + 1;
	        }
	        bstCollection.setRootOfSubject(rootOfSubject);
			return bstCollection;
	}
}
