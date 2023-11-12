package mvc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class serves as the basis for the creation of all the panels that make
 * up NartoStore, it contains attributes such as images, buttons and other
 * necessary properties, in addition, it defines some abstract methods that are
 * in charge of initializing the components and resizing the graphic components
 * when changing the size of the panel, and finally, it has a
 * 
 * <pre>
 * CustomerPanel()
 * </pre>
 * 
 * constructor, this constructor is in charge of automatically executing these
 * abstract methods.
 */
public abstract class AbstractPanel extends JPanel implements ComponentListener, IAccessories {

    protected final GridBagConstraints GBC = new GridBagConstraints();

    protected static final ImageIcon SALE_IMAGE = new ImageIcon("src\\mvc\\view\\sale.png");
    protected static final ImageIcon PRODUCT_IMAGE = new ImageIcon("src\\mvc\\view\\product.png");
    protected static final ImageIcon CUSTOMER_IMAGE = new ImageIcon("src\\mvc\\view\\customer.png");

    protected static final JButton RETURN_BUTTON = new JButton("Regresar");

    /**
     * This constructor is in charge of executing the abstract methods, setting the
     * attributes to the "RETURN_BUTTON" button and adding the resizing event.
     */
    public AbstractPanel() {

        this.startComponents();
        this.addComponentListener(this);
        this.setReturnButton();

    }

    public static final JButton getReturButton() {
        return AbstractPanel.RETURN_BUTTON;
    };

    private void setReturnButton() {
        RETURN_BUTTON.setFocusable(false);
        RETURN_BUTTON.setFont((new Font("Arial", Font.PLAIN, 16)));
        RETURN_BUTTON.setBackground(Color.WHITE);
        RETURN_BUTTON.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
    }

    public abstract void startComponents();

    public abstract void componentResized(ComponentEvent e);

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}
