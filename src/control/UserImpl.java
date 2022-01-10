/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class UserImpl extends UnicastRemoteObject implements UserInterface{
    
    private Connection conn;
    private Statement stm;
    public UserImpl() throws RemoteException {
        String dbUrl="jdbc:mysql://localhost:3306/exam";
        String dbClass="com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            conn= DriverManager.getConnection(dbUrl, "root", "050599");
            stm= conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> search(String name) throws Exception {
        List<User>list= new ArrayList<>();
        String sql="SELECT*FROM user WHERE name LIKE '%"+name+"%'";
        System.out.println(sql);
        
        try {
            ResultSet rs= stm.executeQuery(sql);
            while (rs.next()) {                
                User u= new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateUser(User u) throws Exception {
        String sql="UPDATE user SET name= '"+ u.getName()+"', birth='"+u.getBirth()+
               "', address= '"+u.getAddress()+"WHERE id="+u.getId();
        System.out.println(sql);
        try {
            if(stm.executeUpdate(sql)!=-1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<User> getAll(){
        List<User>list= new ArrayList<>();
        String sql="SELECT*FROM user";
        System.out.println(sql);
        
        try {
            ResultSet rs= stm.executeQuery(sql);
            while (rs.next()) {                
                User u= new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
