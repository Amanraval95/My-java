import java.util.*;
import java.util.Scanner;

class Ansh {
    ArrayList<String> Books = new ArrayList<>();
    String  add;
  public void DefaultBooks(){

        Books.add("Java");
        Books.add("C++");
        Books.add("Python");
        Books.add("C");
        Books.add("JS");
  }
    int num, i, j, count = 0;
   
    char answer;
    Scanner get = new Scanner(System.in);

   
    void Select_book() {
        
        if (count == Books.size()) {

            System.out.println("NO BOOKS LEFT!");
            System.out.println("Do You Want To Add Or Return The Book y/n");
            answer = get.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                AddBooks();
            } else {
                System.exit(0);
            }
        } else {
            for (i = 0; i < Books.size() - count; i++) {
            }
            System.out.println("This Are The Remaining Books,Which one you want ?");
            for (i = 0; i < Books.size() - count; i++) {
                System.out.println(i + 1 + ". " + Books.get(i));
            }
            if (get.hasNextInt()) {
                num = get.nextInt();
                Delete();
            } else {
                System.out.println("Invalid input. Please enter a valid book number.");
            }
            num = get.nextInt();
            Delete();
        }
    }

   
    void Delete() {
        ++count;
        for (i = 0; i < Books.size(); i++) {
            if (Books.get(i).equals(Books.get(num - 1))) {
                for (j = i; j < Books.size() - 1; j++) {
                    Books.get(j) = Books.get(j + 1);
                }
                Books.remove(Books.size() - count) ;

                break;
            }
        }

        System.out.println("Do Yo Wnat Some More Books? y/n");
        answer = get.next().charAt(0);
        if (answer == 'y' || answer == 'Y') {
            Select_book();
        } else {
            System.exit(0);
        }
    }

    
    void AddBooks() {
        System.out.println("How Many Books You Want To Add");
        if (get.hasNext()) {
            try {

                num = get.nextInt();
                if (num > Books.size()) {
                    throw new ArrayIndexOutOfBoundsException("Only 5 Books can be added.");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("only 5 Books can be added");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }

        for (i = 0; i < num; i++) {
            System.out.print("Enter the book no. " + (i + 1) + ". ");

            add = get.next();

            if (Books.get(i) == null) {
                Books.add(add);
            } else {
                break;
            }
        }

    }

}

public class Aman{

    public static void main(String[] args) {
        System.out.println("Welcome to Library,\nWe Have This  Available, Enter The Book Number you Want");
        Ansh call = new Ansh();
        for (call.i = 0; call.i < call.Books.size(); call.i++) {
            System.out.println(call.i + 1 + ". " + call.Books.get(call.i));
        }
        Scanner get = new Scanner(System.in);
        if (get.hasNextInt()) {
            call.num = get.nextInt();
            call.Delete();
        } else {
            System.out.println("Invalid input. Please enter a valid book number.");
        }
        get.close();
    }
}

