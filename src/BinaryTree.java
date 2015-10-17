/**
 * Binary tree is used for storing objects and has shorter insertion- and extractiontime compared to for example a list.
 * @author Filip
 *
 */
public class BinaryTree {
	protected TreeNode root;
	protected int size;
	
	/**
	 * Constructs a BinaryTree with the size 0.
	 */
	public BinaryTree(){
		size = 0;
	}
	
	/**
	 * @return The size of the tree.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Prints the tree from the root.
	 */
	public void printTree(){
		root.printTree();
	}
	
	/**
	 * Adds the specified value to the tree recursively.
	 * 
	 * @param data
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
	 * 
	 * @param current
	 * @param newNode
	 * @return The root for the new tree or subtree.
	 * @throws Exception
	 */
	private TreeNode insert(TreeNode current, TreeNode newNode) throws Exception{
		if(current == null){
			return newNode;
		}else if(current.getData() == newNode.getData()){
			throw new Exception();
		}else if(current.getData() > newNode.getData()){
			current.setLeft(insert(current.getLeft(), newNode));
		}else if(current.getData() < newNode.getData()){
			current.setRight(insert(current.getRight(), newNode));
		}
		return current;
	}
	
	
	/**
	 * Finds the node with the specified value in the tree with current as root.
	 * 
	 * @param current
	 * @param data
	 * @return The node containing the specified value
	 */
	public TreeNode find(TreeNode current, int data){
		if(current == null){
			return null;	
		}else if(current.getData() == data){
			return current;
		}else if(current.getData() > data){
			return find(current.getLeft(), data);
		}else if(current.getData() < data){
			return find(current.getRight(), data);
		}
		return null;
		
	}
	
	/**
	 * Prints the values of the tree, with current as root, in order.
	 * @param current
	 */
	public void inOrder(TreeNode current){
		if(current == null){
			inOrder(root);
		}else{
			if(current.getLeft()!=null){				
				inOrder(current.getLeft());
			}
			if(current.getRight()!=null){				
				inOrder(current.getRight());	
			}
		}
	}
	/**
	 * Finds the parent TreeNode node for the child. Starts with the current.
	 * 
	 * @param current
	 * @param child
	 * @return returns the parent TreeNode. Returns null if the node has no parents or is not found in the tree. 
	 */
	protected TreeNode findParent(TreeNode current, TreeNode child){
//		System.out.println("current:   "  + current.getData() + "     child:  " + child.getData());
		if(child == null){
			return null;	
		}else if(current.getData() > child.getData()){
			if(current.getLeft()==child){
				return current;
			}else{				
				return findParent(current.getLeft(), child);
			}
		}else if(current.getData() < child.getData()){
			if(current.getRight()==child){
				return current;
			}else{				
				return findParent(current.getRight(), child);
			}
		}
		return null;
	}
	
	/**
	 * Removes the value from the tree, if it exists, recursively.
	 * 
	 * @param data
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
	 * 
	 * @param current
	 * @param dataToRemove
	 * @return The root for the new tree or subtree.
	 */
	private TreeNode remove(TreeNode current, int dataToRemove){
		TreeNode nodeToRemoveDataFrom = find(current, dataToRemove);
		if(nodeToRemoveDataFrom != null){
			TreeNode successor = findSuccessor(nodeToRemoveDataFrom);
			TreeNode successorParent = findParent(current, successor);
			if(successorParent == nodeToRemoveDataFrom){
				if(nodeToRemoveDataFrom.getData() < successor.getData()){	
					nodeToRemoveDataFrom.setRight(successor.getRight());
					if(nodeToRemoveDataFrom.getLeft() == null){
						nodeToRemoveDataFrom.setLeft(successor.getLeft());
					}
				}else{
					nodeToRemoveDataFrom.setRight(successor.getRight());
					nodeToRemoveDataFrom.setLeft(successor.getLeft());
				}
			}else if(successorParent.getLeft() != null){
				successorParent.setLeft(successor.getRight());
			}
			nodeToRemoveDataFrom.setData(successor.getData());
		}
		return current;
	}
	
	/**
	 * Finds and returns the successor of the current node.
	 * @param current
	 * @return The successor of the current node
	 */
	protected TreeNode findSuccessor(TreeNode current){
		TreeNode successor;
		if(current == null){
			successor = null;
		}else if(current.getRight() != null){
			if(current.getLeft() == null){
				successor = current.getRight();
			}else{				
				successor = getMinimum(current.getRight());
			}
		}else if(current.getLeft() != null){
			successor = current.getLeft() ;
		}else{
			successor = current;
		}
		return successor;
	}
	
	/**
	 * Returns the minimum value(the leftmost child) of the tree with current as root.
	 * @param current
	 * @return The minimum value of the tree with current as root.
	 */
	private TreeNode getMinimum(TreeNode current){
		if(current.getLeft() != null){
			return getMinimum(current.getLeft());
		}else{
			return current;
		}
	}
}
