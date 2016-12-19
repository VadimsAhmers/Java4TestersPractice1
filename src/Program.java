import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Вадим on 18.12.2016.
 */
public class Program {

    private static Deal[] deals = new Deal[10];
    private static int dealIndex = 0;

    public Deal inputDeal(){

        Party buyer = inputParty("Buyer name");
        Party seller = inputParty("Seller name");
        Product[] products = inputProducts();
        return new Deal(seller, buyer, products);

    }
    private Party inputParty(String reason){

            String partyName = keyboardInput(reason);
            Party party = new Party();
            party.setName(partyName);
            return party;

    }
    private Product[] inputProducts() {

        int productsCount = 0;
        Product[] products = new Product[3];

        while (productsCount<3) {

        String title = keyboardInput("Title");
        String priceStr = keyboardInput("Price");
        String quantityStr = keyboardInput("Quantity");

        double price = Double.parseDouble(priceStr);
        int quantity = Integer.parseInt(quantityStr);

            Product product = new Product();
            product.setTitle(title);
            product.setPrice(price);
            product.setQuantity(quantity);

            products[productsCount] = product;
            productsCount++;
        }
        return products;
    }
        private String keyboardInput(String message){

            System.out.println("Enter " + message);

            Scanner scanner = new Scanner(System.in);
            return scanner.next();

    }

    private static void outputDeals() throws NullPointerException{
        for (Deal deal : deals){
            System.out.println("Deal: ");
            System.out.println("Buyer: " + deal.getBuyer().getName() + ", Seller: " + deal.getSeller().getName());
            System.out.println("Products: " + deal.getProducts());
            System.out.println("Total Cost: " + deal.getSum());
            System.out.println("------------------------------");
        }
    }

    public static void main(String[] args) {


        String answer = "y";
        while (answer.equals("y")){
            System.out.println("Do you want to enter new Deal? Y/N");

            Scanner scanner = new Scanner(System.in);
            answer = scanner.next();
            if (answer.toLowerCase().equals("y")) {

                deals[dealIndex] = new Program().inputDeal();
                dealIndex++;
            }

        }
        try{
        outputDeals();
        }catch (NullPointerException npe){
            System.out.println("Massive of Deals is not Filled! (It must have 3 elements)");
        }
    }










}
