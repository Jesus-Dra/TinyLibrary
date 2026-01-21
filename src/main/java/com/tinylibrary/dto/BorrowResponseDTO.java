package com.tinylibrary.dto;

import com.tinylibrary.enums.BookStatus;
import com.tinylibrary.enums.BorrowStatus;

import java.time.LocalDateTime;

public class BorrowResponseDTO {
    private String userName;
    private String nameBook;

    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    private BorrowStatus status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }
}
