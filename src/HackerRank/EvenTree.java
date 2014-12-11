package HackerRank;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anurag on 11/18/14.
 */
public class EvenTree {
    int m;
    int n;
    Node root;

    public void parseData() throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        String[] line = b.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);

        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
        int min = m;

        for(int i=0; i<n; i++){
            line = b.readLine().split(" ");

            int e1 = Integer.parseInt(line[0]);
            int e2 = Integer.parseInt(line[1]);

            Node e1Node;
            Node e2Node;

            if(nodeMap.get(e1) != null){
                e1Node = nodeMap.get(e1);
            }else{
                e1Node = new Node(e1);
                nodeMap.put(e1, e1Node);
            }

            if(nodeMap.get(e2) != null){
                e2Node = nodeMap.get(e2);
            }else{
                e2Node = new Node(e2);
                nodeMap.put(e2, e2Node);
            }

            int smaller;
            if(e1 < e2) {
                e1Node.children.add(e2Node);
                smaller = e1;
            }else{
                e2Node.children.add(e1Node);
                smaller = e2;
            }

            if(smaller < min){
                root = nodeMap.get(smaller);
                min = smaller;
            }
        }
    }

    public void preProcess(Node root){
        if(root.children.size() == 0){
            root.size = 1;
        }
        else {
            for (Node child : root.children) {
                preProcess(child);
                root.size += child.size;
            }

            root.size += 1;
        }
    }

    public int countBreak(Node node){
        int count = 0;
        for(Node child: node.children){
            if(child.size %2 == 0){
                count++;
            }

            count += countBreak(child);
        }

        return count;
    }


    public static void main(String args[]) throws IOException {
        EvenTree evenTree = new EvenTree();
        evenTree.parseData();
        evenTree.preProcess(evenTree.root);
        System.out.println(evenTree.countBreak(evenTree.root));
    }
}

class Node{
    int id;
    List<Node> children;
    int size;

    Node(int e){
        id = e;
        children = new ArrayList<Node>();
    }
}
