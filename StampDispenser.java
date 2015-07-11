package StampDispenser;
import java.util.*;

/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
    List<Integer> stamps = new ArrayList<Integer>();
    Set<Integer> set = new HashSet<Integer>();

    /**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
    public StampDispenser(int[] stampDenominations) throws InputInvalidException
    {
        // First validate the user input
        // In the input, we should not allow negative integer and 0.
        // There must be at least a 1. 
        // There should not be duplicate integers.

        for (int value : stampDenominations) {
            if (value <= 0) {
                throw new InputInvalidException("This array contains element less or equal to 0.");
            } else if (!set.add(value)) {
                throw new InputInvalidException("This array contains duplicate elements.");
            }
        }

        if (!set.contains(1)) 
            throw new InputInvalidException("This array does not contain at least a 1.");

        // Assign the values in the hashset back to the list
        stamps.addAll(set);

        // Sort the array
        Collections.sort(stamps, Collections.reverseOrder());
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
        return 0;
    }
    
    public static void main(String[] args) throws InputInvalidException
    {
        int[] denominations = { 30, 10, 24, 1, 6, 2, 90};
        StampDispenser stampDispenser = new StampDispenser(denominations);
        //assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
    }
}
