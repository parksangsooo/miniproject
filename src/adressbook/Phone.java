package adressbook;

public class Phone {
    private String name;
    private String mobile;
    private String office;
    private static int lastNo = 0;
    private int no;



    public Phone(String name, String mobile, String office) {
        this.no = ++lastNo;
        this.name = name;
        this.mobile = mobile;
        this.office = office;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, mobile, office);
    }
}
