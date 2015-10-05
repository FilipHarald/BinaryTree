
public class AVLTree extends BinaryTree {

	public AVLTree(){
		super();
	}
	@Override
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

	private TreeNode rotateRight(TreeNode current) {
		if(current == root){
			root = root.getLeft();
			current.setLeft(root.getRight());
			root.setRight(current);
			current.setLeft(null);
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
	
	@Override
	public void delete(int data){
		TreeNode temp = remove(root, data);
		if(temp != null){
			root = temp;
			size--;
		}
	}
	
	private TreeNode remove(TreeNode current, int dataToRemove){
		System.out.println("get data " + current.getData());
		System.out.println("datatoremove  "  + dataToRemove);
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
