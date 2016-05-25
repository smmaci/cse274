
/**
 * ZeroDenominatorException - a runtime exception that signals there was a zero denominator
 * for a Rational number.
 * 
 * @author Ch. H.  Modified by H. W. A 
 */
public class ZeroDenominatorException extends RuntimeException
{

	public ZeroDenominatorException(String reason)
	{
		super(reason);
	}
}
