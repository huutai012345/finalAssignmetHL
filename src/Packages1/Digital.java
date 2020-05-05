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
public class Digital extends Transaction{
    private String  subCategory;

    public Digital(String id, DateCustom date, float amount,String subCategory) {
        super(id, date, amount);
        this.subCategory=subCategory;
    }
    
    public void display()
    {
        super.display();
        System.out.printf("%-20s%-20s\n","Digital",this.subCategory);
    }

    @Override
    String getSubCate() {
        return this.subCategory;
    }
    
    
}  
