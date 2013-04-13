package lab1;

/**
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Contact {

    private String firstName = null;
    private String lastName = null;
    private String address = null;
    private String city = null;
    private String state = null;
    private String zipCode = null;
    private String email = null;
    private String phoneNum = null;

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipCode;
    }

    public void setZipcode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        String str = "Name:   " + firstName + " " + lastName
                + "\nAddr:      " + address
                + "\n                " + city + ", " + state + " " + zipCode
                + "\neMail:      " + email
                + "\nPhone:    " + phoneNum;
        return str;
    }
}