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
                            Book book = new Book();
                            book.inputBook();
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

                                authorList.add(author);
                            }
                            bookList.add(book);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Nhập sai. Vui lòng nhập lại theo menu.");
                        e.getStackTrace();
                    }

                    break;
                case 2:
                    for (Book book : bookList) {
                        book.display();
                    }
                    break;
                case 3:
                    System.out.println("Nhập số lượng tác giả thêm vào: ");
                    try {
                        n = Integer.parseInt(sc.nextLine());

                        for (int i = 0; i < n; i++) {
                            Author author = new Author();
                            author.inputAuthor(authorList);
                            authorList.add(author);
                        }
                    } catch (NumberFormatException e) {
                        e.getStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Nhập tên bút danh cần tìm: ");
                    String nickname = sc.nextLine();

                    for (int i = 0; i < bookList.size(); i++) {
                        if (bookList.get(i).getNickname().equalsIgnoreCase(nickname)) {
                            bookList.get(i).display();
                        }
                    }
                    break;
                case 5:
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
                        e.getStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Nhập ID sách cần xóa: ");
                    id = Integer.parseInt(sc.nextLine());
                    for (Book book : bookList) {
                        if (book.getIdBook() == id) {
                            bookList.remove(book);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Bắt đầu ghi file");
                    FileOutputStream fw = null;

                    try {
                        fw = new FileOutputStream("books.txt", true);

                        for (Book book : bookList) {
                            String line = book.getFileLine();
                            byte[] bytes = line.getBytes("utf8");
                            fw.write(bytes);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (fw != null) {
                            try {
                                fw.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    break;
                case 8:
                    FileInputStream fi = null;
                    InputStreamReader reader = null;
                    BufferedReader bufferedReader = null;

                    try {
                        fi = new FileInputStream("books.txt");

                        reader = new InputStreamReader(fi, StandardCharsets.UTF_8);

                        bufferedReader = new BufferedReader(reader);

                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            if (line.isEmpty()) {
                                continue;
                            }
                            Book book = new Book();
                            book.parse(line);
                            bookList.add(book);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (fi != null) {
                            try {
                                fi.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    break;
                case 9:
                    System.out.println("Tạm biệt và hẹn gặp lại!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Bạn đã nhập sai!");
                    System.err.println("Hãy nhập lại: ");
                    break;
            }
        } while (choice != 9);
    }

    static void showmenu() {
        System.out.println("1. Nhập thông tin sách");
        System.out.println("2. Hiển thị tất cả sách");
        System.out.println("3. Nhập thông tin tác giả");
        System.out.println("4. Tìm kiếm sách theo bút danh");
        System.out.println("5. Chỉnh sửa sách");
        System.out.println("6. Xóa sách");
        System.out.println("7. Ghi File");
        System.out.println("8. Đọc File");
        System.out.println("9. Thoát");
        System.out.println("=================================");
        System.out.println("Nhập lựa chọn của bạn: ");
    }
}
