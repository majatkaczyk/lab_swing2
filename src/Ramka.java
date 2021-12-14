import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Ramka extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Ramka ramka = new Ramka();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }
    public Ramka() throws HeadlessException {
        this("untitled");
    }
    private JButton runButton;
    public Ramka(String title) throws HeadlessException{
        super(title);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBounds(0,200,500,500);
        setContentPane(panel);
        panel.setLayout(null);

        Kanwa kanwa = new Kanwa();
        kanwa.setBounds(60,40, 150,150);
        kanwa.setBackground(Color.gray);
        panel.add(kanwa);
        kanwa.setLayout(null);

        runButton = new JButton("Run");
        runButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                checkLocation(e.getX());
                kanwa.requestFocus(true);
            }
           @Override
            public void mouseClicked (MouseEvent e) {
                super.mouseClicked(e);
                runButton.setBounds(50,400,100,50);
                kanwa.requestFocus(true);
            }
        });
        runButton.setBounds(50,400,100,50);
        panel.add(runButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runButton.setBounds(50,400,100,50);
            }
        });
        resetButton.setBounds(350,400,100,50);
        panel.add(resetButton);

        setResizable(false);
        setVisible(true);
    }
    private void checkLocation(int x)
    {
        if(x >= 0 && x <= 50) {}
        else
            changePosition(runButton);
    }
    private void changePosition(JButton button){
        Random random = new Random();
        button.setLocation(random.nextInt(200),random.nextInt(200));
    }
}