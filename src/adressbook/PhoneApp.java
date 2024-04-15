package adressbook;

import java.util.Scanner;

public class PhoneApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneManager manager = new PhoneManager();
        UserInterface ui = new ConsoleUI(scanner);

        boolean running = true;

        // 처음에 한 번만 메뉴 헤더를 표시합니다.
        displayMenuHeader();

        while (running) {
            displayOptions(); // 옵션들을 계속 표시합니다.
            System.out.print("메뉴번호: ");
            int menu = Integer.parseInt(scanner.nextLine());

            switch (menu) {
                case 1:
                    ui.displayPhoneList(manager.getPhones());
                    break;
                case 2:
                    ui.addEntry(manager);
                    break;
                case 3:
                    ui.deleteEntry(manager);
                    break;
                case 4:
                    ui.searchEntry(manager);
                    break;
                case 5:
                    System.out.println("\n*************************************");
                    System.out.println("*            감사합니다            *");
                    System.out.println("*************************************");
                    running = false;
                    break;
                default:
                    System.out.println("\n유효하지 않은 옵션입니다. 다시 선택해주세요.\n");
            }
        }
        scanner.close();
    }

    private static void displayMenuHeader() {
        System.out.println("\n*************************************");
        System.out.println("* 전화번호 관리 프로그램 *");
        System.out.println("*************************************");
    }

    private static void displayOptions() {
        System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
        System.out.println("-------------------------------------");
    }
}
