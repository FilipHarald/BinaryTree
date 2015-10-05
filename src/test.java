
public class test {
	public static void main(String[] args) {
		AVLTree a = new AVLTree();
		a.add(100);
		a.add(130);
		a.add(150);
		a.add(160);
		a.delete(160);
		a.add(10);
		a.add(16);
		a.add(90);
		a.add(1602);
		a.printTree();
		a.delete(100);
		a.delete(130);
		a.printTree();
		a.delete(1602);
		a.printTree();
		System.out.println("///////////////////////////////////////////////////");
		a.inOrder(null);
		}
}
