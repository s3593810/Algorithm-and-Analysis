import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{	
	private Node<T> head;
	private int length;
	
	public LinkedListMultiset() {
		this.head = null;
		this.length = 0;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		
		if(head == null) {
			head = newNode;
		} else {
			Node<T> currentNode = head;
			Node<T> parentNode = null;
			
			while(currentNode != null) {
				if(currentNode.equals(newNode.getValue())) {
					currentNode.addInstance();
					return;
				}
				parentNode  = currentNode;
				currentNode = currentNode.getNext();
			}
			
			parentNode.setNext(newNode);
		}
		
		length++;
	} // end of add()
	
	
	public int search(T item) {
		Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getValue().equals(item)) {
                return currentNode.getInstance();
            }
            currentNode = currentNode.getNext();
        }

        return 0;

	} // end of add()
	
	
	public void removeOne(T item) {
		Node<T> currentNode = head;
        Node<T> lastNode = null;

        while (currentNode != null) {
            if (currentNode.getValue().equals(item)) {
            	currentNode.removeInstance();
                if (currentNode.getInstance() == 0) {
                    
                	if (currentNode == head)
                        head = currentNode.getNext();
                    else
                        lastNode.setNext(currentNode.getNext());
                    
                    length--;
                }
                return;
            }
            
            lastNode = currentNode;
            currentNode = currentNode.getNext();
        }
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		Node<T> currentNode = head;
        Node<T> lastNode = null;

        while (currentNode != null) {
            if (currentNode.getValue().equals(item)) {
                if (currentNode == head)
                    head = currentNode.getNext();
                else
                    lastNode.setNext(currentNode.getNext());
                
                length--;
                return;
            }
            lastNode = currentNode;
            currentNode = currentNode.getNext();
        }
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node<T> currentNode = head;

        while (currentNode != null) {
            out.printf("%s | %d\n", currentNode.getValue(), currentNode.getInstance());
            currentNode = currentNode.getNext();
        }
	} // end of print()
	
} // end of class LinkedListMultiset
