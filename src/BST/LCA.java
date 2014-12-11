package BST;

import java.util.List;

/**
 * Created by anurag on 11/16/14.
 */
public class LCA {
    public Node lca(Node node, int v1, int v2){
        while(v1 < node.value && v2 < node.value || v1 > node.value && v2 > node.value){
            node = v1 < node.value ? node.left : node.right;
        }

        return node;
    }

    public static void main(String args[]){
        LCA lca = new LCA();

        Node bst = BSTHelper.getSampleBST();

        BSTHelper.printInorder(bst);
        System.out.println();

        List<Integer> entries = BSTHelper.inOrderArray(bst);
        System.out.println(lca.lca(bst, entries.get(0), entries.get(entries.size()-1)).value);

        return;
    }
}
