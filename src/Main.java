import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 음료 메뉴 리스트 생성
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("아메리카노", 4.5, 5.0, 5.5, "진한 에스프레소와 물을 섞어 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피"));
        menuItems.add(new MenuItem("카페라떼", 5.0, 5.5, 6.0, "풍부하고 진한 에스프레소가 신선한 스팀 밀크를 만나 부드러워진 커피 위에 우유 거품을 살짝 얹은 대표적인 커피 라떼"));
        menuItems.add(new MenuItem("카푸치노", 5.2, 5.7, 6.2, "풍부하고 진한 에스프레소에 따뜻한 우유와 벨벳 같은 우유 거품이 1:1 비율로 어우러져 마무리된 커피 음료"));
        menuItems.add(new MenuItem("바닐라 빈 라떼", 5.5, 6.0, 6.5, "리저브만을 위한 바닐라 빈 시럽이 부드럽게 어우러진 카페 라떼"));

        while (true) {
            // 메뉴 출력
            System.out.println("\n⭐ STARBUCKS MENU ⭐");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.print((i + 1) + ". ");
                menuItems.get(i).printInfo();
            }
            System.out.println("0. 종료 | 키오스크 프로그램 종료");

            // 사용자 입력 받기
            int menuNumber = getValidNumber(scanner, "메뉴 번호를 입력하세요: ");

            // 0 입력 시 종료
            if (menuNumber == 0) {
                System.out.println("매장에 방문해주셔서 감사합니다.");
                break;
            }

            // 메뉴 번호 유효성 검사
            if (menuNumber < 1 || menuNumber > menuItems.size()) {
                System.out.println("올바른 메뉴 번호를 입력하세요.");
                continue;
            }

            // 선택한 메뉴 가져오기
            MenuItem selectedItem = menuItems.get(menuNumber - 1);

            // 사이즈 선택
            int menuSize = getValidNumber(scanner, "음료 사이즈를 선택하세요. (1. Tall / 2. Grande / 3. Venti): ");
            String sizeName = getSizeName(menuSize);

            // 유효한 사이즈 선택 시 가격 출력
            double price = selectedItem.getPrice(menuSize);
            if (sizeName != null && price != -1) {
                System.out.printf("▶ 선택한 메뉴: %s (%s) | W %.1f\n", selectedItem.getName(), sizeName, price);
            } else {
                System.out.println("올바른 사이즈를 선택하세요.");
            }
        }
        scanner.close();
    }

    private static int getValidNumber(Scanner scanner, String message) {
        int number;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 제거
                break;
            } else {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 제거
            }
        }
        return number;
    }
    private static String getSizeName(int sizeNumber) {
        return switch (sizeNumber) {
            case 1 -> "Tall";
            case 2 -> "Grande";
            case 3 -> "Venti";
            default -> null;
        };
    }
}
//        // 1. 스타벅스 메뉴 출력
//        while (true){
//            System.out.println("\n ⭐ STARBUCKS MENU ⭐");
//            System.out.println("1. 아메리카노 | Tall W 4.5 | Grande W 5.0 | Venti W 5.5");
//            System.out.println("2. 카페라떼  | Tall W 5.0 | Grande W 5.5 | Venti W 6.0");
//            System.out.println("3. 카푸치노  | Tall W 5.2 | Grande W 5.7 | Venti W 6.2");
//            System.out.println("4. 바닐라라떼 | Tall W 5.5 | Grande W 6.0 | Venti W 6.5");
//            System.out.println("0. 종료      | 프로그램 종료");
//            System.out.print("메뉴 번호를 입력하세요: ");
//
//            // 2. 사용자 입력 처리 (예외 방지)
//            if (!scanner.hasNextInt()) {
//                System.out.println("올바른 숫자를 입력하세요.");
//                scanner.nextLine(); // 잘못된 입력 제거 (개행 문자 제거)
//        }
//
//            int menuNumber = scanner.nextInt();
//
//            // 3. 종료 조건
//            if (menuNumber == 0) {
//                System.out.println("매장에 방문해주셔서 감사합니다.");
//                break;
//            }
//
//            // 4. 음료 사이즈 선택
//            System.out.println("음료 사이즈를 선택하세요. (1. Tall / 2.Grande / 3.Venti): ");
//            if (!scanner.hasNextInt()){
//                System.out.println("올바른 숫자를 입력하세요.");
//                scanner.nextLine(); // 잘못된 입력 제거 (개행 문자 제거)
//            }
//
//            int menuSize = scanner.nextInt();
//            String sizeName;
//
//            switch (menuSize){
//                case 1:
//                    sizeName = "Tall";
//                    break;
//                case 2:
//                    sizeName = "Grande";
//                    break;
//                case 3:
//                    sizeName = "Venti";
//                    break;
//                default:
//                    System.out.println("올바른 사이즈를 선택하세요."); // 1,2,3 이 입력되지 않았을 경우
//            }
//    }

