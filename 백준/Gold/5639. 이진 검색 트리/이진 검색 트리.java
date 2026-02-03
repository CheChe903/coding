import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        TreeNode root = new TreeNode(Integer.parseInt(line));

        while((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);

            TreeNode tempRoot = root;

            while(true) {
                if( tempRoot.value > N) {
                    if(tempRoot.left == null) {
                        tempRoot.left = new TreeNode(N);
                        break;
                    }
                    tempRoot = tempRoot.left;
                } else {
                    if(tempRoot.right == null) {
                        tempRoot.right = new TreeNode(N);
                        break;
                    }
                    tempRoot = tempRoot.right;
                }
            }
        }
        prefix(root);
        
    }

    public static void prefix(TreeNode treeNode) {
        if(treeNode.left != null)  {
            prefix(treeNode.left);
        }
        if(treeNode.right != null) {
            prefix(treeNode.right);
        }

        System.out.println(treeNode.value);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            value =v;
        }

        public void setReft(TreeNode t) {
            left = t;
        }
        public void setRight(TreeNode t) {
            right = t;
        }
    }
}