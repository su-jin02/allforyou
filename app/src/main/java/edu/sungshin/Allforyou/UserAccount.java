package edu.sungshin.Allforyou;

public class UserAccount {
    String idToken; // Firebase 고유 토큰
    String name;
    String email;
    String pw;

    public UserAccount() { }

    public String getIdToken(){return idToken;}

    public void setIdToken(String idToken){this.idToken = idToken;}

    public String getEmailId(){return email;}

    public void setEmailId (String email){this.email = email;}

    public String getPw(){return pw;}

    public void setPw(String pw){this.pw = pw;}
}
