package mvc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mvc.model.CustomerDAO;

public class CustomerPanel extends AbstractPanel {

    private JPanel leftPanel;
    private JPanel letfInternalPanel;
    private JPanel rightPanel;
    private int numCustomers;
    private List<JButton> buttons;
    private JLabel customerCounter;

    public CustomerPanel() {
        leftPanel.addComponentListener(this);
    }

    @Override
    public void startComponents() {

        this.setBackground(AbstractPanel.BACKGROUND);
        this.setLayout(null);

        this.leftPanel = new JPanel(null);
        this.leftPanel.setBackground(Color.WHITE);
        this.leftPanel.setBounds(0, 0, 429, 409);
        this.add(leftPanel);

        this.letfInternalPanel = new JPanel(null);
        this.letfInternalPanel.setBackground(Color.WHITE);
        this.letfInternalPanel.setBounds(21, 20, 387, 369);
        this.letfInternalPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3, false));
        this.leftPanel.add(this.letfInternalPanel);

        this.rightPanel = new JPanel(null);
        this.rightPanel.setBackground(Color.RED);
        this.rightPanel.setBounds(429, 0, 185, 409);
        this.add(rightPanel);

        // Left panel components
        buttons = new ArrayList<>();
        CustomerDAO.selectCustomer().forEach(customer -> {
            buttons.add(new CustomerButton(customer));
        });
        buttons.add(AbstractPanel.RETURN_BUTTON);

        this.addButtons();

        Font negrita = new Font("Arial", Font.BOLD, 14);
        this.customerCounter = new JLabel("N° de Clientes: " + this.numCustomers);
        customerCounter.setFont(negrita);
        this.customerCounter.setBounds(21, 389, 250, 20);
        this.leftPanel.add(this.customerCounter);

    }

    public void updateClients() {

        buttons = null;
        letfInternalPanel.removeAll();

        buttons = new ArrayList<>();
        CustomerDAO.selectCustomer().forEach(customer -> {
            buttons.add(new CustomerButton(customer));
        });
        buttons.add(AbstractPanel.RETURN_BUTTON);

        this.addButtons();

    }

    private void addButtons() {

        // width: 150 height: 30
        int numButtons = this.buttons.size();
        this.numCustomers = numButtons;
        JButton[] buttonsArray = new JButton[numButtons];

        for (int i = 0; i < numButtons; i++) {
            buttonsArray[i] = buttons.get(i);
        }

        int x = 20, y = 20;
        int panelsize = ((int) (this.letfInternalPanel.getWidth()));

        letfInternalPanel.setVisible(false);
        letfInternalPanel.setVisible(true);

        for (JButton jButton : buttonsArray) {

            if (x <= panelsize) {
                jButton.setBounds(x, y, 150, 50);
                this.letfInternalPanel.add(jButton);
                x += 170;
            }
            if ((x + 150) > (panelsize - 20)) {
                x = 20;
                y += 70;
            }

        }

    }

    public void refreshButtons() {
        this.buttons = null;
        this.letfInternalPanel.removeAll();

        buttons = new ArrayList<>();
        CustomerDAO.selectCustomer().forEach(customer -> {
            buttons.add(new CustomerButton(customer));
        });
        buttons.add(AbstractPanel.RETURN_BUTTON);

        this.addButtons();
    }

    @Override
    public void componentResized(ComponentEvent e) {

        if (this.isVisible()) {
            int width = (int) (this.getWidth() * 0.7);
            int heigth = (int) (this.getHeight());
            this.leftPanel.setSize(width, heigth);

            this.rightPanel.setLocation(width, 0);
            width = (int) (this.getWidth() * 0.3);
            this.rightPanel.setSize(width, heigth);
            this.addButtons();

            width = this.leftPanel.getWidth();
            heigth = this.leftPanel.getHeight();
            int widthInternal = (int) (width * 0.05F);
            int heigthInternal = (int) (heigth * 0.05F);
            this.letfInternalPanel.setLocation(widthInternal, heigthInternal);
            this.letfInternalPanel.setSize(width - (widthInternal * 2), heigth - (heigthInternal * 2));
            this.customerCounter.setLocation(21 + ((int) (width * 0.05F)),
                    (heigth - (heigthInternal * 2)) + ((int) (heigth * 0.05F)));
        }

    }

}
