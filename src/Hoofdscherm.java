import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hoofdscherm extends JFrame implements ActionListener {
    private JTextField jtBeginTijd, jtEindTijd, jtKilometers;
    private JButton jbCalculate, jbExit;

    public Hoofdscherm() {
        // Creating JTextFields
        this.jtBeginTijd = new JTextField(5);
        this.jtEindTijd = new JTextField(5);
        this.jtKilometers = new JTextField(5);

        // Creating JButtons
        this.jbCalculate = new JButton("Calculate");
        this.jbExit = new JButton("Exit");

        // Adding ActionListener
        this.jbCalculate.addActionListener(this);
        this.jbExit.addActionListener(this);

        // Setting Text
        this.jtBeginTijd.setText("17:00");
        this.jtEindTijd.setText("20:00");
        this.jtKilometers.setText("0");

        // Adding Components
        this.add(new JLabel("                  "));
        this.add(new JLabel("Begin Tijd:"));
        this.add(this.jtBeginTijd);
        this.add(new JLabel("Eind Tijd:"));
        this.add(this.jtEindTijd);
        this.add(new JLabel("Kilometers:"));
        this.add(this.jtKilometers);
        this.add(new JLabel("                                               "));
        this.add(this.jbCalculate);
        this.add(this.jbExit);

        // iFrame Settings
        this.setTitle("Ninhou Applicatie - Sander Adamse");
        this.setSize(500, 115);
        this.setVisible(true);
        this.setLayout(new FlowLayout(5, 5, 5));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbCalculate) {
            try {
                new Totaalscherm(new Uitrekenen(jtBeginTijd.getText().toString(), (jtEindTijd.getText().toString()), Integer.parseInt(jtKilometers.getText().toString())));
            } catch (Exception i) {
                System.out.println("An error has ocurred!");
            }
        }

        if (e.getSource() == jbExit) {
            this.dispose();
            System.exit(0);
        }
    }
}
