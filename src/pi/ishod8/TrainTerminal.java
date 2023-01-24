/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8;

import lombok.Data;
import pi.ishod8.model.*;
import pi.ishod8.model.Observer;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author beata
 */
@Data
public class TrainTerminal {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        List<Vehicle> vehiclesInLine = new ArrayList<>();
        List<Train> trainsWaitingToBeFull = new ArrayList<>();

        List<Subject> employees = Arrays.asList(
                new Employee("Marko", 0.1),
                new Employee("Kiki", 0.11)
        );
        Observer salesManager = new SalesManager(employees);
        employees.forEach(employee -> employee.register(salesManager));
        salesManager.setSubjects(employees);

        while (true) {

            vehiclesInLine.add(getRandomVehicle());
            trainsWaitingToBeFull.add(getRandomTrain());

            // if sale possible
            if (!vehiclesInLine.isEmpty() && !trainsWaitingToBeFull.isEmpty() && !employees.isEmpty()) {

                Employee employee = getRandomEmployee(employees);
                Vehicle vehicle = vehiclesInLine.iterator().next();

                Sale sale = handleVehicle(employee, vehicle, trainsWaitingToBeFull);


                if (sale != null) {

                    vehiclesInLine.remove(vehicle);
                    System.out.println("+ New : " + sale);

                    List<Sale> employeeSales = employee.getSales();
                    employeeSales.add(sale);
                    employee.setSales(employeeSales);
                    employee.notifyObservers();

                }
            }
            TimeUnit.SECONDS.sleep(2);
        }
    }

    private static Vehicle getRandomVehicle() {

        Vehicle vehicle = null;
        Random random = new Random();
        //  random.nextInt((max - min) + 1) + min;
        int randomInt = random.nextInt(4) + 1;
        switch (randomInt) {
            case 1: {
                vehicle = new Car(Math.random(), Math.random());
                break;
            }
            case 2: {
                vehicle = new Van(Math.random(), Math.random());
                break;
            }
            case 3: {
                vehicle = new Bus(Math.random(), Math.random());
                break;
            }
            case 4: {
                vehicle = new Truck(Math.random(), Math.random());
                break;
            }
            default: {
                break;
            }
        }
        return vehicle;
    }
    private static Train getRandomTrain() {

        Train randomTrain = null;
        Random random = new Random();
        //  random.nextInt((max - min) + 1) + min;
        int randomInt = random.nextInt(2) + 1;
        switch (randomInt) {
            case 1: {
                randomTrain = new SmallTrain();
                break;
            }
            case 2: {
                randomTrain = new BigTrain();
                break;
            }
            default: {
                break;
            }
        }
        return randomTrain;

    }
    private static Employee getRandomEmployee(List<Subject> employees) {
        //  random.nextInt((max - min) + 1) + min;
        return (Employee) employees.get((new Random()).nextInt((employees.size() - 1) + 1));
    }

    private static boolean vehicleNeedsRecharging(Vehicle vehicle) {
        return vehicle.getBatteryPercentage() < 0.1;
    }
    private static boolean vehicleNeedsRefueling(Vehicle vehicle) {
        return vehicle.getGasPercentage() < 0.1;
    }

    private static Sale handleVehicle(Employee employee, Vehicle vehicle, List<Train> trainsWaitingToBeFull) {

        final Sale sale = new Sale();

        sale.setVehicle(vehicle);
        sale.setNeededCharging(vehicleNeedsRecharging(vehicle));
        sale.setNeededRefueling(vehicleNeedsRefueling(vehicle));
        sale.setEmployee(employee);

        if (trainsWaitingToBeFull.isEmpty()) {
            trainsWaitingToBeFull.add(getRandomTrain());
        }
        trainsWaitingToBeFull.forEach((Train train) -> {

            if (train.isNotFull() && train.getPriceMap().containsKey(vehicle.getClass())) {

                train.setCapacity(train.getCapacity() + 1);

                if (!train.isNotFull()) {
                    trainsWaitingToBeFull.remove(train);
                }

                sale.setTrain(train);
                sale.setDateTime(LocalDateTime.now());

                double saleIncome = (double) train.getPriceMap().get(vehicle.getClass());
                sale.setIncome(saleIncome);
            }
        });

        if (sale.getTrain() != null) {
            employee.newSaleMade(sale);
            employee.setEmployeeTotal(employee.getEmployeeTotal() + sale.getIncome() * employee.getTicketProvision());
            return sale;
        } else return null;

    }

}
