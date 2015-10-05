public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	private int height;
	

	public TreeNode(int data){
		this.data = data;
		height = 0;
	}
	
	public TreeNode(int data, int height){
		this.data = data;
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	
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
		System.out.println(height);
	}
	
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
