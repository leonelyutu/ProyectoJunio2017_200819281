package edd.com.cliente_02;

/**
 * Created by lio on 7/15/17.
 */

public class Conexion {
    public Conexion() {
    }

    public boolean validar_login(String name, String password){

        String name_admin = "admin";
        String password_admin = "admin";

        if(name_admin.equals(name) &&  password_admin.equals(password))
            return true;
        else
            return false;
    }
}
