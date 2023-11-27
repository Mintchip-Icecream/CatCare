import java.util.Scanner;
public class SwingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        switch(name) {
            case "Ngoc": System.out.println("Your name is Ngoc");
            break;
            case "Nick": System.out.println("Hi Nick, your name isn't Ngoc");
            break;
            default: System.out.println("Your name is not Ngoc");
        }
    }

}
