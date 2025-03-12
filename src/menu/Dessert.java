package menu;

import java.util.List;
import java.util.Scanner;

public class Dessert extends MenuItem {
    public Dessert(String name, double basePrice, String description, List<String> options){
        super(name, basePrice, description, options);
    }

    @Override
    public double getPrice() {
        double totalPrice = basePrice;
        // 옵션 가격 추가 반영
        for (String option: options) {
            if (option.equals("초코 토핑 추가")) totalPrice += 0.5;
            if (option.equals("휘핑크림 추가")) totalPrice += 0.5;
        }
        return totalPrice;
    }

    @Override
    public void printInfo() {
        System.out.printf("%s | W %.1f | %s\n",name,getPrice(),description);
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

        System.out.print("디저트 옵션을 추가하시겠습니까? (1. 예 / 2. 아니요): ");
        int optionAdd = scanner.nextInt();
        scanner.nextLine(); //잘못된 입력 제거

        if (optionAdd == 1) {
            while (true) {
                // 옵션 선택 번호 출력
                System.out.println("추가할 옵션을 선택하세요.: ");
                System.out.println("1. 초코 토핑 추가 (+₩ 0.5)");
                System.out.println("2. 휘핑크림 추가 (+₩ 0.5)");
                System.out.println("0. 옵션 선택 완료");

                int optionNumber = scanner.nextInt();
                scanner.nextLine();
                switch (optionNumber) {
                    case 1 -> options.add("초코 토핑 추가");
                    case 2 -> options.add("휘핑크림 추가");
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
