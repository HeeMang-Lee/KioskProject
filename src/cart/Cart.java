package cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> items; // 장바구니에 담긴 항목 리스트

    // 생성자
    public Cart() {
        this.items = new ArrayList<>();
    }

    // 메뉴를 장바구니에 추가하는 메서드
    public void addToCart(MenuItem item) {
        items.add(item);
    }

    // 장바구니를 출력하는 메서드
    public void printCart() {
        System.out.println("장바구니 목록: ");
        for (MenuItem item : items) {
            item.printInfo();
        }
    }
}
