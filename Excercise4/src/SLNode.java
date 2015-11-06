/**
 * Node used for craeing Singly Linked Lists.
 * Node stores references to the element and 
 * to the next Node in the Singly Linked List.
 * 
 * Time complexity of all methods in this class
 * is O(1).
 * 
*/
public class SLNode<E>
{
  
  private E element;        //Declaration of generic E element.
  private SLNode<E> next;   //Declaration of generic SLNode next.
  
  /**
   * No argument constructor
   */
  public SLNode() {
    this(null, null);   //Call to SLNode constructor passing null for all arguments
  }                     //which creates and empty node
  
  /**
   * Constructor accepting generic
   * type E element and SLNode<E> n next node
   */
  public SLNode(E e, SLNode<E> n)
  {
    element=e;    //Set node element to e
    next=n;       //Set next node to n
  }
  
  /**
   * Method used to retrive element sored in a node
   * This method receives nothing.
   * This method returns element of generic type E.
   */
  public E getElement()
  {
    return element;     //Returns node element
  }
  
  /**
   * Method used to find out next node in the list.
   * This method accepts nothing.
   * This method returns node's next node.
   */
  public SLNode<E> getNext()
  { 
    return next;    //Returns node's next node
  }
  
  /**
   * Methos used to assign node element.
   * This method accepts element newE
   * of generic type E.
   * This method returns nothing.
   */
  public void setElement(E newE)
  { 
    element=newE; //Set newE to node element
  }
  
  /**
   * Method used to assign node's next node
   * in the list.
   * This method accepts node newN.
   * This method returns nothing.
   */
  public void setNext(SLNode<E> newN)
  {
    next=newN;    //Set newN to node's next node
  }
}
