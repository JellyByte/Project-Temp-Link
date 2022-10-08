/**
 * 
 * File Name : FileManagement.java
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

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
public class FileManagement {
	private String filename;
	private Library lib;

	//Implement Serializable
	public FileManagement(String filename, Library l) {
		this.filename = filename;
		this.lib = l;
	}
	public FileManagement(Library l) {
		this.filename = "bookEntries.save";
		this.lib = l;
	}
	
	// Read in/Deserialization
	public void readFile() {
		try(
		ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(FileSystems.getDefault().getPath(filename)));
		ObjectInput in = new ObjectInputStream(bis)) 
		{		  try {
			  while(true) {
				  Object o = in.readObject();
				  this.lib = (Library)o;
			  }
		  } catch (EOFException e) {
		  }
		} catch(NoSuchFileException e) {
			System.out.println("No file found, will be created.");
		} catch(EOFException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//	Write object to save file/Serialization
	public void saveFile() {
		try(BufferedOutputStream buos = new BufferedOutputStream(new FileOutputStream(filename));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos))
		{
			  out.writeObject(this.lib);
			  out.flush();
		  bos.writeTo(buos);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	//Lib getter
	public Library getLibrary() {
		return this.lib;
	}
	
	//Lib setter
	public void setLibrary(Library l) {
		this.lib = l;
	}

}
