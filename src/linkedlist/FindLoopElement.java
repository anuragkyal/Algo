package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurag on 11/14/14.
 */
public class FindLoopElement {
    public Node getLoopElement(Node node){
        List<Node> explored = new ArrayList<Node>();

        while(node.next != null && !explored.contains(node.next)){
            explored.add(node);
            node = node.next;
        }

        if(node.next != null){
            return node.next;
        }

        return null;
    }

    public static void main(String args[]){
        FindLoopElement findLoopElement = new FindLoopElement();

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9 , 10};

        Node node = NodeOperation.createLoopNode(numbers, 3);

        Node loopNode = findLoopElement.getLoopElement(node);
        System.out.println(loopNode.value);
    }
}
