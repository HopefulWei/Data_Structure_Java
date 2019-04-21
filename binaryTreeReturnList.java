import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.List;

public class binaryTreeReturnList{
    /*
   ###############定义一个节点类，使二叉树与节点类分离##########################
     */
    static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
        }


        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return String.valueOf(value);
        }
    }
    /*
    ###################定于二叉树的类与方法###################
     */
    static class BinaryTree {
        private Node root = null;

        BinaryTree(int value) {
            root = new Node(value);
            root.leftChild = null;
            root.rightChild = null;
        }

        /*
##################二叉树的查找方法#####################
         */
        public Node findKey(int value) {
            Node current = root;
            while (true) {
                if (value == current.value) {
                    return current;
                } else if (value < current.value) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }

                if (current == null) {
                    return null;
                }
            }

        }

        /*
#################二叉树的元素插入方法(插入完成后为二叉查找树)####################
         */
        public String insert(int value) {
            String error = null;

            Node node = new Node(value);
            if (root == null) {
                root = node;
                root.leftChild = null;
                root.rightChild = null;
            } else {
                Node current = root;
                Node parent = null;
                while (true) {
                    if (value < current.value) {
                        parent = current;
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            break;
                        }
                    } else if (value > current.value) {
                        parent = current;
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            break;
                        }
                    } else {
                        error = "having same value in binary tree";
                    }
                } // end of while
            }
            return error;
        }  //插入

        /*
 ##############################层序遍历实现非递归################
         */
        public ArrayList layerOrderTraverse() {
            ArrayList<Integer> List = new ArrayList<>();
            Node current = root;
            if (current == null) {
                return List;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(current);
            ;
            while (queue.size() != 0) {
                current = queue.poll();
                List.add(current.value);
                if (current.leftChild != null) {
                    queue.offer(current.leftChild);
                }
                if (current.rightChild != null) {
                    queue.offer(current.rightChild);
                }
            }
            return List;
        }
        /*
 ##############################层序遍历实现递归方式################
         */
        public ArrayList layerOrderTraverseD() {
            ArrayList<Integer> L=new ArrayList<>();
            layerOrderTraverseD1(root, L);
            return L;
        }
        public static void layerOrderTraverseD1(Node t,List<Integer> L) {
            if(t==null)return;
            L.add(t.value);
            layerOrderTraverseD1(t.leftChild, L);
            layerOrderTraverseD1(t.rightChild, L);
        }


        /*
###############中序遍历实现，返回List，非递归实现#########################
        */
        public ArrayList inOrderByStack() {
            Stack<Node> stack = new Stack<Node>();
            ArrayList<Integer> List_1 = new ArrayList<>();
            Node current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.leftChild;
                }

                if (!stack.isEmpty()) {
                    current = stack.pop();
                    List_1.add(current.value);
                    current = current.rightChild;
                }
            }
            return List_1;
        }
/*
###############中序遍历实现，返回List，递归实现#########################
        */
        public ArrayList inOrderByStackD() {
            ArrayList<Integer> L=new ArrayList<>();
            inOrderTraverseD1(root,L);
            return L;
        }
        public static void inOrderTraverseD1(Node t,List<Integer> L) {
            if (t==null){return;}
            inOrderTraverseD1(t.leftChild,L);
            L.add(t.value);
            inOrderTraverseD1(t.rightChild,L);
        }




        public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(52);
        bt.insert(580);
        bt.insert(12);
        bt.insert(50);
        bt.insert(58);
        bt.insert(9);
        bt.insert(888);
        bt.insert(248);
        bt.insert(32);
        bt.insert(666);
        bt.insert(455);
        bt.insert(777);
        ArrayList<Integer> List = bt.inOrderByStackD();
        for(int num:List){
            System.out.print(num+" ");
        }
        System.out.print("\n");
        ArrayList<Integer> List2 = bt.inOrderByStack();
        for(int num1:List2){
            System.out.print(num1+" ");
        }
    }
}}
