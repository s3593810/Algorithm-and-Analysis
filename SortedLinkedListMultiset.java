import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{	
	private Node<T> head;
	private int length;
	
	public SortedLinkedListMultiset() {
		this.head = null;
		this.length = 0;
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		
		/* list is null set new node head*/
		if(head == null) {
			head = newNode;
			length++;
			return;
		}
		
		Node<T> currentNode = head; // set current node
		Node<T> parentNode = head;
		
		if (newNode.compareTo(currentNode.getValue()) < 0) {
			head = newNode;
			head.setNext(parentNode);
			length++;
			return;
		}
		

		while(currentNode != null) {
			/* if already exists*/
			if(currentNode.getValue().equals(item)) {
				currentNode.addInstance();
				return;
			}
			
			/*compare with listed items*/
			if(newNode.compareTo(currentNode.getValue()) < 0) {
				newNode.setNext(currentNode);
		        parentNode.setNext(newNode);
		        length++;
		        return;
			} else {
				parentNode  = currentNode;
				currentNode = currentNode.getNext();
			}
		}// end of while loop
		
		parentNode.setNext(newNode);

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
	
} // end of class SortedLinkedListMultiset