package leetcode.merged2LinkedLists;

import java.util.*;
import java.util.ArrayList;

public class Merge2LinkedLists {
    public static void main(String[] args) {

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

        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 != null) {
                return list2;
            }
            if (list2 == null && list1 != null) {
                return list1;
            }

            List<Integer> mergedValues = new ArrayList<>();
            while (list1 != null) {
                mergedValues.add(list1.val);
                list1 = list1.next;
            }
            while (list2 != null) {
                mergedValues.add(list2.val);
                list2 = list2.next;
            }
            Collections.sort(mergedValues);

            ListNode head = new ListNode(0);
            ListNode current = head;
            for (int i = 0; i < mergedValues.size(); i++) {
                current.next = new ListNode(mergedValues.get(i));
                current = current.next;
            }

            return head.next;
        }
    }
}
