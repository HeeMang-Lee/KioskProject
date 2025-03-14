package constants;

/**
 * 음료 사이즈를 관리하는 열거형(enum).
 */
public enum Size {
    // 음료 사이즈
    TALL("Tall"),
    GRANDE("Grande"),
    VENTI("Venti");

    private final String label;

    /**
     * Size 열거형 생성자.
     *
     * @param label 사이즈의 문자열 라벨
     */
    Size(String label) {
        this.label = label;
    }

    /**
     * 사이즈의 라벨을 반환하는 메서드.
     *
     * @return 사이즈 라벨
     */
    public String getLabel() {
        return label;
    }

    /**
     * 정수 값에 따라 적절한 Size 값을 반환하는 메서드.
     *
     * @param value 정수 값 (1: TALL, 2: GRANDE, 3: VENTI)
     * @return 해당하는 Size 값
     * @throws IllegalArgumentException 유효하지 않은 값이 입력된 경우 예외 발생
     */
    public static Size fromInt(int value) {
        return switch (value) {
            case 1 -> TALL;
            case 2 -> GRANDE;
            case 3 -> VENTI;
            default -> throw new IllegalArgumentException("올바른 사이즈를 선택하세요.");
        };
    }
}
