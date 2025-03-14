package main;

import cart.*;
import constants.Size;
import constants.Type;
import menu.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 스타벅스 키오스크 시스템을 관리하는 클래스
 */
public class Kiosk {
    private Menu menu; // 메뉴 리스트
    private Scanner scanner; // 사용자 입력 처리
    private Cart cart; // 장바구니 객체

    /**
     * 키오스크 생성자: 메뉴 리스트 초기화
     */
    public Kiosk() {
        menu = new Menu();
        cart = new Cart();
        scanner = new Scanner(System.in);
        initializeMenu(); // 기본 메뉴 추가
    }

    /**
     * 기본 메뉴를 초기화하는 메서드
     */
    private void initializeMenu() {
        menu.addItem(new Coffee("아메리카노", 4.5, "진한 에스프레소와 물의 조합", new ArrayList<>(), Size.TALL, Type.HOT));
        menu.addItem(new Coffee("카페라떼", 5.0, "에스프레소와 부드러운 우유의 조화", new ArrayList<>(), Size.TALL, Type.HOT));
        menu.addItem(new Tea("얼그레이", 4.8, "홍차의 깊은 향", new ArrayList<>(), Type.HOT));
        menu.addItem(new Dessert("치즈케이크", 6.0, "부드럽고 진한 치즈 맛", new ArrayList<>()));
    }

    /**
     * 키오스크를 시작하는 메서드
     */
    public void start() {
        while (true) {
            // 메뉴 출력
            menu.printMenu(!cart.isEmpty());

            // 사용자 입력 받기
            int menuNumber = getValidNumber(scanner, "메뉴 번호를 입력하세요: ");

            // 0 입력 시 종료
            if (menuNumber == 0) {
                System.out.println("매장에 방문해주셔서 감사합니다.");
                break;
            }

            // 장바구니를 보는 숫자 입력 시 장바구니 출력
            if (menuNumber == menu.getMenuSize() + 1) {
                confirmOrderUI(); // 주문 여부 묻기
                continue;
            }

            // 주문 취소하는 숫자 입력 시 주문 확장 메서드 호출
            if (menuNumber == menu.getMenuSize() + 2) {
                cancelOrder(); // 주문 취소 하기
                continue;
            }

            // 메뉴 번호 유효성 검사
            if (menuNumber < 1 || menuNumber > menu.getMenuSize()) {
                System.out.println("올바른 메뉴 번호를 입력하세요.");
                continue;
            }

            // 선택한 메뉴 가져오기
            MenuItem selectedItem = menu.getItem(menuNumber - 1);
            selectedItem = processOrder(selectedItem); // 옵션 설정 후 객체 반환

            while (true) {
                int clarifyCart = getValidNumber(scanner, "위 메뉴를 장바구니에 추가하시겠습니까? (1. 확인 / 2. 취소): ");

                if (clarifyCart == 1) {
                    cart.addToCart(selectedItem, 1); // 수량을 한 번에 1개만 받아야 하므로 리팩토링
                    System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                    break;
                } else if (clarifyCart == 2) {
                    System.out.println("선택이 취소되었습니다.");
                    break;
                } else {
                    System.out.println("올바른 번호를 입력해주세요.");
                    continue;
                }
            }
        }
        scanner.close(); // 자원 반환
    }

    /**
     * 사용자의 주문을 처리하는 메서드
     *
     * @param item 선택한 메뉴 아이템
     * @return 옵션이 적용된 메뉴 아이템
     */
    private MenuItem processOrder(MenuItem item) {
        if (item instanceof Coffee coffee) {
            coffee.setSize(getSizeName());
            coffee.setType(getTypeName());
            coffee.selectOptions(scanner);
            coffee.printInfo();
            return coffee;
        } else if (item instanceof Tea tea) {
            tea.setType(getTypeName());
            tea.selectOptions(scanner);
            tea.printInfo();
            return tea;
        } else if (item instanceof Dessert dessert) {
            dessert.selectOptions(scanner);
            dessert.printInfo();
            return dessert;
        } else {
            return item;
        }
    }


    /**
     * 사용자 입력을 받아 숫자로 반환하는 메서드 (예외 처리 포함)
     *
     * @param scanner Scanner 객체
     * @param message 입력 메시지
     * @return 입력된 숫자
     */
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

    /**
     * 사용자가 선택한 사이즈를 반환하는 메서드
     *
     * @return 선택한 Size 값
     */
    private Size getSizeName() {
        while (true) {
            System.out.print("사이즈를 선택하세요 (1. Tall / 2. Grande / 3.Venti ): ");
            int sizeNumber = getValidNumber(scanner, "선택: ");
            try {
                return Size.fromInt(sizeNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 선택한 타입을 반환하는 메서드
     *
     * @return 선택한 Type 값
     */
    private Type getTypeName() {
        while (true) {
            System.out.print("Hot / Iced를 선택하세요 (1. Hot / 2. Iced): ");
            int typeNumber = getValidNumber(scanner, "선택: ");
            try {
                return Type.fromInt(typeNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 주문을 취소하는 메서드
     */
    private void cancelOrder() {
        if (cart.isEmpty()) {
            System.out.println("진행 중인 주문이 없습니다.");
            return;
        }
        cart.clearCart();
        System.out.println("진행 중인 주문이 취소되었습니다.");
    }

    /**
     * 장바구니 확인 후 주문 여부를 묻는 UI 메서드.
     */
    private void confirmOrderUI() {
        if (cart.isEmpty()) {
            System.out.println("진행 중인 주문이 없습니다.");
            return;
        }

        System.out.println("\n=== [ 장바구니 확인 ] ===");
        cart.printCart();
        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        System.out.printf("총 결제 금액: W %.1f\n", cart.getTotalPrice());

        System.out.println("\n1. 주문      2.메뉴");
        int clarifyOrderNumber = getValidNumber(scanner, "선택: ");

        if (clarifyOrderNumber == 1) {
            cart.confirmOrder(); //주문 확정
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }
}

