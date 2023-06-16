package library;


import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import university.CanBorrowBook;
import university.Employee;
import university.Gender;
import university.Student;
import university.Teacher;
import university.TitleTeacher;

public class Librarian extends Employee implements Comparable<Object>{
	private HashMap<Book, Integer> books;
    private static double fine;	
    private static final long serialVersionUID = 1L;
    
    public Librarian() {
    	super();
    }
    public Librarian(String name, String surname) {
    	super(name, surname);
    }
    public Librarian(String name, String surname, double workExperience, int salary, LocalDate hireDate) {
    	super(name, surname, workExperience, salary, hireDate);
    }
    
    public Book getBook(String title) {
    	for (Book b : this.books.keySet()) {
    		if (b.getTitle().equalsIgnoreCase(title)) return b;
    	}
    	return null;
    }
    public boolean lendBook(CanBorrowBook borrower, Book book, Date borrowDate) {
    	LibraryRecord rec = new LibraryRecord(borrower, book, borrowDate);
        return this.lendBook(rec);
    }
    
    public boolean lendBook(LibraryRecord rec) {
        return RecordBook.getInstance().addRecord(rec);
    }
     
    public boolean getBookBack(LibraryRecord rec, Date returnDate) {
    	Date borrowDate = rec.getBorrowDate();
    	long diffInMillies = Math.abs(returnDate.getTime() - borrowDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    if (diff > 180) {
	    	
	    	if (rec.getBorrower() instanceof Student) {
	    		Student s = (Student) rec.getBorrower();
	    		s.setFee(s.getFee()+fine);
	    	}
	    	else if (rec.getBorrower() instanceof Teacher) {
	    		Teacher t = (Teacher) rec.getBorrower();
	    		t.setFee(t.getFee()+fine);
	    	}
	    }
//	    	Admin.getInstance().addFeeToStudent(rec.getBorrower(), count);
        return RecordBook.getInstance().removeRecord(rec);
    }
    
    public boolean getBookBack(CanBorrowBook borrower, Book book, Date borrowDate, Date returnDate) {
    	LibraryRecord rec = new LibraryRecord(borrower, book, borrowDate);
    	return this.getBookBack(rec, returnDate);
//	    	Admin.getInstance().addFeeToStudent(rec.getBorrower(), count);
    }

	@Override
	public int compareTo(Object o) {
		Librarian l = (Librarian) o;
		return this.getName().compareTo(l.getName());
	}
    
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		Librarian l = (Librarian) o;
		return this.books.equals(l.books);
	}
	
	public int hashCode() {
		return Objects.hash(books);
	}
	
	public HashMap<Book, Integer> getBooks() {
		return books;
	}
	public void setBooks(HashMap<Book, Integer> books) {
		this.books = books;
	}
	
	public Integer addBook(Book b, int quantity) {
		if (this.books.keySet().contains(b)) return this.books.replace(b, books.get(b)+quantity);
		return this.books.put(b, quantity);
	}
	
	@SuppressWarnings("unchecked")
	public Librarian clone() throws CloneNotSupportedException {
		Librarian clone = (Librarian)super.clone();
		clone.books = (HashMap<Book, Integer>)books.clone();
		return clone;
	}
    
}
