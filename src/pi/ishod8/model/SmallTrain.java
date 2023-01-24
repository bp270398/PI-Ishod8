/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beata
 */
@Data
public class SmallTrain extends Train {

    @Getter
    @Setter
    private int capacity;
    public static final int MAX_CAPACITY = 8;
    public static final int CAR_PRICE = 50;
    public static final int VAN_PRICE = 80;

    private static final Map<Class<? extends Vehicle>, Integer> priceMap;

    static {
        priceMap = new HashMap<>();
        priceMap.put(Car.class, CAR_PRICE);
        priceMap.put(Van.class, VAN_PRICE);
    }

    public SmallTrain() {
        super(priceMap, MAX_CAPACITY, 0);
    }

    @Override
    public Boolean isNotFull() {
        return capacity < MAX_CAPACITY;
    }


}
