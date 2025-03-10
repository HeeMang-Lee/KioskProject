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
    public void printMenu(){
        System.out.println("\n⭐ STARBUCKS MENU ⭐");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. ", i + 1);
            menuItems.get(i).printInfo();
        }
        System.out.println("0. 종료 | 키오스크 프로그램 종료");
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
