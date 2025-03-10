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

    // 제품 가격 반환 하위 클래스에서 구현
    public abstract double getPrice();

    // 제품 정보 출력 하위 클래스에서 구현
    public abstract void printInfo() ;

    // 제품 이름 반환
    public String getName() {
        return name;
    }
}
