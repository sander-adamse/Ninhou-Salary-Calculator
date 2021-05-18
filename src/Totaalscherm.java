import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Totaalscherm extends JDialog implements ActionListener {
    private JButton jbSave, jbCancel;
    private JTextField jtUur, jtMinuten, jtKilometers, jtTotaal;
    private Uitrekenen werkdag;

    public Totaalscherm(Uitrekenen werkdag) {
        this.werkdag = werkdag;

        // Creating JTextFields
        this.jtUur = new JTextField();
        this.jtMinuten = new JTextField();
        this.jtKilometers = new JTextField();
        this.jtTotaal = new JTextField();

        // Setting JTextField Text
        this.jtUur.setText(String.valueOf(werkdag.calculateHours()));
        this.jtMinuten.setText(String.valueOf(werkdag.calculateMinutes()));
        this.jtKilometers.setText(String.valueOf(werkdag.getAantalKm()));
        this.jtTotaal.setText("€ " + werkdag.calculateTotal());

        // Disabling Text Editing
        this.jtUur.setEditable(false);
        this.jtMinuten.setEditable(false);
        this.jtKilometers.setEditable(false);
        this.jtTotaal.setEditable(false);

        // Creating JButtons
        this.jbSave = new JButton("Save");
        this.jbCancel = new JButton("Cancel");

        // Adding ActionListeners
        jbSave.addActionListener(this);
        jbCancel.addActionListener(this);

        // Adding Components
        this.add(jtTotaal);
        this.add(jtUur);
        this.add(jtMinuten);
        this.add(jtKilometers);
        this.add(jbSave);
        this.add(jbCancel);

        // iFrame Settings
        this.setTitle("Ninhou Applicatie - Sander Adamse");
        this.setSize(500, 115);
        this.setModal(true);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbSave) {
            try {
                werkdag.CreateFile();
                werkdag.WriteFile(werkdag.calculateTotal());
                this.dispose();
                System.exit(0);
            } catch (Exception i) {
                System.out.println("An error has ocurred!");
            }
        }
        if (e.getSource() == jbCancel) {
            this.setVisible(false);
        }
    }
}
