/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages1;

/**
 *1
 * @author NHT
 */
public class DateCustom {
    private int date;
    private int month;
    private int year;
    
    public DateCustom(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }
    
    public DateCustom(String str)
    {
         String[] words = str.split("-");
         this.date=Integer.valueOf(words[2]);
         this.month=Integer.valueOf(words[1]);
         this.year=Integer.valueOf(words[0]);
    }
    
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

   

    public DateCustom() {
    }
    
    
    public String toString()
    {
        String month;
        String date;
       
        if(this.month<10)
        {
            month="0"+this.month;
        }
        else
            month=""+this.month;
        
        if(this.date<10)
        {
            date="0"+this.date;
        }
        else
             date=""+this.date;
        
        return this.year+"-"+month+"-"+date;
    }
}
