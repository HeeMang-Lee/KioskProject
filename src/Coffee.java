import java.util.List;

public class Coffee extends MenuItem{
    private String size; // Tall, Grande, Venti
    private String type; // Hot, Iced

    public Coffee(String name, double basePrice, String description, List<String> options, String size, String type) {
        super(name, basePrice, description, options);
        this.size = (size != null) ? size : "Tall"; // 기본 값 Tall 설정
        this.type = (type != null) ? type : "Hot"; // 기본 값을 Hot으로 설정 (NullPointException)
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
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
        String dpName = type.equalsIgnoreCase("Iced") ? "Iced-" + name : name;
        System.out.printf("%s (%s) | W %.1f | %s\n", dpName, size, getPrice(), description);
    }
}
