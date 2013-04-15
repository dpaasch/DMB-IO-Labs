package lab2;

import java.util.zip.DataFormatException;

/**
 * Concrete class that contains all contact information. Instantiated by the
 * TextReader concrete class.
 *
 * @author Dawn Bykowski, dpaasch@my.wctc.edu
 */
public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phoneNum;
    private String DFE_MSG = " is not valid - Field cannot contain symbols or digits";
    private String IAE_MSG = " is not valid - Please enter in the following "
            + "format WI";
    private String NPE_MSG = " is not valid - Field cannot be blank or null";
    private String NFE_MSG = " is not valid - Please enter in the following "
            + "format 12345 \n\tfor the Zipcode or 123-456-7890 for the Phone Number";

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        try {
            if (firstName == null || firstName.length() == 0) {
                throw new NullPointerException("First Name" + NPE_MSG);
            } else if (!validateFirstName(firstName)) {
                throw new DataFormatException("First Name" + DFE_MSG);
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        } catch (DataFormatException dfe) {
            System.err.println(dfe.getMessage());
        } finally {
            this.firstName = firstName;
        }
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        try {
            if (lastName == null || lastName.length() == 0) {
                throw new NullPointerException("Last Name" + NPE_MSG);
            } else if (!validateLastName(lastName)) {
                throw new DataFormatException("Last Name" + DFE_MSG);
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        } catch (DataFormatException dfe) {
            System.err.println(dfe.getMessage());
        } finally {
            this.lastName = lastName;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        try {
            if (address == null || address.length() == 0) {
                throw new NullPointerException("Address" + NPE_MSG);
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        } finally {
            this.address = address;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        try {
            if (city == null || city.length() == 0) {
                throw new NullPointerException("City" + NPE_MSG);
            } else if (!validateCity(city)) {
                throw new DataFormatException("City" + DFE_MSG);
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        } catch (DataFormatException dfe) {
            System.err.println(dfe.getMessage());
        } finally {
            this.city = city;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        try {
            if (state.length() > 2) {
                throw new IllegalArgumentException("State" + IAE_MSG);
            } else if (state == null || state.length() == 0) {
                throw new NullPointerException("State" + NPE_MSG);
            } else if (!validateState(state)) {
                throw new DataFormatException("State" + DFE_MSG);
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        } catch (DataFormatException dfe) {
            System.err.println(dfe.getMessage());
        } finally {
            this.state = state;
        }
    }

    public String getZipcode() {
        return zipCode;
    }

    public void setZipcode(String zipCode) {
        try {
            if (validateZipcode(zipCode) == false) {
                throw new NumberFormatException("Zipcode" + NFE_MSG);
            }
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        } finally {
            if (validateZipcode(zipCode) == true) {
                this.zipCode = zipCode;
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            if (email == null || email.length() == 0) {
                throw new NullPointerException("eMail" + NPE_MSG);
            }
        } catch (NullPointerException npe) {
            System.err.println(npe.getMessage());
        } finally {
            this.email = email;
        }
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        try {
            if (validatePhoneNum(phoneNum) == false) {
                throw new NumberFormatException("Phone" + NFE_MSG);
            }
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        } finally {
            if (validatePhoneNum(phoneNum) == true) {
                this.phoneNum = phoneNum;
            }
        }
    }

    public static boolean validateFirstName(String firstName) {
        // validate that firstName is populated with characters
        return firstName.matches("[A-Z] [a-zA-Z]*");
    }

    public static boolean validateLastName(String lastName) {
        // validate that lastName is populated with characters
        return lastName.matches("[A-Z] [a-zA-Z]*");
    }

    public static boolean validateCity(String city) {
        // validate that city is populated with characters
        return city.matches("[A-Z] [a-zA-Z]*");
    }

    public static boolean validateState(String state) {
        // validate that state is populated with characters
        return state.matches("[A-Z] [a-zA-Z]*");
    }

    public static boolean validateZipcode(String zipcode) {
        boolean status = true;
        if (zipcode.length() != 5) {
            status = false;
        } else if (Character.isDigit(zipcode.charAt(0))
                && (Character.isDigit(zipcode.charAt(1))
                && (Character.isDigit(zipcode.charAt(2))
                && (Character.isDigit(zipcode.charAt(3))
                && (Character.isDigit(zipcode.charAt(4))))))) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public static boolean validatePhoneNum(String phoneNum) {
        boolean status = true;
        if (phoneNum.length() != 11) {
            status = false;
        } else if (Character.isDigit(phoneNum.charAt(0))
                && (Character.isDigit(phoneNum.charAt(1))
                && (Character.isDigit(phoneNum.charAt(2))
                && (phoneNum.charAt(3) == '-')
                && (Character.isDigit(phoneNum.charAt(4))
                && (Character.isDigit(phoneNum.charAt(5))
                && (Character.isDigit(phoneNum.charAt(6)))
                && (phoneNum.charAt(7) == '-')
                && (Character.isDigit(phoneNum.charAt(8))
                && (Character.isDigit(phoneNum.charAt(9))
                && (Character.isDigit(phoneNum.charAt(10))
                && (Character.isDigit(phoneNum.charAt(11))))))))))) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    @Override
    public String toString() {
        String str = "Name:    " + firstName + " " + lastName
                + "\nAddr:    " + address + ", " + city + ", " + state + " " + zipCode
                + "\neMail:   " + email
                + "\nPhone:   " + phoneNum;
        return str;
    }
}