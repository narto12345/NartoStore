package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * The MainWindow class represents the JFrame that contains all the NartoStore
 * panels, this in order to improve the user experience, by including all the
 * functionalities in a single JFrame, where the information requested by the
 * user will dynamically show and disappear.
 */
public class MainWindow extends JFrame {

    private final String VERSION = "1.0";

    private AbstractPanel menuPanel;
    private AbstractPanel customerPanel;

    /**
     * Initializes the MainWindow properties and sets a GridBagLayout to manage the
     * visibility of each of the panels.
     */
    private MainWindow() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(640, 480));
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/mvc/view/shopIcon.png")).getImage());
        this.setTitle("NartoStore " + this.VERSION);
        this.getContentPane().setBackground(Color.decode("#FFFFFF"));
        this.getContentPane().setLayout(new GridBagLayout());

    }

    /**
     * Calls the constructor that initializes the properties, and performs a
     * dependency injection of the panels derived from the "panels" variable
     * parameter.
     * 
     * @param panels This parameter represents an array of the memory references of
     *               all the panels that make up the NartoStore
     */
    public MainWindow(AbstractPanel... panels) {

        this();
        this.menuPanel = panels[0];
        this.customerPanel = panels[1];

        this.startComponents();

    }

    /**
     * This method arranges all the panels in a single row, setting the visibility
     * of 'menuPanel' to true and the others to false.
     */
    public void startComponents() {

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH; // Global value for all components

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        this.getContentPane().add(this.menuPanel, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;

        this.getContentPane().add(this.customerPanel, gbc);
        this.customerPanel.setVisible(false);

    }

    public AbstractPanel getMenuPanel() {
        return this.menuPanel;
    }

    public AbstractPanel getCustomerPanel() {
        return this.customerPanel;
    }
}
