package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static Service.Regex.*;

public class Author {
    private String name;
    private int age;
    private String nickname;
    private String birthday;
    private String address;
    Scanner sc = new Scanner(System.in);

    public Author() {
    }

    public Author(String nickname) {
        this.nickname = nickname;
    }

    public Author(String name, int age, String nickname, String birthday, String address) {
        this.name = name;
        this.age = age;
        this.nickname = nickname;
        this.birthday = birthday;
        this.address = address;
    }

    public void inputAuthor(ArrayList<Author> authorList) {
        Scanner sc = new Scanner(System.in);
        inputAuthor();

        try {
            System.out.print("Bút danh: ");
            while (true) {
                nickname = sc.nextLine();
                boolean isFind = false;
                for (int i = 0; i < authorList.size(); i++) {
                    if (authorList.get(i).getNickname().equalsIgnoreCase(nickname)) {
                        isFind = true;
                        break;
                    }
                }
                if (!isFind) {
                    break;
                } else {
                    System.out.print("Nhập bút danh khác: ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputAuthor() {
        System.out.print("Tên tác giả: ");
        while (true) {
            try {
                name = new Scanner(System.in).nextLine();
                if(name == ""){
                    continue;
                }else{
                    break;}
            } catch (InputMismatchException e) {
                System.out.println("Không hợp lệ!!!");
            }
        }
    }

    public void inputAge() {
        System.out.print("Tuổi: ");
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                return;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng. Vui lòng nhập lại!");
                System.out.print("Tuổi: ");
            }
        }
    }

    public void inputBirthday() {
        System.out.print("Ngày sinh: ");
        birthday = sc.nextLine();
        while (!checkDateTime(birthday)) {
            System.out.println("Ngày tháng không hợp lệ. Hãy nhập lại!!!");
            System.out.print("Ngày sinh: ");
            birthday = sc.nextLine();
        }
    }

    public void inputAddress() {
        System.out.print("Địa chỉ: ");
        while (true) {
            try {
                address = new Scanner(System.in).nextLine();
                if(address == ""){
                    continue;
                }else{
                    break;}
            } catch (InputMismatchException e) {
                System.out.println("Không hợp lệ!!!");
            }
        }
    }

//    public void display(){
//        System.out.println(toString());
//    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayAuthor() {
        Author author = new Author(name, age, nickname, birthday, address);
        System.out.format("%20s | ", author.getName());
        System.out.format("%5d | ", author.getAge());
        System.out.format("%20s | ", author.getNickname());
        System.out.format("%20s | ", author.getBirthday());
        System.out.format("%20s%n", author.getAddress());
    }

    @Override
    public String toString() {
        return "model.Author " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", nickname = '" + nickname + '\'' +
                ", birthday = '" + birthday + '\'' +
                ", address = '" + address + '\'';
    }
}