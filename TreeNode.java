
public class TreeNode<T> {
	private T value;
	private int appearence;
	
	private TreeNode<T> parent;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	/** Constructor to set value only */
	public TreeNode(T value) {
		this.value = value;
		this.appearence = 1;
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public void setInstance(int appearence) {
		this.appearence = appearence;
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
	
	/** Get value of tree node */
	public T getValue() {
		return value;
	}
	
	/** Set value to node 
	 * @param value to store in the node
	 * */
	public void setValue(T newValue) {
		this.value = newValue;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
}
