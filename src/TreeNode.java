/**
 * This class represents a TreeNode
 * @author Filip
 *
 */
/**
 * @author Filip
 *
 */
public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	private int height;
	

	/**
	 * Constructs a TreeNode with the specified data.
	 * 
	 * @param data
	 */
	public TreeNode(int data){
		this.data = data;
		height = 0;
	}
	
	/**
	 * @return The height of the TreeNode
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height of the node depending on it's children. If it has no children the height will be 1.
	 */
	public void setHeight(){
		int leftHeight;
		int rightHeight;
		if(left == null){
			leftHeight = 0;
		}else{
			leftHeight = left.getHeight();
		}
		if(right == null){
			rightHeight = 0;
		}else{
			rightHeight = right.getHeight();
		}
		height = leftHeight >= rightHeight ? leftHeight + 1: rightHeight + 1;
	}
	
	/**
	 * Returns the balancefactor. The balancefactor is ((left childs height) - (right childs height)).
	 * @return The balancefactor of the node
	 */
	public int getBalanceFactor(){
		int l;
		int r;
		if(left == null){
			l = 0;
		}else{
			l = left.getHeight();
		}
		if(right == null){
			r = 0;
		}else{
			r = right.getHeight();
		}
			return  l - r;
	}
	
	/**
	 * Sets the data of the node to the specified value.
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Sets the left child to the specified TreeNode
	 * @param newLeft
	 */
	public void setLeft(TreeNode newLeft) {
		this.left = newLeft;
	}

	/**
	 * Sets the right child to the specified TreeNode
	 * @param newRight
	 */
	public void setRight(TreeNode newRight) {
		this.right = newRight;
	}
	
	/**
	 * @return Returns the data of the node.
	 */
	public int getData(){
		return data;
	}
	
	/**
	 * @return Returns the left child
	 */
	public TreeNode getLeft(){
		return left;
	}
	
	/**
	 * @return Returns the right child
	 */
	public TreeNode getRight(){
		return right;
	}
	
	/**
	 * Prints the tree in the command line
	 */
	public void printTree(){
		if (this.right != null){
			right.printTree(true, "");
		}
		printNodeValue();
		if (this.left != null){
			left.printTree(false, "");
		}
	}
	/**
	 * Prints the tree in the command line (recursive call)
	 */
	private void printTree(boolean isRight, String indent){
		if(right != null){
			right.printTree(true, indent + (isRight ? "      " : " |    "));
		}
		System.out.print(indent);
		if(isRight){
			System.out.print(" /");
		}else{
			System.out.print(" \\");
		}
		System.out.print("-----");
		printNodeValue();
		if(left !=null){
			left.printTree(false, indent + (isRight ? " |    " : "      "));
		}
	}
	
	/**
	 * Prints the node value
	 */
	private void printNodeValue(){
		System.out.print(data);
		System.out.print("\n");
	}

}
