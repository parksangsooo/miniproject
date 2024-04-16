package adressbook;

public class Phone {
    private String name; // 전화번호의 소유자 이름
    private String mobile; // 소유자의 모바일 전화번호
    private String office; // 소유자의 사무실 전화번호
    private static int lastNo = 0; // 마지막으로 할당된 고유 번호를 추적
    private int no; // 개별 전화번호의 고유 번호

    // 전화번호 객체 생성자
    public Phone(String name, String mobile, String office) {
        this.no = ++lastNo; // 고유 번호를 자동으로 증가시켜 할당
        this.name = name; // 이름 할당
        this.mobile = mobile; // 모바일 번호 할당
        this.office = office; // 사무실 번호 할당
    }

    public int getNo() {
        return no; // 고유 번호 반환
    }

    public String getName() {
        return name; // 이름 반환
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, mobile, office); // 전화번호 정보를 쉼표로 구분된 문자열로 포맷하여 반환
    }
}
