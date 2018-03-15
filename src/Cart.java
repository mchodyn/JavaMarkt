import java.util.ArrayList;
public class Cart {
    ArrayList<CartItem> items = new ArrayList<>();
    ArrayList<IPromotion> promotions = new ArrayList<>();
    double promotionSumOfProducts=0;
    public double totalPrice(){
        double sum=0;
        for (CartItem it:items) {
            sum+= it.getProduct().getPrice();

        }
        return sum;
    }
    public double totalPriceWithDiscount(){
        double sum=0;
        for (CartItem it:items ) {
            sum+= it.getCurrentPrice();
        }
        return sum;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
    public Cart addProduct(Product product){
        items.add(new CartItem(product));
        promotionSumOfProducts +=product.getPrice();
        return this;
    }
    public Cart addPromo(IPromotion promotion){
        promotions.add(promotion);
    return this;
    }
    public Cart applyPromo(){
        for (IPromotion promo: promotions
             ) {
            promo.CalcOffer(this);
        }
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", promotions=" + promotions +
                ", promotionSumOfProducts=" + promotionSumOfProducts +
                '}';
    }
}
