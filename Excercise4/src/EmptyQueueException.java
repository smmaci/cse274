/**
 * Exception thrown by Queue methods dequeue()
 * and front() if the Queue is empty.
 * 
*/

class EmptyQueueException extends RuntimeException
{   
    /**
     * Constructor accepting argument err String
     */
    public EmptyQueueException(String err)
    {
        super(err); //Call to supperclass constructor passing err String as argument
    }
}