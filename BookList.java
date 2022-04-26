package tuan4.QLSach_SaveText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookList implements Serializable{
	private List<Book> list;
	
	public BookList() {
		list = new ArrayList<Book>();
	}
	
	public List<Book> getList() {
		return list;
	}
	
	public boolean add(Book book) {
		if(list.contains(book))
			return false;
		list.add(book);
		return true;
	}
	
	public boolean update(Book book) {
		int index = list.indexOf(book);
		
		if(index < 0)
			return false;
		list.set(index, book);
		return true;
	}
	
	public boolean deleteById(String id) {
		for(Book b : list) {
			if(b.getId().equals(id)) {
				list.remove(b);
				return true;
			}
				
		}
		return false;
	}
	
	public Book findById(String id) {
		for(Book b : list) {
			if(b.getId().equals(id))
				return b;
		}
		return null;
	}
}

