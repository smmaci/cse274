
public class test {

	public static void main(String[] args) {
		AQueue arr1 = new AQueue();
		arr1.enqueue(5);
		arr1.enqueue(6);
		arr1.enqueue(10);
		arr1.enqueue(-100);
		arr1.enqueue(32);
		System.out.println(arr1.toString());
		
		ReverseQueue reverser = new ReverseQueue();
		reverser.reverse(arr1);
		System.out.println(arr1.toString());

	}

}
