import java.util.List;

public class Coffee extends MenuItem{
    private String size; // Tall, Grande, Venti
    private String hotOrIced; // Hot, Iced

    public Coffee(String name, double basePrice, String description, List<String> options, String size, String hotOrIced) {
        super(name, basePrice, description, options);
        this.size = size;
        this.hotOrIced = hotOrIced;
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "Tall" -> basePrice;
            case "Grande" -> basePrice + 0.5;
            case "Venti" -> basePrice + 1.0;
            default -> basePrice;
        };
    }

    @Override
    public void printInfo() {
        // Iced일 경우만 "Iced-"를 붙여서 출력
        String dpName = hotOrIced.equalsIgnoreCase("Iced") ? "Iced-" + name : name;
        System.out.printf("%s (%s) | W %.1f | %s\n", dpName, size, getPrice(), description);
    }
}
