package constants;

/**
 * 음료의 유형을 관리하는 열거형(enum).
 */
public enum Type {
    HOT("Hot"),
    ICED("Iced");

    private final String label;

    /**
     * Type 열거형 생성자.
     *
     * @param label 유형의 문자열 라벨
     */
    Type(String label) {
        this.label = label;
    }

    /**
     * 유형의 라벨을 반환하는 메서드.
     *
     * @return 유형 라벨
     */
    public String getLabel() {
        return label;
    }

    /**
     * 정수 값에 따라 적절한 Type 값을 반환하는 메서드.
     *
     * @param value 정수 값 (1: HOT, 2: ICED)
     * @return 해당하는 Type 값
     * @throws IllegalArgumentException 유효하지 않은 값이 입력된 경우 예외 발생
     */
    public static Type fromInt(int value) {
        return switch (value) {
            case 1 -> HOT;
            case 2 -> ICED;
            default -> throw new IllegalArgumentException("올바른 옵션을 선택해주세요.");
        };
    }
}
