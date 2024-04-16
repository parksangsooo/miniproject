package adressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneManager {
    private List<Phone> phones; // Phone 객체의 리스트로 전화번호 목록을 저장
    private static String rootPath = System.getProperty("user.dir") + File.separator + "files" + File.separator; // 프로젝트의 작업 디렉토리 경로
    private static String FILE_PATH = rootPath + "PhoneDB.txt"; // 전화번호 데이터를 저장할 파일의 전체 경로

    // 생성자: 파일에서 전화번호 목록 로드
    public PhoneManager() {
        this.phones = loadPhones(); // 시작할 때 전화번호 목록을 로드
    }

    // 파일로부터 전화번호 목록을 로드하는 메소드
    private List<Phone> loadPhones() {
        List<Phone> phoneList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.err.println("No file found at " + FILE_PATH); // 파일이 존재하지 않는 경우 오류 메시지 출력
            return phoneList; // 빈 리스트 반환
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) { // 파일의 끝까지 한 줄씩 읽음
                String[] data = line.split(","); // 쉼표로 구분된 데이터 파싱
                if (data.length == 3) { // 정확하게 3개의 데이터 요소가 있는지 확인
                    phoneList.add(new Phone(data[0], data[1], data[2])); // Phone 객체 생성 및 추가
                } else {
                    System.err.println("Incorrect data format: " + line); // 데이터 형식 오류 메시지 출력
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage()); // 파일 읽기 오류 처리
        }
        return phoneList;
    }

    // 전화번호 목록을 파일에 저장하는 메서드
    public void savePhone() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Phone phone : phones) {
                bw.write(phone.toString()); // Phone 객체를 문자열로 변환하여 파일에 쓰기
                bw.newLine(); // 새로운 줄로 구분
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage()); // 파일 쓰기 오류 처리
        }
    }

    // 전화번호를 추가하는 메서드
    public void addPhone(String name, String mobile, String office) {
        phones.add(new Phone(name, mobile, office)); // 새 Phone 객체를 리스트에 추가
        savePhone(); // 변경 사항을 파일에 즉시 저장
    }

    // 전화번호를 삭제하는 메서드
    public void deletePhone(int no) {
        phones.removeIf(phone -> phone.getNo() == no); // 일치하는 번호를 가진 전화번호 삭제
        savePhone(); // 변경 사항을 파일에 즉시 저장
    }

    // 키워드로 전화번호를 검색하는 메서드
    public List<Phone> searchPhones(String keyword) {
        return phones.stream()
                .filter(phone -> phone.getName().contains(keyword)) // 이름에 키워드가 포함된 전화번호 필터링
                .collect(Collectors.toList()); // 결과를 리스트로 수집
    }

    // 전체 전화번호 목록을 반환하는 메서드
    public List<Phone> getPhones() {
        return phones;
    }
}
