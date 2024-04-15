package adressbook;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UserInterface {
    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayPhoneList(List<Phone> phones) {
        for (int i = 0; i < phones.size(); i++) {
            System.out.println((i + 1) + ". " + phones.get(i));
        }
        System.out.println("-------------------------------------");
    }

    @Override
    public void addEntry(PhoneManager manager) {
        System.out.println("\n<2. 등록>");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("핸드폰번호: ");
        String mobile = scanner.nextLine();
        System.out.print("회사번호: ");
        String office = scanner.nextLine();

        manager.addPhone(name, mobile, office);
        System.out.println("[등록되었습니다.]");
        System.out.println("-------------------------------------");
    }

    @Override
    public void deleteEntry(PhoneManager manager) {
        System.out.println("\n<3. 삭제>");
        System.out.print("번호: ");
        int entryNo = Integer.parseInt(scanner.nextLine());

        manager.deletePhone(entryNo);
        System.out.println("[삭제되었습니다.]");
        System.out.println("-------------------------------------");
    }

    @Override
    public void searchEntry(PhoneManager manager) {
        System.out.println("\n<4. 검색>");
        System.out.print("검색어: ");
        String keyword = scanner.nextLine();

        List<Phone> results = manager.searchPhones(keyword);
        System.out.println("\n> 검색 결과");
        displayPhoneList(results);
    }
}
