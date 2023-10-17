package co.tiagoaguiar.bank;

import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");
        // C = Criar conta
        // E = Sair (exit)
        while (true) {
            System.out.println("O que deseja fazer? C=Criar conta, E=Sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                System.out.println(account);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                System.out.println("Como desejar, saindo da conta. Até breve!");
                break;
            } else {
                System.out.println("Comando inválido, tente novamente!");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for(Account cc: accountList) {
            System.out.println(cc);
        }
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        // D = Deposito
        // S = Saque
        // E = Sair (exit)
        while (true) {
            System.out.println("O que deseja fazer? D=Deposito, S=Saque, E=Sair da Conta");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual o valor deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual o valor deseja sacar?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Ops, Não foi possível sacar o valor R$" + value);
                }
            } else if (op.equals("E")) {
                System.out.println("Como desejar, saindo da conta. Até breve!");
                break;
            } else {
                System.out.println("Comando inválido, tente novamente!");
            }
            scanner = new Scanner(System.in);
        }
    }

}
