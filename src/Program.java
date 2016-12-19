import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Вадим on 18.12.2016.
 */
public class Program {

    private static Deal[] deals = new Deal[10];
    private static int dealIndex = 0;

    public static Deal inputDeal(){

        Party buyer = inputParty("Buyer name");
        Party seller = inputParty("Seller name");
        Product[] products = inputProducts();
        return new Deal(seller, buyer, products);

    }
    private static Party inputParty(String reason){

            String partyName = keyboardInput(reason);
            Party party = new Party();
            party.setName(partyName);
            return party;

    }
    private static Product[] inputProducts() {

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
        private static String keyboardInput(String message){

            System.out.println("Enter " + message);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String str = "-1";

            try{
                str = buffer.readLine();

            } catch (IOException e){
                System.out.println(e.toString());
            }
            return str;


    }

    public static void main(String[] args) {

        deals[dealIndex] = inputDeal();

        for (Deal deal:deals)
            System.out.println("Deal! Buyer: " + deal.getBuyer().getName() + ", Seller: " + deal.getSeller().getName() + ", Cost: " + deal.getSum());


    }











}
