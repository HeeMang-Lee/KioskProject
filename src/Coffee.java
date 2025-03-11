import java.util.List;
import java.util.Scanner;

public class Coffee extends MenuItem {
    private String size; // Tall, Grande, Venti
    private String type; // Hot, Iced

    public Coffee(String name, double basePrice, String description, List<String> options, String size, String type) {
        super(name, basePrice, description, options);
        this.size = (size != null) ? size : "Tall"; // 기본 값 Tall 설정
        this.type = (type != null) ? type : "Hot"; // 기본 값을 Hot으로 설정 (NullPointException)
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "Tall" -> basePrice;
            case "Grande" -> basePrice + 0.5;
            case "Venti" -> basePrice + 1.0;
            default -> basePrice;
        };
    }

    @Override
    public void printInfo() {
        // Iced일 경우만 "Iced-"를 붙여서 출력
        String dpName = type.equalsIgnoreCase("Iced") ? "Iced-" + name : name;
        System.out.printf("%s (%s) | W %.1f | %s\n", dpName, size, getPrice(), description);
    }


    @Override
    public void selectOptions(Scanner scanner) {
        System.out.println("커피 옵션을 추가하시겠습니까? (1. 예 / 2. 아니요): ");
        int optionAdd = scanner.nextInt();
        scanner.nextLine(); //잘못된 입력 제거

        if (optionAdd == 1) {
            while (true) {
                // 옵션 선택 번호 출력
                System.out.println("추가할 옵션을 선택하세요.: ");
                System.out.println("1. 샷 추가 (+₩ 0.5)");
                System.out.println("2. 휘핑크림 추가 (+₩ 0.5)");
                System.out.println("3. 바닐라 시럽 추가 (+₩ 0.5)");
                System.out.println("0. 옵션 선택 완료");

                int optionNumber = scanner.nextInt();
                scanner.nextLine();
                switch (optionNumber) {
                    case 1 -> options.add("샷 추가");
                    case 2 -> options.add("휘핑크림 추가");
                    case 3 -> options.add("바닐라 시럽 추가");
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