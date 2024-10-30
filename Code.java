import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {

    JTextArea t;
    JButton b;

    Main() {
        super("MorningstarNotes");
        setSize(500, 700);
        setResizable(false);
        getContentPane().setBackground(new Color(238, 115, 115));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t = new JTextArea();
        t.setFont(new Font("Arial", Font.BOLD, 17));

        JScrollPane scrollPane = new JScrollPane(t);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(480, 500));

        b = new JButton("Save");
        b.addActionListener(this);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(b);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            try {
                String sv = JOptionPane.showInputDialog("Name that txt file: ");
                if(sv !=null && !sv.trim().isEmpty())
                {
                    FileWriter f = new FileWriter(sv+".txt");
                    f.write(t.getText());
                    f.close();
                    JOptionPane.showMessageDialog(this, "YOOO file saved");
                } else{
                    JOptionPane.showMessageDialog(this,"LOL, Wrong system");
                }
            } catch (IOException ae) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + ae.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
