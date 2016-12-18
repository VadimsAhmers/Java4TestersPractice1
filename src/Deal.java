import java.util.Date;

/**
 * Created by Вадим on 18.12.2016.
 */
public class Deal {

    private Date date;
    private Party seller;
    private Party buyer;
    private Product[] products;

    public Date getDate() {
        return date;
    }

    public Party getSeller() {
        return seller;
    }

    public Party getBuyer() {
        return buyer;
    }

    public Product[] getProducts() {
        return products;
    }

    public Deal(Party seller, Party buyer, Product[] products){
        this.date = new Date();
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;

    }

    public double getSum(){

        double sum = 0;
        for (Product product: products){
            sum += product.getCost();
        }
        return sum;


    }


}
