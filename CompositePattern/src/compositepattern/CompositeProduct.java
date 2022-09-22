/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends AbstractProduct {
    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();
    
    public CompositeProduct(String name, double iva) {
        super(name, 0, iva,1);   
    }
    
    @Override
    public double getPrice() {
        double price = 0d;
        for (AbstractProduct child : products) {
            price += child.getPrice();   
        }
        return price; 
    }

    public double getPriceIva(){
        double price = 0d;
        for (AbstractProduct child : products) {
            price += child.getPrice() * iva;   
        }
        return price; 
    }
    
    @Override
    public void setPrice(double price) {
        throw new UnsupportedOperationException();   
    }       
    
    public void addProduct(AbstractProduct product) {
        this.products.add(product);   
    }
    
    public boolean removeProduct(AbstractProduct product) {
        return this.products.remove(product);
    }
}

