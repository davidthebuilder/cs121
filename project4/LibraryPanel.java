import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * 
 * ReaderPanel will display the left half section of the Frame(ReaderOfBooks).
 * This ReaderPanel will allow the user to input files as etext and will display the library of books in the Book list section.
 * 
 * 
 * 
 * 
 * 
 * 
 * @ author Royce Coykendall
 * Date 2020/11/25
 */


public class LibraryPanel extends JPanel {

	// fields
	private Library library;
	private ActionListener bookButtonListener;
	private JPanel bookListPanel;
	private JScrollPane bookListScrollPane;
	private JPanel importPanel;
	private JTextField importTextField;
	private JButton importButton;






	//Constructor
	public LibraryPanel(ActionListener listener)
	{
		this.setLayout(new BorderLayout() );
		bookListPanel = new JPanel();
		importTextField = new JTextField (20);
		JLabel jlabel = new JLabel("Library");
		add(jlabel,BorderLayout.NORTH);
		
		library = new Library();




		
		importPanel = new JPanel ();
		// You need to put the panel that is being scrolled into the installation of the constructor
		bookListScrollPane= new JScrollPane(bookListPanel);

		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));

		importPanel.setLayout(new BorderLayout());

		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JLabel bookScrollPane = new JLabel("BookList");
		bookScrollPane.setAlignmentX(CENTER_ALIGNMENT);
		//bookListPanel.add(bookScrollPane);
		
		
		add(bookListScrollPane);

		
		//declaring the importButton and is labeled as LOAD
		importButton = new JButton("LOAD");
		
		//add a lister to the loading butt so we can excutate the file
		importButton.addActionListener(new ImportActionListener());
		
		
		
		
		importPanel.add(importButton, BorderLayout.EAST);

		JLabel importBookLabel = new JLabel("Import Books");
		
		importPanel.add(importBookLabel, BorderLayout.NORTH);

		importPanel.add(importTextField,BorderLayout.WEST);

		add(importPanel, BorderLayout.SOUTH);
	
		/*
		 * Extremely important Note for adding a second action listener
		 * 
		 * At this point we need to pass on the listener via the constructor
		 * 
		 * If we look at line 30 (public LibraryPanel(ActionListener listener)) the listener(listener)
		 * is getting past through and will be called later on in the ReaderOfBooksPanel.
		 *
		 * 		bookButtonListener =listener;
		 * 
		 * 	
		 * 	This listener(listener) is need to be passed on to the bookButtonListener.
		 * 
		 */
		bookButtonListener =listener;
		
		
		
		
		
	}

	private class ImportActionListener implements ActionListener
	{

		
		@Override
		public void actionPerformed(ActionEvent e) {

			library.loadLibraryFromCSV(importTextField.getText());

			for(Book book : library.getBooks() )
			{
				BookButton buttonBook = new BookButton(book);
				
				
			
				//buttonBook.setText(book.getTitle());
				
				
				
				buttonBook.setAlignmentX(CENTER_ALIGNMENT);
				
				/*
				 * Extremely important Note for adding a second action listener
				 * 
				 * Goal: We are trying to set a listener to a second button
				 * The button above (line 103) is being created so we must add a listener to it.
				 * Down below the button(buttonBook) has a ActionListner(bookButtonListner) to it
				 * 
				 * It should be noted that since it's in a for each loop each button has a listener
				 */
				buttonBook.addActionListener(bookButtonListener);
				
				
				bookListPanel.add(buttonBook);
				
			}
			
			
			revalidate();
			

		}

	}

	}

