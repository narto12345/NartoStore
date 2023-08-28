package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CustomerDAO {

    private static final String SELECT_CUSTOMER = "SELECT id,name,lastName,identification,cellPhone FROM customer";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT id,name,lastName,identification,cellPhone FROM customer WHERE id=?";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer(name,lastName,identification,cellPhone) VALUES (?,?,?,?)";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET name=?,lastName=?,identification=?,cellPhone=? WHERE id=?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE id=?";

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