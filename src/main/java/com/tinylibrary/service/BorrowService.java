package com.tinylibrary.service;

import com.tinylibrary.dto.BorrowRequestDTO;
import com.tinylibrary.dto.BorrowResponseDTO;
import com.tinylibrary.entity.Book;
import com.tinylibrary.entity.Borrow;
import com.tinylibrary.entity.User;
import com.tinylibrary.enums.BookStatus;
import com.tinylibrary.enums.BorrowStatus;
import com.tinylibrary.exception.*;
import com.tinylibrary.repository.BookRepository;
import com.tinylibrary.repository.BorrowRepository;
import com.tinylibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BorrowService(
            BorrowRepository borrowRepository,
            BookRepository bookRepository,
            UserRepository userRepository){

        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.userRepository =userRepository;
    }

    //Entity -> DTO

    private BorrowResponseDTO entityToDto(Borrow borrow){
        BorrowResponseDTO convertToDto = new BorrowResponseDTO();

        convertToDto.setUserName(borrow.getUser().getName());

        convertToDto.setNameBook(borrow.getBook().getName());

        convertToDto.setBorrowDate(borrow.getBorrow_date());
        convertToDto.setReturnDate(borrow.getReturnDate());

        convertToDto.setStatus(borrow.getStatus());

        return convertToDto;
    }

    public List<BorrowResponseDTO> getAllBorrow(){
        List<Borrow> borrowAll = borrowRepository.findAll();
        List<BorrowResponseDTO>  listAllBorrow = new ArrayList<>();

        for(Borrow borrow: borrowAll){
            listAllBorrow.add(entityToDto(borrow));
        }

        return listAllBorrow;
    }

    public List<BorrowResponseDTO> getAllBorrowActive(){
        return borrowRepository.findByReturnDateIsNull().stream().map(this::entityToDto).toList();
    }

    public BorrowResponseDTO createBorrow(BorrowRequestDTO dto){
        User user = userRepository.findById(dto.getUser_id())
                .orElseThrow(() -> new userNotFound("El usuario que introdujo no existe"));

        Book book = bookRepository.findById(dto.getBook_id())
                .orElseThrow(() -> new NameBookNotFound("El libro que introdujo no existe no existe"));

        if(book.getStatus() == BookStatus.BORROWED){
            throw new BookAlreadyBorrowedException("El libro que intenta asignar. Ya esta prestado");
        }

        Borrow borrow = new Borrow();

        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrow_date(LocalDateTime.now());
        borrow.setStatus(BorrowStatus.BORROWED);

        book.setStatus(BookStatus.BORROWED);

        borrowRepository.save(borrow);
        bookRepository.save(book);

        return entityToDto(borrow);

    }

    public BorrowResponseDTO returnBorrow(Integer borrowId){

        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new BorrowNotFoundException("El prestamo que busca no existe"));

        if(borrow.getReturnDate() != null){
            throw new BorrowAlreadyReturnException("Este usuario ya devolvio el libro :D");
        }

        borrow.setReturnDate(LocalDateTime.now());
        borrow.setStatus(BorrowStatus.RETURNED);

        Book book = borrow.getBook();
        book.setStatus(BookStatus.AVAILABLE);

        borrowRepository.save(borrow);
        bookRepository.save(book);

        return entityToDto(borrow);

    }
}
