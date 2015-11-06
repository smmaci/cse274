/**
 * Exception thrown by Queue method enqueue()
 * if no new Objects can be added to the Queue
 * due to space restrictions related to specific
 * Queue implementation.
 * 
*/

class QueueOverFlowException extends RuntimeException
{
    /**
     * Constructor accepting argument err String
     */
    QueueOverFlowException(String err)
    {
        super(err); //Call to supperclass constructor passing err String as argument
    }
}