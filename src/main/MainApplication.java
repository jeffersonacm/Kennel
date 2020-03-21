package main;

import main.canil.controller.BathController;
import main.canil.models.BathRequest;
import main.canil.models.BathResponse;
import main.canil.utils.ConsoleUtil;
import main.canil.utils.DateUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainApplication {

    private static BathController bathController = new BathController();

    private static Scanner scanner = new Scanner(System.in);

    private static ConsoleUtil consoleUtil = new ConsoleUtil();

    public static void main(String [] args) throws InterruptedException, IOException {
        int op;

        do {
            printMenu();
            System.out.print("Escolha uma opção: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    BathResponse bathResponse = bathController.findBestPetshop(getRequestData());
                    System.out.println("\nO melhor canino é: ");
                    printBest(bathResponse);
                    consoleUtil.pause();
                    break;
                case 2:
                    List<BathResponse> bathResponseList = bathController.findAllBestPetshops();
                    System.out.println("\nUltimas buscas: ");
                    bathResponseList.stream().forEach(br -> printBest(br));
                    consoleUtil.pause();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção não encontrada!");
                    Thread.currentThread().sleep(2000);
                    break;
            }

            consoleUtil.clear();
        } while (op != 3);
    }

     static BathRequest getRequestData() {
        String date;
        Boolean validRequest = false;
        DateUtil dateUtil = new DateUtil();
        BathRequest bathRequest = new BathRequest();

        do {
            System.out.print("Digite a data que deseja (dd/mm/yyyy): ");
            date = scanner.next();

            if (Boolean.FALSE.equals(dateUtil.isValidFormatDate(date))) {
                System.out.println("Formato de data não suportado, ou data inválida!");
                continue;
            }

            bathRequest.setDate(dateUtil.toLocaldate(date));

            System.out.print("Digite a quantidade de cães pequenos: ");
            bathRequest.setSmallDogs(scanner.nextInt());

            System.out.print("Digite a quantidade de cães grandes: ");
            bathRequest.setBigDogs(scanner.nextInt());

            validRequest = true;

        } while (Boolean.FALSE.equals(validRequest));

        return bathRequest;
    }

    static void printMenu() {
        System.out.println("O programa que busca o melhor petshop para os seus cães!");
        System.out.println("\nMenu: ");
        System.out.println("1 - Encontrar melhor PetShop");
        System.out.println("2 - Listar ultimas buscas");
        System.out.println("3 - Sair");
    }

    static void printBest(BathResponse bathResponse) {
        System.out.println("Nome: " + bathResponse.getKennel().getName() +
                " | Preço total dos banhos: "+ bathResponse.getTotalPrice());
    }

}
