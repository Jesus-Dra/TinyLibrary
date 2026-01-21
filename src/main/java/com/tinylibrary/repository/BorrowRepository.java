package com.tinylibrary.repository;

import com.tinylibrary.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    List<Borrow> findByReturnDateIsNull();
}
