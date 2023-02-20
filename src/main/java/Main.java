import notifications.CheckoutNotification;
import notifications.SaleNotification;
import service.SaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SaleNotification saleNotification = new SaleNotification();

        CheckoutNotification checkoutNotification = new CheckoutNotification();


        SaleService saleService = new SaleService();


        saleNotification.getSaleFlux().subscribe(sale -> {
            System.out.println(sale.getClientName() + " realizou uma compra");
        });

        checkoutNotification.getCheckoutNotification().subscribe(id ->{
            System.out.println("incluiu item: " + id);
        });


        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("nome");
            String clientName = scanner.next();
            Integer saveProduct = 0;
            List<Integer> productsId = new ArrayList<>();
            while(saveProduct != 4){
                System.out.println("Digite o produto que deseja adicionar ou 4 para finalizar");
                System.out.println(" 1 - bala \n 2 - refrigerante \n 3 - chocolate \n 4 - finalizar");
                Integer escolha = scanner.nextInt();
                if(escolha != 4){
                    productsId.add(escolha);
                    checkoutNotification.send(escolha);
                }
                saveProduct = escolha;
            }
            saleService.saveSale(clientName, productsId, saleNotification);
        }
        }
    }

