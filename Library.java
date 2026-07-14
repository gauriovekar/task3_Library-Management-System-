package com.task3;
import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Add Book
    public void addBook() {

        System.out.println("\n========== ADD BOOK ==========");

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Book b : books){
            if(b.getBookId()==id){
                System.out.println("Book ID already exists.");
                return;
            }
        }

        System.out.print("Enter Book Title : ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name : ");
        String author = sc.nextLine();

        books.add(new Book(id,title,author));

        System.out.println("\nBook Added Successfully.");
    }

    // View Books
    public void viewBooks() {

        if(books.isEmpty()){
            System.out.println("\nNo Books Available.");
            return;
        }

        System.out.println("\n========================= BOOK LIST =========================");

        System.out.printf("%-10s %-25s %-20s %-12s\n",
                "Book ID","Title","Author","Status");

        System.out.println("---------------------------------------------------------------------");

        for(Book b : books){

            String status = b.isIssued() ? "Issued" : "Available";

            System.out.printf("%-10d %-25s %-20s %-12s\n",
                    b.getBookId(),
                    b.getTitle(),
                    b.getAuthor(),
                    status);
        }
    }

    // Add User
    public void addUser() {

        System.out.println("\n========== ADD USER ==========");

        System.out.print("Enter User ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for(User u:users){
            if(u.getUserId()==id){
                System.out.println("User ID already exists.");
                return;
            }
        }

        System.out.print("Enter User Name : ");
        String name = sc.nextLine();

        users.add(new User(id,name));

        System.out.println("\nUser Added Successfully.");
    }

    // View Users
    public void viewUsers() {

        if(users.isEmpty()){
            System.out.println("\nNo Users Found.");
            return;
        }

        System.out.println("\n============== USER LIST ==============");

        System.out.printf("%-10s %-25s\n","User ID","Name");

        System.out.println("---------------------------------------");

        for(User u:users){

            System.out.printf("%-10d %-25s\n",
                    u.getUserId(),
                    u.getName());
        }
    }

    // Issue Book
    public void issueBook() {

        System.out.println("\n========== ISSUE BOOK ==========");

        System.out.print("Enter User ID : ");
        int userId = sc.nextInt();

        User user = null;

        for(User u:users){
            if(u.getUserId()==userId){
                user=u;
                break;
            }
        }

        if(user==null){
            System.out.println("User Not Found.");
            return;
        }

        System.out.print("Enter Book ID : ");
        int bookId = sc.nextInt();

        for(Book b:books){

            if(b.getBookId()==bookId){

                if(b.isIssued()){
                    System.out.println("Book Already Issued.");
                }
                else{
                    b.setIssued(true);

                    System.out.println("\nBook Issued Successfully.");
                    System.out.println("Book : "+b.getTitle());
                    System.out.println("Issued To : "+user.getName());
                }

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    // Return Book
    public void returnBook() {

        System.out.println("\n========== RETURN BOOK ==========");

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();

        for(Book b:books){

            if(b.getBookId()==id){

                if(!b.isIssued()){
                    System.out.println("Book is already available.");
                }
                else{
                    b.setIssued(false);
                    System.out.println("Book Returned Successfully.");
                }

                return;
            }
        }

        System.out.println("Book Not Found.");
    }

}
