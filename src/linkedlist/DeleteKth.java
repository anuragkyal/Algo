package linkedlist;

/**
 * Created by anurag on 11/14/14.
 */
public class DeleteKth {
    public void deleteKth(Node root, int K){
        int i = 0;

        while(root != null && i != K){
            root = root.next;
            i++;
        }

        if(root == null){
            return;
        }else if(root.next == null){
            //Dont know what to do here
            root = null;
            return;
        }

        root.value = root.next.value;
        root.next = root.next.next;
    }

    public static void main(String args[]){
        DeleteKth deleteKth = new DeleteKth();
        NodeOperation nodeOperation = new NodeOperation();

        int[] numbers = new int[]{10,20,30,40,50,60,71,80,90,91};
        Node head = nodeOperation.createList(numbers);

        nodeOperation.printList(head);
        deleteKth.deleteKth(head, 10);
        nodeOperation.printList(head);
    }
}
