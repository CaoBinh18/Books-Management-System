import java.util.ArrayList;
import java.util.Scanner;

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
//        System.out.println("Tên tác giả: ");
//        name = sc.nextLine();
//
//        System.out.println("Tuổi: ");
//        age = Integer.parseInt(sc.nextLine());

        try {
            System.out.println("Bút danh: ");
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
                    System.out.println("Nhập bút danh khác: ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("Ngày sinh: ");
//           birthday = sc.nextLine();
//
//           System.out.println("Địa chỉ: ");
//           address = sc.nextLine();
    }

    public void inputAuthor() {
        System.out.println("Tên tác giả: ");
        name = sc.nextLine();
    }

    public void inputAge() {
        System.out.println("Tuổi: ");
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                return;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng. Vui lòng nhập lại!");
                System.out.println("Tuổi: ");
            }
        }
    }

    public void inputBirthday() {
        System.out.println("Ngày sinh: ");
        birthday = sc.nextLine();
    }

    public void inputAddress() {
        System.out.println("Địa chỉ: ");
        address = sc.nextLine();
    }

    public void display(){
        System.out.println(toString());
    }

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

    @Override
    public String toString() {
        return "Author " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", nickname = '" + nickname + '\'' +
                ", birthday = '" + birthday + '\'' +
                ", address = '" + address + '\'';
    }
}
