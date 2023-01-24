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
public class SalesManager implements Observer {

    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RESET = "\u001B[0m";

    List<Sale> sales;
    double totalIncome;
    List<Subject> employees;


    public SalesManager(List<Subject> employees) {

        this.sales = new ArrayList<>();
        this.employees = employees;
    }

    public void updateSalesList(Sale sale) {
        sales.add(sale);
        double employeeIncome = sale.getEmployee().getTicketProvision() * sale.getIncome();
        totalIncome += (sale.getIncome() - employeeIncome);
        System.out.println(
                TEXT_GREEN +
                "Total income updated: " +
                totalIncome +
                TEXT_RESET
        );

    }

    @Override
    public void update() {
        employees.forEach(employee -> {
            List<Sale> employeeSales = employee.getUpdate(this);
            for (Sale sale:employeeSales) {
                if(!sales.contains(sale)){
                    updateSalesList(sale);
                }
            }
        });
    }
    @Override
    public void setSubjects(List<Subject> sub) {
        this.employees = sub;
    }
}
