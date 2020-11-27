import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * @ Royce Coykendall
 * 2020/11/07
 * This Class allows us to create book objects.
 * In this class we have the following methods:
 * setter, getter, toString, isValid, and getText
 */

public class Book implements BookInterface
{

	//fields
	private String title;
	private String author;
	private String genre;
	private String filename;


	//constructor
	public Book(String title, String author)
	{
		this.title=title;
		this.author=author;
		this.genre= null;
		this.filename=null;
	}

	// methods

	@Override
	// gets the title and return a string title to the object
	public String getTitle() {
		return title;

	}


	@Override
	// use to establish a title
	public void setTitle(String title) {

		this.title=title;

	}


	@Override
	// gets the Author and return a string Author to the object
	public String getAuthor() {

		return author;
	}


	@Override
	// use to establish a the author
	public void setAuthor(String author) {
		this.author=author;

	}


	@Override
	// gets the Genre and return a string Genre to the object
	public String getGenre() {

		return genre;
	}


	@Override
	// 
	public void setGenre(String genre) {
		this.genre=genre;

	}


	@Override
	// gets the Filename and return a string Filename to the object
	public String getFilename() {

		return filename;
	}


	@Override
	// sets the file name
	public void setFilename(String filename) {

		this.filename=filename;

	}

	//String is used to print out objects content
	public String toString()
	{
		String bookAttributes= "title: "+title+", author: "+author+", genre: "+genre+", filename: "+
				filename;
		return bookAttributes;
	}


	@Override
	// to verify is the object is valid
	public boolean isValid() {


		if(title != null && author != null && genre != null && filename != null)
		{
			File objectBookFile = new File(filename);
			if(objectBookFile.exists() &&  objectBookFile.isFile())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}


	}


	@Override
	// gettext method attempt to read the etext-files print it out
	public String getText() {
		
		String contentOfBookString= "";
		
		File objectBookFile = new File(filename);
		
		try {
			Scanner scannerBookFile = new Scanner (objectBookFile);
			while(scannerBookFile.hasNextLine())
			{
				
				contentOfBookString +="                                                "
				+"                                                                     "+
				"                                                                      "
				+ "         "+scannerBookFile.nextLine()+"\n";
				
			}
				
			scannerBookFile.close();	
		}
		catch (FileNotFoundException error)
		{
			System.out.println("File: "+filename+" does not exits");
		}
		
		
		return contentOfBookString;
	}




}



