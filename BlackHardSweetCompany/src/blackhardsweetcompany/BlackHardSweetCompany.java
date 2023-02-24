/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackhardsweetcompany;

import GUI.LoaderFrame;
import DatabaseManager.DatabaseController;

/**
 *
 * @author lynch
 */
public class BlackHardSweetCompany {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new LoaderFrame().setVisible(true);
       DatabaseController databaseControl = new DatabaseController();
       
    }   
}