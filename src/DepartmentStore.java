import java.util.Scanner;

public class DepartmentStore {

    public static void main(String[] args) {
        final int MAX_NAME = 20;
        final int MAX_RFID_NUM = 9;
        final int MAX_LOCATION = 6;

        Scanner userInput = new Scanner(System.in);
        String choice = new String();

        ItemList itemList = new ItemList();

        do {
            try {
                System.out.printf("Welcome!\n\n");
                System.out.printf("C) Clean store\n");
                System.out.printf("I) Insert an item into the list\n");
                System.out.printf("L) List by location\n");
                System.out.printf("M) Move an item in the store\n");
                System.out.printf("O) Checkout\n");
                System.out.printf("P) Print all items in store\n");
                System.out.printf("R) Print by RFID tag number\n");
                System.out.printf("U) Update inventory system\n");
                System.out.printf("Q) Exit the program.\n\n");

                System.out.printf("Select an Operation: ");
                choice = userInput.nextLine();

                if (choice.equalsIgnoreCase("C")) {
                    itemList.cleanStore();

                } else if (choice.equalsIgnoreCase("I")) {
                    System.out.printf("Enter the name: ");
                    String name = userInput.nextLine();

                    if (name.length() > MAX_NAME)
                        throw new IllegalArgumentException("Name can only contain maximum of 20 characters");

                    System.out.printf("Enter the RFID: ");
                    String rfid = userInput.nextLine();

                    if (rfid.length() > MAX_RFID_NUM || !rfid.matches("[0-9a-fA-F]+"))
                        throw new IllegalArgumentException("RFID can only contain maximum of 9 characters from 0-9 or a-f or A-F");

                    System.out.printf("Enter the original location: ");
                    String location = userInput.nextLine();

                    if (location.length() > MAX_LOCATION || !location.startsWith("s"))
                        throw new IllegalArgumentException("Location can only contain maximum of 6 characters and must start with s");

                    System.out.printf("Enter the price: ");
                    double price = userInput.nextDouble();

                    itemList.insertInfo(name, price, rfid, location);

                    System.out.println("\nItem added");

                    userInput.nextLine();


                } else if (choice.equalsIgnoreCase("L")) {
                    System.out.printf("Enter the original location: ");
                    itemList.printByLocation(userInput.nextLine());

                } else if (choice.equalsIgnoreCase("M")) {
                    System.out.printf("Enter the RFID: ");
                    String rfid = userInput.nextLine();

                    System.out.printf("Enter the source location: ");
                    String source = userInput.nextLine();

                    System.out.printf("Enter the destination location: ");
                    String destination = userInput.nextLine();

                    if(itemList.moveItem(rfid,source,destination))
                        System.out.printf("Item with RFID: %s moved from %s to %s", rfid,source,destination);
                    else
                        throw new Exception("Invalid move: Data entered does not match any item in the list");


                } else if (choice.equalsIgnoreCase("O")) {
                    System.out.printf("Enter the cart number: ");
                    String cartNum = userInput.nextLine();

                    System.out.printf("The total cost for all merchandise in cart %s was $%.2f\n", cartNum, itemList.checkOut(cartNum));

                } else if (choice.equalsIgnoreCase("P")) {
                    itemList.printAll();
                } else if (choice.equalsIgnoreCase("R")) {
                    System.out.printf("Enter the RFID: ");
                    itemList.printByRFID(userInput.nextLine());

                } else if (choice.equalsIgnoreCase("U")) {
                    itemList.removeAllPurchased();
                }

                System.out.println();

            } catch (Exception e) {
                System.out.println(e.getMessage());

                System.out.println();
            }

        } while (!choice.equalsIgnoreCase("Q"));

        System.exit(0);
    }
}
