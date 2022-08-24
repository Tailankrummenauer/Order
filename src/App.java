import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");



    System.out.println("Enter client Data:");
    System.out.print("Name: ");
    String name  = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Birth date (DD/MM/YYYY): ");
    Date birthDate = sdf.parse(sc.next());

    Client client = new Client (name, email, birthDate);

    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    OrderStatus status = OrderStatus.valueOf(sc.next());

    Order order = new Order (new Date(), status, client);

    System.out.print("How many items to this order: ");
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++){
        System.out.println("Enter " + i + " item data:");
        System.out.print("Product name: ");
        sc.nextLine();
        String nameProduct = sc.nextLine();
        System.out.print("Product price: ");
        double priceProduct = sc.nextDouble();

        Product product = new Product(nameProduct, priceProduct);

        System.out.print("Quantity: ");
        int quantityProduct = sc.nextInt();

    OrderItem orderItems = new OrderItem(quantityProduct, priceProduct, product);

    order.addItem(orderItems);

    }

    System.out.println();

    System.out.println("ORDER SUMMARY: ");
    System.out.println(order);

    sc.close();






    }
}
