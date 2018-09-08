

/**
 * Node class is generic class, store value and point the next node
 * 
 * 
 * @param <T>
 */
public class Node<T> {
	private T value;
	private Node<T> next;
	private int appearence;
	
	/** Constructor to set value only */
	public Node(T value) {
		this.value = value;
		this.next = null;
		this.appearence = 1;
	}
	
	public void addInstance() {
		appearence++;
	}
	
	public void removeInstance() {
		appearence--;
	}
	
	public int getInstance() {
		return appearence;
	}
	
	/** Constructor to set value of node and next node object*/
	public Node(T value, Node<T> nextNode) {
		this.value = value;
		this.next = nextNode;
	}
	
	/** Get value of node */
	public T getValue() {
		return value;
	}
	
	/** Set value to node 
	 * @param value to store in the node
	 * */
	public void setValue(T newValue) {
		this.value = newValue;
	}
	
	/** Get next point node object */
	public Node<T> getNext() {
		return next;
	}
	
	/** Set next node object */
	public void setNext(Node<T> nextNode ) {
		this.next = nextNode;
	}
} // end of Node class

