package mvc.model;

public class CustomerDTO {

    private int id;
    private String name;
    private String lastName;
    private String identification;
    private String cellPhone;

    public CustomerDTO(int id) {
        this.id = id;
    }

    public CustomerDTO(String name, String lastName, String identification, String cellPhone) {
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        this.cellPhone = cellPhone;
    }

    public CustomerDTO(int id, String name, String lastName, String identification, String cellPhone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identification = identification;
        this.cellPhone = cellPhone;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return this.identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getCellPhone() {
        return this.cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "CustomerDTO [id=" + id + ", name=" + name + ", lastName=" + lastName + ", identification="
                + identification + ", cellPhone=" + cellPhone + "]";
    }

}