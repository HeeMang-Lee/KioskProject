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
    public void addToCart(MenuItem item, int quantity) {
        for (CartItem cartItem : items) {
            if (cartItem.getMenuItem().getName().equals(item.getName())) {
                cartItem.increaseQuantity(quantity); // 같은 메뉴가 들어오면 수량 증가
                return;
            }
        }
        items.add(new CartItem(item, quantity)); // 새로운 메뉴는 장바구니에 추가
    }

    // 장바구니에 담긴 총 가격을 계산하는 메서드
    public double getTotalPrice() {
        double totalPrice = 0; // 총 가격이 담길 변수 초기화
        for (CartItem cartItem : items) {
            totalPrice += cartItem.getMenuItem().getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    // 장바구니를 출력하는 메서드
    public void printCart() {
        System.out.println("장바구니 목록: ");
        if (items.isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
            return;
        }
        for (CartItem cartItem : items) {
            cartItem.printCartItem();
        }
        System.out.printf("총 가격: W %.1f\n", getTotalPrice()); // 장바구니의 총 금액 합계 출력
    }

    public void clearCart(){
        items.clear();
    }

    public void confirmOrder() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 메뉴를 선택해주세요.");
            return;
        }

        System.out.println("\n === 주문 내역 ===");
        printCart();
        System.out.printf("총 결제 금액: W %.1f\n",getTotalPrice());
        System.out.println("결제가 완료되었습니다. 감사합니다!\n");

        clearCart();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
