

public class MugPromo implements IPromotion {
    @Override
    public boolean CanCalc(Cart cart) {
        double cartWithoutPromo=cart.totalPrice();
        if(cartWithoutPromo>=200)
            return true;
        else
            return false;
    }
boolean isMugAdded(Cart cart){
        boolean itIs=false;
    for (CartItem it:cart.getItems()){
        if(it.getProduct().getName().equals("Kubek promocyjny")){
            itIs=true;
        }
    }
    return itIs;
}
    @Override
    public void CalcOffer(Cart cart) {
        if(this.CanCalc(cart)&&!this.isMugAdded(cart)){
            cart.addProduct(new Product("Kubek promocyjny",0.01));
        }

    }

    @Override
    public String toString() {
        return "MugPromo{dodano kubek}";
    }
}
