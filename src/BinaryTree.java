public class BinaryTree {
	protected TreeNode root;
	protected int size;
	
	public int getSize() {
		return size;
	}

	public BinaryTree(){
		size = 0;
	}
	
	public void printTree(){
		root.printTree();
	}
	
	public void add(int data){
		try {
			root = insert(root, new TreeNode(data));
			size++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	public void inOrder(TreeNode current){
		if(current == null){
			inOrder(root);
		}else{
			if(current.getLeft()!=null){				
				inOrder(current.getLeft());
			}
			System.out.println(current.getData());
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
	
	public void delete(int data){
		TreeNode temp = remove(root, data);
		if(temp != null){
			root = temp;
			size--;
		}
	}
	
	private TreeNode remove(TreeNode current, int dataToRemove){
		TreeNode nodeToRemoveDataFrom = find(current, dataToRemove);
		if(nodeToRemoveDataFrom != null){
			TreeNode successor = findSuccessor(nodeToRemoveDataFrom);
			TreeNode successorParent = findParent(current, successor);
			if(successorParent == nodeToRemoveDataFrom){
				if(nodeToRemoveDataFrom.getData() < successor.getData()){					
					nodeToRemoveDataFrom.setRight(successor.getRight());
				}else{
					nodeToRemoveDataFrom.setRight(successor.getRight());
					nodeToRemoveDataFrom.setLeft(successor.getLeft());
				}
			}else if(successorParent.getLeft() != null){
				successorParent.setLeft(null);
			}
			nodeToRemoveDataFrom.setData(successor.getData());
		}
		return current;
	}
	
	protected TreeNode findSuccessor(TreeNode current){
		TreeNode successor;
		if(current == null){
			successor = null;
		}else if(current.getRight() != null){
			successor = getMinimum(current.getRight());
		}else if(current.getLeft() != null){
			successor = current.getLeft() ;
		}else{
			successor = current;
		}
		return successor;
	}
	
	private TreeNode getMinimum(TreeNode current){
		if(current.getLeft() != null){
			return getMinimum(current.getLeft());
		}else{
			return current;
		}
	}
}
