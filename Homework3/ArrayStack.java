import java.util.EmptyStackException;

/*
 * A stack structure using arrays.
 * Samuel Mallamaci 
 * CSE274 Section C
 * October 13, 2015
 */
public class ArrayStack<T> implements StackInterface<T>{
	T[] array;
	int topIndex;
	@SuppressWarnings("unchecked")
	public ArrayStack(int s){
		array = (T[])new Object[s];
		topIndex = 0;
	}//end specified constructor
	
	public ArrayStack(){
		topIndex = 0;
	}//end unspecified constructor
	
	public void push(T element) {
		if(topIndex == array.length){//if the current stack is full, create a new stack twice the size of the old one
			@SuppressWarnings("unchecked")
			T[] tempArray = (T[])new Object[array.length*2];
			for(int i = 0; i < array.length; i++){//adding the elements of the old stack to the new stack
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		array[topIndex] = element;
		topIndex++;
	}//end push

	public T pop() {//returns the top element and removes it from the array by making the top index lower
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		else{
			T obj = array[topIndex - 1];
			topIndex--;
			array[topIndex] = null;
			return obj;
		}
	}//end pop

	public T peek() {//returns the element at the top of the stack, but does not remove it
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		else{
			return array[topIndex - 1];
		}
	}//end peek

	public boolean isEmpty() {//returns if the first element of the array is null
		if(array[0] == null){//the first index should always be filled if the stack contains elements
			return true;
		}
		return false;
	}//end isEmpty

	public int size() {//returns the size of the stack
		return array.length;
	}//end size
	
	public String toString(){
		String retValue = "";
		for(int i = 0; i < this.size(); i++){
			retValue += (array[i] + " ");
		}
		return retValue;
	}//end toString
	
	
}//end arraystack
