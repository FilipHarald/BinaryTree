
/**
 * This is a balanced BinaryTree
 * @author Filip
 *
 */
public class AVLTree extends BinaryTree {

	/**
	 * Constructs an AVLTree with the size 0.
	 */
	public AVLTree(){
		super();
	}

	/* (non-Javadoc)
	 * @see BinaryTree#add(int)
	 */
	public void add(int data){
		try {
			root = insert(root, new TreeNode(data));
			size++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Used by add for recursively adding the newNode. Throws Exception if the value exists in the tree.
	 * @param current
	 * @param newNode
	 * @return The root for the new balanced- tree or subtree.
	 * @throws Exception
	 */
	private TreeNode insert(TreeNode current, TreeNode newNode) throws Exception{
		if(current == null){
			current = newNode;
			current.setHeight();
		}else if(current.getData() == newNode.getData()){
			throw new Exception();
		}else if(current.getData() > newNode.getData()){
			current.setLeft(insert(current.getLeft(), newNode));
		}else if(current.getData() < newNode.getData()){
			current.setRight(insert(current.getRight(), newNode));
		}
		current.setHeight();
		current = balanceNode(current);
		return current;
	}
	

	/** 
	 * Used to balance the node so that the two subtrees height won't differ more than 1.
	 * @param current
	 * @return The root of the new balanced tree
	 */
	private TreeNode balanceNode(TreeNode current) {
		TreeNode replacingNode = current;
		if(current.getBalanceFactor() == 2){
			if(current.getLeft().getBalanceFactor() == -1){
				current.setLeft(rotateLeft(current.getLeft()));
			}
			replacingNode = rotateRight(current);
		}else if(current.getBalanceFactor() == -2){
			if(current.getRight().getBalanceFactor() == 1){
				current.setRight(rotateRight(current.getRight()));
			}
			replacingNode = rotateLeft(current);
		}
		
		return replacingNode;
	}

	/**
	 * @param current
	 * @return The replacement of the current node after rotation
	 */
	private TreeNode rotateLeft(TreeNode current) {
		if(current == root){ 
			root = root.getRight();
			current.setRight(root.getLeft());
			root.setLeft(current);
			current.setHeight();
			root.setHeight();
			return root;
		}else{
			TreeNode rightC = current.getRight();
			current.setRight(rightC.getLeft());
			rightC.setLeft(current);
			current.setHeight();
			rightC.setHeight();
			return rightC;
		}
	}

	/**
	 * @param current
	 * @return The replacement of the current node after rotation
	 */
	private TreeNode rotateRight(TreeNode current) {
		if(current == root){
			root = root.getLeft();
			current.setLeft(root.getRight());
			root.setRight(current);
			current.setHeight();
			root.setHeight();
			return root;
		}else{
			TreeNode leftC = current.getLeft();
			current.setLeft(leftC.getRight());
			leftC.setRight(current);
			current.setHeight();
			leftC.setHeight();
			return leftC;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see BinaryTree#delete(int)
	 */
	public void delete(int data){
		TreeNode temp = remove(root, data);
		if(temp != null){
			root = temp;
			size--;
		}
	}
	
	/**
	 * Removes the data from the tree with current as root. 
	 * @param current
	 * @param dataToRemove
	 * @return The root for the new balanced- tree or subtree.
	 */
	private TreeNode remove(TreeNode current, int dataToRemove){
		if(current == null){
		}else if(current.getData() > dataToRemove ){
			current.setLeft(remove(current.getLeft(), dataToRemove));
		}else if(current.getData() < dataToRemove){
			current.setRight(remove(current.getRight(), dataToRemove));
		}else if(current.getData() == dataToRemove){
			TreeNode successor = findSuccessor(current);
			TreeNode successorParent = findParent(root, successor);
			if(successor == current){
				return null;
			}else if(successorParent == current){
				if(current.getData() < successor.getData()){	
					current.setRight(successor.getRight());
				}else{
					current.setRight(successor.getRight());
					current.setLeft(successor.getLeft());
				}
			}else if(successorParent.getLeft() != null){
				successorParent.setLeft(null);
			}
			current.setData(successor.getData());
		}
		current.setHeight();
		current = balanceNode(current);
		return current;
	}


}
