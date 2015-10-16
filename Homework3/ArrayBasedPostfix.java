/*
 * Arraystack implementation of the postfixing algorithm
 * Samuel Mallamaci
 * 15 October 2015
 */
public class ArrayBasedPostfix {
	public ArrayBasedPostfix(){
		
	}
	public String convertToPostfix(String infix){
		ArrayStack<Character> operatorStack = new ArrayStack<Character>(20);
		String postfix = "";
		int i = 0;
		char nextChar;
		while(i < infix.length()){//start main algorithm
			nextChar = infix.charAt(i);
			switch(nextChar){//start switch for character type
				case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':{
					postfix += nextChar;
					break;
				}//end case variable
				case '^':{
					operatorStack.push(nextChar);
					break;
				}//end case ^
				case '+':case '-':case '*':case '/':{
					while(!operatorStack.isEmpty() 
							&& determinePrecedence(infix.charAt(i), operatorStack.peek())){//if the next char has a lower or equal precedence, stop looping
						postfix += operatorStack.pop();
					}//end while loop
					operatorStack.push(infix.charAt(i));
					break;
				}//end case operator
				case '(':{
					operatorStack.push(infix.charAt(i));
					break;
				}//end case (
				case ')':{
					char topOperator = operatorStack.pop();
					while(topOperator != '('){
						postfix += topOperator;
						topOperator = operatorStack.pop();
					}
					break;
				}//end case )
				default: break;
			}//end switch
			i++;
		}//end algorithm
		while(!operatorStack.isEmpty()){
			char topOperator = operatorStack.pop();
			postfix += topOperator;
		}
		return postfix;
	}//end convertToPostfix
	
	public Integer evaluatePostfix(String postfix){
		ArrayStack<Integer> valueStack = new ArrayStack<Integer>(20);
		int i = 0;
		while(i < postfix.length()){
			char nextCharacter = postfix.charAt(i);
			switch(nextCharacter){
				case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':{
					valueStack.push((int)nextCharacter);
					break;
				}//end case variable
				case '+':case '-':case '*':case '/':case '^':{
					int operandTwo = valueStack.pop();
					int operandOne = valueStack.pop();
					int result = 0;
					switch(nextCharacter){
						case '+':{
							result = operandOne + operandTwo;
							break;
						}
						case '-':{
							result = operandOne - operandTwo;
							break;
						}
						case '*':{
							result = operandOne * operandTwo;
							break;
						}
						case '/':{
							result = operandOne / operandTwo;
							break;
						}
						case '^':{
							result = (int) Math.pow(operandOne, operandTwo);
							break;
						}
						default: break;
					}//end switch
					valueStack.push(result);
				}//end case operation
			}//end switch
			i++;
		}//end while
		return valueStack.peek();
	}//end evaluatePostfix
	
	/*
	 * An algorithm for determining the precedence of the upcoming chars
	 * returns true if the postfixing algorithm should continue popping the stack
	 */
	public boolean determinePrecedence(char currentChar, char topChar){
		if(((currentChar == '+' || currentChar == '-')&&(topChar == '*' || topChar == '/'))
			||((currentChar == '+' || currentChar == '-')&&(topChar == '+' || topChar == '-'))
			||((currentChar == '*' || currentChar == '/')&&(topChar == '*' || topChar == '/'))){
			return true;
		}
		return false;
	}//end determinePrecedence

}
