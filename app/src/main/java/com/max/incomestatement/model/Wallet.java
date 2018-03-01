package com.max.incomestatement.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.max.incomestatement.R;

import java.text.DecimalFormat;



/**
 * Created by Max on 2/15/2017.
 */
@Entity(tableName = "wallet", indices = {@Index(value = {"id"}, unique = true)})
public class Wallet {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCurrentcy() {
        return currentcy;
    }

    public void setCurrentcy(String currentcy) {
        this.currentcy = currentcy;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private double balance;
    private String icon;
    private String currentcy;

     @Ignore
    public Wallet( String name, double balance,String icon,String currentcy)
    {

        this.name = name;
        this.balance=balance;
        this.icon=icon;
        this.currentcy =currentcy;
    }


    public Wallet(int id,String name, double balance,String icon,String currentcy)
    {
        this.id=id;
        this.name = name;
        this.balance=balance;
        this.icon=icon;
        this.currentcy =currentcy;
    }

    public String getName(){
        return this.name;
    }

    public String getBalace() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(this.balance)+" ฿";
    }

    public String getBalannceString(){
        return Double.toString(balance);
    }
    public void setName(String name) {
        if(name!="" && name!=null){this.name=name;}
    }
    public  void setBalance(double money){
        this.balance=money;
    }
    public String getcerrentcy() {return this.currentcy; }

    public String getIcon(){
        return icon;
    }
    public Integer getIconImage() {
        switch (this.icon){
            case "ic_account_balance_wallet_white_24dp":
                return Integer.valueOf(R.drawable.ic_account_balance_wallet_white_24dp);
            case "ic_account_balance_white_24dp":
                return Integer.valueOf(R.drawable.ic_account_balance_white_24dp);
            case "local_atm_white_48x48":
                return Integer.valueOf(R.drawable.local_atm_white_48x48);
        }
        return 0;
    }
}

