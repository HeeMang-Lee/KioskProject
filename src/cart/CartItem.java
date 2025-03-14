package cart;

import menu.*;

/**
 * 장바구니에 담긴 개별 항목을 나타내는 클래스.
 */
public class CartItem {
    private MenuItem menuItem;
    private int quantity;

    /**
     * CartItem 생성자.
     *
     * @param menuItem 장바구니에 담긴 메뉴 아이템
     * @param quantity 해당 아이템의 수량
     */
    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    /**
     * 장바구니에 담긴 메뉴 아이템을 반환하는 메서드.
     *
     * @return 장바구니 아이템
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     * 장바구니에 담긴 해당 아이템의 수량을 반환하는 메서드.
     *
     * @return 수량
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * 해당 장바구니 아이템의 수량을 증가시키는 메서드.
     *
     * @param amount 증가할 수량
     */
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

//    public void printCartItem() {
//        if (menuItem instanceof Coffee coffee){
//            System.out.printf("%s (%s, %s) | 수량: %d | 총 가격: W %.1f", coffee.getName(),coffee.getSize().getLabel(),coffee.getType().getLabel(),quantity,menuItem.getPrice()* quantity);
//        } else if (menuItem instanceof  Tea tea) {
//            System.out.printf("%s (%s) | 수량: %d | 총 가격: W %.1f", tea.getName(),tea.getType().getLabel(),quantity,menuItem.getPrice()* quantity);
//        } else {
//            System.out.printf("%s | 수량: %d | 총 가격: W %.1f",menuItem.getName(), quantity, menuItem.getPrice() * quantity);
//        }
//
//        // 옵션 출력
//        if (!menuItem.getOptions().isEmpty()) {
//            System.out.print(" | 옵션 : " + menuItem.getOptions());
//        }
//        System.out.println();
//    }

    /**
     * 장바구니에 담긴 항목 정보를 출력하는 메서드.
     */
    public void printCartItem() {
        menuItem.printInfo();
        System.out.printf(" | 수량: %d | 총 가격: W %.1f\n", quantity, menuItem.getPrice() * quantity);
    }
}
