package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * This class contains the methods that allow direct operations with the
 * database.
 * It depends on the ConnectionSQLite and CustomerDTO classes for its correct
 * operation.
 */
public class CustomerDAO {

    private static final String SELECT_CUSTOMER = "SELECT id,name,lastName,identification,cellPhone FROM customer";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT id,name,lastName,identification,cellPhone FROM customer WHERE id=?";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer(name,lastName,identification,cellPhone) VALUES (?,?,?,?)";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET name=?,lastName=?,identification=?,cellPhone=? WHERE id=?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE id=?";

    /**
     * Return all existing clients.
     * 
     * @return Returns a dynamic array with all existing clients in the database.
     */
    public static List<CustomerDTO> selectCustomer() {

        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = ConnectionSQLite.getConnection();
            ps = conn.prepareStatement(SELECT_CUSTOMER);
            rs = ps.executeQuery();

            while (rs.next()) {

                customers.add(new CustomerDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("identification"),
                        rs.getString("cellPhone")));

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionSQLite.close(rs);
            ConnectionSQLite.close(ps);
            ConnectionSQLite.close(conn);
        }

        return customers;

    }

    /**
     * Returns a customer with all attributes complete, starting from the ID
     * referenced by a CustomerDTO object passed as an argument.
     * 
     * @param customer This object must have the "id" attribute set, so that the
     *                 implementation of this method can perform a search based on
     *                 that value.
     * @return Returns a customer from the search performed.
     */
    public static CustomerDTO selectCutomerById(CustomerDTO customer) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = ConnectionSQLite.getConnection();
            ps = conn.prepareStatement(SELECT_CUSTOMER_BY_ID);
            ps.setInt(1, customer.getId());
            rs = ps.executeQuery();

            while (rs.next()) {
                customer.setName(rs.getString("name"));
                customer.setLastName("lastName");
                customer.setIdentification("identification");
                customer.setCellPhone("cellPhone");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionSQLite.close(rs);
            ConnectionSQLite.close(ps);
            ConnectionSQLite.close(conn);
        }

        return customer;

    }

    /**
     * Creates a customer from a CustomerDTO type object provided by the user
     * 
     * @param customer CustomerDTO object that represents the customer that will be
     *                 inserted or created in the database.
     * @return Returns True if the client was created successfully, otherwise it
     *         returns False if the client was not created successfully.
     */
    public static boolean insertCustomer(CustomerDTO customer) {

        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ConnectionSQLite.getConnection();
            ps = conn.prepareStatement(INSERT_CUSTOMER);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getIdentification());
            ps.setString(4, customer.getCellPhone());

            if (ps.executeUpdate() == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionSQLite.close(ps);
            ConnectionSQLite.close(conn);
        }

        return result;

    }

    /**
     * Updates the information of a customer in the database, based on an existing
     * instance.
     * 
     * @param customer CustomerDTO object that represents the customer to update. It
     *                 is important that the "id" attribute corresponds to the
     *                 client for whom you wish to update information.
     * @return Returns True if the client could be updated successfully. On the
     *         other hand, if it returns False it means that the client could not be
     *         updated successfully.
     */
    public static boolean updateCustomer(CustomerDTO customer) {

        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ConnectionSQLite.getConnection();
            ps = conn.prepareStatement(UPDATE_CUSTOMER);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getIdentification());
            ps.setString(4, customer.getCellPhone());
            ps.setInt(5, customer.getId());

            if (ps.executeUpdate() == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionSQLite.close(ps);
            ConnectionSQLite.close(conn);
        }

        return result;

    }

    /**
     * Delete a customer from the database.
     * 
     * @param customer CustomerDTO object that represents the customer to delete.
     *                 The object must have the "id" attribute defined to achieve
     *                 correct deletion.
     * @return Returns True if the client was successfully deleted and returns False
     *         if the client could not be successfully deleted.
     */
    public static boolean deleteCustomer(CustomerDTO customer) {

        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ConnectionSQLite.getConnection();
            ps = conn.prepareStatement(DELETE_CUSTOMER);

            ps.setInt(1, customer.getId());

            if (ps.executeUpdate() == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionSQLite.close(ps);
            ConnectionSQLite.close(conn);
        }

        return result;

    }

}