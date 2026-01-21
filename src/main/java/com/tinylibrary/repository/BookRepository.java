package com.tinylibrary.repository;

import com.tinylibrary.entity.Book;
import com.tinylibrary.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByName(String name);
    boolean existsByName(String name);
    List<Book> findByStatus(BookStatus status);
}
