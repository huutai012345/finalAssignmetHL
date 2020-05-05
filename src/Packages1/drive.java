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
public class drive {
    public static void main(String[] args) {

        StatementDB data = new StatementDB("data.csv");
        ProcessingEngine process = new ProcessingEngine(data);
        Controller ui = new Controller(process);
        ui.run();
    }
}
