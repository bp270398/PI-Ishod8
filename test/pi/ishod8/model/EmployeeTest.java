package pi.ishod8.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void newSaleMade() {
        Sale sale = new Sale();
        List<Sale> sales = new ArrayList<>();

        sales.add(sale);

        assertTrue(sales.contains(sale));
    }

}