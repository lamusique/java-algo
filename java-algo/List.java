/**
 *  リスト
 *
 *  @version $Revision: 1.3 $, $Date: 2003/04/28 23:23:17 $
 */

public class List {
    class Item {
        Item next;  int info;
        Item(Item next, int info) {
            this.next = next;  this.info = info;
        }
    }

    Item head = null;

    public void add(int info) {
        Item q = new Item(head, info);
        head = q;
    }

    public String toString() {
        String s = "";
        for (Item p = head; p != null; p = p.next) s += " " + p.info;
        return s;
    }

    public void reverse() {
        Item q = null;
        for (Item p = head; p != null; ) {
            Item t = q;  q = p;  p = p.next;  q.next = t;
        }
        head = q;
    }

    public static void main(String[] args) {
        List list = new List();  // 空のリスト
        for (int x = 1; x <= 9; x++) list.add(x);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
