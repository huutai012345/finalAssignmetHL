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
public class Fixed extends Transaction{
    private String  subCategory;
    
    public Fixed(String id, DateCustom date, float amount,String subCategory) {
        super(id, date, amount);
        this.subCategory=subCategory;
    }
    
    public void display()
    {
        super.display();
        System.out.printf("%-20s%-20s\n","Fixed",this.subCategory);
    }
     String getSubCate() {
        return this.subCategory;
    }
}
