import java.util.*;

/*
 * Samuel Mallamaci
 * Sept. 24 2015
 * CSE274 Section C
 * Uses some code from the lecture notes by H. Alomari
 */
public class hw2_mallamsg_part3 {

	public static void main(String[] args) {
		String[] cities= {"Montreal", "Saskatoon", "New York", "Toronto",
				"Sudbury", "London", "Paris", "Delhi", "Vancouver", "Winnipeg"};
		ArrayList<Object> arrList = new ArrayList<Object>();
		DList list = new DList();
		addToArrayList(cities, arrList);
		addToDList(arrList, list);
		System.out.println("Printing the current list: " + list.toString());
		list.remove(5);
		System.out.println("Printing the current list: " + list.toString());
	}
	
	public static void addToArrayList(String[] s, ArrayList<Object> arrList){
		for(int i = 0; i < s.length; i++){
			arrList.add(s[i]);
		}
	}
	
	public static void addToDList(ArrayList<Object> arrList, DList list){
		for(Object i : arrList){
			list.addToEnd(i);
		}
	}
	
	public static class DList{
		/*
		 * A DList contains nodes that are doubly linked to each other
		 * the DList also keeps track of nodes using a head and a tail node
		 * DLists accept objects as nodes.
		 */
		private DListNode head;
		private DListNode tail;
		private int size;
		
		public DList() {
			head = null;
			tail = null;
			size = 0;
		}
		public DList(DListNode h, DListNode t){
			head = h;
			tail = t;
			size = 0;
		}
		public DListNode getHead() {
			return head;
		}
		public void setHead(DListNode head) {
			this.head = head;
		}
		public DListNode getTail() {
			return tail;
		}
		public void setTail(DListNode tail) {
			this.tail = tail;
		}
		
		public String toString(){
			String output = "";
			DListNode marker;
			marker = head;
			if(size == 0){
				output = "{This Doubly Linked List is empty}";
			}
			else{
				do{
					output += " " + marker.getItem();
					marker = marker.getNext();
				}while(marker != tail);
			}
			return output;
		}
		public void remove(int n){
			DListNode marker = head;
			for (int i = 0; i < n - 1; i++){
				marker = marker.getNext();
			}
			marker.getNext().setPrevious(marker.getPrevious());
			marker.getPrevious().setNext(marker.getNext());
			System.out.println("Removing item " + n);
		}
		public void addToEnd(Object item){
			if(size == 0){
				head = new DListNode(null, null, item);
				tail = head;
			}
			else{
				tail = new DListNode(null, tail, item);
				tail.getPrevious().setNext(tail);
			}
			size++;
			System.out.println("Adding " + item.toString() + " to the end");
		}
	}
	
	public static class DListNode{
		private DListNode next;
		private DListNode previous;
		Object item;
		
		public DListNode() {
			next = null;
			previous = null;
			item = null;
		}
		public DListNode(DListNode n, DListNode p, Object i){
			next = n;
			previous = p;
			item = i;
		}
		public DListNode getNext() {
			return next;
		}
		public void setNext(DListNode next) {
			this.next = next;
		}
		public DListNode getPrevious() {
			return previous;
		}
		public void setPrevious(DListNode previous) {
			this.previous = previous;
		}
		public Object getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
	}

}
