package com.example.bookm_managment_system1.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException (String meassage){
        super(meassage);
    }

}
