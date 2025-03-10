import java.util.List;

public class Dessert extends MenuItem {
    public Dessert(String name, double basePrice, String description, List<String> options){
        super(name, basePrice, description, options);
    }

    @Override
    public double getPrice() {
        return basePrice; // 디저트는 사이즈 개념 X
    }

    @Override
    public void printInfo() {
        System.out.printf("%s | W %.1f | %s\n",name,getPrice(),description);
    }
}
