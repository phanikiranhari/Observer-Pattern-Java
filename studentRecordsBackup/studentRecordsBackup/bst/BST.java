package studentRecordsBackup.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hari
 *This is the class which has all methods for a tree.
 *Insertion into a tree
 *Traversing a tree
 */
public class BST {
	
	private Node node;
	private static List<Integer> inOrderListOfSubject = new ArrayList<Integer>();
	private static List<Integer> inOrderListOfObserver1 = new ArrayList<Integer>();
	private static List<Integer> inOrderListOfObserver2 = new ArrayList<Integer>();

	/**
	 * This method accepts a BNumber and inserts into all the trees.
	 * @param Root Node of main Tree
	 * @param Observer1 Root Node 
	 * @param Observer2 Root Node
	 * @param Bnumber to be inserted
	 * @return Root Node after inserting BNumbers into all trees.
	 */
	public Node insertIntoTree(Node rootBST, Node copy1BST, Node copy2BST, int bNumber) {

		if (rootBST == null) {
			//Tree is empty. Create root node first
			rootBST = createNode(rootBST, bNumber);
			copy1BST = createNode(copy1BST, bNumber);
			copy2BST = createNode(copy2BST, bNumber);
			if (rootBST.getObservers().size() < 2){
			rootBST.registerObserver(copy1BST);
			rootBST.registerObserver(copy2BST);
			}
		} else {
			if (bNumber < rootBST.getbNumber()) {
				Node lnode = insertIntoTree(rootBST.getLeft(),
						copy1BST.getLeft(), copy2BST.getLeft(), bNumber);
				rootBST.setLeft(lnode);
				copy1BST.setLeft(lnode);
				copy2BST.setLeft(lnode);
				if (rootBST.getObservers().size() < 2){
				rootBST.registerObserver(lnode);
				rootBST.registerObserver(lnode);
				}

			} else {

				Node rnode = insertIntoTree(rootBST.getRight(),
						copy1BST.getRight(), copy2BST.getRight(), bNumber);
				rootBST.setRight(rnode);
				copy1BST.setRight(rnode);
				copy2BST.setRight(rnode);
				if (rootBST.getObservers().size() < 2){
				rootBST.registerObserver(rnode);
				rootBST.registerObserver(rnode);
				}
			}
		}
		return rootBST;
	}
	/**
	 * This method creates Node for a given Bnumber and returns the same.
	 * @param Node to be created. Node is null. We need to instantiate new Node();
	 * @param Bnumber read from input file
	 * @return New Node created
	 */
	private Node createNode(Node node, int value) {
		node = new Node();
		node.setbNumber(value);
		node.setLeft(null);
		node.setRight(null);
		return node;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	/**
	 * This method iterate through the tree and store the Bnumbers into 3 separate lists
	 * @param Root node of main BST
	 * @return No return value but lists are updated
	 */
	public void storeInorderOfAllTrees(Node node) {
		if (node != null) {
			storeInorderOfAllTrees(node.getLeft());
			inOrderListOfSubject.add(node.getbNumber());
			inOrderListOfObserver1.add(node.getObservers().get(0).getbNumber());
			inOrderListOfObserver2.add(node.getObservers().get(1).getbNumber());
			storeInorderOfAllTrees(node.getRight());
		}
	}
	/**
	 * This method prints the In Order of a tree
	 * 
	 */
	public void printInorder() {
		System.out.println("Inorder of Subject Tree");
		for (Integer subjectBnumber : inOrderListOfSubject){
			System.out.print(subjectBnumber+" ");
		}
		System.out.println();
		System.out.println("Inorder of Observer1 Tree");
		for (Integer observer1Bnumber : inOrderListOfObserver1){
			System.out.print(observer1Bnumber+" ");
		}
		System.out.println();
		System.out.println("Inorder of Observer2 Tree");
		for (Integer observer2BNumber : inOrderListOfObserver2){
			System.out.print(observer2BNumber+" ");
		}
		System.out.println();
	}
	/**
	 * This method prints the sum of all the nodes in a tree.
	 */
	public void printBSum() {
		int sum =0;
		System.out.println("Sum of BNumbers in Subject Tree");
		for (Integer a : inOrderListOfSubject){
			sum = sum + a;
		}
		System.out.println(sum);
		sum =0;
		System.out.println("Sum of BNumbers in Observer1 Tree");
		for (Integer b : inOrderListOfObserver1){
			sum = sum+b;
		}
		System.out.println(sum);
		sum =0;
		System.out.println("Sum of BNumbers in Observer2 Tree");
		for (Integer b : inOrderListOfObserver2){
			sum = sum+b;
		}
		System.out.println(sum);
		sum =0;
		inOrderListOfObserver1 = new ArrayList<Integer>();
		inOrderListOfObserver2 = new ArrayList<Integer>();
		inOrderListOfSubject = new ArrayList<Integer>();
	}
}
