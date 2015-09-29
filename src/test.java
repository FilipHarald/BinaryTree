
public class test {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(3);
		bt.add(2);
		bt.add(6);
		bt.add(1);
		bt.printTree();
		bt.inOrder(null);
		}
}
