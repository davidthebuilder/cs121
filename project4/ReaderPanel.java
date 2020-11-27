import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * 
 * 
 * 
 * ReaderPanel shows the Author and title above the text.
 * 
 * @ author Royce Coykendall
 * Date: 2020/11/25
 * 
 */
public class ReaderPanel extends JPanel {

	//field
	private JPanel infoPanel ;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JTextArea bookTextArea;
	private JScrollPane bookTextScrollPane;



	//Constructor 
	public ReaderPanel()
	{
		
		setLayout(new BorderLayout());
		JLabel label = new JLabel("Reader");
		
		add(label, BorderLayout.NORTH);
		infoPanel = new JPanel();
		titleLabel = new JLabel("title");
		authorLabel = new JLabel("author");
		bookTextScrollPane = new JScrollPane();
		bookTextArea = new JTextArea();
		
		bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


		infoPanel.add(titleLabel, BorderLayout.WEST);
		infoPanel.add(authorLabel, BorderLayout.EAST);
		add(infoPanel, BorderLayout.CENTER);
		//add(bookTextArea, BorderLayout.SOUTH);

	}


	//Method
	public void LoadBook (Book b) 
	{
		//TODO og titleLabel.setName(b.getTitle());
		// what does setName do and why will it not work on JLable
		JLabel label = new JLabel("Reader");
		
		infoPanel = new JPanel();
		JPanel centerScrollPanel = new JPanel();
		titleLabel = new JLabel("Title: "+b.getTitle()+"           ");
		authorLabel = new JLabel("Author: "+b.getAuthor()+"           ");
		bookTextArea = new JTextArea(b.getText());
		bookTextArea.setAlignmentX(CENTER_ALIGNMENT);
		
		
		bookTextScrollPane = new JScrollPane(bookTextArea);
		
		centerScrollPanel.setAlignmentX(CENTER_ALIGNMENT);
		bookTextScrollPane.add(centerScrollPanel);
		
		bookTextScrollPane.setAlignmentX(CENTER_ALIGNMENT);
		
		bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		
		infoPanel.add(label, BorderLayout.NORTH);
		infoPanel.add(titleLabel, BorderLayout.WEST);
		infoPanel.add(authorLabel, BorderLayout.EAST);
		
		
		add(infoPanel, BorderLayout.NORTH);
		add(bookTextScrollPane, BorderLayout.CENTER);
	
		revalidate();
	}

}
