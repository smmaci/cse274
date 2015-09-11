
/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Ch. H.  Modified by H. W. A 
 */
public class Counter
{
    // PUT PRIVATE DATA FIELDS HERE
	private Integer minimum;
	private Integer maximum;
	private int currentCount;
	private boolean rolled;
	

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        // ADD CODE FOR THE CONSTRUCTOR
    	minimum = 0;
    	maximum = Integer.MAX_VALUE;
    	currentCount = minimum;
    	rolled = false;
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
    	if(min < max){
    		minimum = min;
    		maximum = max;
    	}
    	else{
    		CounterInitializationException cie = new CounterInitializationException("Minimum must be less than maximum");
    		throw cie;
    	}
    	currentCount = minimum;
    	rolled = false;
    }
    
    public int getMinimum(){
    	return minimum;
    }
    
    public int getMaximum(){
    	return maximum;
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        boolean result = true;
        if (otherObject instanceof Counter)
        {
           if(((Counter)otherObject).getMaximum() == maximum){
        	   if(((Counter)otherObject).getMinimum() == minimum){
        		  if(((Counter)otherObject).currentCount == currentCount){
        			  if(((Counter)otherObject).rolled == rolled){
        				  result = true;
        			  }
        			  else{
        				  result = false;
        			  }
        		  }
        		  else{
        			  result = false;
        		  }
        	   }
        	   else{
        		   result = false;
        	   }
           }
           else{
        	   result = false;
           }
        }
        else{
        	result = false;
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
    	currentCount++;
    	if(currentCount <= maximum){
    		rolled = false;
    	}
    	if(currentCount > maximum){
    		rolled = true;
    		currentCount = minimum;
    	}
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
    	currentCount--;
    	if(currentCount >= minimum){
    		rolled = false;
    	}
    	if(currentCount < minimum){
    		rolled = true;
    		currentCount = maximum;
    	}
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return currentCount;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
    	return rolled;
    	
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        return "Minimum : " + minimum + ". Maximum: " + maximum + ". Current Counter: " + currentCount + ". Rolled over: " + rolled;		
    }
 
}
