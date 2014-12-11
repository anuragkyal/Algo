package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by anurag on 11/19/14.
 */
public class ThanhFB {
    public Node buildSuffixTreeAndEncodeOnFly(String s){
        Node root = new Node(' ');
        boolean[] marked = new boolean[s.length()];

        for(int i=0; i<s.length(); i++){
            Node temp = root;
            int lastIndex = s.length();
            int start = -1;
            int length = 0;

            for(int j=i; j<s.length(); j++){
                boolean flagExists = false;

                for(Node child: temp.children){
                    if(child.value == s.charAt(j)){
                        temp = child;
                        flagExists = true;

                        length++;

                        if(start == -1){
                            //branch is a list of leaf nodes in sorted order. just do a binary search for your
                            //interval
                            start = child.branch.get(0);
                        }

                        break;
                    }
                }

                if(!flagExists){
                    lastIndex = j;
                    break;
                }
            }

            for(int j=lastIndex; j<s.length(); j++){
                Node node = new Node(s.charAt(j));
                node.branch.add(i);
                temp.children.add(node);
                temp = node;
            }

            if(!marked[i]){
                if(length >=3){
                    length = length > i ? i : length;
                    System.out.print("(" + (start) + "," + length + ")");
                    for (int j = i; j < i + length; j++) {
                        marked[j] = true;
                    }
                }else{
                    System.out.print(s.charAt(i));
                    marked[i] = true;
                }
            }
        }

        System.out.println();
        return root;
    }

    public static void main(String args[]){
        ThanhFB thanhFB = new ThanhFB();
        Scanner scan = new Scanner(System.in);
        Node node = thanhFB.buildSuffixTreeAndEncodeOnFly(scan.nextLine());
        return;
    }
}

class Node{
    char value;
    List<Node> children;
    List<Integer> branch;

    Node(char value){
        this.value = value;
        children = new ArrayList<Node>();
        branch = new ArrayList<Integer>();
    }
}