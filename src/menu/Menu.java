package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 메뉴를 관리하는 클래스.
 */
public class Menu {
    private List<MenuItem> menuItems;

    /**
     * Menu 생성자: 메뉴 리스트 초기화.
     */
    public Menu() {
        menuItems = new ArrayList<>();
    }


    /**
     * 메뉴 아이템을 추가하는 메서드.
     *
     * @param item 추가할 메뉴 아이템
     */
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }


    /**
     * 현재 메뉴 목록을 출력하는 메서드.
     *
     * @param hasCartItems 장바구니에 아이템이 있는지 여부
     */
    public void printMenu(boolean hasCartItems) {
        System.out.println("\n⭐ STARBUCKS MENU ⭐");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s | W %.1f | %s\n", i + 1, menuItems.get(i).getName(), menuItems.get(i).basePrice, menuItems.get(i).description);
        }
        System.out.println("0. 종료 | 키오스크 종료");
        // 장바구니가 비어있지 않다면 [ ORDER MENU ] 출력
        if (hasCartItems) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.printf("%d. Orders       | 장바구니를 확인 후 주문합니다.\n", menuItems.size() + 1);
            System.out.printf("%d. Cancel       | 진행중인 주문을 취소합니다.\n", menuItems.size() + 2);
        }
    }

    /**
     * 특정 인덱스의 메뉴 아이템을 가져오는 메서드.
     *
     * @param index 메뉴의 인덱스
     * @return 해당 인덱스의 MenuItem 객체
     */
    public MenuItem getItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }

    /**
     * 현재 등록된 메뉴의 개수를 반환하는 메서드.
     *
     * @return 메뉴 개수
     */
    public int getMenuSize() {
        return menuItems.size();
    }
}
