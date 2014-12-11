package linkedlist;

/**
 * Created by anurag on 11/14/14.
 */
public class Partition {

    public Node partition(Node head, int k){
        Node left = new Node();
        Node origLeft = left;

        Node right = new Node();
        Node origRight = right;

        while(head != null){
            Node node = new Node();
            node.value = head.value;
            node.next = null;

            if(head.value <= k){
                left.next = node;
                left = left.next;
            }else{
                right.next = node;
                right = right.next;
            }

            head = head.next;
        }

        origLeft = origLeft.next;
        origRight = origRight.next;

        if(origLeft == null && origRight == null){
            return null;
        }else if(origLeft == null){
            return origRight;
        }else if(origRight == null){
            return origRight;
        }

        left.next = origRight;
        return origLeft;
    }

    public static void main(String args[]){
        DeleteKth deleteKth = new DeleteKth();
        Partition partition = new Partition();
        NodeOperation nodeOperation = new NodeOperation();

        int[] numbers = new int[]{10,20,3,40,50,60,7,80,9,91};
        Node head = nodeOperation.createList(numbers);

        nodeOperation.printList(head);
        nodeOperation.printList(partition.partition(head, 10));
    }
}
