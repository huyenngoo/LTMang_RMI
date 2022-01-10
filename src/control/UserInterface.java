/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.rmi.*;
import java.util.List;
import model.User;

/**
 *
 * @author admin
 */
public interface UserInterface extends Remote{
    public List<User>search(String name) throws Exception;
    public boolean updateUser(User u) throws Exception;
}
