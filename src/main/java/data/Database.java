package data;

import model.Sale;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Sale> sales = new ArrayList<>();

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(Sale sale) {
        this.sales.add(sale);
    }
}
