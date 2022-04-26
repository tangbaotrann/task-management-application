package tuan4.QLSach_SaveText;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable{
	private String id;
	private String title;
	private String author;
	private int lauchYear;
	private String publishCompany;
	private int pageNumber;
	private double price;
	private String isbn;

	public Book(String id, String title, String author, int lauchYear, String publishCompany, int pageNumber,
			double price, String isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.lauchYear = lauchYear;
		this.publishCompany = publishCompany;
		this.pageNumber = pageNumber;
		this.price = price;
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getLauchYear() {
		return lauchYear;
	}

	public void setLauchYear(int lauchYear) {
		this.lauchYear = lauchYear;
	}

	public String getPublishCompany() {
		return publishCompany;
	}

	public void setPublishCompany(String publishCompany) {
		this.publishCompany = publishCompany;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(author, id);
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
		return Objects.equals(author, other.author) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", lauchYear=" + lauchYear
				+ ", publishCompany=" + publishCompany + ", pageNumber=" + pageNumber + ", price=" + price + ", isbn="
				+ isbn + "]";
	}
}
