package constants;

// 음료 사이즈를 관리하는 Enum 타입
public enum Size {
    // 음료 사이즈
    TALL("Tall"),
    GRANDE("Grande"),
    VENTI("Venti");

    private final String label;

    // 생성자
    Size(String label) {
        this.label = label;
    }

    // 게터
    public String getLabel() {
        return label;
    }

    public static Size fromInt(int value) {
        return switch (value) {
            case 1 -> TALL;
            case 2 -> GRANDE;
            case 3 -> VENTI;
            default -> throw new IllegalArgumentException("올바른 사이즈를 선택하세요.");
        };
    }
}
