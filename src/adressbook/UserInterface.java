package adressbook;

import java.util.List;

public interface UserInterface {
    // 전화번호 목록을 화면에 표시하는 메소드
    void displayPhoneList(List<Phone> phones);  // List<Phone> phones: 표시할 전화번호 객체 리스트

    // 새 전화번호를 등록하는 메소드
    void addEntry(PhoneManager manager);  // PhoneManager 객체를 인자로 받아 전화번호를 추가

    // 전화번호를 삭제하는 메소드
    void deleteEntry(PhoneManager manager);  // PhoneManager 객체를 인자로 받아 전화번호를 삭제

    // 전화번호를 검색하는 메소드
    void searchEntry(PhoneManager manager);  // PhoneManager 객체를 인자로 받아 키워드로 전화번호를 검색
}
