import javax.swing.JFrame;
/*
 * 
 * This is the main driver class that grabs the combined panels(LibraryPanel and ReaderPanel)
 *  and displays it on to the frame.
 * 
 * 
 * @ author Royce Coykendall
 * Date 2020/11/25
 */

//ReaderOfBooks is the main frame of the GUi
public class ReaderOfBooks extends JFrame {

	public static void main(String [] args)
	{
		//
		JFrame frame = new JFrame("Reader of Books");


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		frame.getContentPane().add(panel);

		//pack is moving all the continent in to the window 
		frame.pack();
		
		// this just makes the frame visible to the user
		frame.setVisible(true);

	}

}
