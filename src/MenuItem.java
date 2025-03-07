// MenuItem 클래스: 음료 정보를 저장하는 객체
public class MenuItem {
    private String name;       // 음료 이름
    private double tallPrice;  // Tall 사이즈 가격
    private double grandePrice; // Grande 사이즈 가격
    private double ventiPrice; // Venti 사이즈 가격
    private String description; // 설명

    // 생성자
    public MenuItem(String name, double tallPrice, double grandePrice, double ventiPrice, String description) {
        this.name = name;
        this.tallPrice = tallPrice;
        this.grandePrice = grandePrice;
        this.ventiPrice = ventiPrice;
        this.description = description;
    }

    // 음료 정보 출력
    public void printInfo() {
        System.out.printf("%s | Tall W %.1f | Grande W %.1f | Venti W %.1f | %s\n",
                name, tallPrice, grandePrice, ventiPrice, description);
    }

    // 선택한 사이즈에 따른 가격 반환
    public double getPrice(int size) {
        return switch (size) {
            case 1 -> tallPrice;
            case 2 -> grandePrice;
            case 3 -> ventiPrice;
            default -> {
                System.out.println("유효하지 않은 사이즈입니다. 다시 선택해주세요.");
                yield -1; // 오류값 반환
            }
        };
    }

    // 음료 이름 반환
    public String getName() {
        return name;
    }
}
