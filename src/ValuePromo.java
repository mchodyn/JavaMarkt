public class ValuePromo implements IPromotion {
    @Override
    public boolean CanCalc(Cart cart) {
        double cartWithoutPromo=cart.totalPrice();
        if(cartWithoutPromo>=300)
            return true;
        else
            return false;
    }

    @Override
    public void CalcOffer(Cart cart) {
        if(this.CanCalc(cart)){
            cart.promotionSumOfProducts=cart.totalPrice()*0.95;
        }
    }

    @Override
    public String toString() {
        return "ValuePromo{5% off}";
    }
}
