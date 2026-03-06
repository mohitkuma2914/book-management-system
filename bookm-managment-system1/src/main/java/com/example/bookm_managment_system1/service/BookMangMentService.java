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
}
