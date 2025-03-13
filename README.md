# Starbucks Kiosk 프로젝트

## 프로젝트 개요
이 프로젝트는 Java 기반 콘솔 스타벅스 키오스크 시스템으로, 객체지향 프로그래밍(OOP) 원칙을 적용하여 개발되었다.  
사용자가 커피, 티, 디저트를 선택하고, 사이즈 및 옵션을 추가한 후 장바구니를 활용하여 주문할 수 있도록 구현되었다.

단순한 키오스크 시스템이 아니라, **확장 가능성과 유지보수성을 고려한 구조 설계**에 집중하였으며,  
이를 위해 **패키지 분리, Enum 활용, 다형성 적용, 예외 처리 강화** 등의 개념을 적극적으로 도입하였다.

---

## 주요 기능
- **객체지향 설계(OOP) 기반의 패키지 구조 분리**
- **커피 및 티 메뉴의 사이즈(Tall, Grande, Venti) 및 온도(Hot, Iced) 선택 가능**
- **디저트 메뉴는 별도 사이즈 없이 선택 가능하며, 옵션(초코 추가 등) 추가 가능**
- **장바구니 기능 지원 (중복 메뉴 추가 시 수량 증가)**
- **총 가격 계산 및 주문 확정 후 장바구니 초기화 기능**
- **잘못된 입력 방지를 위한 예외 처리 및 검증 로직 강화**
- **Enum을 활용한 사이즈, 온도, 옵션 관리로 유지보수성 향상**
- **Lambda & Stream API 일부 적용 (추가 리팩토링 가능성 고려)**

---

## 프로젝트 구조
이 프로젝트는 **객체지향 설계(OOP)의 SRP(단일 책임 원칙)를 준수하기 위해 패키지를 분리**하였으며,  
각 클래스의 역할을 명확히 정의하고 기능을 세분화하여 **재사용성과 확장성을 극대화**하였다.  

- [📂 starbucks-kiosk]
  - ── 📂 constants # Enum 타입 정의
  - ├── 📂 constants # Enum 타입 정의
  - │ ├── Size.java # Tall, Grande, Venti
  - │ ├── Type.java # Hot, Iced
  - │
  - ├── 📂 menu # 메뉴 관련 클래스
  - │ ├── MenuItem.java # 추상 클래스 - 공통 속성 정의
  - │ ├── Coffee.java # 커피 클래스, Size/Type 적용
  - │ ├── Tea.java # 티 클래스, Type 적용
  - │ ├── Dessert.java # 디저트 클래스, 옵션 적용
  - │ ├── Menu.java # 메뉴 관리, 메뉴 추가 및 출력
  - │
  - ├── 📂 cart # 장바구니 관련 클래스
  - │ ├── CartItem.java # 장바구니 아이템 - 개별 메뉴 저장
  - │ ├── Cart.java # 장바구니 관리 - 추가, 삭제, 결제
  - │
  - ├── 📂 main # 프로그램 실행 및 키오스크 관리
  - │ ├── Kiosk.java # 메인 키오스크 로직
  - │ ├── Main.java # 프로그램 실행
  - │
  - └── README.md # 프로젝트 문서


---

## 설계 시 신경 쓴 점

### 1. 객체지향 원칙(OOP) 적용 및 패키지 구조 분리
- **단일 책임 원칙(SRP)** 을 준수하여 **메뉴(Menu), 장바구니(Cart), 키오스크(Kiosk)** 를 분리
- **공통 속성 및 기능**을 추출하여 `MenuItem`을 추상 클래스로 만들고, `Coffee`, `Tea`, `Dessert`가 이를 상속하도록 구현
- **패키지 분리**를 통해 각 모듈의 책임을 명확히 하고, 유지보수성을 높임

### 2. Enum 활용을 통한 데이터 안정성 확보
- `Size`, `Type`을 **Enum으로 관리**하여 문자열 비교 없이 안정적으로 데이터 처리
- `Enum.fromInt()` 메서드를 구현하여 사용자 입력을 직접 변환 가능하도록 개선

```java
public enum Size {
    TALL(1, "Tall"), GRANDE(2, "Grande"), VENTI(3, "Venti");

    private final int value;
    private final String label;

    Size(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static Size fromInt(int value) {
        return Arrays.stream(values())
                .filter(size -> size.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사이즈를 선택하세요."));
    }
}
```
### 3. 다형성 적용 및 유지보수성 강화
- `processOrder()`를 활용하여 `Coffee`, `Tea`, `Dessert`의 로직을 통합하여 코드 중복을 줄이고, 유지보수성을 향상
- `CartItem.printCartItem()`에서 `instanceof`를 제거하고, 각 클래스의 `printInfo()`를 호출하도록 변경

```java
public void printCartItem() {
    menuItem.printInfo();
    System.out.printf(" | 수량: %d | 총 가격: W %.1f\n", quantity, menuItem.getPrice() * quantity);
}
```
### 4. 예외 처리 및 사용자 입력 검증 강화
- 숫자가 아닌 입력을 방지하기 위해 `getValidNumber()` 메서드 도입
- `Scanner.nextInt()` 사용 후 `nextLine()`을 호출하여 개행 문자 문제 해결

```java
private int getValidNumber(Scanner scanner, String message) {
    while (true) {
        System.out.print(message);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            scanner.nextLine();
            return number;
        } else {
            System.out.println("올바른 숫자를 입력하세요.");
            scanner.nextLine();
        }
    }
}
```

### 설치 및 실행 방법
1. JDK 17+ 설치
2. Main.java 실행
### 향후 개선 방향
- Lambda & Stream API 활용하여 for 루프 최적화
- 팩토리 패턴 적용하여 객체 생성 방식 개선
- 파일 저장 기능 추가하여 주문 내역 관리 기능 확장
### 마무리
- 이 프로젝트는 단순한 키오스크 구현을 넘어 객체지향 설계, 다형성, 예외 처리, 유지보수성을 고려한 확장 가능성을 목표로 개발되었다.
- 각 기능을 세분화하고 패키지를 구성하면서 개발 과정에서의 문제 해결 능력과 설계 능력을 키울 수 있는 좋은 경험이 되었다.
- 향후 추가 기능을 구현하면서 더 많은 디자인 패턴과 최적화 기법을 적용해볼 계획이다.