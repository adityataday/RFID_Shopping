/**
 *
 */

public class ItemList {

    private ItemInfoNode head;
    private ItemInfoNode tail;
    private ItemInfoNode cursor;

    ItemInfo item;
    ItemInfoNode newNode;

    public ItemList() {
        head = null;
        tail = null;
        cursor = null;
    }

    public void insertInfo(String name, double price, String rfidTag, String initPosition) {
        item = new ItemInfo(name, price, rfidTag, initPosition);
        newNode = new ItemInfoNode(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            cursor = head;
            while (cursor != null) {
                if (cursor.getInfo().getRfidTagNumber().compareToIgnoreCase(newNode.getInfo().getRfidTagNumber()) > 0 || cursor.getInfo().getRfidTagNumber().compareToIgnoreCase(newNode.getInfo().getRfidTagNumber()) == 0) {
                    if (cursor == head) {
                        newNode.setNext(head);
                        head.setPrev(newNode);
                        head = newNode;
                    } else {
                        newNode.setNext(cursor);
                        newNode.setPrev(cursor.getPrev());
                        cursor.setPrev(newNode);
                        cursor.getPrev().setNext(newNode);
                    }
                } else {
                    if (cursor == tail) {
                        tail.setNext(newNode);
                        newNode.setPrev(tail);
                        tail = newNode;
                    }
                }

                cursor = cursor.getNext();

            }
        }

    }
}
