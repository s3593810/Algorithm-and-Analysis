/**
 * Linked list class
 * 
 *
 */

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public Node<T> getHead() {
		return head;
	}
	
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	public Node<T> getTail() {
		return tail;
	}
	
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	public void add(T value) {
		Node<T> node = new Node<T>(value);
		
		if(head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
	}
	
	public void remove() {
		 Node<T> tmp = head;
	     head = tmp.getNext();
	     
	     if(head == null){
	    	 tail = null;
	     }
	}
	
	public void addAfter(T value, T after) {
		Node<T> tmp = head;
        Node<T> refNode = null;
        
        //Search for node exist
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.getValue() == after){
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        
        if(refNode != null){
            Node<T> node = new Node<T>(value);
            node.setNext(tmp.getNext());
            
            if(tmp == tail){
                tail = node;
            }
            tmp.setNext(node);
             
        }
	}
	
	public void removeAfter(T after) {
		Node<T> tmp = head;
        Node<T> refNode = null;
        
        //Search for node exist
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.getValue() == after){
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        
        if(refNode != null){
        	 tmp = refNode.getNext();
             refNode.setNext(tmp.getNext());
             
             if(refNode.getNext() == null){
                 tail = refNode;
             }
        }
	}
	
}
