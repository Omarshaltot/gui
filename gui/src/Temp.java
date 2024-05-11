import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class Temp extends JFrame implements ActionListener {

    JPanel p1, p2, p3, p4;
    JTextField f;
    JLabel l, l2, l3;
    JComboBox c;
    JRadioButton r1, r2;
    JButton b;

    public Temp() {
        p1 = new JPanel();
        l = new JLabel("Temperature");
        f = new JTextField();
        f.setPreferredSize(new DimensionUIResource(90, 30));
        f.setHorizontalAlignment(JTextField.RIGHT);

        c = new JComboBox();
        c.addItem("Celsius");
        c.addItem("Fahrenheit");
        c.addActionListener(this);
        c.setPreferredSize(new DimensionUIResource(90, 30));

        p1.add(l);
        p1.add(f);
        p1.add(c);

        p2 = new JPanel();
        l2 = new JLabel("Convert to: ");

        r1 = new JRadioButton("Celsius");
        r2 = new JRadioButton("Fahrenheit");

        p2.add(l2);
        p2.add(r1);
        p2.add(r2);

        p3 = new JPanel();
        b = new JButton("convert");
        b.addActionListener(this);

        p4 = new JPanel();
        l3 = new JLabel();
       
        p1.add(p4);
        p1.add(p2);
        p3.add(b);
        p1.add(p3);
        p4.add(l3);
        p1.add(p4);
        this.add(p1);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Temp t = new Temp();
        t.setTitle("Temperature");
        t.setSize(600, 530);
        t.setLocation(650, 300);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (r2.isSelected()) {// fahrenhiet
            if (c.getSelectedItem() == "Fahrenheit") {
                l3.setText("you cant chose fahrenhiet and convert to fahrenhiet at the same time");
                return;
            }
            double Fahrenheit = (Integer.parseInt(f.getText()) * 1.8) + 32;
            l3.setText(String.valueOf(Fahrenheit));
        }
        if (r1.isSelected()) {// celsiase
            if (c.getSelectedItem() == "Celsius") {
                l3.setText("you cant chose Celsius and convert to Celsius at the same time");
                return;
            }
            double Celsius = (((Integer.parseInt(f.getText()) - 32) * 5) / 9);
            l3.setText(String.valueOf(Celsius));
        }
    }

}
