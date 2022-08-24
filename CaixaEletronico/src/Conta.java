import java.util.Scanner;

public class Conta {
    Scanner scan = new Scanner(System.in);
    String titular = "Lucas Sechirolli";
    int numero = 123;
    String agencia = "Santander";
    double saldo = 0;
    String criacao = "21/08/2022";

    public void verificarConta(){
        System.out.println("Olá, seja Bem-Vindo ao Caixa Eletrônico!");
        System.out.println("Já possui conta cadastrada?");
        System.out.println("Sim (0)   -   Não (1)");
    }

    public void operarCaixa(){
        int operando =0;
        while (operando != 4){
        System.out.println("Bem-Vindo, "+titular+". Qual operação deseja realizar?");
        System.out.println("Depositar (0)  -  Sacar (1)  -  Calcular Saldo (2)  -  Informações(3)  -  Sair(4)");
        int operacao = scan.nextInt();
        operando = operacao;
        System.out.println();
        switch (operacao) {
            case 0:
                depositar();
                break;
            case 1:
                sacar();
                break;
            case 2:
                calcularSaldo();
                break;
            case 3:
                informacoesConta();
                break;
            case 4:
                System.out.println("Agradeço pela presença, "+titular+"!\n");
                break;
            default:
                System.out.println("Não existe nenhuma operação correspondente!\n");
                break;
        }
        }

    }

    public void criarConta(){
        inserirTitular();
        inserirNumero();
        inserirAgencia();
        inserirCriacao();
    }

    public void inserirTitular(){
        System.out.println("Insira o nome do Titular da Conta:");
        titular = scan.next();
        System.out.println();
    }

    public void inserirNumero(){
        System.out.println("Insira o Numero da Conta:");
        numero = scan.nextInt();
        System.out.println();
    }

    public void inserirAgencia(){
        System.out.println("Insira o nome da Agência da Conta:");
        agencia = scan.next();
        System.out.println();
    }

    public void inserirCriacao(){
        System.out.println("Insira a data de criação da Conta:");
        criacao = scan.next();
        System.out.println();
    }

    public void depositar(){
        System.out.println("Digite o valor do depósito: ");
        double deposito = scan.nextDouble();
        saldo += deposito;
        System.out.println("--------Depósito Realizado--------");
        System.out.println("Valor depositado: R$"+deposito);
        System.out.println("Saldo atual: R$"+saldo);
        System.out.println();
    }

    public void sacar(){
        System.out.println("Digite o valor para sacar:");
        double saque = scan.nextDouble();
        if(saque <= saldo){
            saldo -= saque;
            System.out.println("--------Saque Realizado--------");
            System.out.println("Valor sacado: R$"+saque);
            System.out.println("Saldo atual: R$"+saldo);
            System.out.println();
        }else{
            System.out.println("----------SAQUE NEGADO----------");
            System.out.println("-------SALDO INSUFICIENTE-------");
            System.out.println();
        }
    }

    public void calcularSaldo(){
        System.out.println("---------SALDO---------");
        System.out.println("- R$"+saldo);
        System.out.println();
    }

    public void informacoesConta(){
        System.out.println("-------INFORMAÇÕES DA CONTA--------");
        System.out.println("Nome do Titular: "+titular);
        System.out.println("Saldo: "+saldo);
        System.out.println("Agência da Conta: "+agencia);
        System.out.println("Número da Conta: "+numero);
        System.out.println("Data de Criação: "+criacao);
        System.out.println();
    }
    
}
