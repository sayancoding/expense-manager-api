package com.practice.expensemanager.payload;

public class CommonUtil {
    static public int _uid = 0;
    static public String _username = null;
    static public String _name = null;
    static public boolean _isLogged = false;

    static public void set(int uid,String username,String name, boolean isLogged){
        _uid = uid;
        _username = username;
        _name = name;
        _isLogged = isLogged;
    }

    static public void reset(){
        _uid = 0;
        _username = null;
        _name = null;
        _isLogged = false;
    }
}
