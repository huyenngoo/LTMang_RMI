/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.rmi.RemoteException;
import view.ClientView;

/**
 *
 * @author admin
 */
public class clientRun {
    public static void main(String[] args) throws RemoteException {
        new ClientView().setVisible(true);
    }
}
