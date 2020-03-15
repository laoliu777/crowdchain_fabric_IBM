package com.crowdchain.crowdchaindemo.model;

public class PlayerItem {
    private String testID;
    private String sign;
    private String name;
    private String hashv;

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashv() {
        return hashv;
    }

    public void setHashv(String hashv) {
        this.hashv = hashv;
    }

    @Override
    public String toString() {
        return "PlayerItem{" +
                "testID='" + testID + '\'' +
                ", sign='" + sign + '\'' +
                ", name='" + name + '\'' +
                ", hashv='" + hashv + '\'' +
                '}';
    }
}
