//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node getMid(Node head) {
        Node slow = head, fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    static Node merging(Node l, Node r) {
        if(l == null)
            return r;
            
        if(r == null)
            return l;
            
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while(l != null && r != null) {
            if(l.data <= r.data) {
                temp.next = l;
                l.prev = temp;
                l = l.next;
            } else {
                temp.next = r;
                r.prev = temp;
                r = r.next;
            }
            
            temp = temp.next;
        }
        
        while(l != null) {
            temp.next = l;
            l.prev = temp;
            l = l.next;
            temp = temp.next;
        }
        
        while(r != null) {
            temp.next = r;
            r.prev = temp;
            r = r.next;
            temp = temp.next;
        }
        
        dummy.next.prev = null;
        return dummy.next;
    }

    static Node sortDoubly(Node head) {
        if(head == null || head.next == null)
            return head;
        
        Node left = head;
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        
        Node res = merging(sortDoubly(left), sortDoubly(right));
        return res;
    }
}