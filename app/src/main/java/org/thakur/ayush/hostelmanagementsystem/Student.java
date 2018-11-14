package org.thakur.ayush.hostelmanagementsystem;

import java.io.Serializable;

/**
 * Created by win on 23-10-2018.
 */
@SuppressWarnings("serial")
public class Student implements Serializable
{
    String id;
    String name;
    String phone_number;
    String password;
    int balance;
    int messNumber;
    String joinDate;
    String rechargeDate;

    public Student (){}
    public Student ( String id,String name,String phone_number,String password,int balance,int messNumber,String joinDate,String rechargeDate){
        this.id=id;
        this.name=name;
        this.phone_number=phone_number;
        this.password = password;
        this.balance=balance;
        this.messNumber=messNumber;
        this.joinDate = joinDate;
        this.rechargeDate = rechargeDate;
    }

    public String getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(String rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getMessNumber() {
        return messNumber;
    }

    public void setMessNumber(int messNumber) {
        this.messNumber = messNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
