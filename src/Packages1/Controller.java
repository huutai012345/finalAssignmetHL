/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages1;

import java.util.Scanner;

/**
 *
 * @author NHT
 */
public class Controller {
    private ProcessingEngine process;

    public Controller() {
    }
    
    public Controller(ProcessingEngine process)
    {
        this.process=process;
    }
    
    public void menu() {
        System.out.println("\t\tMenu");
        System.out.println("1.Transactions are there in each month and in total");
        System.out.println("2.Transactions are there per category in a particular month");
        System.out.println("3.The total year balance of all the statements");
        System.out.println("4.The balance (amount, proﬁt or loss) in a particular month");
        System.out.println("5.The top ten biggest expenses (single items) in a particular month");
        System.out.println("6.Money was spent per category in a particular month");
        System.out.println("7.Money was spent on average/max/min per month for a catego");
        System.out.println("8.Income was earned in a year per income sub-category");
        System.out.println("0.Exit");
        System.out.print("\tChose:");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        while (true) {
            menu();
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    process.countTransactionsforMonth();
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 2: {
                    int month;
                    System.out.print("Enter Month:");
                    do {
                        month = sc.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.print("Input invail. Enter agian:");
                        }
                    } while (month < 1 || month > 12);

                    process.countTransactionsforCate(month);
                    sc.nextLine();
                    sc.nextLine();
                    break;
                }

                case 3:
                    process.countAmount();
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 4: {
                    int month;
                    System.out.print("Enter Month:");
                    do {
                        month = sc.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.print("Input invail. Enter agian:");
                        }
                    } while (month < 1 || month > 12);
                    process.countAmountforMonth(month);
                    sc.nextLine();
                    sc.nextLine();
                    break;
                }
                case 5: {
                    int month;
                    System.out.print("Enter Month:");
                    do {
                        month = sc.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.print("Input invail. Enter agian:");
                        }
                    } while (month < 1 || month > 12);
                    process.amountMax10(month);
                    sc.nextLine();
                    sc.nextLine();
                    break;
                }
                case 6: {
                    int month;
                    String cate;
                    System.out.print("Enter Month:");
                    do {
                        month = sc.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.print("Input invail. Enter agian:");
                        }
                    } while (month < 1 || month > 12);
                    sc.nextLine();
                    System.out.print("Enter Cate:");
                    cate = sc.nextLine();
                    process.amountforCateinMonth(month, cate);
                    sc.nextLine();

                    break;
                }
                case 7: {
                   
                    String cate;
                    sc.nextLine();
                    System.out.print("Enter Cate:");
                    cate = sc.nextLine();
                    process.averageAmountforCate(cate);
                    sc.nextLine();

                    break;
                }
                case 8:
                    process.countTransactionforIncome();
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Input invail");
                    break;
            }
        }
    }
}
