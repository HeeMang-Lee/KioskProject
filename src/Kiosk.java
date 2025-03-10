import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 스타벅스 키오스크 시스템을 관리하는 클래스
public class Kiosk {
    private List<MenuItem> menuItems; // 메뉴 리스트
    private Scanner scanner; // 사용자 입력 처리

    // 생성자 : 메뉴 리스트 초기화
    public Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
        this.scanner = new Scanner(System.in);
    }

    // 키오스크 시작
    public void start() {
        while (true) {
            // 메뉴 출력
            Menu.printMenu();

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

            while (true) {
                // 사이즈 선택
                int menuSize = getValidNumber(scanner, "음료 사이즈를 선택하세요. (1. Tall / 2. Grande / 3. Venti): ");
                String sizeName = getSizeName(menuSize);

                // 유효한 사이즈 선택 시 가격 출력
                double price = selectedItem.getPrice(menuSize);
                if (sizeName != null && price != -1) {
                    System.out.printf("▶ 선택한 메뉴: %s (%s) | W %.1f\n", selectedItem.getName(), sizeName, price);
                    break;
                } else {
                    System.out.println("올바른 사이즈를 선택하세요.");
                    continue;
                }
            }
        }
        scanner.close(); // 자원 반환
    }

    // 사용자 입력을 받아 숫자로 반환 (잘못된 입력 예외 처리)
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

    // 입력된 사이즈 번호에 따라 사이즈명 반환
    private static String getSizeName(int sizeNumber) {
        return switch (sizeNumber) {
            case 1 -> "Tall";
            case 2 -> "Grande";
            case 3 -> "Venti";
            default -> null;
        };
    }

}

