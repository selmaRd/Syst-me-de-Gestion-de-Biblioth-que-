package GUI;

import libraryManagementSystem.Book;
import libraryManagementSystem.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class BookListInterface extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton btnBack;

    public BookListInterface() {
        // configuration de la fenêtre
        setTitle("Liste des livres");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(249, 251, 151));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // ----- JTable pour afficher les livres -----
        String[] columnNames = {"ID", "Titre", "Auteur"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // ajouter les livres de Main.library
        for (Book book : Main.library.getBooks()) {
            Object[] row = {book.getId(), book.getTitle(), book.getAuthor()};
            model.addRow(row);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 250);
        contentPane.add(scrollPane);

        // ----- Bouton Retour -----
        btnBack = new JButton("Retour");
        btnBack.setBounds(230, 300, 120, 30);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> {
            // ouvre MainDashboard et ferme cette fenêtre
            GUI.MainDashboard dashboard = new GUI.MainDashboard();
            dashboard.setVisible(true);
            dispose();
        });
    }

    // pour tester la fenêtre seule
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookListInterface frame = new BookListInterface();
            frame.setVisible(true);
        });
    }
}
