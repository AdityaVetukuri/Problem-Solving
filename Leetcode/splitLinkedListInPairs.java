import java.util.*;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
 }
class splitLinkedListInPaiurs {
    public  static  ListNode2[] splitListToParts(ListNode2 root, int k) {
        ListNode2[] res = new ListNode2[k];
        Arrays.fill(res,null);

        int n = 0;
        ListNode2 curr = root;
        while(curr!=null)
        {
            n++;
            curr = curr.next;
        }
        int mostParts = n/k;
        int firstParts = n%k;
        int extraParts = mostParts + 1;
        ListNode2 passer = root;
        ListNode2 current = root;
        int splits = 0;
        int i = 0;
        while(passer!=null)
        {
            current = passer;
            if(firstParts <= 0)
                splits = mostParts;
            else
                splits = mostParts + 1;
            ListNode2 temp = current;
            while(splits > 1)
            {
                current = current.next;
                splits--;
            }
            if(current!=null) {
                passer = current.next;
                current.next = null;
            }
            else
                passer = null;
           res[i] = temp;
            i++;
            firstParts--;

        }
        return res;
    }

    public static void main(String[] args) {
        ListNode2 root = new ListNode2(1);
        root.next = new ListNode2(2);
        root.next.next = new ListNode2(3);
        root.next.next.next = new ListNode2(4);
        root.next.next.next.next = new ListNode2(5);
        root.next.next.next.next.next = new ListNode2(6);
        root.next.next.next.next.next.next = new ListNode2(7);
        root.next.next.next.next.next.next.next = new ListNode2(8);
        root.next.next.next.next.next.next.next.next = new ListNode2(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode2(10);
        int k = 5;

        splitListToParts(root, k);
    }
}