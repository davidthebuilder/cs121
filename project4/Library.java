import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * @ Royce Coykendall
 * 2020/11/07
 * This Class allows us to create a library array list filled with objects .
 * In this class we have the following methods:
 * getter for books, addBook, removeBook, getVook and toString.
 * More Information can be found below.
 */
public class Library implements LibraryInterface {

	//field(s)
	private ArrayList<Book> multiBooksList ;

	//constructor
	public  Library()
	{

		this.multiBooksList= new ArrayList<Book>();
	}

	//methods
	@Override
	// This method allows us to grab all of the books an put them in to 
	// an cloned array list
	// clone() method allows us to copy and add it a differant address
	public ArrayList<Book> getBooks() {

		ArrayList<Book> copyList = (ArrayList<Book>) multiBooksList.clone();

		return copyList;
	}

	@Override
	//I ran out time finish the proper way of building an internal arraylist
	// I look at the tester and saw that he Library Unit Tester keeped removeing it's own book from
	//Library array (which in this case was value.remove() on line 237) 
	// I don't know how to prevent this
	public void addBook(Book newBook) {

		multiBooksList.add(newBook);
		// multiBooksList= internalLib;

	}

	@Override
	// This removes books from the array (multiBookslist)
	public void removeBook(int index) {

		int a = multiBooksList.size()-1;

		if(a  >= index  )
		{
			multiBooksList.remove(index);
		}





	}

	@Override
	//this methods allow us to return Book reference
	public Book getBook(int index) {
		int a = multiBooksList.size()-1;


		if(a  < index  )
		{
			return null ;
		}
		else
		{

			return multiBooksList.get(index);
		}
	}
	// The toString method allow us to print all of the content of the 
	// array list
	public String toString() {

		String wholeLibraryString = "";
		for(Book a: multiBooksList)
		{

			wholeLibraryString += a.toString()+"\n";

		}
		return wholeLibraryString ; 


	}

	@Override
	//the loadlibraryfromcsv allows us to pass in file name (from _____________) and will be used to
	// into the main driver class ( ReaderOfBooks)
	public void loadLibraryFromCSV(String csvFilename) {
		
		File Book =new File(csvFilename);

		if(Book.exists() && Book.isFile())
		{
			try {
				Scanner fileScan = new Scanner(Book); 
				Scanner BookInfoDem;
				while (fileScan.hasNextLine())
				{
					String title,author, genre, filepath;
					
					BookInfoDem = new Scanner(fileScan.nextLine());
					BookInfoDem.useDelimiter(",");
					
					title =  BookInfoDem.next();
					author = BookInfoDem.next();
					genre = BookInfoDem.next();
					filepath = BookInfoDem.next();
				Book book = new Book (title,author);
				
				book.setGenre(genre);
				book.setFilename(filepath);
				
					multiBooksList.add(book);
				}
			}
				
					catch (FileNotFoundException e) {
						System.out.println("I wish this was a file ,but it's not");
					
				}

			
		}
		else
			System.out.println("The file does not exits");
	}
}




