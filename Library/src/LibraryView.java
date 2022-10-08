/**
 * 
 * File Name : LibraryView.java
 * Package : edu.psu.smc6693.LibraryInventoryManager.main
 * Project : Library Inventory Manager
 * Author : Seth Corbin, Long Le, Joe Yeung
 * Section : IST 311 - Section 001
 * Assignment : Team 4 Group project
 * Description : The Book object
 * Date Created : September 9, 2022
 * Date Modified : September 9, 2022
 * 
 * 
 * @author Seth Corbin
 * @author Long Le
 * @author Joe Yeung
 * @version 1.0
 */

public class LibraryView {
	
	//List all the book in library l
	//TODO: UI INTEGRATION
	public void listBooks(Library l) {
		for(Book b : l.getBooks()) {
			System.out.println(b.getTitle());
		}
	}	
	
	//Display Book b
	//TODO: UI INTEGRATION
	public void displayBook(Book b) {
		System.out.println("Displaying " + b.getTitle() );
	}
	
	//Display book in category g
	//TODO: UI INTEGRATION
	public void displayCategory(Category g) {
		for(Book b : g.getCategoryBooks()) 
			System.out.println(b.getTitle());
		
	}
}
