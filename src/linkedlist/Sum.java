package linkedlist;

/**
 * Created by anurag on 11/14/14.
 */
public class Sum {
    public Node sum(Node node1, Node node2){
        Node sumNode = new Node();
        Node temp = sumNode;
        int carry = 0;

        while(node1 != null && node2 != null){
            int sum = node1.value + node2.value + carry;
            carry = sum/10;

            Node node = new Node(sum%10, null);
            temp.next = node;
            temp = temp.next;

            node1 = node1.next;
            node2 = node2.next;
        }

        if(node1 == null && node2 == null){
            if(carry != 0){
                Node node = new Node(carry, null);
                temp.next = node;
            }
            return sumNode.next;
        }

        Node nonNull = node1 == null ? node2 : node1;

        while (nonNull != null){
            int sum = nonNull.value + carry;
            carry = sum/10;

            Node node = new Node(sum%10, null);
            temp.next = node;
            temp = temp.next;

            nonNull = nonNull.next;
        }

        return sumNode.next;
    }

    public void printNode(Node node){
        while (node != null){
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

    public  static  void main(String args[]){
        Sum sum = new Sum();

        Node node1;
        Node node2;

        int[] ar1 = new int[]{1, 2, 4};
        int[] ar2 = new int[]{2, 3, 9, 5, 4, 2, 1};

        node1 = NodeOperation.createList(ar1);
        node2 = NodeOperation.createList(ar2);

        NodeOperation.printList(sum.sum(node1, node2));
    }
}
