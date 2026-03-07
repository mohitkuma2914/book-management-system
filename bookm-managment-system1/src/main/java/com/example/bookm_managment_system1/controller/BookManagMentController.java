package com.example.bookm_managment_system1.controller;

import com.example.bookm_managment_system1.models.Book;
import com.example.bookm_managment_system1.service.BookMangMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookManagMentController {
    @Autowired
BookMangMentService bookMangMentService;
    @PostMapping("/new")
    public ResponseEntity<Book> createNewBook(@RequestBody Book book){
        Book savedBook=bookMangMentService.storeBook(book);
        return ResponseEntity.ok(savedBook);
    }
@GetMapping("/get")
    public ResponseEntity<Book> getBookById(@RequestParam("id") int id){
      Book book=  bookMangMentService.getBookById(id);
      return ResponseEntity.ok(book);


}

@PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") int id,@RequestBody Book book){
       Book newbook= bookMangMentService.updateBookById(id,book);
        return ResponseEntity.ok(newbook);

}
@DeleteMapping("/delete/{id}")
public ResponseEntity<Book> deleteById(@PathVariable("id") int id){
       Book deletedBook= bookMangMentService.deleteById(id);
        return ResponseEntity.ok(deletedBook);

    }



}
