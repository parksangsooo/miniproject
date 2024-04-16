package adressbook;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UserInterface {
    private final Scanner scanner;  // 사용자로부터 입력을 받기 위해 Scanner 객체를 저장하는 변수

    // ConsoleUI 생성자
    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;  // 외부에서 Scanner 객체를 받아서 클래스 내부 변수에 할당
    }

    // 전화번호 목록을 화면에 표시하는 메서드
    @Override
    public void displayPhoneList(List<Phone> phones) {
        // List<Phone> phones: Phone 객체의 리스트로, 전화번호 목록을 포함
        for (int i = 0; i < phones.size(); i++) {
            // phones.size(): 전화번호 목록의 크기(개수)를 반환
            // (i + 1): 사용자에게 표시되는 번호이며, 리스트의 인덱스는 0부터 시작하지만 사용자에게는 1부터 시작하는 번호를 보여줌
            // phones.get(i): Phone 리스트에서 i번째 Phone 객체를 가져옴
            System.out.println((i + 1) + ". " + phones.get(i));
        }
        System.out.println("-------------------------------------");  // 구분선 표시
    }

    // 새로운 전화번호를 등록하는 메서드
    @Override
    public void addEntry(PhoneManager manager) {
        System.out.println("\n<2. 등록>");
        System.out.print("이름: ");
        String name = scanner.nextLine();  // 사용자로부터 이름 입력 받음
        System.out.print("핸드폰번호: ");
        String mobile = scanner.nextLine();  // 사용자로부터 모바일 전화번호 입력 받음
        System.out.print("회사번호: ");
        String office = scanner.nextLine();  // 사용자로부터 사무실 전화번호 입력 받음

        manager.addPhone(name, mobile, office);  // PhoneManager를 통해 전화번호 추가
        System.out.println("[등록되었습니다.]");
        System.out.println("-------------------------------------");
    }

    // 전화번호를 삭제하는 메서드
    @Override
    public void deleteEntry(PhoneManager manager) {
        System.out.println("\n<3. 삭제>");
        System.out.print("번호: ");
        int entryNo = Integer.parseInt(scanner.nextLine());  // 사용자로부터 삭제할 전화번호의 번호 입력 받음

        manager.deletePhone(entryNo);  // PhoneManager를 통해 해당 번호의 전화번호 삭제
        System.out.println("[삭제되었습니다.]");
        System.out.println("-------------------------------------");
    }

    // 전화번호를 검색하는 메서드
    @Override
    public void searchEntry(PhoneManager manager) {
        System.out.println("\n<4. 검색>");
        System.out.print("검색어: ");
        String keyword = scanner.nextLine();  // 사용자로부터 검색어 입력 받음

        List<Phone> results = manager.searchPhones(keyword);  // PhoneManager를 통해 검색어에 해당하는 전화번호 목록 검색
        System.out.println("\n> 검색 결과");
        displayPhoneList(results);  // 검색 결과를 화면에 표시
    }
}
