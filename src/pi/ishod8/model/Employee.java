/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beata
 */
@Data
public class Employee implements Subject{

    private String name;
    private double ticketProvision;
    private double employeeTotal;
    private List<Sale> sales;
    private List<pi.ishod8.model.Observer> observers;



    public Employee(String name, double ticketProvision) {
        this.name = name;
        this.ticketProvision = ticketProvision;
        this.sales = new ArrayList<>();
        this.observers = new ArrayList<>();

    }

    public void newSaleMade(Sale sale) {
        this.sales.add(sale);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", total=" + String.format("%.2f", employeeTotal) +
                '}';
    }


    @Override
    public void register(pi.ishod8.model.Observer obj) {
        if (!observers.contains(obj)){
            observers.add(obj);
        }
    }
    @Override
    public void unregister(pi.ishod8.model.Observer obj) {
        observers.remove(obj);
    }
    @Override
    public void notifyObservers() {
        for (pi.ishod8.model.Observer observer: observers) {
            observer.update();
        }
    }
    @Override
    public List<Sale> getUpdate(Observer obj) {
        return sales;
    }
}
