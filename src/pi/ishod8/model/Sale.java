/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author beata
 */
@Data
@NoArgsConstructor
public class Sale {
    private LocalDateTime dateTime;
    private Employee employee;
    private Train train;
    private Vehicle vehicle;
    private boolean neededCharging;
    private boolean neededRefueling;
    private double income;

    public Sale(Employee employee, Train train, Vehicle vehicle, boolean neededCharging, boolean neededRefueling, double income) {
        this.dateTime = LocalDateTime.now();
        this.employee = employee;
        this.train = train;
        this.vehicle = vehicle;
        this.neededCharging = neededCharging;
        this.neededRefueling = neededRefueling;
        this.income = income;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Sale { " +
                dateTime.format(formatter) +
                ", employee = " + employee +
                ", train = " + train +
                ", vehicle =" + vehicle +
                ", recharged = " + neededCharging +
                ", refueled = " + neededRefueling +
                ", income= " + income +
                '}';
    }
}
