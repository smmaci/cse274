
/**
 * CounterInitializationException - a runtime exception that signals that the counter could
 * not be created.
 * 
 * @author Ch. H.  Modified by H. W. A 
 */
public class CounterInitializationException extends RuntimeException
{

	public CounterInitializationException(String reason)
	{
		super(reason);
	}
}
