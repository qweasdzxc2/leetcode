package binaryTree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class BrinaryTreeTest {
    public static void main(String[] args) {
        MyBrinarySearchTree tree = new MyBrinarySearchTree();

        tree.insertNode(4);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(1);
        tree.insertNode(5);

        //获取二叉树的根节点
        MyTreeNode root = tree.getRoot();

        System.out.println("递归写法：");
        System.out.print("中序遍历：");inorderByMiddle(root);
        System.out.print("前序遍历：");inorderByFront(root);
        System.out.print("后序遍历：");inorderByLast(root);
        System.out.print("层序遍历：");inorderBySequence(root);
        System.out.println();

        System.out.println("迭代写法：");
        System.out.print("中序遍历：");middle(root);
        System.out.print("前序遍历：");front(root);
        System.out.print("后序遍历：");last(root);
        System.out.println();

        System.out.println("层序遍历优化：");
        System.out.println(inorderLevel(root));

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
     * 迭代的中序遍历
     * @param root
     */
    public static void middle(MyTreeNode root){
        //使用栈进行辅助
        Stack<MyTreeNode> stack = new Stack<>();
        //声明一个指针指向当前结点
        MyTreeNode currentNode = root;

        if(currentNode == null){
            return;
        }
        while(currentNode != null || !stack.isEmpty()){
            //第一次执行以下循环会把包括根节点的所有左孩子结点全部入栈
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            }
            //栈顶元素出栈
            currentNode = stack.pop();
            System.out.print(currentNode.value + " ");
            //转向当前出栈结点的右孩子
            //如果当前出栈的元素已经没有右孩子了，会判定栈是否已经空了，
            //如果没空，就把栈顶元素出栈，接着继续判断是否有右孩子，循环
            //如果栈空了，说明整棵二叉树已经遍历完了，结束即可
            currentNode = currentNode.rightChild;
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
     * 迭代的前序遍历
     * @param root
     */
    private static void front(MyTreeNode root){
        //通过使用栈进行处理
        Stack<MyTreeNode> stack = new Stack<>();
        if(root == null){
            return;
        }
        //根节点入栈
        stack.push(root);
        while(!stack.isEmpty()){
            //弹出栈顶结点
            MyTreeNode node = stack.pop();
            System.out.print(node.value + " ");
            //先右子结点入栈，再左子结点入栈，这样出栈先处理的是左子树，确保顺序为中左右
            if(node.rightChild != null){
                stack.push(node.rightChild);
            }
            if(node.leftChild != null){
                stack.push(node.leftChild);
            }
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
     * 迭代的后序遍历
     * @param root
     */
    private static void last(MyTreeNode root){
        //使用单栈的后序遍历只需要在前序遍历的基础上修改代码
        //由于后序遍历的顺序使左右中，前序遍历的顺序使中左右
        //将前序遍历的入栈顺序改为先左后右，这样出栈顺序将是先右后左
        //将出栈结果按顺序存入集合，二叉树遍历完成后反转集合顺序即可
        List<MyTreeNode> list = new ArrayList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        if(root == null){
            return;
        }
        //根节点入栈
        stack.push(root);
        while(!stack.isEmpty()){
            //弹出栈顶结点
            MyTreeNode node = stack.pop();
            list.add(node);
            if(node.leftChild != null){
                stack.push(node.leftChild);
            }
            if(node.rightChild != null){
                stack.push(node.rightChild);
            }
        }
        Collections.reverse(list);
        for (MyTreeNode node : list) {
            System.out.print(node.value + " ");
        }
    }

    /**
     * 层序遍历
     * 采用的是边出边进的思路，利用队列先进先出的特性
     * 队头元素出队列的同时，将队头元素的左右孩子（如果有）进入队列，实现层序遍历
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

    /**
     * 层序遍历优化
     * @param root
     * @return
     */
    private static List<List<Integer>> inorderLevel(MyTreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<MyTreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                MyTreeNode node = queue.poll();
                tempList.add(node.value);
                if(node.leftChild != null){
                    queue.add(node.leftChild);
                }
                if(node.rightChild != null){
                    queue.add((node.rightChild));
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
