/**
 *
 */

public class ItemInfoNode {

    private ItemInfo item;
    private ItemInfoNode prev;
    private ItemInfoNode next;

    public ItemInfoNode(ItemInfo item) {
        this.item = item;
        prev = null;
        next = null;
    }

    public void setInfo(ItemInfo info){
        item = info;
    }

    public ItemInfo getInfo(){
        return item;
    }

    public void setPrev(ItemInfoNode node) {
        this.prev = node;
    }

    public void setNext(ItemInfoNode node) {
        this.next = node;
    }

    public ItemInfoNode getNext() {
        return next;
    }

    public ItemInfoNode getPrev() {
        return prev;
    }
}
