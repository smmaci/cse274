import java.util.ArrayList;
import java.util.Scanner;

public class exr2_mallamsg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String[] cities= {"Montreal", "Saskatoon", "New York", "Toronto",
				"Sudbury", "London", "Paris", "Delhi", "Vancouver", "Winnipeg"};
		ArrayList<String> list = new ArrayList<String>();
		addToArrayList(list, cities);
		System.out.println("Current list of cities:");
		System.out.println("     "+list.toString());
		
		System.out.println("What index should we replace wiht Calgary?");
		int calIndex = in.nextInt();
		replaceWithCalgary(list, calIndex);
		System.out.println("Printing after adding Calgary");
		System.out.println(list.toString());

		
		System.out.println("What index should we add Edmonton at?");
		int edIndex = in.nextInt();
		addEdmonton(list, edIndex);
		System.out.println("Printing after adding Edmonton");
		System.out.println(list.toString());
	}
	public static void addToArrayList(ArrayList<String> a, String[] s){
		for(int i = 0; i < s.length; i++){
			a.add(s[i]);
		}
	}
	public static void addEdmonton(ArrayList<String> a, int index){
		a.add(index, "Edmonton");
	}
	public static void replaceWithCalgary(ArrayList<String> a, int index){
		a.set(index, "Calgary");
	}

}
