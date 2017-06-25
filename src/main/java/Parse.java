import com.home.parse.*;
import org.jsoup.nodes.Document;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static com.home.parse.ParseCinema.getPage;
import static com.home.parse.ParseCinema.printCinema;

public class Parse {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Parse window = new Parse();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Parse() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        frame.getContentPane().add(textArea, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        JButton btnNewButton = new JButton("Peoples Park Cinema");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    Document page = getPage();
                    printCinema(page);
                    textArea.setText(String.valueOf(printCinema(page)));
                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        });
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Real Scare Movie");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Document page = ParseRSM.getPage();

                    textArea.setText(String.valueOf(ParseRSM.printRSM(page)));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("11111");

            }
        });
        panel.add(btnNewButton_2);

       /* textField = new JTextField();
        frame.getContentPane().add(textField, BorderLayout.CENTER);
        textField.setColumns(10);*/
    }

}