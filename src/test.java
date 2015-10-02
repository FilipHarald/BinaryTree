
public class test {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		AVLTree a = new AVLTree();
		bt.add(28);
		bt.add(44);
		bt.add(38);
		bt.add(18);
		bt.add(41);
		bt.add(2);
		bt.add(26);
		bt.add(4);
		bt.add(47);
		bt.add(21);
		bt.add(48);
		bt.delete(47);
		bt.add(50);
		bt.add(6);
		bt.add(30);
		bt.add(9);
		bt.printTree();
//		bt.inOrder(null);
		}
}
