package studentRecordsBackup.bst;

import java.util.ArrayList;

import studentRecordsBackup.util.EvenFilterImpl;
import studentRecordsBackup.util.OddEvenFilterI;
import studentRecordsBackup.util.OddFilterImpl;

/**
 * @author Hari
 *
 * Node class that has the details of Node viz. Right Node, Left Node, Max Value.
 * And also this class is both Observer and Subject
 */
public class Node implements SubjectI, ObserverI {

	private int bNumber;
	private String description;
	private Node left;
	private Node right;
	private boolean maxValue = false;

	public int getbNumber() {
		return bNumber;
	}
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public boolean isMaxValue() {
		return maxValue;
	}
	public void setMaxValue(boolean isMaxValue) {
		this.maxValue = isMaxValue;
	}
	private ArrayList<Node> observers = new ArrayList<Node>();
	private int update;

	public int getUpdate() {
		return update;
	}

	public void setUpdate(int updateValue) {
		this.update = updateValue;
		notifyAllTheRegisteredObservers(updateValue);
	}

	/**
	 * @return All the registered observers for a specific node
	 */
	public ArrayList<Node> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Node> observers) {
		this.observers = observers;
	}

	
	/**
	 * @param Update value passed from the command line
	 * @return No return value but update method of Node is called to do the update
	 */
	public void notifyAllTheRegisteredObservers(int updateValue) {
		update(updateValue);
	}

	
	/**
	 * @param List of observers
	 * Add the given observer to the array list of observers
	 */
	public void registerObserver(Node observer) {
		observers.add(observer);

	}
	
	/**
	 * This method registers a filter and calls the appropriate filter
	 * @param Update value by which each node has to be updated
	 * @return No return value but sets the Bnumber with incremented value.
	 */
	public void update(int updateValue) {
		int updateValueReturnedByFilter = 0;
		if (updateValue % 2 == 0) {
			OddEvenFilterI evenFilter = new EvenFilterImpl();
			updateValueReturnedByFilter = evenFilter.oddEvenFilterImplementation(updateValue, observers.get(0).getbNumber());
			observers.get(0).setbNumber(updateValueReturnedByFilter);
		} else {
			OddEvenFilterI oddFilter = new OddFilterImpl();
			updateValueReturnedByFilter = oddFilter.oddEvenFilterImplementation(updateValue, observers.get(1).getbNumber());
			observers.get(1).setbNumber(updateValueReturnedByFilter);
		}
	}

}
