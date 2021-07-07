import java.util.Scanner;

public class Book {
    public int idBook;
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



    public void displayBook() {
        Book book = new Book(idBook, nameBook, publishDay, nickname);
        System.out.format("%5d | ", book.getIdBook());
        System.out.format("%20s | ", book.getNameBook());
        System.out.format("%20s | ", book.getPublishDay());
        System.out.format("%20s%n", book.getNickname());
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

    public void inputBook() {
           System.out.println("Tên sách: ");
           nameBook = sc.nextLine();

            System.out.println("Ngày xuất bản: ");
            publishDay = sc.nextLine();

            System.out.println("Bút danh: ");
            nickname = sc.nextLine();
    }

    @Override
    public String toString() {
        return "ID: " + idBook +
                "| Tên sách: '" + nameBook + '\'' +
                "| Ngày phát hành: '" + publishDay + '\'' +
                "| Bút danh = '" + nickname + '\'';
    }
}
