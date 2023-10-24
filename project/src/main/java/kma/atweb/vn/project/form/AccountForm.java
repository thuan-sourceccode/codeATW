package kma.atweb.vn.project.form;

public class AccountForm {
    private String userName;
    private String email;
    private String address;
    private String fullName;
    private boolean active;
    private String EncrytedPassword;

    private String confirmpassword;
    private String userRole;

    private int age;

    private String otp;

    public AccountForm() {
    }

    public AccountForm(String userName, String email, String address, String fullName, boolean active, String EncrytedPassword, String confirmpassword, String userRole, int age, String otp) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.fullName = fullName;
        this.active = active;
        this.EncrytedPassword = EncrytedPassword;
        this.confirmpassword = confirmpassword;
        this.userRole = userRole;
        this.age = age;
        this.otp = otp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEncrytedPassword() {
        return EncrytedPassword;
    }

    public void setEncrytedPassword(String EncrytedPassword) {
        this.EncrytedPassword = EncrytedPassword;
    }

    public String getConfirmpassword() {return confirmpassword;}

    public void setConfirmpassword(String confirmpassword) {this.confirmpassword = confirmpassword;}

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOtp() {return otp;}

    public void setOtp(String otp) {this.otp = otp;}
}
