package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @Description:
 * @Author: sunweiqiang
 * @Date: 2018-05-20
 */
public class _2_AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        System.out.println(l1);
        System.out.println(l4);
        System.out.println(addTwoNumbers(l1, l4));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int tmp = l1.val + l2.val;
        int carry = tmp / 10;
        int remainder = tmp % 10;
        ListNode result = new ListNode(remainder);
        ListNode header = new ListNode(0);
        header.next = result;

        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            tmp = l1.val + l2.val + carry;
            carry = tmp / 10;
            remainder = tmp % 10;
            result.next = new ListNode(remainder);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            tmp = l1.val + carry;
            carry = tmp / 10;
            remainder = tmp % 10;
            result.next = new ListNode(remainder);
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            tmp = l2.val + carry;
            carry = tmp / 10;
            remainder = tmp % 10;
            result.next = new ListNode(remainder);
            result = result.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }

        return header.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val + ", ");
            ListNode tmp = next;
            while (tmp != null) {
                sb.append(tmp.val + ", ");
                tmp = tmp.next;
            }
            return sb.toString();
        }
    }
}
