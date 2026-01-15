package classwork.jan13;

public class BinarySearchTree<T extends Comparable<T>> {
	TreeNode<T> root;

	BinarySearchTree() {
		root = null;
	}

	void insertData(T data) {
		root = insert(root, data);
	}

	private TreeNode<T> insert(TreeNode<T> temp, T data) {
		if (temp == null)
			return new TreeNode<>(data);

		if (data.compareTo(temp.getData()) < 0)
			temp.setLeft(insert(temp.getLeft(), data));
		else
			temp.setRight(insert(temp.getRight(), data));

		return temp;
	}

	public void display(int choice) {
		switch (choice) {
			case 1:
				inorder(root);
				break;
			case 2:
				preorder(root);
				break;
			case 3:
				postorder(root);
				break;
			default:
				System.out.println("Invalid choice");
				break;
		}
	}

	private void postorder(TreeNode<T> temp) {
		if (temp != null) {

			postorder(temp.getLeft());
			postorder(temp.getRight());
			System.out.println(temp.getData());
		}

	}

	private void preorder(TreeNode<T> temp) {
		if (temp != null) {
			System.out.println(temp.getData());
			preorder(temp.getLeft());
			preorder(temp.getRight());
		}

	}

	private void inorder(TreeNode<T> temp) {
		if (temp != null) {

			inorder(temp.getLeft());
			System.out.println(temp.getData());
			inorder(temp.getRight());
		}

	}

	public void deleteData(T data) {
		root = delete(data, root);
	}

	private TreeNode<T> delete(T data, TreeNode<T> temp) {
		if (data.compareTo(temp.getData()) < 0) {
			temp.setLeft(delete(data, temp.getLeft()));
			return temp;
		} else if (data.compareTo(temp.getData()) > 0) {
			temp.setRight(delete(data, temp.getRight()));
			return temp;
		} else {
			if (temp.getLeft() == null && temp.getRight() == null)
				return null;
			if (temp.getRight() == null)
				return temp.getLeft();
			else if (temp.getLeft() == null)
				return temp.getRight();
			else {
				TreeNode<T> leastNode = temp.getRight();
				while (leastNode.getLeft() != null) {
					leastNode = leastNode.getLeft();
				}
				temp.setData(leastNode.getData());
				temp.setRight(delete(leastNode.getData(), temp.getRight()));
				return temp;
			}

		}
	}

}
