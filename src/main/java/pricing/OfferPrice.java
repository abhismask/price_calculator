package pricing;


public class OfferPrice implements PriceStrategy {
    private final int bundleSize;
    private final int priceToBepaidFor;


    public OfferPrice(int bundleSize, int priceToBepaidFor) {
        this.bundleSize = bundleSize;
        this.priceToBepaidFor = priceToBepaidFor;
    }

    public double calculatePrice(double unitPrice, int quantity) {
        int bundle = quantity / bundleSize;
        int remainder = quantity % bundleSize;
        return (bundle * priceToBepaidFor + remainder) * unitPrice;
    }
}
