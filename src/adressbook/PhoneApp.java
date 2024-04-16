package adressbook;

import java.util.Scanner;

public class PhoneApp {
    // 주 실행 메소드
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 입력을 위한 Scanner 객체 생성
        PhoneManager manager = new PhoneManager();  // 전화번호 관리를 위한 PhoneManager 객체 생성
        UserInterface ui = new ConsoleUI(scanner);  // 사용자 인터페이스 구현을 위한 ConsoleUI 객체 생성, Scanner 전달

        boolean running = true;  // 프로그램 실행 상태를 제어하는 변수

        // 프로그램 시작 시 메뉴 헤더 표시
        displayMenuHeader();

        while (running) {
            displayOptions();  // 사용자에게 선택할 옵션 표시
            System.out.print("메뉴번호: ");
            int menu = Integer.parseInt(scanner.nextLine());  // 사용자로부터 메뉴 번호 입력 받음

            switch (menu) {
                case 1:
                    ui.displayPhoneList(manager.getPhones());  // 전화번호 목록 표시
                    break;
                case 2:
                    ui.addEntry(manager);  // 새 전화번호 등록
                    break;
                case 3:
                    ui.deleteEntry(manager);  // 전화번호 삭제
                    break;
                case 4:
                    ui.searchEntry(manager);  // 전화번호 검색
                    break;
                case 5:
                    // 종료 메시지 출력
                    System.out.println("\n*************************************");
                    System.out.println("*            감사합니다            *");
                    System.out.println("*************************************");
                    running = false;  // 반복 종료
                    break;
                default:
                    System.out.println("\n유효하지 않은 옵션입니다. 다시 선택해주세요.\n");
            }
        }
        scanner.close();  // Scanner 리소스 해제
    }

    // 메뉴 헤더를 화면에 표시하는 메소드
    private static void displayMenuHeader() {
        System.out.println("\n*************************************");
        System.out.println("* 전화번호 관리 프로그램 *");
        System.out.println("*************************************");
    }

    // 사용자가 선택할 수 있는 옵션을 화면에 표시하는 메소드
    private static void displayOptions() {
        System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
        System.out.println("-------------------------------------");
    }
}
