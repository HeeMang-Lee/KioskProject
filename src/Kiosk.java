import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 스타벅스 키오스크 시스템을 관리하는 클래스
public class Kiosk {
    private Menu menu; // 메뉴 리스트
    private Scanner scanner; // 사용자 입력 처리

    // 생성자 : 메뉴 리스트 초기화
    public Kiosk() {
        menu = new Menu();
        scanner = new Scanner(System.in);
        initializeMenu(); // 기본 메뉴 추가
    }

    private void initializeMenu() {
        menu.addItem(new Coffee("아메리카노", 4.5, "진한 에스프레소와 물의 조합", List.of("샷 추가"), "Tall", "Hot"));
        menu.addItem(new Coffee("카페라떼", 5.0, "에스프레소와 부드러운 우유의 조화", List.of("시럽 추가"), "Tall", "Hot"));
        menu.addItem(new Tea("얼그레이", 4.8, "홍차의 깊은 향", List.of("레몬 추가"), "Hot"));
        menu.addItem(new Dessert("치즈케이크", 6.0, "부드럽고 진한 치즈 맛", List.of("초코 토핑 추가")));
    }

    // 키오스크 시작
    public void start() {
        while (true) {
            // 메뉴 출력
            menu.printMenu();

            // 사용자 입력 받기
            int menuNumber = getValidNumber(scanner, "메뉴 번호를 입력하세요: ");

            // 0 입력 시 종료
            if (menuNumber == 0) {
                System.out.println("매장에 방문해주셔서 감사합니다.");
                break;
            }

            // 메뉴 번호 유효성 검사
            if (menuNumber < 1 || menuNumber > menu.getMenuSize()) {
                System.out.println("올바른 메뉴 번호를 입력하세요.");
                continue;
            }

            // 선택한 메뉴 가져오기
            MenuItem selectedItem = menu.getItem(menuNumber - 1);
            processOrder(selectedItem);
        }
        scanner.close(); // 자원 반환
    }

    private void processOrder(MenuItem item) {
        if (item instanceof Coffee coffee) {
            coffee.setSize(getSizeName());
            coffee.setType(getTypeName());
            coffee.printInfo();
        } else if (item instanceof Tea tea) {
            tea.setType(getTypeName());
            tea.printInfo();
        } else if (item instanceof Dessert) {
            item.printInfo();
        }
    }


    // 사용자 입력을 받아 숫자로 반환 (잘못된 입력 예외 처리)
    private int getValidNumber(Scanner scanner, String message) {
        int number;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 제거
                return number;
            } else {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 제거
            }
        }
    }

    // 입력된 사이즈 번호에 따라 사이즈명 반환
    private String getSizeName() {
        while (true){
        System.out.print("사이즈를 선택하세요 (1. Tall / 2. Grande / 3.Venti ): ");
        int sizeNumber = scanner.nextInt();
        scanner.nextLine();
        return switch (sizeNumber) {
            case 1 -> "Tall";
            case 2 -> "Grande";
            case 3 -> "Venti";
            default -> {
                System.out.println("올바른 사이즈를 선택하세요.");
                yield null;
            }
        };
    }
}

    private String getTypeName() {
        while (true) {
            System.out.print("Hot / Iced를 선택하세요 (1. Hot / 2. Iced): ");
            if (scanner.hasNextInt()) {
                int typeNumber = scanner.nextInt();
                scanner.nextLine();
                switch (typeNumber) {
                    case 1 -> {
                        return "Hot";
                    }
                    case 2 -> {
                        return "Iced";
                    }
                    default -> System.out.println("올바른 입력을 해주세요.");
                }
            } else {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine();
            }
        }
    }
}

