package linkedlist;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurag on 11/13/14.
 */
public class KFromLast {
    public Pair<Node, Integer> getKFromLast(Node head, int K){
        if(head == null){
            return new Pair<Node, Integer>(null, 0);
        }

        Pair<Node, Integer> kNode = getKFromLast(head.next, K);

        if(kNode.getValue() == K){
            kNode = new Pair<Node, Integer>(head, kNode.getValue()+1);
        }else {
            kNode = new Pair<Node, Integer>(kNode.getKey(), kNode.getValue()+1);
        }

        return kNode;
    }

    public Node getKFromLast2(Node head, int k){
        List<Node> nodes = new ArrayList<Node>();

        while(head != null){
            nodes.add(0, head);
            head = head.next;
        }

        return nodes.get(k);
    }

    public static void main(String args[]){
        NodeOperation nodeOperation = new NodeOperation();

        int[] numbers = new int[]{10,20,30,40,50,60,71,80,90,91};
        Node head = nodeOperation.createList(numbers);

        System.out.print(new KFromLast().getKFromLast(head, 1).getKey().value);
        System.out.print(new KFromLast().getKFromLast2(head, 1).value);
    }
}
