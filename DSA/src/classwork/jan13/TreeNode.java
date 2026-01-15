package classwork.jan13;

public class TreeNode<T>{
    T data;
    TreeNode<T> left, right;

    public TreeNode(T data){
        this.data=data;
        left=null;
        right=null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }
}
