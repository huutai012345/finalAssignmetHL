/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NHT
 */
class date {

    /**
     * @param args the command line arguments
     */
    
    
}

class amountComparator implements Comparator<Transaction> {

    public int compare(Transaction s1, Transaction s2) {
        if (s1.getAmount() == s2.getAmount()) {
            return 0;
        } else if (s1.getAmount() < s2.getAmount()) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class ProcessingEngine {

    private List<Transaction> list;
    private int size;

    public ProcessingEngine(StatementDB data) {
        this.list=data.getList();
        this.size=data.getSize();
    }
    
    
    public void display()
    {
        for (Transaction transaction : list) {
            transaction.display();
        }
    }

    //Cau 1
    public void countTransactionsforMonth() {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
       
        for (Transaction transaction : list) {
            
               
                a[transaction.getDate().getMonth()-1 ]++;
            
               
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Month " + (i + 1) + " : " + a[i]);
        }
        System.out.println("Total Transactions: " + size);
        
    }

    //Cau2
    public void countTransactionsforCate(int month) {
        int[] a = {0, 0, 0, 0, 0, 0, 0};
        String[] nameClass = {"Income", "Fixed", "Car", "Digital", "Food", "Fun", "Clothes"};

        for (Transaction transaction : list) {

            if (transaction.getDate().getMonth() == month) {
               //transaction.display();
                if (transaction.getClass().getSimpleName().equals(nameClass[0])) {
                    a[0]++;
                } else if (transaction.getClass().getSimpleName().equals(nameClass[1])) {
                    a[1]++;
                } else if (transaction.getClass().getSimpleName().equals(nameClass[2])) {
                    a[2]++;
                } else if (transaction.getClass().getSimpleName().equals(nameClass[3])) {
                    a[3]++;
                } else if (transaction.getClass().getSimpleName().equals(nameClass[4])) {
                    a[4]++;
                } else if (transaction.getClass().getSimpleName().equals(nameClass[5])) {
                    a[5]++;
                } else {
                    a[6]++;
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(nameClass[i] + " : " + a[i]);
        }
    }

    //Cau3
    public void countAmount() {
        float sumAmout = 0;

        for (Transaction transaction : list) {
            sumAmout += transaction.getAmount();
        }
        System.out.println("Total Amount: " + sumAmout);
    }

    //Cau4
    public void countAmountforMonth(int month) {
        float sumAmout = 0;
        for (Transaction transaction : list) {
            if (transaction.getDate().getMonth() == month) {
               //    transaction.display();
                sumAmout += transaction.getAmount();
            }
        }
        System.out.println("Total Amount in " + (month+1) + " : " + sumAmout);
    }

    //Cau5
    public void amountMax10(int month) {
        List<Transaction> temp = new LinkedList<>();
        for (Transaction transaction : list) {
            if (transaction.getDate().getMonth() == month) {
                temp.add(transaction);

            }
        }

        Collections.sort(temp, new amountComparator());

        int size = 10;
        if (temp.size() < 10) {
            size = temp.size();
        }

        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","ID","Date","Amount","Sub-Category","Category");
        for (int i = 0; i < size; i++) {
            temp.get(i).display();
        }
    }

    //Cau6
    public void amountforCateinMonth(int month, String cate) {
        cate = cate.trim();
        cate = cate.substring(0, 1).toUpperCase() + cate.substring(1);
        float sumAmount = 0;
        for (Transaction transaction : list) {
           
            if (transaction.getDate().getMonth() == month && transaction.getClass().getSimpleName().equals(cate)) {
                 //transaction.display();
                sumAmount += transaction.getAmount();
            }
        }

        System.out.println("Total Amount in " + (month) + " : " + sumAmount);
    }

    //Cau7
    public void averageAmountforCate(String cate) {
        cate = cate.trim();
        cate = cate.substring(0, 1).toUpperCase() + cate.substring(1);

        int[] amountNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float[] amountMin = {Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE};
        float[] amountMax = {Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE};
        float[] amountAvegare = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      
        for (Transaction transaction : list) {
            if ( transaction.getClass().getSimpleName().equals(cate)) {
              int index=transaction.getDate().getMonth()-1;
              if(transaction.getAmount()>amountMax[index])
              {
                  amountMax[index]=transaction.getAmount();
              }
              if(transaction.getAmount() < amountMin[index])
              {
                  amountMin[index]=transaction.getAmount();
              }
              
              amountAvegare[index] += transaction.getAmount() ;
              amountNum[index]++;
            }
        }

      

        for (int i = 0; i < 12; i++) {
            System.out.println("Month "+(i+1)+" :");
            if(amountNum[i]>0)
            {
                System.out.println("\tAverage Amount  :" + amountAvegare[i]/amountNum[i] );
                System.out.println("\tMax Amount in  :" + amountMax[i]);
                System.out.println("\tMin Amount in  :"+ amountMin[i]);
            }
            else
                System.out.println("Not found ");
            
        }

       
    }

    //Cau8
    public void countTransactionforIncome() {
        List<String> nameSubCate =new LinkedList<>();
        List<Float> amountSubCate =new LinkedList<>();
       
        int n = 0;
        for (Transaction transaction : list) {
            if ("Income".equals(transaction.getClass().getSimpleName())) {
                boolean kt = false;
                for (int i = 0; i < n; i++) {
                    if (nameSubCate.get(i).equals(transaction.getSubCate())) {
                        amountSubCate.set(i, amountSubCate.get(i)+transaction.getAmount()) ;
                        kt = true;
                        break;
                    }
                }
                if (!kt) {
                    nameSubCate.add(transaction.getSubCate());
                    amountSubCate.add(transaction.getAmount()) ;
                    n++;
                }
            }
        }
        
        if(n==0)
        {
            System.out.println("No Found For Income");
            return;
        }
        
        System.out.println("Income sub-category");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1)+". "+nameSubCate.get(i) + " : " + amountSubCate.get(i));
        }
    }


    

   
}
