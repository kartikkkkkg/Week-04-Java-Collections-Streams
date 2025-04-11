import java.io.*;

public class ReadUserInput {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("user_info.txt")) {
            System.out.print("Enter name: ");
            String name = br.readLine();
            System.out.print("Enter age: ");
            String age = br.readLine();
            System.out.print("Enter favorite programming language: ");
            String lang = br.readLine();
            fw.write("Name: " + name + "\nAge: " + age + "\nFavorite Language: " + lang);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}