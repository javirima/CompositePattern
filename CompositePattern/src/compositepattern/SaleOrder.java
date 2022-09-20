/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;



import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder {
    private long orderId;
    private String customer;
    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();
    
    public SaleOrder(long orderId, String customer) {
        super();
        this.orderId = orderId;
        this.customer = customer;
    }
    
    public double getPrice() {
        double price = 0d;
        for (AbstractProduct child : products) {
            price += child.getPrice() * child.getCantidad();
        }           
        
        return price;
    }

    public double getPriceIva(){
        double price = 0d;
        for (AbstractProduct child : products) {
            price += child.getPriceIva() * child.getCantidad();   
        }
        return price; 
    }
    
    public void addProduct(AbstractProduct product) {
        for (AbstractProduct child : products) {
            if(child.getName().equals(product.getName())){
                child.setCantidad(child.getCantidad()+1);
            
                return;
            }
        }
        products.add(product);

        
    }   

    public void printOrder() {
        NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("\\\n============================================="  
                + "\nOrden: " + orderId + "\nCliente: " + customer
                + "\nProductos:\n"); 
        for (AbstractProduct prod : products) {
            System.out.println(prod.getCantidad()+ "\t\t" +prod.getName() + "\t\t\t$ "
                    + formater.format(prod.getPrice())+"\t\t$"+formater.format(prod.getPrice()*prod.getCantidad())+"\t\t\t "
                     + prod.getIva()*100);
            
        }
    
        System.out.println("Subtotal: " + formater.format(getPrice())
                +"\n IVA: " + formater.format(getPriceIva())
                +"\n Total: " + formater.format(getPrice()+ getPriceIva())
                + "\n=============================================");
    
    }
}