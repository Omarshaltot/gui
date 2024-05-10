import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

        JLabel l = new JLabel();
        JFrame f = new JFrame();
        ImageIcon img = new ImageIcon("Screenshot 2024-04-23 000710.png");
        img.getImage();
        f.setVisible(true);
        f.setSize(420,420);
        l.setText("hello world");
        l.setIcon(img);
        l.setHorizontalTextPosition(JLabel.CENTER);
        f.add(l);
    }
}
