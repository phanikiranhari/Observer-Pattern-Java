package studentRecordsBackup.bst;

/**
 * @author Hari
 *
 */
public interface SubjectI {
	
	/**
	 * @param Observer node
	 */
	public void registerObserver(Node observer);
	/**
	 * @param Update Value
	 */
	public void notifyAllTheRegisteredObservers(int update);
	
}