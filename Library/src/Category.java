
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * File Name : Library.java
 * Package : edu.psu.smc6693.LibraryInventoryManager.main
 * Project : Library Inventory Manager
 * Author : Seth Corbin, Long Le, Joe Yeung
 * Section : IST 311 - Section 001
 * Assignment : Team 4 Group project
 * Description : This class contains the information of a category, which is a named collection of books.
 * Date Created : September 9, 2022
 * Date Modified : September 9, 2022
 * 
 * 
 * @author Seth Corbin
 * @author Long Le
 * @author Joe Yeung
 * @version 1.0
 */
public class Category implements Comparable<Category>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strCategoryName;
	private ArrayList<Book> arrCategoryBooks;
	
	public Category() {
		this("", new ArrayList<Book>());
	}
	
	public Category(String CategoryName) {
		this(CategoryName, new ArrayList<Book>());
	}
	
	public Category(ArrayList<Book> arrCategoryBooks) {
		this("", arrCategoryBooks);
	}
	
	public Category(String CategoryName, ArrayList<Book> arrCategoryBooks) {
		this.strCategoryName = CategoryName;
		this.arrCategoryBooks = arrCategoryBooks;
	}

	//Name Getter and Setter
	public String getName() { return strCategoryName; }
	public void setName(String strCategoryName) { this.strCategoryName = strCategoryName; }

	//Books Getter, Setter, and modifiers
	public ArrayList<Book> getCategoryBooks() { return arrCategoryBooks; }
	public void setCategoryBooks(ArrayList<Book> arrCategoryBooks) { this.arrCategoryBooks = arrCategoryBooks; }
	public void addBook(Book newBook) { arrCategoryBooks.add(newBook); }
	/**
	 * Removes the first occurrence of the specified Book.
	 * @param bookToDelete - element to be removed from the list of Books
	 * @return true, if the Category contained the Book;
	 */
	public boolean RemoveBook(Book bookToDelete) { return arrCategoryBooks.remove(bookToDelete); }

	
	@Override
	public int compareTo(Category o) {
		return this.strCategoryName.compareTo(o.getName());
	}
}
