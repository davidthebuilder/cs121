
import javax.swing.JButton;
/*
 * 
 * This is the BookButton class that allows us to gain access to the book
 * and will be used to create a button with this class
 * 
 * 
 * 
 * @ author Royce Coykendall
 * Date: 2020/11/25
 */
public class BookButton extends JButton { 
	
	//field
	private final int MAX_TEXT_LENGTH = 20; // use in the reader panel
	private final String ELLIPSES = "..."; // used in the reader panel
	private Book book;
	
	
	
	//constructor
	public BookButton(Book book) {
		
		this.book = book;
		if(book.getTitle().length()<=MAX_TEXT_LENGTH)
		
			this.setText(book.getTitle());
		else
			this.setText(book.getTitle().substring(0, 17)+ ELLIPSES);
		
		
			this.setToolTipText(book.getTitle());
			
			this.setActionCommand(book.getTitle());
	}
	
	
	
	//methods

	public Book getBook()
	{
		
		return book;
	}

	/*
	 * sets the button's text to show the title of the book.
	 */
	private void setTitleText() {
		
		setText(book.getTitle());
	}
	
	
	
}
