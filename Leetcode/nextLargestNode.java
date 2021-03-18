import java.util.*;

class ListNode {
    int val;
    ListNode next;
}

class nextLargestNode {
    public int[] nextLargerNodes(ListNode head) {

        Stack<ListNode> list = new Stack<ListNode>();
        int size = 1;
        ListNode temp = head;

        list.push(temp);
        temp = temp.next;

        while (temp != null) {
            while (!list.empty() && temp.val > list.peek().val) {
                ListNode current = list.pop();
                current.val = temp.val;
            }
            size++;
            list.push(temp);
            temp = temp.next;
        }

        while (!list.empty()) {
            ListNode current = list.pop();
            current.val = 0;
        }

        int[] array = new int[size];
        temp = head;

        for (int i = 0; i < size; i++) {
            array[i] = temp.val;
            temp = temp.next;
        }
        return array;
    }
}