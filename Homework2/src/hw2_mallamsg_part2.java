import java.util.ArrayList;


public class hw2_mallamsg_part2 {
	/*
	 * Samuel Mallamaci
	 * CSE274 Section C
	 * using some code for the SList from the lecture
	 */

	public static void main(String[] args) {
		String[] cities= {"Montreal", "Saskatoon", "New York", "Toronto",
				"Sudbury", "London", "Paris", "Delhi", "Vancouver", "Winnipeg"};
		SList list = new SList();
		ArrayList<Object> arrList = new ArrayList<Object>();
		//System.out.println("Hello World!");
		addToArrayList(cities, arrList);
		//System.out.println("Hello World!");
		addToSList(arrList, list);
		//System.out.println("Hello World!");
		System.out.println("Current list: " + list.toString());
		//System.out.println("Hello World!");
		list.removeLast();
		//System.out.println("Hello World!");
		System.out.println("Current list: " + list.toString());
		//System.out.println("Hello World!");

	}

	public static void addToArrayList(String[] s, ArrayList<Object> arrList){
		for(int i = 0; i < s.length; i++){
			arrList.add(s[i]);
		}
	}
	
	public static void addToSList(ArrayList<Object> arrList, SList list){
		//This takes an array list and turns it into a singly-linked list
		for(Object i: arrList){
			list.insertFront(i);
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
			System.out.println("Adding " + item.toString() + " at the front");
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
		public String toString(){
			String output = "";
			SListNode dummy = head;
			while(dummy != null){
				//System.out.println("adding to toString!");
				output = output + " " + dummy.getItem().toString();
				dummy = dummy.getNext();
			}
			 
			 return output;
		}
		public void removeLast(){
			//This will iterate through the SLsit and remove the last node
			System.out.println("Removing last element.");
			SListNode marker = head;
			while(marker.getNext().getNext() != null){
				//System.out.println(marker.getItem());
				marker = marker.getNext();
			}
			if(marker.getNext().getNext() == null){
				marker.setNext(null);
			}
		}
	}
	
	public static class SListNode {
		//The node for the SList class
		private SListNode next;
		private Object item;
		public SListNode(){
			item = null;
			next = null;
		}
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

