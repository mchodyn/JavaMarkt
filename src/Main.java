public class Main {
    public static void main(String[] args) {
        Cart cart =new Cart();
        cart.addProduct(new Product("rzecz",150));
        cart.addProduct(new Product("rzecz2",200));
        //cart.addPromo(new ValuePromo());
       // cart.addPromo(new MugPromo());
        cart.addPromo(new VoucherPromo());
        cart.applyPromo();
        System.out.println(cart);
    }
}
