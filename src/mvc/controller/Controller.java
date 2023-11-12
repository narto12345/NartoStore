package mvc.controller;

import mvc.view.AbstractPanel;
import mvc.view.CustomerPanel;
import mvc.view.IAccessories;
import mvc.view.MainWindow;
import mvc.view.MenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener, IAccessories {

    private MainWindow mainWindow;
    private MenuPanel menuPanel;
    private CustomerPanel customerPanel;

    public Controller(MainWindow mainWindow) {

        this.mainWindow = mainWindow;
        this.menuPanel = (MenuPanel) mainWindow.getMenuPanel();
        this.customerPanel = (CustomerPanel) mainWindow.getCustomerPanel();

    }

    public void starProgram() {

        this.initializeActions();

        this.mainWindow.setVisible(true);

    }

    public void initializeActions() {

        this.menuPanel.getSaleButton().addActionListener(this);
        this.menuPanel.getProductButton().addActionListener(this);
        this.menuPanel.getCustomerButton().addActionListener(this);
        AbstractPanel.getReturButton().addActionListener(this);

        this.menuPanel.getSaleButton().addMouseListener(this);
        this.menuPanel.getProductButton().addMouseListener(this);
        this.menuPanel.getCustomerButton().addMouseListener(this);
        AbstractPanel.getReturButton().addMouseListener(this);

    }

    public void menuPanelActionsSelecting(ActionEvent e) {

        if (e.getSource() == this.menuPanel.getSaleButton()) {
            this.menuPanel.getSaleButton().setBackground(Controller.COLOR_MOUSE_CLICKED);
        }

        if (e.getSource() == this.menuPanel.getProductButton()) {
            this.menuPanel.getProductButton().setBackground(Controller.COLOR_MOUSE_CLICKED);
        }

        if (e.getSource() == this.menuPanel.getCustomerButton()) {
            this.menuPanel.getCustomerButton().setBackground(Controller.COLOR_MOUSE_CLICKED);
            this.customerPanel.updateClients();
            this.menuPanel.setVisible(false);
            this.customerPanel.setVisible(true);
        }

        if (e.getSource() == AbstractPanel.getReturButton()) {
            AbstractPanel.getReturButton().setBackground(Controller.COLOR_MOUSE_CLICKED);
            this.customerPanel.setVisible(false);
            this.menuPanel.setVisible(true);
        }

    }

    /**
     * Action executed when selecting
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.menuPanelActionsSelecting(e);
    }

    /**
     * Action executed when pressed
     */
    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == this.menuPanel.getSaleButton()) {
            this.menuPanel.getSaleButton().setBackground(Controller.COLOR_MOUSE_PRESSED);
        }

        if (e.getSource() == this.menuPanel.getProductButton()) {
            this.menuPanel.getProductButton().setBackground(Controller.COLOR_MOUSE_PRESSED);
        }

        if (e.getSource() == this.menuPanel.getCustomerButton()) {
            this.menuPanel.getCustomerButton().setBackground(Controller.COLOR_MOUSE_PRESSED);
        }

        if (e.getSource() == AbstractPanel.getReturButton()) {
            AbstractPanel.getReturButton().setBackground(Controller.COLOR_MOUSE_CLICKED);
        }

    }

    /**
     * Action executed on login
     */
    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == this.menuPanel.getSaleButton()) {
            this.menuPanel.getSaleButton().setBackground(Controller.COLOR_MOUSE_ENTERED);
        }

        if (e.getSource() == this.menuPanel.getProductButton()) {
            this.menuPanel.getProductButton().setBackground(Controller.COLOR_MOUSE_ENTERED);
        }

        if (e.getSource() == this.menuPanel.getCustomerButton()) {
            this.menuPanel.getCustomerButton().setBackground(Controller.COLOR_MOUSE_ENTERED);
        }

        if (e.getSource() == AbstractPanel.getReturButton()) {
            AbstractPanel.getReturButton().setBackground(Controller.COLOR_MOUSE_ENTERED);
        }

    }

    /**
     * Action executed on exit
     */
    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == this.menuPanel.getSaleButton()) {
            this.menuPanel.getSaleButton().setBackground(Controller.BACKGROUND);
        }

        if (e.getSource() == this.menuPanel.getProductButton()) {
            this.menuPanel.getProductButton().setBackground(Controller.BACKGROUND);
        }

        if (e.getSource() == this.menuPanel.getCustomerButton()) {
            this.menuPanel.getCustomerButton().setBackground(Controller.BACKGROUND);
        }

        if (e.getSource() == AbstractPanel.getReturButton()) {
            AbstractPanel.getReturButton().setBackground(Controller.BACKGROUND);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
