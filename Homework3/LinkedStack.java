import java.util.EmptyStackException;

/*
 * A stack implementation that uses linked lists
 * Samuel Mallamaci
 * CSE274 C
 * 15 October, 2015
 */
public class LinkedStack<T> implements StackInterface<T>{

	int size;
	Node head = null;
	
	public LinkedStack(){
		size = 0;
	}
	public void push(T element) {
		// adds an element as a new node at the front of the list
		Node temp = new Node(head, element);
		head = temp;
		size++;
	}//end push

	public T pop() {
		// removes the front of the list, returns the value
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		@SuppressWarnings("unchecked")
		T item = (T)head.getElement();
		head = head.getNext();
		size--;
		return item;
	}//end pop

	@SuppressWarnings("unchecked")
	public T peek() {
		// returns the value of the front of the list
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		return (T)head.getElement();
	}//end peek

	public boolean isEmpty() {
		// returns if the first element of the list is null
		if(head == null){
			return true;
		}
		return false;
	}//end isEmpty

	public int size() {
		// returns the length of the list
		return size;
	}//end size
	
	public String toString(){
		String retValue = "";
		Node marker = head;
		for(int  i = 0; i < size; i++){
			retValue = marker.getElement() + " " + retValue;
			marker = marker.getNext();
		}
		return retValue;
	}//end toString
	
	/*
	 *Innerclass for list nodes 
	 */
	protected class Node{
		Node next;
		Object element;
		public Node(Node n, Object e){
			this.next = n;
			this.element = e;
		}
		public Node(){
			this.element = null;
			this.next = null;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Object getElement() {
			return element;
		}
		public void setElement(Object element) {
			this.element = element;
		}
		
		
	}

}
