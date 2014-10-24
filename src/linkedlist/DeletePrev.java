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

    public static Node createList(int[] array){
        Node head = new Node();
        Node temp = head;

        for(int n: array){
            Node node = new Node(n, null);
            temp.next = node;
            temp = temp.next;
        }

        return head;
    }

    public static void printList(Node head){
        head = head.next;

        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        int[] numbers = new int[]{10,20,30,40,50,60,71,80,90,91};

        Node head = createList(numbers);
        printList(head);
        head = deletePrev(head, 10);
        printList(head);
    }
}
