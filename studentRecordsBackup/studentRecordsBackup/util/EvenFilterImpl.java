package studentRecordsBackup.util;

/**
 * @author Hari
 *
 */
public class EvenFilterImpl implements OddEvenFilterI {

	/**
	 * @param Update Value by which each BNumber has to be updated
	 * @param Actual BNumber of a node
	 * 
	 * @return BNumber after the increment
	 *
	 */
	public int oddEvenFilterImplementation(int updateValue, int bNumberOfNode) {

		return (updateValue + bNumberOfNode);
	}

}
