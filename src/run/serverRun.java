/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import control.serverControl;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 *
 * @author admin
 */
public class serverRun {
    public static void main(String[] args){
        new serverControl();
    }
}
