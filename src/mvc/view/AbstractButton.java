package mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public abstract class AbstractButton extends JButton implements MouseListener, ActionListener, IAccessories {

    public AbstractButton(String name) {
        super(name);
        this.addMouseListener(this);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isVisible() && e.getSource() == this) {
            this.setBackground(IAccessories.COLOR_MOUSE_CLICKED);
            this.action();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.isVisible() && e.getSource() == this) {
            this.setBackground(IAccessories.COLOR_MOUSE_PRESSED);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.isVisible()) {
            this.setBackground(IAccessories.COLOR_MOUSE_ENTERED);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.isVisible()) {
            this.setBackground(IAccessories.BACKGROUND);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    public abstract void action();
}
