package Service;

import Model.Author;
import Model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static Service.Regex.*;

public class bookManagement {
    private static int n, id;
    private static Scanner sc = new Scanner(System.in);

    private static ArrayList<Author> authorList = new ArrayList<>();
    private static ArrayList<Book> bookList = new ArrayList<>();

    public static void addBook() {
        System.out.println("Số sách cần thêm: ");
        try {
            n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                id = (bookList.size() > 0) ? (bookList.size() + 1) : 1;
                System.out.println("Sách số: " + id);

                int idBook = (bookList.size() > 0) ? (bookList.size() + 1) : 1;
                System.out.println("ID: " + idBook);

                System.out.println("Tên sách: ");
                String nameBook = sc.nextLine();

                System.out.println("Ngày xuất bản: ");
                String publishDay = sc.nextLine();

                while (!checkDateTime(publishDay)) {
                    System.out.println("Ngày tháng không hợp lệ. Hãy nhập lại!!!");
                    System.out.println("Ngày xuất bản: ");
                    publishDay = sc.nextLine();
                }

                System.out.println("Bút danh: ");
                String nickname = sc.nextLine();

                Book book = new Book(idBook, nameBook, publishDay, nickname);

                boolean isFind = false;

                for (int j = 0; j < authorList.size(); j++) {
                    if (authorList.get(j).getNickname().equalsIgnoreCase(book.getNickname())) {
                        isFind = true;
                        break;
                    }
                }
                if (!isFind) {
                    Author author = new Author(book.getNickname());
                    author.inputAuthor();
                    author.inputAge();
                    author.inputBirthday();
                    author.inputAddress();
                    authorList.add(author);
                }
                bookList.add(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai. Vui lòng nhập lại theo menu.");
        }
    }

    public static void showB() {
        System.out.println("   ID |             Tên sách |       Ngày phát hành |              Bút danh");
        for (Book book : bookList) {
            book.displayBook();
        }
    }

    public static void addAuthor() {
        System.out.println("Nhập số lượng tác giả thêm vào: ");
        try {
            n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                id = (authorList.size() > 0) ? (authorList.size() + 1) : 1;
                System.out.println("Tác giả " + id);
                Author author = new Author();
                author.inputAuthor(authorList);
                author.inputAge();
                author.inputBirthday();
                author.inputAddress();
                authorList.add(author);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai. Vui lòng nhập lại theo Menu.");
//                        e.getStackTrace();
        }
    }

    public static void showAu() {
        System.out.println("         Tên tác giả |  Tuổi |             Bút danh |            Ngày sinh |               Địa chỉ");
        for (Author author : authorList) {
            author.displayAuthor();
        }
    }

    public static void findNickname() {
        System.out.println("Nhập tên bút danh cần tìm: ");
        String nickname = sc.nextLine();

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getNickname().equalsIgnoreCase(nickname)) {
                bookList.get(i).displayBook();
            }
        }
    }

    public static void edit() {
        System.out.println("Nhập ID sách cần sửa: ");
        try {
            id = Integer.parseInt(sc.nextLine());
            for (Book book : bookList) {
                if (book.getIdBook() == id) {
                    book.inputBook();
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("ID không tồn tại. Hãy nhập lại");
//                        e.getStackTrace();
        }

        for (Book book : bookList) {
            book.displayBook();
        }
    }

    public static void delete() {
        System.out.println("Nhập ID sách cần xóa: ");
        try {
            id = Integer.parseInt(sc.nextLine());
            bookList.remove(id-1);
            for(int i = 0; i < bookList.size(); i++){
                if (bookList.get(i).getIdBook() > (id - 1)) {
                    bookList.get(i).setIdBook(bookList.get(i).getIdBook() - 1);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (Book book : bookList) {
            book.displayBook();
        }
    }

    public static void writeFile() {
        File infile = new File("E:\\CaseStudy2\\books.csv");
        try{
            FileWriter fw = new FileWriter(infile);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i <  bookList.size(); i++){
                bw.write(bookList.get(i).getIdBook() +
                        ", " + bookList.get(i).getNameBook() +
                        ", " +bookList.get(i).getPublishDay() +
                        ", " +bookList.get(i).getNickname() +
                        "\n");
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Đã ghi file!");
    }

    public static void readFile() {
        String line = "";
        String splitBy = ", ";
        if (bookList.size() == 0){
            System.out.println("Chưa thêm thông tin sách vào!");
        } else {
            System.out.println("Đọc file!");
            try {
                BufferedReader br = new BufferedReader(new FileReader("CaseStudy2\\books.csv"));
                int i = 0;
                while ((line = br.readLine()) != null) {
                    String[] book = line.split(splitBy);
                    Book book1 = new Book();
                    book1.setIdBook(Integer.parseInt(book[0]));
                    book1.setNameBook(book[1]);
                    book1.setPublishDay(book[2]);
                    book1.setNickname(book[3]);
                    bookList.add(book1);

                }
            } catch (IOException e) {
                e.getMessage();
            }
        }

        for (Book book : bookList) {
            book.displayBook();
        }
    }
}
