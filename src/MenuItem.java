import java.util.List;

// MenuItem 클래스: 음료 정보를 저장하는 객체
public abstract class MenuItem {
    protected String name;       // 제품 이름
    protected double basePrice; // 기본 가격
    protected String description; // 제품 설명
    protected List<String> options; // 옵션 ( 시럽 추가, 토핑 추가)

    // 생성자
    public MenuItem(String name, double basePrice, String description, List<String> options) {
        this.name = name;
        this.basePrice = basePrice;
        this.description = description;
        this.options = options;
    }

    public abstract double getPrice();

    // 음료 정보 출력
    public void printInfo() {
        System.out.printf("%s | W %.1f | %s\n",
                name, getPrice(), description);
    }

//     //선택한 사이즈에 따른 가격 반환
//    public double getPrice(int size) {
//        return switch (size) {
//            case 1 -> tallPrice;
//            case 2 -> grandePrice;
//            case 3 -> ventiPrice;
//            default -> -1; // 오류값 반환
//        };
//    }

    // 음료 이름 반환
    public String getName() {
        return name;
    }
}
