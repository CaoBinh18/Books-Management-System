import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        int choice, n, id;
        ArrayList<Author> authorList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        do {
            showmenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
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
//                        e.getStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("   ID |             Tên sách |       Ngày phát hành |              Bút danh");
                    for (Book book : bookList) {
                        book.displayBook();
                    }
                    break;
                case 3:
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
                    break;
                case 4:
                    System.out.println("          Tên tác giả | Tuổi |             Bút danh |           Ngày sinh |               Địa chỉ");
                    for (Author author : authorList) {
                        author.displayAuthor();
                    }
                    break;
                case 5:
                    System.out.println("Nhập tên bút danh cần tìm: ");
                    String nickname = sc.nextLine();

                    for (int i = 0; i < bookList.size(); i++) {
                        if (bookList.get(i).getNickname().equalsIgnoreCase(nickname)) {
                            bookList.get(i).displayBook();
                        } else {
                            System.out.println("Không có trong danh sách.");
                        }
                    }
                    break;
                case 6:
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
                    break;
                case 7:
                    System.out.println("Nhập ID sách cần xóa: ");
                    try {
                        id = Integer.parseInt(sc.nextLine());
//                        for (Book book : bookList) {
//                            if (book.getIdBook() == id) {
//                                bookList.remove(book);
//                                break;
//                            }
//                        }
                        bookList.remove(id-1);
                        for(int i = 0; i < bookList.size(); i++){
                            if (bookList.get(i).getIdBook() > (id - 1)) {
                                bookList.get(i).setIdBook(bookList.get(i).getIdBook() - 1);
                            }
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
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
                    break;
                case 9:
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
                    break;
                case 0:
                    System.out.println("Tạm biệt và hẹn gặp lại!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Bạn đã nhập sai!");
                    System.err.println("Hãy nhập lại: ");
                    break;
            }
        } while (choice != 0);
    }

    static void showmenu() {
        System.out.println("===============MENU===============");
        System.out.println("1. Nhập thông tin sách");
        System.out.println("2. Hiển thị tất cả sách");
        System.out.println("3. Nhập thông tin tác giả");
        System.out.println("4. Hiển thị thông tin tác giả");
        System.out.println("5. Tìm kiếm sách theo bút danh");
        System.out.println("6. Chỉnh sửa thông tin sách");
        System.out.println("7. Xóa sách");
        System.out.println("8. Ghi File");
        System.out.println("9. Đọc File");
        System.out.println("0. Thoát");
        System.out.println("==================================");
        System.out.println("Nhập lựa chọn của bạn: ");
    }
}