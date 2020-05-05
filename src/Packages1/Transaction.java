/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages1;

/**
 *
 * @author NHT
 */
abstract class Transaction {
    protected String id;
    protected DateCustom date;
    protected float amount;

    public Transaction() {
    }

    
    public Transaction(String id, DateCustom date, float amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateCustom getDate() {
        return date;
    }

    public void setDate(DateCustom date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public void display()
    {
       
        
       
        System.out.printf("%-20s%-20s%-20.2f",this.id, date.toString() ,this.amount);
    }
    
    
    abstract String getSubCate();
}
