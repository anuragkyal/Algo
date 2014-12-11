package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by anurag on 11/16/14.
 */
public class BSTHelper {
    public static Node getSampleBST(){
        int[] entries = new int[20];

        Random random = new Random();

        entries[0] = 50;
        for(int i=1; i<20; i++){
            entries[i] = Math.abs(random.nextInt()) % 100 + 1;
        }

        return getSampleBST(entries);
    }

    public static Node getSampleBST(int[] entries){
        if(entries.length == 0){
            return null;
        }

        Node root = new Node();
        Node origRoot = root;
        root.value = entries[0];

        for(int i=1; i<entries.length; i++){
            Node node = new Node();
            node.value = entries[i];

            Node parent = null;
            while(root != null){
                parent = root;
                if(entries[i] <= root.value){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }

            if(entries[i] <= parent.value){
                parent.left = node;
            }else{
                parent.right = node;
            }

            root = origRoot;
        }

        return origRoot;
    }

    public static void printInorder(Node node){
        if(node == null){
            return;
        }

        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    public static List<Integer> inOrderArray(Node node){
        List<Integer> list = new ArrayList<Integer>();
        inOrderArray(node, list);
        return list;
    }

    public static void inOrderArray(Node node, List<Integer> inorderList){
        if(node == null){
            return;
        }

        inOrderArray(node.left, inorderList);
        inorderList.add(node.value);
        inOrderArray(node.right, inorderList);
    }
}
