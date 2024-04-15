package adressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneManager {
    private List<Phone> phones; // 전화번호 목록을 저장하는 리스트
    private static String rootPath = System.getProperty("user.dir") + File.separator + "files" + File.separator;
    private static String FILE_PATH = rootPath + "PhoneDB.txt"; // 파일 경로

    // 생성자: 파일에서 전화번호 목록 로드
    public PhoneManager() {
        this.phones = loadPhones();
    }

    // 전화번호 목록 로드 메서드
    private List<Phone> loadPhones() {
        List<Phone> phoneList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.err.println("No file found at " + FILE_PATH);
            return phoneList; // 파일이 없으면 빈 리스트 반환
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    phoneList.add(new Phone(data[0], data[1], data[2]));
                } else {
                    System.err.println("Incorrect data format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return phoneList;
    }

    // 전화번호 목록을 파일에 저장하는 메서드
    public void savePhone() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Phone phone : phones) {
                bw.write(phone.toString());
                bw.newLine(); // 각 레코드 후에 개행
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // 전화번호 추가 메서드
    public void addPhone(String name, String mobile, String office) {
        phones.add(new Phone(name, mobile, office));
        savePhone(); // 변경 사항 저장
    }

    // 전화번호 삭제 메서드
    public void deletePhone(int no) {
        phones.removeIf(phone -> phone.getNo() == no);
        savePhone(); // 변경 사항 저장
    }

    // 전화번호 검색 메서드
    public List<Phone> searchPhones(String keyword) {
        return phones.stream()
                .filter(phone -> phone.getName().contains(keyword))
                .collect(Collectors.toList());
    }

    // 전화번호 목록 반환 메서드
    public List<Phone> getPhones() {
        return phones;
    }
}
