

public class Binary_Search_Tree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node createBST(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(val < root.data){
            root.left = createBST(root.left, val);
        }
        if(val>root.data){
            root.right = createBST(root.right, val);
        }
        return root;
    }
    
    public static Node findMin(Node root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node findMax(Node root){
        if(root == null){
            return null;
        }
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    public static int findCeiling(Node root, int val){
        if(root == null){
            return -1;
        }

        int ceiling = -1;

        while(root != null){
            if(root.data == val){
                ceiling = root.data;
                break;
            }
            else if(root.data < val){
                root = root.right;
            }
            else{
                ceiling = root.data;
                root = root.left;
            }
        }
        return ceiling;
    }

    public static int findFloor(Node root, int val){
        if(root == null){
            return -1;
        }

        int floor = -1;

        while(root != null){
            if(root.data == val){
                floor = root.data;
                break;
            }
            else if(root.data < val){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }

    public static Node helper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        Node rightTree = root.right;
        Node lastright = findRightMost(root.left);
        lastright.right = rightTree;
        return root.left;
    }

    public static Node deleteNode(Node root, int val){
        if(root == null){
            return null;
        }

        if(root.data == val){
            return helper(root);
        }

        // Node dummy = root;
        // while(root != null){
        //     if(root.data > val){
        //         if(root.left != null && root.left.data == val){
        //             root.left = helper(root.left);
        //             break;
        //         }
        //         else{
        //             root = root.left;
        //         }
        //     }
        //     else{
        //         if(root.right != null && root.right.data == val){
        //             root.right = helper(root.right);
        //             break;
        //         }
        //         else{
        //             root = root.right;
        //         }
        //     }
        // }
        // return dummy;

        if(val < root.data){
            root.left = deleteNode(root.left, val);
        }
        else{
            root.right = deleteNode(root.right, val);
        }
        
        return root;
    } 

    public static Node findRightMost(Node root){
        if(root.right == null){
            return root;
        }
        return findRightMost(root.right);
    }

    public static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + "  ");
            inorder(root.right);
        }
    }

    static int count = 0;
    static int smallest = -1;
    public static void inorderModified(Node root, int k){
        if(root == null){
            return;
        }
        inorderModified(root.left, k);
        count++;
        if(count == k){
            smallest = root.data;
            return;
        }
        inorderModified(root.right, k);
    }

    // BST Validation - 3rd Approach (Optimized Inorder)
    static Node prev = null;
    
    public static boolean isValidBST(Node root) {
        prev = null; // Reset for each call
        return inorderCheck(root);
    }
    
    private static boolean inorderCheck(Node root) {
        if (root == null) {
            return true;
        }
        
        // Check left subtree
        if (!inorderCheck(root.left)) {
            return false;
        }
        
        // Check current node with previous node
        if (prev != null && root.data <= prev.data) {
            return false;
        }
        prev = root;
        
        // Check right subtree
        return inorderCheck(root.right);
    }

    public static Node inorderSuccessor(Node root, int key){

        Node successor = null;
        if(root == null){
            return null;
        }

        while(root != null){
            if(key >= root.data && root.right != null){
                root = root.right;
            }
            else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static Node inorderPredecessor(Node root, int key){

        Node Predecessor = null;
        if(root == null){
            return null;
        }

        while(root != null){
            if(key > root.data){
                Predecessor = root;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return Predecessor;
    }


    public static void main(String[] args) {
        Node root = null;
        
        int[] arr = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int i = 0; i < arr.length; i++) {
            root = createBST(root , arr[i]);
        }

        // System.out.println(findMin(root).data);
        // System.out.println(findMax(root).data);
        // System.out.println(findCeiling(root, 75));
        // System.out.println(findFloor(root, 75));

        inorder(root);
        System.out.println();
        
        // Test BST validation
        // System.out.println("Is valid BST: " + isValidBST(root));
        
        // Test with kth smallest
        // inorderModified(root, 1);
        // System.out.println("1st smallest: " + smallest);
        // root = deleteNode(root, 50);  
        // root = deleteNode(root, 40);  
        // System.out.println();
        // inorder(root);

        System.out.println(inorderSuccessor(root, 20).data);
        System.out.println();
        System.out.println(inorderPredecessor(root, 20).data);
    }
}
