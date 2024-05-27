package com.example.shopforeveryone;

public class UserData {
    static String name="";
    static String email="";
    static String Password="";
    static String phoneNumber;
    static String Address;
    static String profileImage;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserData.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserData.email = email;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        UserData.phoneNumber = phoneNumber;
    }

    public static String getAddress() {
        return Address;
    }

    public static void setAddress(String address) {
        Address = address;
    }

    public static String getProfileImage() {
        return profileImage;
    }

    public static void setProfileImage(String profileImage) {
        UserData.profileImage = profileImage;
    }
}
