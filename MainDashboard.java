package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import libraryManagementSystem.Main;
import libraryManagementSystem.Book;
import libraryManagementSystem.Library;


public class MainDashboard extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldTitle;
	private JTextField textFieldAuthor;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDashboard frame = new MainDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 251, 151));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(278, 65, 170, 29);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(278, 115, 170, 29);
		contentPane.add(textFieldTitle);
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(278, 164, 170, 29);
		contentPane.add(textFieldAuthor);
	
		
		JTextArea txtrId = new JTextArea();
		txtrId.setEditable(false);
		txtrId.setBackground(new Color(249, 251, 151));
		txtrId.setFont(new Font("Vivaldi", Font.PLAIN, 18));
		txtrId.setText("book id :");
		txtrId.setBounds(227, 64, 58, 30);
		contentPane.add(txtrId);
		
		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setEditable(false);
		txtrTitle.setText("Title :");
		txtrTitle.setFont(new Font("Vivaldi", Font.PLAIN, 18));
		txtrTitle.setBackground(new Color(249, 251, 151));
		txtrTitle.setBounds(227, 116, 68, 23);
		contentPane.add(txtrTitle);
		
		JTextArea txtrAuthor = new JTextArea();
		txtrAuthor.setEditable(false);
		txtrAuthor.setText("Author :");
		txtrAuthor.setFont(new Font("Vivaldi", Font.PLAIN, 18));
		txtrAuthor.setBackground(new Color(249, 251, 151));
		txtrAuthor.setBounds(217, 163, 68, 23);
		contentPane.add(txtrAuthor);
		
		JButton btnAddBook = new JButton("Add Book");
		
		btnAddBook.setBounds(10, 25, 103, 41);
		contentPane.add(btnAddBook);
		btnAddBook.addActionListener(e -> {
		    try {
		        int id = Integer.parseInt(textFieldId.getText());
		        String title = textFieldTitle.getText();
		        String author = textFieldAuthor.getText();

		        Book book = new Book(id, title, author);

		        Main.library.addBook(book);

		        JOptionPane.showMessageDialog(null, "Livre ajouté avec succès !");

		        // vider les champs
		        textFieldId.setText("");
		        textFieldTitle.setText("");
		        textFieldAuthor.setText("");

		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "ID invalide !");
		    }
		});
		
		JButton btnBookList = new JButton("Book List");
		btnBookList.setBounds(10, 76, 103, 41);
		contentPane.add(btnBookList);
		//affichage liste 
		btnBookList.addActionListener(e -> {
		    BookListInterface bookListInterface = new BookListInterface();
		    bookListInterface.setVisible(true);

		});
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 126, 103, 41);
		contentPane.add(btnSearch);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 177, 103, 41);
		contentPane.add(btnLogout);
		//action logout 
		btnLogout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Ouvrir SystemInterface
		        SystemInterface systemInterface = new SystemInterface();
		        systemInterface.setVisible(true);

		        // fermer dashboard
		        dispose();
		    }
		});

	}
}

