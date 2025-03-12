package cart;

import menu.*;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items; // 장바구니에 담긴 항목 리스트

    // 생성자
    public Cart() {
        this.items = new ArrayList<>();
    }

    // 메뉴를 장바구니에 추가하는 메서드
    public void addToCart(MenuItem item,int quantity) {
        for(CartItem cartItem : items){
            if (cartItem.getMenuItem().getName().equals(item.getName())) {
                cartItem.increaseQuantity(quantity); // 같은 메뉴가 들어오면 수량 증가
                return;
            }
        } items.add(new CartItem(item,quantity)); // 새로운 메뉴는 장바구니에 추가
    }

    // 장바구니를 출력하는 메서드
    public void printCart() {
        System.out.println("장바구니 목록: ");
        if (items.isEmpty()){
            System.out.println("장바구니가 비었습니다.");
            return;
        }
        for (CartItem cartItem : items) {
            cartItem.printCartItem();
        }
    }
}
