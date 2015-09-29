public class BinaryTree {
	private TreeNode root;
	private int size;
	
	public BinaryTree(){
		size = 0;
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
			current.setLeft(insert(current.getRight(), newNode));
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
	
	private void inOrder(TreeNode current){
		
	}
	private TreeNode findParent(TreeNode current, TreeNode child){
		if(current == null){
			return null;	
		}else if(current.getData() == child.getData()){
			return current;
		}else if(current.getData() > child.getData()){
			return findParent(current.getLeft(), child);
		}else if(current.getData() < child.getData()){
			return findParent(current.getRight(), child);
		}
		return null;
	}
	
	public void delete(int data){
		TreeNode temp = remove(root, data);
		if(temp != null){
			root = temp;
		}
	}
	
	private TreeNode remove(TreeNode current, int dataToRemove){	
		if(current.getData() == dataToRemove){
			TreeNode successor = findSuccessor(current);
			findParent(root, successor).setLeft(null);
			current.setData(successor.getData());
		}
	}
	private TreeNode findSuccessor(TreeNode current){
		if(current == null){	
		}else if(current.getRight() != null){
			return getMinimum(current.getRight());
		}
		return current;
	}
	private TreeNode getMinimum(TreeNode current){
		if(current.getLeft() != null){
			return getMinimum(current.getLeft());
		}else{
			return current;
		}
	}
	


}
