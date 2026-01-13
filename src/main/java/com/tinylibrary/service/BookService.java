package com.tinylibrary.service;


import com.tinylibrary.dto.BookRequestDTO;
import com.tinylibrary.dto.BookResponseDTO;
import com.tinylibrary.entity.Book;
import com.tinylibrary.exception.NameAlreadyExistException;
import com.tinylibrary.exception.NameBookNotFound;
import com.tinylibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //Entity -> DTO & DTO -> Entity

    private Book dtoToEntity(BookRequestDTO dto){
        Book convert = new Book();

        convert.setName(dto.getName());
        convert.setEditorial(dto.getEditorial());
        convert.setAgebook(dto.getAgebook());
        convert.setStatus(dto.getStatus());

        return convert;
    }

    private BookResponseDTO entityToDto(Book convert){
        BookResponseDTO convertToDto = new BookResponseDTO();

        convertToDto.setAgebook(convert.getAgebook());
        convertToDto.setName(convert.getName());
        convertToDto.setEditorial(convert.getEditorial());
        convertToDto.setStatus(convert.getStatus());

        return convertToDto;
    }

    public List<BookResponseDTO> getAllBook(){

        List<Book> allBook = bookRepository.findAll();
        List<BookResponseDTO> listAllBook = new ArrayList<>();

        for(Book book: allBook){
            listAllBook.add(entityToDto(book));
        }

        return listAllBook;
    }

    public BookResponseDTO createBook(BookRequestDTO dto){
        bookRepository.findByName(dto.getName()).ifPresent(userExisting -> {
            throw new NameAlreadyExistException("El nombre del libro que intenta crear ya esta registrado "+dto.getName());
        });

        Book bookEntity = dtoToEntity(dto);

        bookRepository.save(bookEntity);

        return entityToDto(bookEntity);
    }

    public BookResponseDTO updateBook(Integer id, BookRequestDTO dto){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NameBookNotFound("El libro que busca no fue encontrado"));

        if(!book.getName().equals(dto.getName())){
            if(bookRepository.existsByName(dto.getName())){
                throw new NameAlreadyExistException
                        ("El nombre del libro que intenta actualizar ya existe: "+dto.getName());
            }
        }

        book.setName(dto.getName());
        book.setEditorial(dto.getEditorial());
        book.setAgebook(dto.getAgebook());
        book.setStatus(dto.getStatus());

        return entityToDto(bookRepository.save(book));

    }

    public BookResponseDTO patchBook(Integer id, BookRequestDTO dto){
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->new NameBookNotFound("El libro que busca no fue encontrado"));

        System.out.println("Aqui esta el name: "+book.getName());

        validateChangeName(book, dto);
        applyPatch(book, dto);

        return entityToDto(bookRepository.save(book));
    }

    public String deleteBook(Integer id){
        Book bookDelete = bookRepository.findById(id).orElseThrow(
                () -> new NameBookNotFound("El libro que busca no fue encontrado"));

        String nameBook = bookDelete.getName();
        Integer idDelete = bookDelete.getId();

        bookRepository.deleteById(idDelete);

        return nameBook;
    }

    //Metodo privado

    private void validateChangeName(Book book, BookRequestDTO dto){
        if(!book.getName().equals(dto.getName())){
            if(bookRepository.existsByName(dto.getName())){
                throw new NameAlreadyExistException
                        ("El nombre del libro que intenta actualizar ya existe: "+dto.getName());
            }
        }
    }

    private void applyPatch(Book book, BookRequestDTO dto){
        if(dto.getName() != null){
            book.setName(dto.getName());
        }

        if(dto.getAgebook() != null){
            book.setAgebook(dto.getAgebook());
        }

        if(dto.getStatus() != null){
            book.setStatus(dto.getStatus());
        }

        if(dto.getEditorial() != null){
            book.setEditorial(dto.getEditorial());
        }
    }

}
