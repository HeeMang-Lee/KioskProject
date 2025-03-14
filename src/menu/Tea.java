package menu;

import java.util.List;
import java.util.Scanner;

import constants.Type;

/**
 * 차(Tea) 메뉴 아이템을 나타내는 클래스.
 */
public class Tea extends MenuItem {
    private Type type; // Hot, Iced

    /**
     * Tea 생성자.
     *
     * @param name        차 이름
     * @param basePrice   기본 가격
     * @param description 설명
     * @param options     선택 가능한 옵션 리스트
     * @param type        차의 종류 (HOT 또는 ICED)
     */
    public Tea(String name, double basePrice, String description, List<String> options, Type type) {
        super(name, basePrice, description, options);
        this.type = type;
    }

    /**
     * 차의 종류를 반환하는 메서드.
     *
     * @return 차의 종류 (HOT 또는 ICED)
     */
    public Type getType() {
        return type;
    }

    /**
     * 차의 종류를 설정하는 메서드.
     *
     * @param type 차의 종류 (HOT 또는 ICED)
     */
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        double totalPrice = basePrice;

        // 옵션 가격 추가 반영
        for (String option : options) {
            if (option.equals("샷 추가")) totalPrice += 0.5;
            if (option.equals("레몬 추가")) totalPrice += 0.5;
        }
        return totalPrice;
    }

    @Override
    public void printInfo() {
        System.out.printf("%s (%s) | W %.1f | %s\n", name, type, getPrice(), description);
        // 옵션 선택했을 경우 옵션 출력
        if (!options.isEmpty()) {
            System.out.print("| 옵션: " + options);
        }
        System.out.println();
    }

    @Override
    public void selectOptions(Scanner scanner) {
        // 기존 옵션 리스트 초기화
        options.clear();

        System.out.print("티 옵션을 추가하시겠습니까? (1. 예 / 2. 아니요): ");
        int optionAdd = scanner.nextInt();
        scanner.nextLine(); //잘못된 입력 제거

        if (optionAdd == 1) {
            while (true) {
                // 옵션 선택 번호 출력
                System.out.println("추가할 옵션을 선택하세요.: ");
                System.out.println("1. 레몬 추가 (+₩ 0.5)");
                System.out.println("2. 샷 추가 (+₩ 0.5)");
                System.out.println("0. 옵션 선택 완료");

                int optionNumber = scanner.nextInt();
                scanner.nextLine();
                switch (optionNumber) {
                    case 1 -> options.add("레몬 추가");
                    case 2 -> options.add("샷 추가");
                    case 0 -> {
                        System.out.println("옵션 선택 완료.");
                        return;
                    }
                    default -> System.out.println("올바른 옵션 번호를 입력해주세요.");
                }
            }
        }
    }
}
