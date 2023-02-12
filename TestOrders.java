public class TestOrders {

  public static void main(String[] args) {
    
    CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

    coffeeKiosk.addMenuItem("mocha", 5.50);
    coffeeKiosk.addMenuItem("latte", 5.00);
    coffeeKiosk.addMenuItem("drip coffee", 2.50);
    coffeeKiosk.addMenuItem("cappuccino", 3.50);
    coffeeKiosk.addMenuItem("muffin", 4.0);

    coffeeKiosk.newOrder();






  }


  
}
