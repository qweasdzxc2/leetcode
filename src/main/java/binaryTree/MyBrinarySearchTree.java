package binaryTree;

/**
 * 二叉搜索树定义类
 */
public class MyBrinarySearchTree {
    private MyTreeNode root;

    /**
     * 获取二叉树根结点
     * @return
     */
    public MyTreeNode getRoot(){
        return root;
    }
    /**
     * 初始化二叉搜索树
     */
    public MyBrinarySearchTree(){
        this.root = null;
    }

    /**
     * 递归插入二叉树结点
     * @param val
     */
    public void insertNode(int val){
        root = insertRec(root, val);
    }

    private MyTreeNode insertRec(MyTreeNode root, int val){
        if(root == null){
            //当前二叉树为空,则初始化二叉树根节点的值
            root = new MyTreeNode(val);
            return root;
        }

        //根据值的大小判断需要插入左子树还是右子树
        //逐层判断是否与当前根节点的值大小关系
        if(val < root.value){
            root.leftChild = insertRec(root.leftChild, val);
        }else{
            root.rightChild = insertRec(root.rightChild, val);
        }

        //返回根节点
        return root;
    }
}
