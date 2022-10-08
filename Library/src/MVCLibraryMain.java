import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * File Name : MVCLibraryManager.java
 * Package : edu.psu.smc6693.LibraryInventoryManager.main
 * Project : Library Inventory Manager
 * Author : Seth Corbin, Long Le, Joe Yeung
 * Section : IST 311 - Section 001
 * Assignment : Team 4 Group project
 * Description : The main MVC file
 * Date Created : September 9, 2022
 * Date Modified : September 9, 2022
 * 
 * 
 * @author Seth Corbin
 * @author Long Le
 * @author Joe Yeung
 * @version 1.0
 */
public class MVCLibraryMain {
	
	
	/**
	 * 
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		boolean runAgain = false;
		String options = "1. Display my books\n2.I want to a add book\n3.I want to delete a book\n4.Exit";
		int o;
		String bname = "";
		String adate = "";
		String genre;
		String type;
		int id;
		int delID;
		
		BookDataBase x = new BookDataBase();
		while(!runAgain) {
			o = Integer.parseInt(JOptionPane.showInputDialog("What do you want to do?\n" + options));
			
			if(o == 1) {
				x.BookDataBaseDisplay();
				//String bname = "Silly";
				//String adate = "Goose";
				//double genre = 10.0;
				//double type = 30.0;
				//int id = 3;
				//int result = 0;
				//result = x.addEmployee(bname, adate, genre, type);
				//result = x.UpdateEmployee(bname, adate, genre, type, id);
			}
			else if(o == 2) {
				bname = JOptionPane.showInputDialog("Enter book name");
				adate = JOptionPane.showInputDialog("Enter date added");
				genre = JOptionPane.showInputDialog("Enter the genre(s)");
				type = JOptionPane.showInputDialog("Enter the type (Scholarly journal, news publication, ...");
				x.addEmployee(bname, adate, genre,type);
			}
			else if(o == 3) {
				JOptionPane.showMessageDialog(null, "WIP");
				// WIP
				/*
				delID = Integer.parseInt(JOptionPane.showInputDialog("Pls enter ID of the book that you want to delete"));			
				String query = "DELETE FROM BookLib WHERE ID" + delID;
				x.statement.executeUpdate(query);*/
			}
			else if(o == 4) {
				runAgain = true;
			}
		}
		
		x.statement.close();
		System.out.println("Statement closed");
		x.connection.close();
		System.out.println("connection severed");
		
	}
}
