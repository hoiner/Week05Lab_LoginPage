/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 758688
 */

public class AccountService {
private User user;
        
       public User login(String username, String password) {
            if ((username.equals("abe") || username.equals("barb")) && password.equals("password"))
            {
                user = new User(username,password);
            }
            if (user != null)
            {
                return user;
            }
            else
            {
             return null;
            }
        }
}

