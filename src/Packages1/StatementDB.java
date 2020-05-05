/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NHT
 */
public class StatementDB {
    private List list = new LinkedList();
    private int size = 0;

    public List getList() {
        return list;
    }

    public int getSize() {
        return size;
    }

    private String path;

    public StatementDB(String path) {
        this.path = path;
        this.readData();
    }

    public void readData() {
        try {
            Scanner sc = new Scanner(new File("src//Packages1//" + path).getAbsoluteFile());
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                input = input.replaceAll(" ", "");
                String[] words = input.split(",");
                if ("car".equals(words[4])) {
                    list.add(new Car(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                } else if ("clothes".equals(words[4])) {
                    list.add(new Clothes(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                } else if ("digital".equals(words[4])) {
                    list.add(new Digital(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                } else if ("fixed".equals(words[4])) {
                    list.add(new Fixed(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                } else if ("food".equals(words[4])) {
                    list.add(new Food(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                } else if ("fun".equals(words[4])) {
                    list.add(new Fun(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                } else {
                    list.add(new Income(words[0], new DateCustom(words[1]), Float.valueOf(words[2]), words[3]));
                }
                size++;

            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not exist");
        }

    }
}
