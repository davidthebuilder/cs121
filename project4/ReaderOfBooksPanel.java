import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/*
 * 
 * 
 * ReaderofBooksPanel will combine the ReaderPanel and Library Panel 
 * so it can be displayed to the ReaderOfBook frame class
 * 
 * 
 * 
 * @ author Royce Coykendall
 * Date: 2020/11/25
 * 
 */
public class ReaderOfBooksPanel extends JPanel {

	//fields
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;
	
	//constructor
	public ReaderOfBooksPanel()
	{
		
		setPreferredSize(new Dimension(500,400));
		setLayout(new BorderLayout());
		// ** You can uses memory directly by insulation (i.e. new BookButtonListner())
		libraryPanel = new LibraryPanel(new BookButtonListener());
		
		this.readerPanel = new ReaderPanel();
		
		//readerPanel.setBackground(Color.WHITE);
		//will populate the west side of the panel
		add(libraryPanel, BorderLayout.WEST);
		
		// borderlayout.center will scale to size (west, and east will not)
		add(readerPanel, BorderLayout.CENTER);
	}
	private class BookButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			// (BookButton) is a casting for the event
			// the event is then grabbing the source or location of what was clicked
			BookButton bb = (BookButton)e.getSource();
			
			// bb is grabbing the object book and giving it to b that is a book.
			// therefore b carrying the object to the display via readerPanel
			Book b = bb.getBook();
			readerPanel.LoadBook(b);
			add(readerPanel, BorderLayout.CENTER);
			System.out.println("button is working");
			revalidate();
		}
		
	}	
}
