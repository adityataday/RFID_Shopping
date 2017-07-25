/**
 *
 */

public class ItemInfo {

    private String name;
    private Double price;
    private String rfidTagNumber;
    private String originalLocation;
    private String CurrentLocation;

    public ItemInfo() {
        price = 0.00;
    }

    public ItemInfo(String name, Double price, String rfidTagNumber, String location) {
        this.name = name;
        this.price = price;
        this.rfidTagNumber = rfidTagNumber;
        this.originalLocation = location;
        this.CurrentLocation = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRfidTagNumber() {
        return rfidTagNumber;
    }

    public void setRfidTagNumber(String rfidTagNumber) {
        this.rfidTagNumber = rfidTagNumber;
    }

    public String getOriginalLocation() {
        return originalLocation;
    }

    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }

    public String getCurrentLocation() {
        return CurrentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        CurrentLocation = currentLocation;
    }
}
