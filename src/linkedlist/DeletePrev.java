package linkedlist;

/**
 * Created by anurag on 10/24/14.
 */
public class DeletePrev {
    public static Node deletePrev(Node head, int n){
        if(head == null || head.next == null){
            System.out.println("No elements");
        }else if(head.next.value == n){
            System.out.println("No previous");
        }else{
            Node curr = head.next.next;
            Node prev = head;

            while(curr != null){
                if(curr.value == n){
                    prev.next = curr;
                    return head;
                }
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String args[]){
        int[] numbers = new int[]{10,20,30,40,50,60,71,80,90,91};

        NodeOperation nodeOperation = new NodeOperation();

        Node head = nodeOperation.createList(numbers);

        nodeOperation.printList(head);
        head = deletePrev(head, 10);
        nodeOperation.printList(head);
    }
}
