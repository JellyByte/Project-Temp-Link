
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
 * Description : The class manages books into different collections, and contains a list of all the books
 * Date Created : September 9, 2022
 * Date Modified : September 9, 2022
 * 
 * 
 * @author Seth Corbin
 * @author Long Le
 * @author Joe Yeung
 * @version 1.0
 */
public class Library implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Book> arrBooks;
	private ArrayList<Category> arrCategories;
	
	public Library() {
		this(new ArrayList<Book>(), new ArrayList<Category>());
	}
	
	public Library(ArrayList<Book> arrBooks) {
		this(arrBooks, new ArrayList<Category>());
	}
	
	public Library(ArrayList<Book> arrBooks, ArrayList<Category> arrCategories) {
		this.arrBooks = arrBooks;
		this.arrCategories = arrCategories;
	}

	//Books Getter, Setter, and modifiers
	public ArrayList<Book> getBooks() { return arrBooks; }
	public void setBooks(ArrayList<Book> arrBooks) { this.arrBooks = arrBooks; }
	public void addBook(Book newBook) { arrBooks.add(newBook); }
	/**
	 * Removes the first occurrence of the specified Book.
	 * @param bookToDelete - element to be removed from the list of Books
	 * @return true, if the list contained the Book.
	 */
	public boolean removeBook(Book bookToDelete) { return arrBooks.remove(bookToDelete); }

	
	//Category Getter, Setter, and modifiers
	public ArrayList<Category> getCategories() { return arrCategories; }
	public void setCategories(ArrayList<Category> arrCategories) { this.arrCategories = arrCategories; }
	public void addCategory(Category newCategory) { arrCategories.add(newCategory); }
	/**
	 * Removes the first occurrence of the specified Category.
	 * @param categoryToDelete - element to be removed from the list of Category
	 * @return true, if the list contained the Category.
	 */
	public boolean removeCategory(Category categoryToDelete) { return arrCategories.remove(categoryToDelete); }
	
	
}
