package com.tinylibrary.controller;


import com.tinylibrary.dto.BookRequestDTO;
import com.tinylibrary.dto.BookResponseDTO;
import com.tinylibrary.entity.Book;
import com.tinylibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tinyLibrary/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookResponseDTO> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/available")
    public List<BookResponseDTO> getAllBookAvailable(){
        return bookService.getAllBookAvailable();
    }

    @GetMapping("/borrowed")
    public List<BookResponseDTO> getAllBookBorrowed(){
        return bookService.getAllBookBorrowed();
    }

    @PostMapping()
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookRequestDTO dto){
        BookResponseDTO bookCreate = bookService.createBook(dto);

        return ResponseEntity.ok(bookCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@Valid @PathVariable Integer id, @RequestBody BookRequestDTO dto){
        BookResponseDTO bookUpdate = bookService.updateBook(id, dto);

        return ResponseEntity.ok(bookUpdate);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponseDTO> patchBook(@Valid @PathVariable Integer id, @RequestBody BookRequestDTO dto){
        BookResponseDTO book = bookService.patchBook(id, dto);

        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
