/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class serverControl {
    private String rmiService="rmiService";
    private UserImpl userImpl;

    public serverControl() {
        try {
            userImpl= new UserImpl();
            // tao dang ky  --> tao registry thi phai co thu vien java.rmi.registry.LocateRegistry
            LocateRegistry.createRegistry(1099);
            Naming.rebind(rmiService, userImpl);
        } catch (RemoteException ex) {
            Logger.getLogger(serverControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(serverControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
