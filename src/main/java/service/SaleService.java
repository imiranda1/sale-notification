package service;

import data.Database;
import model.Sale;
import notifications.SaleNotification;

import java.util.List;

public class SaleService {

    Database database = new Database();


    public void saveSale(String clientName, List<Integer> producsId, SaleNotification notification){
       Sale sale = new Sale(clientName, producsId);
       database.setSales(sale);
       notification.send(sale);
    }
}
