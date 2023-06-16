package library;

import java.util.Set;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private LocalDate published;
    private String description;

    public Book() {
    	
    }
    
    public Book(String title) {
    	this.title = title;
    }
    
    public Book(String title, String author) {
    	this(title);
    	this.author = author;
    }
    
    public Book(String title, String author, String description) {
    	this(title, author);
    	this.setDescription(description);
    }
   // private Set<Librarian> librarian;
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
	public LocalDate getPublished() {
		return published;
	}
	public void setPublished(LocalDate published) {
		this.published = published;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(author.toLowerCase(), published, title.toLowerCase());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return author.equalsIgnoreCase(other.author) && Objects.equals(published, other.published)
				&& title.equalsIgnoreCase(other.title);
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", published=" + published + "]";
	}
}
