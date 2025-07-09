package edu.cibertec.util;

public class Calculadora {

    public int sumar(int num1, int num2){
        return num1+num2;
    }

    public int restar(int num1, int num2){
        return num1-num2;
    }

    public boolean validarParImpar(int valor){
        return valor%2==0?true:false;
    }

    public String concatenarString(String cadena1, String cadena2){
        return cadena1+" - "+ cadena2;
    }

    public int valorMayor(int num1, int num2){
        return num1>num2?num1:num2;
    }

}
