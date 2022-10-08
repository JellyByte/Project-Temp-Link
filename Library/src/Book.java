

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * File Name : Book.java
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
public abstract class Book implements Comparable<Book>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Instance Variables
	private String strTitle;
	private ArrayList<String> strAuthors;
	private ArrayList<Genre> arrGenre;
	private String strDescription;
	
	//Default Constructor
	public Book() {
		this("", new ArrayList<String>());
	}

	//Overloaded Constructors
	public Book(String title) {
		this(title, new ArrayList<String>());
	}
	
	public Book(String title, String author) {
		this.strTitle = title;
		this.strAuthors = new ArrayList<String>();
		strAuthors.add(author);
		this.arrGenre = new ArrayList<Genre>();
		strDescription = "";
	}
	
	public Book(String title, String[] authors) {
		this.strTitle = title;
		this.strAuthors = new ArrayList<String>();
		for(String author: authors) {
			strAuthors.add(author);
		}
		this.arrGenre = new ArrayList<Genre>();
		strDescription = "";
	}
	
	public Book(String title, ArrayList<String> author) {
		this.strTitle = title;
		this.strAuthors = author;
		this.arrGenre = new ArrayList<Genre>();
		strDescription = "";
	}

	//Title Getter and Setter
	public String getTitle() { return strTitle; }
	public void setTitle(String strTitle) { this.strTitle = strTitle; }

	//Author Getter, Setter, and modifiers
	public ArrayList<String> getAuthor() { return strAuthors; }
	public abstract void setStrAuthor();//ArrayList<String> strAuthor) { this.strAuthors = strAuthor; }
	public void addAuthor(String newAuthor) { strAuthors.add(newAuthor); }
	/**
	 * Removes the first occurrence of the specified author.
	 * @param authorToDelete - element to be removed from the list of authors
	 * @return true, if the book contained the author;
	 */
	public boolean removeAuthor(String authorToDelete) { return strAuthors.remove(authorToDelete); }

	//Genre Getter, Setter, and modifiers
	public ArrayList<Genre> getGenres() { return arrGenre; }
	public void setGenres(ArrayList<Genre> arrGenre) { this.arrGenre = arrGenre; }
	public void addGenre(Genre newGenre) { arrGenre.add(newGenre); }
	/**
	 * Removes the first occurrence of the specified genre.
	 * @param genreToDelete - element to be removed from the list of genres
	 * @return true, if the book contained the genre;
	 */
	public boolean removeAuthor(Genre genreToDelete) { return arrGenre.remove(genreToDelete); }

	//Description Getter and Setter
	public String getDescription() { return strDescription; }
	public void setDescription(String strDescription) { this.strDescription = strDescription; }

	
	@Override
	public int compareTo(Book o) {
		return this.strTitle.compareTo(o.getTitle());
	}
}
