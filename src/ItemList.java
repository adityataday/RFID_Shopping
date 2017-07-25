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
                        break;
                    } else {
                        cursor.getPrev().setNext(newNode);
                        newNode.setNext(cursor);
                        newNode.setPrev(cursor.getPrev());
                        cursor.setPrev(newNode);
                    }
                } else {
                    if (cursor == tail) {
                        tail.setNext(newNode);
                        newNode.setPrev(tail);
                        tail = newNode;
                        break;
                    }
                }

                cursor = cursor.getNext();

            }
        }

    }

    public void removeAllPurchased() {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

        cursor = head;

        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
                System.out.println(cursor.toString());

                if (cursor == head) {
                    head = cursor.getNext();
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

    public void printAll() {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

        cursor = head;

        while (cursor != null) {
            System.out.println(cursor.toString());
            cursor = cursor.getNext();
        }
    }

    public void printByLocation(String location) {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

        cursor = head;

        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase(location))
                System.out.println(cursor.toString());
            cursor = cursor.getNext();
        }
    }

    public void cleanStore() {
        System.out.println("The following item(s) have been moved back to their original location");
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

        cursor = head;

        while (cursor != null) {
            if (cursor.getInfo().getOriginalLocation().compareToIgnoreCase(cursor.getInfo().getCurrentLocation()) != 0 && !cursor.getInfo().getCurrentLocation().equalsIgnoreCase("out") && !cursor.getInfo().getCurrentLocation().startsWith("c")) {
                System.out.println(cursor.toString());
                cursor.getInfo().setCurrentLocation(cursor.getInfo().getOriginalLocation());
            }

            cursor = cursor.getNext();
        }
    }

    public double checkOut(String cartNumber) throws Exception {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

        cursor = head;
        double totalAmount = 0;

        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase(cartNumber)) {
                cursor.getInfo().setCurrentLocation("out");
                System.out.println(cursor.toString());
                totalAmount += cursor.getInfo().getPrice();
            }else if(cursor == tail){
                throw new Exception("Cart not found");
            }

            cursor = cursor.getNext();
        }


        return totalAmount;

    }

    public void printByRFID(String rfidTagNumber) {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s\n", "Item Name", "RFID", "Original Location", "Current Location", "Price");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

        cursor = head;

        while (cursor != null) {
            if (cursor.getInfo().getRfidTagNumber().equalsIgnoreCase(rfidTagNumber)) {
                System.out.println(cursor.toString());
            }

            cursor = cursor.getNext();
        }
    }


}
