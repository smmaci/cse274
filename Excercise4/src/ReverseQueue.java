
public class ReverseQueue {
	public ReverseQueue(){
		
	}
	public static void reverse(Queue q){
		Object[] tempQ = new Object[q.size()];
		int finalSize = q.size();
		for(int k = finalSize - 1; k >= 0; k--){
			tempQ[k] = q.dequeue();
		}
		for(int k = 0; k < finalSize; k++){
			q.enqueue(tempQ[k]);
		}
	}
}
