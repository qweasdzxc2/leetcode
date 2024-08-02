package binaryTree;

/**
 * 二叉树结点定义类
 */
public class MyTreeNode {
    public Integer value;//值
    public MyTreeNode leftChild;//左子树
    public MyTreeNode rightChild;//右子树


    public MyTreeNode(Integer x) {
        this.value = x;
    }

    public MyTreeNode(Integer value, MyTreeNode leftChild, MyTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
