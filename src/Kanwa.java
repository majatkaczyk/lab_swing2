import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kanwa extends JPanel implements MouseInputListener{
    private int x =0;
    private int y = 0;
    private int shapes = 0;
    public Kanwa() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar() == 'k'){
                    shapes = 1;
                    repaint();
                }
                if(e.getKeyChar() == 'o') {
                    shapes = 2;
                    repaint();
                }
            }
        });
        addMouseListener(this);
    }
    public void paint(Graphics graph) {
        super.paint(graph);
        if(shapes == 1){
            graph.fillRect(x,y,10,10);
            graph.drawRect(x,y,10,10);
        }
        if(shapes == 2)
        {
            graph.fillOval(x,y,10,10);
            graph.drawOval(x,y,10,10);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

