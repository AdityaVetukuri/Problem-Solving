import java.util.*;
class ListNode3 {
     int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
  }

class RemoveDuplicatesII82 {
    public static ListNode3 deleteDuplicates(ListNode3 head) {
       ListNode3 sentinel = new ListNode3(0, head);
       ListNode3 pred = sentinel;
        while(head.next != null)
        {
            if(head.next != null && head.val == head.next.val)
           {
               while(head.next != null && head.next.val == head.val) {
                   head = head.next;
               }
               pred.next = head.next;
           }
            else
            {
                pred = pred.next;
            }
           head = head.next;

        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(3);
        head.next.next.next = new ListNode3(3);
        head.next.next.next.next = new ListNode3(4);
        head.next.next.next.next.next = new ListNode3(5);
        deleteDuplicates(head);

    }
}