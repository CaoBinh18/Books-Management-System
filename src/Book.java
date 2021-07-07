import java.util.Scanner;

public class Book {
    private int idBook;
    private String nameBook;
    private String publishDay;
    private String nickname;
    private static Scanner sc = new Scanner(System.in);

    public Book() {
    }

    public Book(int idBook, String  nameBook, String publishDay, String nickname) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.publishDay = publishDay;
        this.nickname = nickname;
    }

    public String getFileLine() {
        return idBook + ", " + nameBook + ", " + publishDay + ", " + nickname + "\n";
    }

    public void parse(String line) {
        String[] params = line.split(", ");

        idBook = Integer.parseInt(params[0]);
        nameBook = params[1];
        publishDay = params[2];
        nickname = params[3];
    }

    public void inputBook() {

        System.out.println("ID của sách: ");
        idBook = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Tên sách: ");
            nameBook = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Ngày xuất bản: ");
        publishDay = sc.nextLine();

        System.out.println("Bút danh: ");
        nickname = sc.nextLine();
    }

    public void display() {
        System.out.println(toString());
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getPublishDay() {
        return publishDay;
    }

    public void setPublishDay(String publishDay) {
        this.publishDay = publishDay;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "ID: " + idBook +
                ", Tên sách: '" + nameBook + '\'' +
                ", Ngày phát hành: '" + publishDay + '\'' +
                ", Bút danh = '" + nickname + '\'';
    }
}
