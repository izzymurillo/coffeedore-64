import java.util.ArrayList;

// Create a new class called CoffeeKiosk
public class CoffeeKiosk {

  // ===== MEMBER VARIABLES =====
  private ArrayList<Item> menu;
  private ArrayList<Order> orders;

  // ===== CONSTRUCTOR =====
  // no params, initializes items and orders to empty arrays.
  public CoffeeKiosk() {
    this.menu = new ArrayList<Item>();
    this.orders = new ArrayList<Order>();
  }

  // ======= METHODS =======
  // addMenuItem
  // The addMenuItem method should create a new item object with the given name
  // and price.
  public void addMenuItem(String name, double price) {
    Item item = new Item(name, price);
    // Add the new Item object to the menu items array.
    menu.add(item);
    // The new menu item itself will also need to be assigned an index property. The
    // value should be its position, its index, in the menu array.
    item.setIndex(menu.indexOf(item));
  }

  // displayMenu
  // Now with an array of items you can display the menu without needing separate
  // arrays of names and prices!
  // The displayMenu method should display all of the items from the menu array
  // like so:
  // 0 banana -- $2.00
  // 1 coffee -- $1.50
  // 2 latte -- $4.50
  // 3 capuccino -- $3.00
  // 4 muffin -- $4.00
  public void displayMenu() {
    for (Item item : menu) {
      System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
    }
  }

  // newOrder
  // The newOrder method will take input from the user in the terminal to create a
  // new order instance and add it to the orders array.
  public void newOrder() {

    // Shows the user a message prompt and then sets their input to a variable, name
    System.out.println("Please enter customer name for new order:");
    String name = System.console().readLine();

    // Your code:
    // Create a new order with the given input string
    Order order = new Order(name);
    // Show the user the menu, so they can choose items to add.
    displayMenu();

    // Prompts the user to enter an item number
    System.out.println("Please enter a menu item index or q to quit:");
    String itemNumber = System.console().readLine();

    // Write a while loop to collect all user's order items
    while (!itemNumber.equals("q")) {

      // Get the item object from the menu, and add the item to the order
      try {
        order.addItem(menu.get(Integer.parseInt(itemNumber)));
      } catch (IndexOutOfBoundsException i) { // (<== error on terminal)
        System.out.println("Invalid Selection");
      } catch (NumberFormatException n) { // (<== error on terminal)
        System.out.println("Invalid Selection");
      }
      // Ask them to enter a new item index or q again, and take their input
      System.out.println("Please enter a menu item index or q to quit:");
      itemNumber = System.console().readLine();
    }
    // After you have collected their order, print the order details
    // as the example below. You may use the order's display method.
    order.display();
  }

}