package com.tinylibrary.controller;

import com.tinylibrary.dto.BorrowRequestDTO;
import com.tinylibrary.dto.BorrowResponseDTO;
import com.tinylibrary.service.BorrowService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tinyLibrary/borrow")
public class BorrowController {

    private BorrowService borrowService;

    public BorrowController(BorrowService borrowService){
        this.borrowService = borrowService;
    }

    @GetMapping
    public List<BorrowResponseDTO> getAllBorrow(){
        List<BorrowResponseDTO> getBorrowAll = borrowService.getAllBorrow();

        return getBorrowAll;
    }

    @GetMapping("/active")
    public List<BorrowResponseDTO> getAllBorrowActive(){
        List<BorrowResponseDTO> getBorrowActive = borrowService.getAllBorrowActive();

        return getBorrowActive;
    }

    @PostMapping
    public ResponseEntity<BorrowResponseDTO> createBorrow(@Valid @RequestBody BorrowRequestDTO dto){
        BorrowResponseDTO newBorrow = borrowService.createBorrow(dto);

        return ResponseEntity.ok(newBorrow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowResponseDTO> returnedBorrow(@PathVariable Integer id){
        BorrowResponseDTO borrowReturned = borrowService.returnBorrow(id);

        return ResponseEntity.ok(borrowReturned);
    }
}
