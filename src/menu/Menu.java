package menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
    }

    // 메뉴 아이템 추가
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    // 메뉴 리스트 출력
    public void printMenu(boolean hasCartItems){
        System.out.println("\n⭐ STARBUCKS MENU ⭐");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s | W %.1f | %s\n", i + 1,menuItems.get(i).getName(), menuItems.get(i).basePrice,menuItems.get(i).description);
        }
        System.out.println("0. 종료 | 키오스크 종료");
        // 장바구니가 비어있지 않다면 [ ORDER MENU ] 출력
        if (hasCartItems) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.printf("%d. Orders       | 장바구니를 확인 후 주문합니다.\n", menuItems.size() + 1);
            System.out.printf("%d. Cancel       | 진행중인 주문을 취소합니다.\n", menuItems.size() + 2);
        }
    }

    // 특정 메뉴 가져오기
    public MenuItem getItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }

    public int getMenuSize() {
        return menuItems.size();
    }
}
