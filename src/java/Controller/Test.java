/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

public class Test {
    public static boolean validatePasswordLength(String password){
        boolean valid = false;
        if((password.length()>5 && password.length()<65))valid = true;
        return valid;
    }
}
