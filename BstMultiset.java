import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T extends Comparable<T>> extends Multiset<T>
{	
	private TreeNode<T> root;
	private int length;
	
	public BstMultiset() {
		this.root = null;
		this.length = 0;
	} // end of BstMultiset()

	public void add(T item) {
		if(root == null) {
			root = new TreeNode<T>(item);
			length++;
			return;
		}
		
		TreeNode<T> currentNode = root;
		boolean conti = true;
		int compareValue = currentNode.getValue().compareTo(item);
		while(conti) {
			if(compareValue > 0){
				if(currentNode.getRightChild() == null){
					/* set new node as right child of node */
					TreeNode<T> newNode = new TreeNode<T>(item);
					currentNode.setRightChild(newNode);
					newNode.setParent(currentNode);
					length++;
					conti = false;
				}
				else{
					currentNode = currentNode.getRightChild();
				}
		
			}// end of if compareValue > 0
			else if(compareValue < 0){
				if(currentNode.getLeftChild() == null){
					/* set new node as left child of node */
					TreeNode<T> newNode = new TreeNode<T>(item);
					currentNode.setLeftChild(newNode);
					newNode.setParent(currentNode);
					length++;
					conti = false;
				}
				else{
					currentNode = currentNode.getLeftChild();
				}
			}// end of else if compareValue < 0
			else {
				/*  if item is already exists, increase appearance */
				currentNode.addInstance();
				conti = false;
			}// end of else	
		}// end of while loop	
		
	} // end of add()


	public int search(T item) {
		return search(item, this.root);
	} // end of search()
	
	private int search(T item, TreeNode<T> node){		
		// search the item in recursive way
		if(node == null){
			return 0;
		}
		else if(node.getValue().compareTo(item) > 0){
			return search(item, node.getRightChild());
		}
		else if(node.getValue().compareTo(item) < 0){
			return search(item, node.getLeftChild());
		}
		else{
			return node.getInstance();
		}
	}// end of search

	public void removeOne(T item) {
		removeOne(item, root);
	} // end of removeOne()
	
	private void removeOne(T item, TreeNode<T> node) {
		int compareValue = node.getValue().compareTo(item);
		
		if(compareValue == 0){
            if(node.getInstance() > 1){
                node.removeInstance();
            }else{
            	deleteNode(node);
            }
        }else if(compareValue < 0){
            if(node.getLeftChild() != null){
                removeOne(item, node.getLeftChild());
            }else{
                return;
            }
        }else {
            if(node.getRightChild() != null){
                removeOne(item, node.getRightChild());
            }else{
                return;
            }
        }// end of if(compare == 0)
	}
	
	public void removeAll(T item) {
		removeAll(item, this.root);
	} // end of removeAll()
	
	private void removeAll(T item, TreeNode<T> node) {
		int compareValue = node.getValue().compareTo(item);
        if(compareValue == 0){
            deleteNode(node);
        }else if(compareValue < 0){
            if(node.getLeftChild() != null){
                removeAll(item, node.getLeftChild());
            }else{
                return;
            }
        }else {
            if(node.getRightChild() != null){
                removeAll(item, node.getRightChild());
            }else{
                return;
            }
        }// end of if(compare == 0)
	}

	public void print(PrintStream out) {
		print(out, this.root);
	} // end of print()
	
	private void print(PrintStream out, TreeNode<T> node) {
        if(node.getLeftChild() != null){
            print(out, node.getLeftChild());
        }
        
        out.println(node.getValue() + " | " + node.getInstance());
        
        if(node.getRightChild() != null){
            print(out, node.getRightChild());
        }
	}//end of print(PrintStream out, TreeNode<T> node)
	
	private void deleteNode(TreeNode<T> node) {

        if(node.getLeftChild() == null && node.getRightChild() == null) {
        	TreeNode<T> parent = node.getParent();
        	if(parent == null){
        		/* node is root node */
        		this.root = null;
        	}
        	else{
            	if(parent.getLeftChild() == node){
            		parent.setLeftChild(null);
            	}
            	else{
            		parent.setRightChild(null);
            	}
            	node.setParent(null);
                node = null;	
                
        	}// end of if(parent == null)
    		this.length--;

        }//end of if(node.getLeftChild() == null && node.getRightChild() == null)
        
        else if(node.getLeftChild() != null && node.getRightChild() == null) {
        
        	TreeNode<T> parent = node.getParent();
        	TreeNode<T> leftChild = node.getLeftChild();

        	leftChild.setParent(parent);
        	
        	if(parent!= null){
        	    if(parent.getLeftChild() == node){
        		    parent.setLeftChild(leftChild);
        	    }
        	    else{
        		    parent.setRightChild(leftChild);
        	    }

        	    leftChild.setParent(parent);
        	}
        	else{
        		/* node is root node */
        		this.root = leftChild;
        	}// end of if(parent!= null)
        	
        	node.setParent(null);
        	node.setLeftChild(null);
        	node = null;
        	this.length--;
            
        }// end of  else if(node.getLeftChild()!=null && node.getRightChild() == null)
        
        else if(node.getLeftChild() == null && node.getRightChild() != null) {
        	TreeNode<T> parent = node.getParent();
        	TreeNode<T> rightChild = node.getRightChild();
        	
        	rightChild.setParent(parent);
        	
        	if(parent != null) {
        	     if(parent.getLeftChild() == node) {
        		     parent.setLeftChild(rightChild);
        	    }
        	    else{
        		    parent.setRightChild(rightChild);
        	    }

        	    rightChild.setParent(parent);
        	}else{
        		this.root = rightChild;
        	}
        	
        	node.setParent(null);
        	node.setRightChild(null);
        	node = null;
        	this.length--;

        }//end of else if(node.getLeftChild() == null && node.getRightChild() != null)
        else {
            //node has two children nodes
            
        	TreeNode<T> newRoot = node.getRightChild();
            
            while (newRoot.getLeftChild() != null) {
            	newRoot = newRoot.getLeftChild();//find the minimum of right subtree
            }
            node.setValue(newRoot.getValue());
            node.setInstance(newRoot.getInstance());
            
            if(newRoot == node.getRightChild()) {
            	node.setRightChild(newRoot.getRightChild());
            	newRoot.setRightChild(null);
            }
            else{
            	if(newRoot.getRightChild() != null){
            		newRoot.getRightChild().setParent(newRoot.getParent());
            	}
                newRoot.getParent().setLeftChild(newRoot.getRightChild());
            }

            newRoot.setParent(null);
            newRoot = null;
            
            this.length--;
        }
	}
} // end of class BstMultiset
