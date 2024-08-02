package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BrinaryTreeTest {
    public static void main(String[] args) {
        MyBrinarySearchTree tree = new MyBrinarySearchTree();

        tree.insertNode(4);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(1);

        //中序遍历验证
        System.out.print("中序遍历：");
        inorderByMiddle(tree.getRoot());
        System.out.println();

        //前序遍历
        System.out.print("前序遍历：");
        inorderByFront(tree.getRoot());
        System.out.println();

        //后序遍历
        System.out.print("后序遍历：");
        inorderByLast(tree.getRoot());
        System.out.println();

        //层序遍历
        System.out.print("层序遍历：");
        inorderBySequence(tree.getRoot());
        System.out.println();
    }

    /**
     * 递归的中序遍历
     * @param node
     */
    private static void inorderByMiddle(MyTreeNode node) {
        if (node != null) {
            inorderByMiddle(node.leftChild);
            System.out.print(node.value + " ");
            inorderByMiddle(node.rightChild);
        }
    }

    /**
     * 递归的前序遍历
     * @param node
     */
    private static void inorderByFront(MyTreeNode node){
        if(node != null){
            System.out.print(node.value + " ");
            inorderByFront(node.leftChild);
            inorderByFront(node.rightChild);
        }
    }

    /**
     * 递归的后序遍历
     * @param node
     */
    private static void inorderByLast(MyTreeNode node){
        if(node != null){
            inorderByLast(node.leftChild);
            inorderByLast(node.rightChild);
            System.out.print(node.value + " ");
        }
    }

    /**
     * 层序遍历
     * 采用的是边出边进的思路，队头元素出队列的同时，将队头元素的左右孩子（如果有）进入队列，实现层序遍历
     * @param node
     */
    private static void inorderBySequence(MyTreeNode node){
        //若树的根节点不存在，则直接返回
        if(node == null){
            return;
        }
        //初始化一个队列用于存放遍历的结点
        Queue<MyTreeNode> myTreeNodeQueue = new ArrayDeque<>();
        myTreeNodeQueue.add(node);
        while(!myTreeNodeQueue.isEmpty()){
            //从队列中取出结点
            MyTreeNode treeNode = myTreeNodeQueue.poll();
            System.out.print(treeNode.value + " ");

            //左孩子进队列
            if(treeNode.leftChild != null){
                myTreeNodeQueue.add(treeNode.leftChild);
            }
            //右孩子进队列
            if(treeNode.rightChild != null){
                myTreeNodeQueue.add(treeNode.rightChild);
            }
        }
    }
}
