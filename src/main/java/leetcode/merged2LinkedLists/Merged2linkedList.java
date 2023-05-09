package leetcode.merged2LinkedLists;

import java.util.*;

public class Merged2linkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(7);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n5.next = n6;
        n6.next = n7;

     /*   ListNode listNode = Merged2linkedList.mergeTwoLists5(n1, n5);
        ListNode.printNode(listNode);*/

        ListNode l5 = ListNode.mergeTwoLists(n1, n5);
        ListNode.printNode(l5);
    }

    static class ListNode {
        private int value;
        private ListNode next;


        public ListNode(int value) {
            this.value = value;
        }

        public ListNode() {
        }

        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            while (list1 != null) {
                l1.add(list1.value);
                list1 = list1.next;
            }

            while (list2 != null) {
                l2.add(list2.value);
                list2 = list2.next;
            }
            l1.addAll(l2);
            Collections.sort(l1);
            return generateFromList2(l1);
        }

        public static ListNode generateFromList(List<Integer> l1) {
            List<ListNode> listNodes = new ArrayList<>();
            for (int i = 0; i < l1.size(); i++) {
                listNodes.add(new ListNode(l1.get(i)));
            }
            ListNode resultNode = new ListNode(listNodes.get(0).value);
            Stack<ListNode> stack = new Stack<>();
            for (int i = 1; i < listNodes.size(); i++) {
                if (resultNode.next == null) {
                    resultNode.next = listNodes.get(i);
                } else {
                    while (resultNode.next != null) {
                        stack.push(resultNode.next);
                        resultNode.next = resultNode.next.next;
                    }
                    ListNode pop = stack.pop();
                    pop.next = listNodes.get(i);
                    stack.clear();
                }
            }
            return resultNode;
        }

        public static void printNode(ListNode node1) {
            while (node1 != null) {
                System.out.println(node1.value);
                node1 = node1.next;
            }
        }

        public static ListNode generateFromList2(List<Integer> l1) {
            ListNode head = new ListNode(0);
            ListNode handler = head;
            for (int i = 0; i < l1.size(); i++) {
                handler.next = new ListNode(l1.get(i));
                handler = handler.next;
            }
            return head.next;
        }
    }

    public static ListNode mergeTwoLists5(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                handler.next = list1;
                list1 = list1.next;
            } else {
                handler.next = list2;
                list2 = list2.next;
            }
            handler = handler.next;
        }

        if (list1 != null) {
            handler.next = list1;
        } else if (list2 != null) {
            handler.next = list2;
        }
        return head.next;
    }
}
