//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
      static Node tar;
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
         ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Node> q1 = new LinkedList<>();
        
        Queue<Node> q2 = new LinkedList<>();
        
        HashMap<Node,Node> hs_Parent= new HashMap<>();
        
        HashMap<Node,Boolean> isVisited = new HashMap<>();
        int dist=0;
        
        q1.add(root);
        hs_Parent.put(root,root);
        while(!q1.isEmpty()){
            Node curr = q1.poll();
            
            if(curr.left!=null){
                q1.add(curr.left);
                hs_Parent.put(curr.left,curr);
            }
            if(curr.right!=null){
                q1.add(curr.right);
                hs_Parent.put(curr.right,curr);
            }
        }
        
        getTarget(root,target);
        
        q2.offer(tar);
        
        isVisited.put(tar,true);
        
        while(!q2.isEmpty()){
            if(dist==k) break;
            dist++;
            
            int size= q2.size();
            
            for(int i=0;i<size; i++){
             Node curr= q2.poll();
             if(curr.left!=null&& isVisited.get(curr.left)==null){
                isVisited.put(curr.left,true);
                q2.offer(curr.left);
               
            }
            if(curr.right!=null && isVisited.get(curr.right)==null){
                isVisited.put(curr.right,true);
                q2.offer(curr.right);
                }
            
            
            if(isVisited.get(hs_Parent.get(curr))==null){
                q2.offer(hs_Parent.get(curr));
                isVisited.put(hs_Parent.get(curr),true);
            }
          }
        }
          
        while(!q2.isEmpty()){
            Node curr = q2.poll();
            ans.add(curr.data);
        }
        Collections.sort(ans);
        return ans;
        
    }
    public static void getTarget(Node root, int target){
        if(root==null){
            return ;
        }
        if(root.data==target){
            tar= root;
            return;
        }
        getTarget(root.left,target);
        getTarget(root.right,target);
    }
    
};