public class Binary_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void Pre_Order(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        Pre_Order(root.left);
        Pre_Order(root.right);
    }

    public static void In_Order(TreeNode root){
        if(root == null){
            return;
        }
        In_Order(root.left);
        System.out.print(root.val + " ");
        In_Order(root.right);
    }

    public static void Post_Order(TreeNode root){
        if(root == null){
            return;
        }
        Post_Order(root.left);
        Post_Order(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);


        System.out.print("Pre-Order Traversal : ");
        Pre_Order(root);
        System.out.println();
        System.out.print("In-Order Traversal : ");
        In_Order(root);
        System.out.println();
        System.out.print("Post-Order Traversal : ");
        Post_Order(root);

    }
}
