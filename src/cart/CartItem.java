package cart;

import menu.*;

public class CartItem {
    private MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
    // menuItem Getter
    public MenuItem getMenuItem() {
        return menuItem;
    }
    // quantity Getter
    public int getQuantity() {
        return quantity;
    }

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

    public void printCartItem() {
        menuItem.printInfo();
        System.out.printf(" | 수량: %d | 총 가격: W %.1f\n", quantity, menuItem.getPrice() * quantity);
    }
}
