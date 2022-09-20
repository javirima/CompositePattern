/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

public abstract class AbstractProduct {
    protected String name;
    protected double price;
    protected double iva;
    protected int cantidad;       


    public AbstractProduct(String name, double price, double iva,int cantidad) {
        super();

        this.name = name;
        this.price = price;
        this.iva = iva;
        this.cantidad = cantidad;
    }

    public double getPriceIva(){

        double result = price * iva;

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}      