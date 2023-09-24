
import java.util.Scanner;

class Library1 {
    
    String books[] = { "Java", "C++", "Python", "C", "JS" }, add;
    
    int num, i, j, count = 0;
   
    char answer;
    Scanner get = new Scanner(System.in);

   
    void Select_book() {
        if (count == books.length) {

            System.out.println("NO BOOKS LEFT!");
            System.out.println("Do You Want To Add Or Return The Book y/n");
            answer = get.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                AddBooks();
            } else {
                System.exit(0);
            }
        } else {
            for (i = 0; i < books.length - count; i++) {
            }
            System.out.println("This Are The Remaining Books,Which one you want ?");
            for (i = 0; i < books.length - count; i++) {
                System.out.println(i + 1 + ". " + books[i]);
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
        for (i = 0; i < books.length; i++) {
            if (books[i].equals(books[num - 1])) {
                for (j = i; j < books.length - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[books.length - count] = null;

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
                if (num > books.length) {
                    throw new ArrayIndexOutOfBoundsException("Only 5 books can be added.");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("only 5 books can be added");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
        }

        for (i = 0; i < num; i++) {
            System.out.print("Enter the book no. " + (i + 1) + ". ");

            add = get.next();

            if (books[i] == null) {
                books[i] = add;
            } else {
                break;
            }
        }
    }
}

public class Library {

    public static void main(String[] args) {
        System.out.println("Welcome to Library,\nWe Have This Books Available, Enter The Book Number you Want");
        Library1 call = new Library1();
        for (call.i = 0; call.i < call.books.length; call.i++) {
            System.out.println(call.i + 1 + ". " + call.books[call.i]);
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
