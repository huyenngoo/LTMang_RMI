/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
/**
 *
 * @author admin
 */
public class clientControl {
    private String rmiService="rmiService";
    private UserInterface userInterface;

    public clientControl() throws NotBoundException, RemoteException, MalformedURLException {

            userInterface= (UserInterface)Naming.lookup(rmiService);

        
    }
    
    public List<User> search(String name) throws Exception{
        return userInterface.search(name);
    }
    public boolean updateUser(User u) throws Exception{
        return userInterface.updateUser(u);
    }
    
}
