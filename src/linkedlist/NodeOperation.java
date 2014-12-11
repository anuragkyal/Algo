package linkedlist;

/**
 * Created by anurag on 11/14/14.
 */
public class NodeOperation {
    public static Node createList(int[] array){
        Node head = new Node();
        Node temp = head;

        for(int n: array){
            Node node = new Node(n, null);
            temp.next = node;
            temp = temp.next;
        }

        return head.next;
    }

    public static void printList(Node head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node createLoopNode(int[] numbers, int n){
        Node node = createList(numbers);
        Node origNode = node;

        if(n >= numbers.length-1){
            System.out.println("cant loop!");
            return node;
        }

        int i=0;
        Node iNode = null;

        while(node.next != null){
            if(i == n){
                iNode = node;
            }

            node = node.next;
            i++;
        }

        node.next = iNode;
        return origNode;
    }
}
