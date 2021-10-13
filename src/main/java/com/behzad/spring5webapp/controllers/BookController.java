package com.behzad.spring5webapp.controllers;


import com.behzad.spring5webapp.model.Author;
import com.behzad.spring5webapp.model.Book;
import com.behzad.spring5webapp.repositories.AuthorRepository;
import com.behzad.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
    
    
     @GetMapping("/")
    public String index(){
       return "Hello AZure!!!";
    }

    @GetMapping("/booksget")
    public List<Book> getBooks(){
       return (List<Book>)bookRepository.findAll();
    }

    @GetMapping("/books")
    public List<Book> addBooks(){
        Book book = new Book("tttt","dasdffaf","fasddfs");
        Book book2 = new Book("tttt","dasdffaf","fasddfs");
        Author author = new Author("sdfdf","zdgadfg");
        author.setBooks(new HashSet<Book>(Arrays.asList(book,book2)));
        authorRepository.save(author);
        book.setAuthors(new HashSet<Author>(Arrays.asList(author)));
        book2.setAuthors(new HashSet<Author>(Arrays.asList(author)));
        bookRepository.save(book);
        bookRepository.save(book2);
        List<Book> books = (List<Book>)bookRepository.findAll();
        return books;
    }



}
