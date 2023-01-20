/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author beata
 */
@Data
@AllArgsConstructor
public abstract class Vehicle {
    private double gasPercentage;
    private double batteryPercentage;

    @Override
    public String toString() {
        return " " +removePackageNames(this.getClass().getName()) + " {" +
                "gas = " + String.format("%.2f", gasPercentage) + "%" +
                ", battery = " + String.format("%.2f", batteryPercentage) + "%" +
                '}';
    }

    private static String removePackageNames(String s) {

        if (s.contains(".")) {
            return s.substring(s.lastIndexOf(".") + 1, s.length());
        }
        return s;
    }
}

