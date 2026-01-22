/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bt1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author hhuy0
 */
public class Book {


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + '}';
    }

    public Book(int id, String title, String author, Long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    private int id;
    private String title;
    private String author;
    private Long price;
    public void input()
    {
        Scanner x = new Scanner (System.in);
        System.out.println("Nhap ma sach");
        this.id = Integer.parseInt(x.nextLine());
        System.out.println("Nhap ten sach");
        this.title = x.nextLine();
        System.out.println("Nhap tac gia:");
        this.author=x.nextLine();
        System.out.println("Nhap gia sach:");
        this.price= x.nextLong();
        
    }
    public void output()
    {
        String msg="""
                   BOOK:id =%d, title =%s, author = %s, price=%d""".formatted(id,title,author,price);
        System.out.println(msg);
    }
    public Book(){}
     public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String msg="""
                   Chuong tring quan ly sach:
                   1.them 1 sach
                   2. xoa 1 sach
                   3.Thay doi sach
                   4.xuat thong tin
                   5.tim sach
                   6.lay sach theo ten tac gia
                   7.tim kiem theo tac gia
                   8. thoat
                   Chhon chuc nang""";
        int chon=0;
        do{
            System.out.println(msg);
            chon = x.nextInt();
            switch (chon) {
                case 1-> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                    
                }
                case 2->{
                    System.out.println("Nhap ma sach can xoa");
                    int bookId =x.nextByte();
                    Book find =listBook.stream().filter(p->p.getId()== bookId ).findFirst().orElseThrow();
                    listBook.remove(find);
                    System.out.println("da xoa thanh cong");
                }
                case 3 ->{
                    System.out.println("Nhap ma sach can chinh");
                    int bookId = x.nextInt();
                    Book find = listBook.stream().filter(p->p.getId()== bookId).findFirst().orElseThrow();
                }
                case 4->{
                    System.out.println("\n xuat thong tin danh sach");
                    listBook.forEach(p->p.output());
                }
                case 5->{
                    List<Book> list5 = listBook.stream()
                            .filter(u->u.getTitle().toLowerCase().contains("Lap trinh"))
                            .toList();
                    list5.forEach(Book::output);
                }
                case 6 -> {
                    x.nextLine(); 
                    System.out.println("Nhap ten tac gia:");
                    String author = x.nextLine();

                    System.out.println("Nhap so luong sach muon lay:");
                    int limit = x.nextInt();

                    listBook.stream()
                            .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                            .limit(limit)
                            .forEach(Book::output);
                    }
                   case 7 -> {
                    x.nextLine(); 
                    System.out.println("Nhap cac tac gia (cach nhau boi dau phay):");
                    String input = x.nextLine();


                    Set<String> authorSet = new HashSet<>();
                    for (String a : input.split(",")) {
                                 authorSet.add(a.trim().toLowerCase());
                        }

                        listBook.stream()
                                .filter(b -> authorSet.contains(b.getAuthor().toLowerCase()))
                                .forEach(Book::output);
                        }

            }
        }while(chon!=0);
    }
}
