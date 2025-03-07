import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 스타벅스 메뉴 출력
        while (true){
            System.out.println("\n ⭐ STARBUCKS MENU ⭐");
            System.out.println("1. 아메리카노 | Tall W 4.5 | Grande W 5.0 | Venti W 5.5");
            System.out.println("2. 카페라떼  | Tall W 5.0 | Grande W 5.5 | Venti W 6.0");
            System.out.println("3. 카푸치노  | Tall W 5.2 | Grande W 5.7 | Venti W 6.2");
            System.out.println("4. 바닐라라떼 | Tall W 5.5 | Grande W 6.0 | Venti W 6.5");
            System.out.println("0. 종료      | 프로그램 종료");
            System.out.print("메뉴 번호를 입력하세요: ");

            // 2. 사용자 입력 처리 (예외 방지)
            if (!scanner.hasNextInt()) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 제거 (개행 문자 제거)
        }

            int menuNumber = scanner.nextInt();

            // 3. 종료 조건
            if (menuNumber == 0) {
                System.out.println("매장에 방문해주셔서 감사합니다.");
                break;
            }

            // 4. 음료 사이즈 선택
            System.out.println("음료 사이즈를 선택하세요. (1. Tall / 2.Grande / 3.Venti): ");
            if (!scanner.hasNextInt()){
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 제거 (개행 문자 제거)
            }

            int menuSize = scanner.nextInt();
            String sizeName;

            switch (menuSize){
                case 1:
                    sizeName = "Tall";
                    break;
                case 2:
                    sizeName = "Grande";
                    break;
                case 3:
                    sizeName = "Venti";
                    break;
                default:
                    System.out.println("올바른 사이즈를 선택하세요."); // 1,2,3 이 입력되지 않았을 경우
            }
    }
}
}