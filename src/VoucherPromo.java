public class VoucherPromo implements IPromotion {
    @Override
    public boolean CanCalc(Cart cart) {
        return true;
    }
//30% procent na najdrozszy produkt
    @Override
    public void CalcOffer(Cart cart) {
        CartItem cheapestOne=new CartItem(new Product(" ",0));

        for (CartItem it:cart.getItems()) {
            if(it.getProduct().getPrice()>cheapestOne.getProduct().getPrice()) {
                cheapestOne.getProduct().setName(it.getProduct().getName());
                cheapestOne.getProduct().setPrice(it.getProduct().getPrice());
            }
        }
        if(this.CanCalc(cart)){
            for (CartItem it:cart.getItems()) {
                if(it.getProduct().getName().equals(cheapestOne.getProduct().getName())) {

                    it.setCurrentPrice(it.getProduct().getPrice() * 0.70);
                    cart.promotionSumOfProducts=cart.totalPrice()-it.getProduct().getPrice()+it.getCurrentPrice();

                }
            }
        }

    }

    @Override
    public String toString() {
        return "VoucherPromo{}";
    }
}

