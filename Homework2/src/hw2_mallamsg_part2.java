import java.util.ArrayList;


public class hw2_mallamsg_part2 {
	/*
	 * Samuel Mallamaci
	 * CSE274 Section C
	 * using some code for the SList from the lecture
	 */

	public static void main(String[] args) {
		SList list = new SList();

	}
	
	public void addToSList(ArrayList<Object> arrList, SList list){
		//This takes an array list and turns it into a singly-linked list
		for(Object i: arrList){
			list.insertFront(i);
		}
	}
	
	public void removeLast(SList list){
		//This will iterate through the SLsit and remove the last node
		SListNode marker = list.getHead();
		while(marker.getNext() != null){
			marker.setNext(marker.getNext());
		}
		if(marker.getNext() == null){
			marker.setNext(null);
		}
		
		
	}
	
	public static class SList {
		//A singly-linked list class
		private SListNode head;
		private int size; 
		public SList(){
			head = null;
			size = 0;
		}
		public void insertFront(Object item){
			head = new SListNode(item, head);
			size++;
		}
		public int getSize(){
			return size;
		}
		public SListNode getHead(){
			return head;
		}
		public void setHead(SListNode h){
			head = h;
		}
		
	}
	
	public static class SListNode {
		//The node for the SList class
		private SListNode next;
		private Object item;
		public SListNode(Object i, SListNode n){
			item = i;
			next = n;
		}
		public Object getItem(){
			return item;
		}
		public SListNode getNext(){
			return next;
		}
		public void setNext(SListNode s){
			next = s;
		}
	}

}
