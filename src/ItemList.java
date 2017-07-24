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

    /**
     * Time complexity is Big O(n).
     *
     * @param name
     * @param price
     * @param rfidTag
     * @param initPosition
     */
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

    public void removeAllPurchased() {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------");

        cursor = head;

        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
                System.out.println(cursor.toString());

                if (cursor == head) {
                    head = cursor.getNext();
                    head.setPrev(null);
                } else if (cursor == tail) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                } else {
                    cursor.getNext().setPrev(cursor.getPrev());
                    cursor.getPrev().setNext(cursor.getNext());
                }
            }

            cursor = cursor.getNext();

        }
    }

    public boolean moveItem(String rfidTag, String source, String dest) {
        cursor = head;

        while (cursor != null) {
            if (cursor.getInfo().getRfidTagNumber().equalsIgnoreCase(rfidTag) && cursor.getInfo().getCurrentLocation().equalsIgnoreCase(source)) {
                cursor.getInfo().setCurrentLocation(dest);
                return true;
            } else {
                cursor = cursor.getNext();
            }
        }

        return false;
    }

    public void printAll(){
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------");

        cursor = head;

        while(cursor != null){
            System.out.println(cursor.toString());
            cursor = cursor.getNext();
        }
    }


}
