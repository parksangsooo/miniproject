package adressbook;

import java.util.List;

public interface UserInterface {

    void displayPhoneList(List<Phone> phones);
    void addEntry(PhoneManager manager);
    void deleteEntry(PhoneManager manager);
    void searchEntry(PhoneManager manager);
}
