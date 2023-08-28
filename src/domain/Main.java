package domain;

import javax.swing.UIManager;

import mvc.controller.Controller;
import mvc.view.CustomerPanel;
import mvc.view.MainWindow;
import mvc.view.MenuPanel;

/**
 * This class represents the starting point of NartoStore.
 * 
 * Each of the components that represent the application are instantiated in it:
 * 
 * - MenuPanel: Contains the buttons to access the program modules (sales,
 * products and customer).
 * - CustomerPanel: Contains the functionalities related to customer management.
 * - MainWindow: It is the window that contains all the NartoStore panels.
 * - Controller: It fulfills the controller function in the MVC design pattern.
 */
public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        MenuPanel menuPanel = new MenuPanel();
        CustomerPanel customerPanel = new CustomerPanel();
        MainWindow mainWindow = new MainWindow(menuPanel, customerPanel);
        Controller controller = new Controller(mainWindow);

        controller.starProgram();

    }

}
