
public class SLLQueue implements Queue{
	int size;
	SLNode<Object> head;
	SLNode<Object> tail;
	
	public SLLQueue(){
		size = 0;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public Object front() throws EmptyQueueException {
		if(size == 0){
			throw new EmptyQueueException("The queue is empty");
		}
		return head.getElement();
	}

	@Override
	public void enqueue(Object element) {
		if(size == 0){
			head = new SLNode<Object>(element, null);
			tail = head;
		}
		else{
			SLNode<Object> tempNode = new SLNode<Object>(element, null); 
			tail.setNext(tempNode);
			tail = tempNode;
		}
		size++;
		
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if(size == 0){
			throw new EmptyQueueException("The queue is empty");
		}
		Object out = head.getElement();
		head = head.getNext();
		size--;
		return out;
	}
	
	public String toString(){
		String out = "";
		SLNode<Object> mark = head;
		for(int i = 0; i < size; i++){
			out += mark.getElement() + " ";
			mark = mark.getNext();
		}
		return out;
	}
	
}
