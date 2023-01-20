/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author beata
 */
@Data
public class Employee {
  
    private String name;
    private double ticketProvision;
    private double total;
    private List<Sale> sales;
    
        public Employee(String name, double ticketProvision) {
        this.name = name;
        this.ticketProvision = ticketProvision;
        this.sales = new ArrayList<>();
    }
        
    public void newSaleMade(Sale sale){
        this.sales.add(sale);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", total=" + String.format("%.2f", total) +
                '}';
    }
}
