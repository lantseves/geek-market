package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.Book;
import com.geekbrains.geekmarket.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService ;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showBooksList(Model model) {
        model.addAttribute("books" , bookService.getAllBook() ) ;
        return "books" ;
    }

    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Book book) {
        bookService.insertOrUpdateBook(book);
        return "redirect:/books";
    }
}
