import java.util.List;

public class Tea extends MenuItem {
    private String type; // Hot, Iced

    public Tea(String name, double basePrice, String description, List<String> options, String type){
        super(name, basePrice, description, options);
        this.type = type;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public void printInfo() {
        System.out.printf("%s (%s) | W %,1f | %s\n",name,type,getPrice(),description);
    }
}
