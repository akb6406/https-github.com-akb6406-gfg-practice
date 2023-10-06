//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node head)
    {
        if(head.next == null || head.next.next == null){
            return;
        }

        Node prev = head;
        Node curr = head.next;
        Node head2 = head.next;
        Node curr2 = head2;
        curr = curr.next;
        prev.next = curr;
        int count=0;

        while(curr != null && curr.next != null){
            count++;
            if(count%2==0){
                curr2.next= curr;
                curr2 = curr2.next;
                curr = curr.next;
                prev.next = curr;
            }else{
                curr = curr.next;
                prev = prev.next;
            }
        }

        if(curr!=null && curr.next==null){
            curr2.next= curr;
        }

        head2 = reverse(head2);
        prev.next = head2;
        return;
    }

    //Function to reverse the Node
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        Node next = curr.next;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next; 
        }
        curr.next = prev;
        head.next = null;
        head = curr;
        return head;
    
    }
}
