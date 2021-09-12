package com.comp.prog;

public class IntersectionOfLinkedList {

	public static void main(String[] args) {

		ListNode listNode1 = new ListNode(2);
		listNode1.next = new ListNode(3);
		listNode1.next.next = new ListNode(4);
		listNode1.next.next.next = new ListNode(5);
		listNode1.next.next.next.next = new ListNode(12);

		ListNode listNode2 = new ListNode(2);
		listNode2.next = new ListNode(3);
		listNode2.next.next = new ListNode(4);
		listNode2.next.next.next = new ListNode(5);
		listNode2.next.next.next.next = new ListNode(12);

		findIntersection(listNode1, listNode2);

	}

	private static ListNode findIntersection(ListNode listNode1, ListNode listNode2) {

		ListNode l1 = listNode1;
		ListNode l2 = listNode2;

		while (l1 != l2) {
			if (l1 == null)
				l1 = listNode2;
			else if (l2 == null)
				l2 = listNode1;
			l1 = l1.next;
			l2 = l2.next;
			if (l1 == null && l2 != null)
				l1 = listNode2;
			else if (l2 == null & l1 != null)
				l2 = listNode1;
		}
		return listNode1;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
