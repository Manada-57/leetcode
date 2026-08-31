/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
        int n=0;
        while(temp.next!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        int i=0;
        int pos=0;
        int[] arr=new int[n-1];
        prev=temp;
        temp=temp.next;
        while(temp.next!=null && temp.next!=null){
            if((temp.val>prev.val && temp.val>temp.next.val)||(temp.val<prev.val && temp.val<temp.next.val)){
                arr[i++]=pos+2;
            }
            pos++;
            prev=temp;
            temp=temp.next;
            
        }
        if(i<2)
        return new int[]{-1,-1};
        int mind=Integer.MAX_VALUE;
        int maxd=arr[i-1]-arr[0];
        for(int j=1;j<i;j++){
            int t=arr[j]-arr[j-1];
            if(t<mind){
                mind=t;
            }
        }
        return new int[]{mind,maxd};
    }
}