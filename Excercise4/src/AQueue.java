
public class AQueue implements Queue{
	Object[] array;
	int size = 0;
	int indexFront;
	
	public AQueue(){
		array = new Object[10];
	}//end constructor
	
	public AQueue(int s){
		array = new Object[s];
	}
	
	public int size() {
		return size;
	}//end size

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}//end isEmpty

	@Override
	public Object front() throws EmptyQueueException {
		if(this.isEmpty()){
			throw new EmptyQueueException("The queue is empty");
		}
		return array[indexFront];
	}//end enqueue

	@Override
	public void enqueue(Object element) {
		if(size == array.length){
			throw new QueueOverFlowException("The queue is full");
		}
		else{
			array[(indexFront + size) % array.length] = element;
			size++;
		}
		
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if(size == 0){
			throw new EmptyQueueException("The queue is empty");
		}
		Object out = array[indexFront];
		array[indexFront] = null;
		indexFront = (indexFront + 1) % array.length;
		size--;
		return out;
	}//end dequeue
	
	/*public void reverseQueue(){
		T[] tempArray = (T[]) new Object[size];
		for(int k = size - 1; k >= 0; k--){
			tempArray[k] = (T) this.dequeue();
		}
		for(int k = 0; k < size; k++){
			this.enqueue(tempArray[k]);
		}
	}//end reverseQueue*/
	
	public String toString(){
		String out = "";
		for(int i = 0; i < array.length; i++){
			out += array[i] + " ";
		}
		return out;
	}//end toString

}//end AQueue
