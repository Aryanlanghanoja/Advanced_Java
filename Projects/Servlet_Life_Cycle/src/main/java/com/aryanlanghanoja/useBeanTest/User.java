package com.aryanlanghanoja.useBeanTest;

import java.io.Serializable;

public class User implements Serializable {
    private String userName ;
    private String PWD;

    public void setuserName(String user_Name) {
        userName = user_Name;
    }

    public String getPWD() {
        return PWD;
    }

    public String getuserName() {
        return userName;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }
}
