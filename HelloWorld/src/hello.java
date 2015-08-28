
public class hello {
	public static void main(String args[]){
		System.out.println("Hello World!");
		System.out.println(reverse("Hello World!"));
		if(isPal("racecar")){
			System.out.println("Racecar is a palindrome!");
		}
		else{
			System.out.println("NOOOOO!");
		}
	}
	public static String reverse(String s){
		if(s.length() == 1){
			return s;
		}
		else{
			return(reverse(s.substring(1)) + s.substring(0, 1));
		}
	}
	public static boolean isPal(String s){
		if(reverse(s.toLowerCase()).equals(s.toLowerCase())){
			return true;
		}
		else return false;
	}
}