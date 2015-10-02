
public class AVLTree extends BinaryTree {
	
	
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
			current.incHeight();
		}else if(current.getData() == newNode.getData()){
			throw new Exception();
		}else if(current.getData() > newNode.getData()){
			current.setLeft(insert(current.getLeft(), newNode));
			if(current.getLeft().getHeight() - current.getRight().getHeight() == 2){
				////////////////
				current.decHeight();
			}else{
				current.incHeight();
			}
		}else if(current.getData() < newNode.getData()){
			current.setRight(insert(current.getRight(), newNode));
			if(current.getRight().getHeight() - current.getLeft().getHeight() == 2){
				//////////////
				current.decHeight();
			}else{
				current.incHeight();
			}
		}
		return current;
	}
	

	@Override
	public void delete(int data) {
		// TODO Auto-generated method stub
		super.delete(data);
	}

	public AVLTree(){
		super();
	}

}
