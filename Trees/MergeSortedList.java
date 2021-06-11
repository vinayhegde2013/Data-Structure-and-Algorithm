package com.comp.prog;

public class MergeSortedList {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(6);

		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(9);

		ListNode result = MergeUtil(l1, l2);

		while (result != null) {
			System.out.print(result.val);
			result = result.next;

		}
	}

	public static ListNode MergeUtil(ListNode l1, ListNode l2) {

		ListNode res = new ListNode();
		ListNode head = res;

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				res.next = l1;
				l1 = l1.next;
			} else {
				res.next = l2;
				l2 = l2.next;
			}

			res = res.next;
		}

		if (l1 != null)
			res.next = l1;
		if (l2 != null)
			res.next = l2;

		return head.next;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
