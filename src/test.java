
public class test {
	public static void main(String[] args) {
		AVLTree a = new AVLTree();
		a.add(100);
		a.add(150);
		a.add(130);
		a.printTree();
		System.out.println("///////////////////////////////////////////////////");
		a.inOrder(null);
		}
}
