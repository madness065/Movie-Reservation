package group10.smcinema.Objects;

public class User {

    public static int UserID;
    public static String Fullname;
    public static String Username;
    public static String Password;
    public static String Address;
    public static String PhoneNumber;

    public User(String fullname, String username, String password, String address, String phoneNumber) {
        Fullname = fullname;
        Username = username;
        Password = password;
        Address = address;
        PhoneNumber = phoneNumber;
    }
    public User(){

    }

    public String getFullname() {
        return Fullname;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setFullname(String fullname) {
        Fullname = fullname;
    }
}
