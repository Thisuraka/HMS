package com.example.hms.classes;

public class User {
    private String Nic;
    private Integer code;

    public User() {

    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public User(String nic, Integer code) {
        this.Nic = nic;
        this.code = code;
    }
}
