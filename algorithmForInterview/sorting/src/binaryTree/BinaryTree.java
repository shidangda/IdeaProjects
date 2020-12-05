package binaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTree {

    public static void preOrderTraverse1(TreeNode root){
        if(root!=null){
            System.out.println(root.val+" ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    public static void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val + "  ");
            inOrderTraverse1(root.right);
        }
    }

    public static void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val + "  ");
        }
    }

    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();  //LinkedList作为队列常用的方法：offer(),poll(),isEmpty()
        queue.offer(root);  //将root添加进队列尾并返回true，若队列满则返回false
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();  //如果队列不空，则删除队列头部元素，否则返回false
            System.out.print(node.val + "  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void preOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val + "  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    public static void inOrderTraverse2(TreeNode root){
        if(root==null){
            return;
        }
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode p=root;
        while(p!=null&&!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else {
                p=stack.pop();
                System.out.println(p.val+" ");
                p=p.right;
            }
        }
    }

    /**
     * 二叉树的后序遍历
     *
     * @param root 二叉树根节点
     * @return 后序遍历结果集
     */
    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();  //ArrayDeque和ArrayList均实现了栈操作和队列操作
        TreeNode pre = null;  //记录之前访问的元素
        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            // i ：判断如果右子树不为空且不为之前访问的节点pre（即右子树未被访问）
            if (root.right != null && root.right != pre) {
                root = root.right;
            } else {
                root = stack.pop();
                list.add(root.val);
                pre = root;
                root = null;
            }
        }
        return list;
    }
}


