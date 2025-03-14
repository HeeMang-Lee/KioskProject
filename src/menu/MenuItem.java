package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 메뉴 아이템을 나타내는 추상 클래스.
 */
public abstract class MenuItem {
    protected String name;       // 제품 이름
    protected double basePrice; // 기본 가격
    protected String description; // 제품 설명
    protected List<String> options; // 옵션 ( 시럽 추가, 토핑 추가)
    // 옵션이 null 일 경우 new ArrayList<>()로 초기화하여 NullPointerException 방지


    /**
     * 메뉴 아이템의 생성자.
     *
     * @param name        메뉴 이름
     * @param basePrice   기본 가격
     * @param description 설명
     * @param options     선택 가능한 옵션 리스트
     */
    public MenuItem(String name, double basePrice, String description, List<String> options) {
        this.name = name;
        this.basePrice = basePrice;
        this.description = description;
        this.options = (options != null) ? options : new ArrayList<>();
    }

    /**
     * 옵션을 선택하는 추상 메서드.
     *
     * @param scanner 사용자 입력을 위한 Scanner 객체
     */
    public abstract void selectOptions(Scanner scanner);

    /**
     * 최종 가격을 반환하는 추상 메서드.
     *
     * @return 최종 가격
     */
    public abstract double getPrice();

    /**
     * 제품 정보를 출력하는 추상 메서드.
     */
    public abstract void printInfo();

    /**
     * 메뉴 이름을 반환하는 메서드.
     *
     * @return 메뉴 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 옵션 리스트를 반환하는 메서드.
     *
     * @return 옵션 리스트
     */
    public List<String> getOptions() {
        return options;
    }
}
