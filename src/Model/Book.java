package Model;

import java.util.InputMismatchException;
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
        System.out.print("Tên sách: ");
        while (true) {
            try {
                nameBook = new Scanner(System.in).nextLine();
                if(nameBook == ""){
                    continue;
                }else{
                    break;}
            } catch (InputMismatchException e) {
                System.out.println("Không hợp lệ!!!");
            }
        }


        System.out.print("Ngày xuất bản: ");
        while (true) {
            try {
                publishDay = new Scanner(System.in).nextLine();
                if(publishDay == ""){
                    continue;
                }else{
                    break;}
            } catch (InputMismatchException e) {
                System.out.println("Không hợp lệ!!!");
            }
        }

        System.out.print("Bút danh: ");
        while (true) {
            try {
                nickname = new Scanner(System.in).nextLine();
                if(nickname == ""){
                    continue;
                }else{
                    break;}
            } catch (InputMismatchException e) {
                System.out.println("Không hợp lệ!!!");
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + idBook +
                "| Tên sách: '" + nameBook + '\'' +
                "| Ngày phát hành: '" + publishDay + '\'' +
                "| Bút danh = '" + nickname + '\'';
    }
}
