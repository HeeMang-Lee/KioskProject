package constants;

public enum Type {
    HOT("Hot"),
    ICED("Iced");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Type fromInt(int value) {
        return switch (value) {
          case 1 -> HOT;
          case 2 -> ICED;
          default -> throw new IllegalArgumentException("올바른 옵션을 선택해주세요.");
        };
    }
}
