package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Book;
import com.geekbrains.geekmarket.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository ;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook() {
        List<Book> books = bookRepository.findAll() ;
        books.forEach(System.out::println);

        return bookRepository.findAll() ;
    }

    public void insertOrUpdateBook(Book book) {
        bookRepository.save(book) ;
    }
}
