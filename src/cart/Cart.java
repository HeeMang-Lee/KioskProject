package cart;

import menu.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니를 관리하는 클래스.
 */
public class Cart {
    private List<CartItem> items; // 장바구니에 담긴 항목 리스트

    /**
     * Cart 생성자: 장바구니 리스트 초기화.
     */
    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
     * 장바구니에 메뉴를 추가하는 메서드.
     *
     * @param item     추가할 메뉴 아이템
     * @param quantity 추가할 수량
     */
    public void addToCart(MenuItem item, int quantity) {
        for (CartItem cartItem : items) {
            if (cartItem.getMenuItem().getName().equals(item.getName())) {
                cartItem.increaseQuantity(quantity); // 같은 메뉴가 들어오면 수량 증가
                return;
            }
        }
        items.add(new CartItem(item, quantity)); // 새로운 메뉴는 장바구니에 추가
    }

    /**
     * 장바구니의 총 가격을 계산하는 메서드.
     *
     * @return 총 가격
     */
    public double getTotalPrice() {
        double totalPrice = 0; // 총 가격이 담길 변수 초기화
        for (CartItem cartItem : items) {
            totalPrice += cartItem.getMenuItem().getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    /**
     * 장바구니 내용을 출력하는 메서드.
     */
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

    /**
     * 장바구니를 비우는 메서드.
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * 주문을 확정하는 메서드.
     */
    public void confirmOrder() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 메뉴를 선택해주세요.");
            return;
        }

        System.out.printf("총 결제 금액: W %.1f\n", getTotalPrice());
        System.out.println("결제가 완료되었습니다. 감사합니다!\n");

        clearCart();
    }

    /**
     * 장바구니가 비어있는지 확인하는 메서드.
     *
     * @return 장바구니가 비어있으면 true, 아니면 false
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
