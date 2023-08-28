package mvc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends AbstractPanel {

        private JButton saleButton;
        private JButton productButton;
        private JButton customerButton;

        private int panelSize = 1;

        public MenuPanel() {

        }

        @Override
        public void startComponents() {

                this.setLayout(new GridBagLayout());

                this.GBC.fill = GridBagConstraints.BOTH; // Global value for all components

                // RESPONSIVE PANELS

                this.GBC.insets = new Insets(0, 0, 0, 0); // Global values for the Top, Left, Bottom, and Right panels

                // Global values for the Up and Below panels
                this.GBC.weightx = 0.1;
                this.GBC.weighty = 0.3;
                this.GBC.gridwidth = 3;
                this.GBC.gridheight = 1;

                this.GBC.gridx = 0;
                this.GBC.gridy = 0;

                JPanel panelUp;
                panelUp = new JPanel();
                panelUp.setBackground(AbstractPanel.BACKGROUND); // Up
                this.add(panelUp, this.GBC);

                this.GBC.gridx = 0;
                this.GBC.gridy = 2;

                JPanel panelBelow = new JPanel();
                panelBelow.setBackground(AbstractPanel.BACKGROUND); // Below
                this.add(panelBelow, this.GBC);

                // Global values for the Left and Right panels
                this.GBC.weightx = 0.15;
                this.GBC.weighty = 0.3;
                this.GBC.gridwidth = 1;
                this.GBC.gridheight = 1;

                this.GBC.gridx = 0;
                this.GBC.gridy = 1;

                JPanel panelLeft = new JPanel();
                panelLeft.setBackground(AbstractPanel.BACKGROUND); // Left
                this.add(panelLeft, this.GBC);

                this.GBC.gridx = 2;
                this.GBC.gridy = 1;

                JPanel panelRight = new JPanel();
                panelRight.setBackground(AbstractPanel.BACKGROUND); // Right
                this.add(panelRight, this.GBC);

                this.GBC.gridx = 1;
                this.GBC.gridy = 1;
                this.GBC.gridwidth = 1;
                this.GBC.gridheight = 1;
                this.GBC.weightx = 0.7;
                this.GBC.weighty = 0.4;

                JPanel panelCenter = new JPanel(new GridBagLayout());
                panelCenter.setBackground(AbstractPanel.BACKGROUND); // Center
                this.add(panelCenter, this.GBC);

                // RESPONSIVE BUTTONS

                // Global values for buttons
                this.GBC.gridwidth = 1;
                this.GBC.gridheight = 1;
                this.GBC.weightx = 0.1;
                this.GBC.weighty = 0.1;
                this.GBC.fill = GridBagConstraints.BOTH;
                this.GBC.insets = new Insets(10, 10, 10, 10);

                this.GBC.gridx = 0;
                this.GBC.gridy = 0;

                this.saleButton = new JButton(new ImageIcon(MenuPanel.SALE_IMAGE.getImage()
                                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                this.saleButton.setFocusable(false);
                this.saleButton.setBackground(AbstractPanel.BACKGROUND);
                this.saleButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
                panelCenter.add(saleButton, this.GBC);

                this.GBC.gridx = 1;
                this.GBC.gridy = 0;

                this.productButton = new JButton(new ImageIcon(MenuPanel.PRODUCT_IMAGE.getImage()
                                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                this.productButton.setFocusable(false);
                this.productButton.setBackground(AbstractPanel.BACKGROUND);
                this.productButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
                panelCenter.add(productButton, this.GBC);

                this.GBC.gridx = 2;
                this.GBC.gridy = 0;

                this.customerButton = new JButton(new ImageIcon(MenuPanel.CUSTOMER_IMAGE.getImage()
                                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                this.customerButton.setFocusable(false);
                this.customerButton.setBackground(AbstractPanel.BACKGROUND);
                this.customerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
                panelCenter.add(customerButton, this.GBC);

        }

        public JButton getSaleButton() {
                return this.saleButton;
        }

        public JButton getProductButton() {
                return this.productButton;
        }

        public JButton getCustomerButton() {
                return this.customerButton;
        }

        @Override
        public void componentResized(ComponentEvent e) {

                if (this.isVisible()) {

                        // Size 1
                        if (this.getWidth() < 829 && this.getHeight() < 561
                                        && (this.panelSize == 2 || this.panelSize == 3)) {

                                this.panelSize = 1;
                                saleButton.setIcon(new ImageIcon(MenuPanel.SALE_IMAGE.getImage()
                                                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

                                productButton.setIcon(new ImageIcon(MenuPanel.PRODUCT_IMAGE.getImage()
                                                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

                                customerButton.setIcon(new ImageIcon(MenuPanel.CUSTOMER_IMAGE.getImage()
                                                .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                        }

                        // Size 2
                        if (this.getWidth() > 829 && this.getHeight() > 561 && this.getWidth() < 1280
                                        && this.getHeight() < 800
                                        && (this.panelSize == 1 || this.panelSize == 3)) {

                                this.panelSize = 2;
                                saleButton.setIcon(new ImageIcon(MenuPanel.SALE_IMAGE.getImage()
                                                .getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

                                productButton.setIcon(new ImageIcon(MenuPanel.PRODUCT_IMAGE.getImage()
                                                .getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

                                customerButton.setIcon(new ImageIcon(MenuPanel.CUSTOMER_IMAGE.getImage()
                                                .getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
                        }

                        // Size 3
                        if (this.getWidth() > 1280 && this.getHeight() > 800
                                        && (this.panelSize == 1 || this.panelSize == 2)) {

                                this.panelSize = 3;
                                saleButton.setIcon(new ImageIcon(MenuPanel.SALE_IMAGE.getImage()
                                                .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

                                productButton.setIcon(new ImageIcon(MenuPanel.PRODUCT_IMAGE.getImage()
                                                .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

                                customerButton.setIcon(new ImageIcon(MenuPanel.CUSTOMER_IMAGE.getImage()
                                                .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
                        }

                }

        }

}
