public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public int getData(){
		return data;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public void printTree(){
		if (this.right != null){
			right.printTree(true, "");
		}
		printNodeValue();
		if (this.left != null){
			left.printTree(false, "");
		}
	}
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
	private void printNodeValue(){
		System.out.print(data);
		System.out.print("\n");
	}

}
