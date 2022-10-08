import java.sql.*;

import javax.swing.JOptionPane;

public class BookDataBase {
	static final String DATABASE_URL = "jdbc:ucanaccess://" + System.getProperty("user.dir") + "\\BookLibrary.accdb";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement insertNewEmployee = null;
	PreparedStatement updateEmployee = null;

	public BookDataBase() {
		try {
			System.out.println("Starting the connection");
			connection = DriverManager.getConnection(DATABASE_URL);
			System.out.println("Made the connection");
			// create Statement for querying the database
			statement = connection.createStatement();
			System.out.println("Created Statement");
		} catch (SQLException sqlerr) {
			System.out.println("error " + sqlerr.getMessage());
			JOptionPane.showMessageDialog(null, sqlerr.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void BookDataBaseDisplay() {
		try {
		// result set
		resultSet = statement.executeQuery("Select ID, BookName, AddedDate, Genre, Type From BookLib");
		while (resultSet.next()) {
			JOptionPane.showMessageDialog(null, resultSet.getString(1) + " - " + resultSet.getString(2) + "\nDate Added: " + resultSet.getString(3) + "\nGenre: " + resultSet.getString(4)+ "\nType: " + resultSet.getString(5));}}
		  catch (SQLException sqlerr) {
			System.out.println("error " + sqlerr.getMessage());
			JOptionPane.showMessageDialog(null, sqlerr.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public int addEmployee(String bname, String adate, String genre, String type) {
		int result = 0;
		try {
			insertNewEmployee = connection.prepareStatement(
					"INSERT INTO BookLib (BookName,AddedDate, Genre, Type) " + "VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			insertNewEmployee.setString(1, bname);
			insertNewEmployee.setString(2, adate);
			insertNewEmployee.setString(3, genre);
			insertNewEmployee.setString(4, type);
			result = insertNewEmployee.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Record Insert Completed", adate, JOptionPane.INFORMATION_MESSAGE);
			} else if (result == 0) {
				JOptionPane.showMessageDialog(null, "Record Insert Failed", adate, JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException sqlex) {
			JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Insert Failed",
					JOptionPane.ERROR_MESSAGE);
			result = 0;}
		/*finally {
			try {
				statement.close();
				connection.close();
				System.out.println("Closing statement and connection to database");
			} catch (SQLException sqlex) {
				JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}*/
		return result;
	}
	

	public int UpdateEmployee(String bname, String adate, String genre, String type, int nID) {
		int result = 0;
		try {
			updateEmployee = connection.prepareStatement(
					"UPDATE BookLib SET BookName = ?, AddedDate = ?, Genre = ?, Type = ? WHERE ID= ?");
			updateEmployee.setString(1, bname);
			updateEmployee.setString(2, adate);
			updateEmployee.setString(3, genre);
			updateEmployee.setString(4, type);
			updateEmployee.setInt(5, nID);
			result = updateEmployee.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Record Updated Completed", adate, JOptionPane.INFORMATION_MESSAGE);
			} else if (result == 0) {
				JOptionPane.showMessageDialog(null, "Record Update Failed", adate, JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException sqlex) {
			JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Insert Failed",
					JOptionPane.ERROR_MESSAGE);
			result = 0;
		} finally {
			try {
				statement.close();
				connection.close();
				System.out.println("Closing statement and connection to database");
			} catch (SQLException sqlex) {
				JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
		return result;
	}

}
