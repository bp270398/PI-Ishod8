/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.ishod8.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author beata
 */
@Data
@AllArgsConstructor
public abstract class Train {
    
    private final Map<Class<? extends Vehicle>,Integer> priceMap;
    private final int MAX_CAPACITY;
    private int capacity;

    public abstract Boolean isNotFull();
   
}
