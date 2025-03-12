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

    public void printCartItem() {
        System.out.printf("%s | 수량: %d | 총 가격: W %.1f\n",
                menuItem.getName(),quantity,menuItem.getPrice()* quantity);
    }
}
