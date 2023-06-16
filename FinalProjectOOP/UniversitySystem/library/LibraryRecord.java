package library;



import java.util.Date;

import university.CanBorrowBook;
public class LibraryRecord  {

    private CanBorrowBook borrower;
    private Date borrowDate;
    private Book book;
    private Date returnDate;
    
    public LibraryRecord () {
    	
    }
    
    public LibraryRecord(CanBorrowBook borrower, Book book, Date date) {
    	this.borrower = borrower;
    	this.book = book;
    	this.borrowDate = date;
    }
    public LibraryRecord(Book book, CanBorrowBook borrower, Date borrowDate) {
    	this(borrower, book, borrowDate);
    }
    
    public CanBorrowBook getBorrower() {
        return this.borrower;
    }
    public void setBorrower(CanBorrowBook borrower) {
        this.borrower = borrower;
    }
    public Date getBorrowDate() {
        return this.borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    public Book getBook() {
        return this.book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Date getReturnDate() {
        return this.returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    public String toString() {
    	return "Record of borrow: " + borrower + " , book: "+book.toString() + ", date: " + borrowDate.toString();
    }
    
}
