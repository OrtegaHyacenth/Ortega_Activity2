/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ortega_Activity2;

import java.util.LinkedList;
import java.util.Scanner;


        class Book{
          String author;
          String title;
          String ISBN;
             
    Book(String author, String title, String ISBN) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }
      
        public String getISBN() {
        return ISBN;
    }

        public String toString() {
        return "Author: " + author + ", Title: " + title + ", ISBN: " + ISBN;
    }
}

        class LibraryList {
        LinkedList<Book> books = new LinkedList<>();

        public void insertBook(String author, String title, String ISBN) {
        Book insertBook = new Book(author, title, ISBN);
        books.add(insertBook);
    }

        public Book search(String ISBN) {
        for (Book bks : books) {
            if (bks.getISBN().equals(ISBN)) {
                return bks;
            }
        }
        return null; 
    }

        public void display() {
        for (Book bks : books) {
            System.out.println(bks);
        }
    }
}


/**
 *
 * @author home
 */
public class Ortega_Activity2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        LibraryList lib= new LibraryList();
        
        while (continueLoop) {
            System.out.println("Choose: \n [1] Add Books \n [2] Search ISBN \n"
                    + " [3] Display All Books \n [4] Exit) ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice){
                
                case 1:
                    Scanner scan = new Scanner(System.in);
                    
                    System.out.println("Author: ");
                    String addAuthor = scanner.nextLine();

                    System.out.println("Title: ");
                    String addTitle = scanner.nextLine();

                    System.out.println("ISBN: ");
                    String addISBN = scanner.nextLine();

                    lib.insertBook(addAuthor, addTitle, addISBN);
                    break;
                
                case 2:
                    Scanner scn = new Scanner(System.in);
                    
                    System.out.println("Enter ISBN to search: ");
                    String searchISBN = scanner.nextLine();
                    Book foundBook = lib.search(searchISBN);
        
                     if (foundBook != null) {
                     System.out.println("Found book with ISBN:" + searchISBN + ":  " + foundBook);
                     } else {
                     System.out.println("Book with ISBN: " + searchISBN + "  wa dyamo!\n Please try again.");
                     }
                break;
                
                case 3: 
                    lib.display();
                    break;
                    
                case 4:
                      continueLoop = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
    }
    scanner.close();
}
}