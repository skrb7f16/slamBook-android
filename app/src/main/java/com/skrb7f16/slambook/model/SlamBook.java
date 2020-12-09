package com.skrb7f16.slambook.model;

public class SlamBook {
    private int id;
    private String nickName;
    private String name;
    private String bday;
    private String hobby;
    private String phoneNo;
    private String email;
    private String aim;
    private String firstThought;
    private String age;
    private String crush;

    public SlamBook(int id, String nickName, String name, String bday, String hobby, String phoneNo, String email, String aim, String firstThought, String age, String crush) {
        this.id = id;
        this.nickName = nickName;
        this.name = name;
        this.bday = bday;
        this.hobby = hobby;
        this.phoneNo = phoneNo;
        this.email = email;
        this.aim = aim;
        this.firstThought = firstThought;
        this.age = age;
        this.crush = crush;
    }

    public SlamBook(String nickName, String name, String bday, String hobby, String phoneNo, String email, String aim, String firstThought, String age, String crush) {
        this.nickName = nickName;
        this.name = name;
        this.bday = bday;
        this.hobby = hobby;
        this.phoneNo = phoneNo;
        this.email = email;
        this.aim = aim;
        this.firstThought = firstThought;
        this.age = age;
        this.crush = crush;
    }

    public SlamBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getFirstThought() {
        return firstThought;
    }

    public void setFirstThought(String firstThought) {
        this.firstThought = firstThought;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCrush() {
        return crush;
    }

    public void setCrush(String crush) {
        this.crush = crush;
    }


}
