import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class exr2_mallamsgTest extends exr2_mallamsg {

	@Test
	public void testAddToArrayList() {
		ArrayList<String> arrList = new ArrayList<String>();
		String[] arr = {"Montreal", "Saskatoon", "New York", "Toronto",
				"Sudbury", "London", "Paris", "Delhi", "Vancouver", "Winnipeg"};
		addToArrayList(arrList, arr);
		assertTrue(arrList.contains("London"));
		assertTrue(arrList.contains("Paris"));
		assertFalse(arrList.contains("Cleveland"));
		assertTrue(arrList.contains("New York"));
		assertTrue(arrList.size() == arr.length);
		for(int i = 0; i < arrList.size(); i++){
			assertEquals(arrList.get(i), arr[i]);
		}
		
	}

}
