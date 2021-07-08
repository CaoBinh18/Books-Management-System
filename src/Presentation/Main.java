package Presentation;

import Service.bookManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int choice;

        Scanner sc = new Scanner(System.in);

        do {
            showmenu();
            while (true) {
                try{
                    choice = new Scanner(System.in).nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Không hợp lệ!!!");
                }
            }

            switch (choice) {
                case 1:
                    bookManagement.addBook();
                    break;
                case 2:
                    bookManagement.showB();
                    break;
                case 3:
                    bookManagement.addAuthor();
                    break;
                case 4:
                    bookManagement.showAu();
                    break;
                case 5:
                    bookManagement.findNickname();
                    break;
                case 6:
                    bookManagement.edit();
                    break;
                case 7:
                    bookManagement.delete();
                    break;
                case 8:
                    bookManagement.writeFile();
                    break;
                case 9:
                    bookManagement.readFile();
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