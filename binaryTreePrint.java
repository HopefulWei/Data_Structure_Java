import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class binaryTreePrint{
    /*
   ###############定义一个节点类，使二叉树与节点类分离##########################
     */
    static class Node {
        int  value;
        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
        }

        public void display() {
            System.out.print(this.value + "\t");
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
            root.leftChild  = null;
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
                } else if (value > current.value) {
                    current = current.rightChild;
                }

                if (current == null) {
                    return null;
                }
            }

        }
        /*
#################二叉树的元素插入方法####################
         */
        public String insert(int value) {
            String error = null;

            Node node = new Node(value);
            if (root == null) {
                root = node;
                root.leftChild  = null;
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
 ##############################层次遍历，非递归实现##################
  */
        public void layerOrderTraverse(){
            Node current = root;
            if(current == null){return ;}
            Queue<Node> queue = new LinkedList<>();
            queue.add(current);
            System.out.println("层序遍历：");
            while(queue.size()!=0){
                current = queue.poll();
                current.display();
                if(current.leftChild!=null){
                    queue.offer(current.leftChild);
                }
                if(current.rightChild!=null){
                    queue.offer(current.rightChild);
                }
            }
        }

        /*
###########中序遍历实现，靠print操作，递归实现###########
         */
        public void inOrderTraverse() {
            System.out.print("中序遍历:");
            inOrderTraverse(root);
            System.out.println();
        }

        private void inOrderTraverse(Node node) {
            if (node == null)
                return ;

            inOrderTraverse(node.leftChild);
            node.display();
            inOrderTraverse(node.rightChild);

        }    //中序遍历递归操作

        /*
###############中序遍历实现，靠print操作，非递归实现#########################
        */
        public void inOrderByStack() {
            System.out.print("中序非递归遍历:");
            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.leftChild;
                }

                if (!stack.isEmpty()) {
                    current = stack.pop();
                    current.display();
                    current = current.rightChild;
                }
            }
            System.out.println();
        }     //中序遍历非递归操作
        /*
#####################前序遍历实现，靠print操作，递归实现############################
        */
        public void preOrderTraverse() {
            System.out.print("前序遍历:");
            preOrderTraverse(root);
            System.out.println();
        }

        private void preOrderTraverse(Node node) {
            if (node == null)
                return ;

            node.display();
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        }  //前序遍历
        /*
###########前序遍历实现，靠print操作，非递归实现########################
        */
        public void preOrderByStack() {
            System.out.print("前序非递归遍历:");
            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current.display();
                    current = current.leftChild;
                }

                if (!stack.isEmpty()) {
                    current = stack.pop();
                    current = current.rightChild;
                }
            }
            System.out.println();
        }   //前序遍历非递归操作
        /*
#############后序遍历实现，靠print操作，递归实现################
        */
        public void postOrderTraverse() {
            System.out.print("后序遍历:");
            postOrderTraverse(root);
            System.out.println();
        }

        private void postOrderTraverse(Node node) {
            if (node == null)
                return ;

            postOrderTraverse(node.leftChild);
            postOrderTraverse(node.rightChild);
            node.display();
        } //后序遍历
        /*
####################后序遍历实现，靠print操作，非递归实现#########################
        */
        public void postOrderByStack() {
            System.out.print("后序非递归遍历:");
            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            Node preNode = null;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.leftChild;
                }

                if (!stack.isEmpty()) {
                    current = stack.peek().rightChild;
                    if (current == null || current == preNode) {
                        current = stack.pop();
                        current.display();
                        preNode = current;
                        current = null;
                    }
                }
            }
            System.out.println();
        }  //后序遍历非递归操作
        /*
       二叉树得到最小，最大值, 其中left 为最小值；right为最大值
        */
        public int getMinValue() {
            Node current = root;
            while (true) {
                if (current.leftChild == null)
                    return current.value;

                current = current.leftChild;
            }
        } //得到最小(大)值
    }

/*
#####################主程序，在二叉树中添加节点#####################33
 */

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
        bt.insert(999);
        bt.inOrderTraverse();
        bt.preOrderTraverse();
        bt.postOrderTraverse();
        System.out.println(bt.findKey(32));
        System.out.println(bt.findKey(81));
        System.out.println("最小值:" + bt.getMinValue());
        bt.inOrderTraverse();
        bt.layerOrderTraverse();
    }
}
