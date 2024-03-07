package pricing;

public class BasePrice implements PriceStrategy {

    public double calculatePrice(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

}
