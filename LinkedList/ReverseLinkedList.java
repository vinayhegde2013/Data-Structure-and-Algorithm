package com.comp.prog;
public class ReverseLinkedList {

	public static void main(String args[]) {

		ListNode listNode = new ListNode(2);
		listNode.next = new ListNode(3);
		listNode.next.next = new ListNode(4);
		listNode.next.next.next = new ListNode(5);
    
		ListNode res = reverse(listNode);
        }
  
  	// While traversing change the present node's next reference to previous element
	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
  
       static class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
     }

}
