import java.io.PrintStream;

public class LinkedListMultiset<T extends Comparable<T>> extends Multiset<T>
{	
	private Node<T> head;
	private int length;
	
	public LinkedListMultiset() {
		this.head = null;
		this.length = 0;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		
		/* list is null set new node head*/
		if(head == null) {
			head = newNode;
			this.length++;
			
			return;
		} 
		
		/* if head node contains the value add instance */
		if(head.getValue().equals(item)){
			head.addInstance();
			return;
		}
		
		Node<T> currentNode = head; // set head as current node
		Node<T> parentNode = null;
		int compareValue;
		while(currentNode != null) {
			compareValue = currentNode.getValue().compareTo(item);
			
			if(compareValue == 0) {
				currentNode.addInstance();
				this.length ++;
				return;
			}
			
			parentNode  = currentNode;
			currentNode = currentNode.getNext();
		}
		
		parentNode.setNext(newNode);
		
		this.length++;
	} // end of add()
	
	
	public int search(T item) {
		Node<T> currentNode = head;
		int compareValue;
		int count = 0;

        while (currentNode != null) {
        	compareValue = currentNode.getValue().compareTo(item);
            
        	if (compareValue == 0) {
                count = currentNode.getInstance();
                break;
            }
        	
            currentNode = currentNode.getNext();
        }

        return count;
	} // end of add()
	
	
	public void removeOne(T item) {
		Node<T> currentNode = head;
        Node<T> lastNode = null;
        int compareValue;
      		
        while (currentNode != null) {
        	compareValue = currentNode.getValue().compareTo(item);
        	
            if (compareValue == 0) {
            	currentNode.removeInstance();
            	
                if (currentNode.getInstance() == 0) {
                    
                	if (currentNode == head) {
                        head = currentNode.getNext();
                	} else {
                        lastNode.setNext(currentNode.getNext());
                	}
                	
                    this.length--;
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
        int compareValue;

        while (currentNode != null) {
        	compareValue = currentNode.getValue().compareTo(item);
        	
            if (compareValue == 0) {
                if (currentNode == head) {
                    head = currentNode.getNext();
                } else {
                    lastNode.setNext(currentNode.getNext());
                }
                
                length--; //remove one element from head
//  		if(currentNode.getValue().equals(item)){
//  			if(currentNode.getInstance() == 1){
//  				/* remove head */
//  				head = head.getNext();
//  				currentNode.setNext(null);
//  				currentNode = null;
//  			}
//  			else{
//  				head.removeInstance();
//  			}// end of (head.getCount() == 1)
//  			
//  			this.length--;
//  		}
//  		//remove one element from other nodes
//  		else{
//  			while(currentNode.getNext() != null){
//  				if(currentNode.getNext().getValue().equals(item)){
//  					currentNode.getNext().removeInstance();
//  					break;
//  				}
//  				currentNode = currentNode.getNext();
//  			}// end of while(node.getNext() != null)
//
//  			if(currentNode.getNext() != null){
//  				if(currentNode.getNext().getInstance() == 1){
//  					/* remove the node */
//  					Node<T> tempNode = currentNode.getNext();
//  					currentNode.setNext(tempNode.getNext());
//  					tempNode.setNext(null);
//  				}
//  				else{
//  					currentNode.getNext().removeInstance();
//  				}
//  				this.length--;
//  			}// end of if(node.getNext() != null)
//      }// end of if(head.getValue().equals(item))
                
                return;
            }
            lastNode = currentNode;
            currentNode = currentNode.getNext();
        }
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node<T> currentNode = head;
		out.println("Value | Instance");
		
        while (currentNode != null) {
            out.printf("%s | %d\n", currentNode.getValue(), currentNode.getInstance());
            currentNode = currentNode.getNext();
        }
	} // end of print()
	
} // end of class LinkedListMultiset
