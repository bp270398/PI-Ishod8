/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author beata
 */
@Data
public class BigTrain extends Train{
    
    @Getter
    @Setter
    private int capacity;
    public static final int MAX_CAPACITY = 8;
    public static final int BUS_PRICE = 70;
    public static final int TRUCK_PRICE = 90;
    
    private static final Map<Class<? extends Vehicle>, Integer> priceMap;
    static{
        priceMap = new HashMap<>();
        priceMap.put(Bus.class, BUS_PRICE);
        priceMap.put(Truck.class, TRUCK_PRICE);
    }
    
    public BigTrain() {
        super(priceMap, MAX_CAPACITY, 0);
    }

    @Override
    public Boolean isNotFull() {
        return capacity < MAX_CAPACITY;
    }
    
}
