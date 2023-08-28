package mvc.view;

import java.awt.Color;

import javax.swing.BorderFactory;

import mvc.model.CustomerDTO;

public class CustomerButton extends AbstractButton {

    private CustomerDTO customer;

    public CustomerButton(CustomerDTO customer) {
        super(customer.getName());
        this.customer = customer;
        this.setFocusable(false);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
    }

    public CustomerDTO getCustomerDTO() {
        return this.customer;
    }

    @Override
    public void action() {
        System.out.println("Seleccionó el siguiente objeto: " + this.customer);
    }

}
