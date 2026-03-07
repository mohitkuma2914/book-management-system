package com.example.bookm_managment_system1.service;

import com.example.bookm_managment_system1.models.Book;
import com.example.bookm_managment_system1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookMangMentService {
    @Autowired
    BookRepository bookRepository;

    public Book storeBook(Book book) {
         return bookRepository.save(book);
    }

    public Book getBookById(int id) {
        Optional<Book> optionalBook=  bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new RuntimeException("book Not found by this id");
        }
        return  optionalBook.get();
    }

    public Book updateBookById(int id, Book book) {
        Optional<Book> optionalBook=bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new RuntimeException("there is no book by the id");
        }
            Book existBook=optionalBook.get();
            existBook.setTitle(book.getTitle());
            existBook.setAuthor(book.getAuthor());
            existBook.setCopiesSold(book.getCopiesSold());


        return  bookRepository.save(existBook);

    }

    public Book deleteById(int id) {
        Optional<Book> optionalBook=bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new RuntimeException("there is no book by this id");
        }
        Book deleteBook=optionalBook.get();
        bookRepository.delete(deleteBook);
        return  deleteBook;
    }
}
