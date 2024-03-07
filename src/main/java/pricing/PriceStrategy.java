package pricing;

public interface PriceStrategy {
    double calculatePrice(double unitPrice, int quantity);
}
