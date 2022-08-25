import java.util.Scanner;

/**
 * <h1>Conta</h1>
 * <p>A classe conta contém as possíveis operações que uma conta bancária pode efetuar em um caixa eletrônico.</p>
 * <p>Contém os métodos:</p>
 * <ul>
 * <li>verificarConta();</li>
 * <li>criarConta();</li>
 * <li>operarCaixa();</li>
 * <li>inserirTitular();</li>
 * <li>inserirNumero();</li>
 * <li>inserirAgencia();</li>
 * <li>inserirCriacao();</li>
 * <li>depositar();</li>
 * <li>sacar();</li>
 * <li>calcularSaldo();</li>
 * <li>informacoesConta();</li>
 * </ul>
 * <hr>
 * @author Lucas Eduardo Sechirolli da Silva
 * @version 1.0
 * @since 24/08/2022
 */
public class Conta {
    Scanner scan = new Scanner(System.in);
    String titular = "Lucas Sechirolli";
    int numero = 123;
    String agencia = "Santander";
    double saldo = 10000;
    String criacao = "21/08/2022";

    /**<h2>verificarConta();</h2>
     * <p>Este método inicia o caixa eletrônico e verifica se o cliente já possui conta cadastrada.</p>
     * <p>Se o cliente já for cadastrado chamará o método operarCaixa();</p>
     * <p>Caso o cliente não tiver conta, o método criarConta(); será chamado</p>
    */
    public void verificarConta(){
        int rep = 2;
        while (rep > 1 || rep < 0){
        System.out.println("Olá, seja Bem-Vindo ao Caixa Eletrônico!");
        System.out.println("Já possui conta cadastrada?");
        System.out.println("Sim (0)   -   Não (1)");
        int verifica = scan.nextInt();
        System.out.println();
        rep = verifica;
        switch (verifica) {
            case 0:
                operarCaixa();
                break;
            case 1:
                criarConta();
                break;
            default:
                System.out.println("Valor inválido!\n");
                break;
        }
        }
    }

    /**<h2>criarConta();</h2>
     * <p>Este método serve para criar uma conta bancária.</p>
     * <p>Para criar a conta, é chamado os seguintes métodos:</p>
     * <ul>
     * <li>inserirTitular();</li>
     * <li>inserirNumero();</li>
     * <li>inserirAgencia();</li>
     * <li>inserirCriacao();</li>
     * </ul>
    */
    public void criarConta(){
        inserirTitular();
        inserirNumero();
        inserirAgencia();
        inserirCriacao();
    }

    /**<h2>operarCaixa();</h2>
     * <p>Este método contém as possíveis operações a serem realizadas no caixa eletrônico</p>
     * <p>O usuário pode escolher as seguintes opções:</p>
     * <ul>
     * <li>Depositar - Que chamará o método depositar();</li>
     * <li>Sacar - Que chamará o método sacar();</li>
     * <li>Calcular Saldo - Que chamará o método calcularSaldo();</li>
     * <li>Informações - Que chamará o método informacoesConta();</li>
     * <li>Sair - Que encerará as operações do caixa</li>
     * </ul>
    */
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

    /**<h2>inserirTitular();</h2>
     * <p>Método que receberá o nome do titular e o armazenará na variável titular</p>
     */
    public void inserirTitular(){
        System.out.println("Insira o nome do Titular da Conta:");
        titular = scan.next();
        System.out.println();
    }

    /**<h2>inserirNumero();</h2>
     * <p>Método que receberá o número da conta e o armazenará na variável numero</p>
     */
    public void inserirNumero(){
        System.out.println("Insira o Numero da Conta:");
        numero = scan.nextInt();
        System.out.println();
    }

    /**<h2>inserirAgencia();</h2>
     * <p>Método que receberá o nome da Agência e o armazenará na variável agencia</p>
     */
    public void inserirAgencia(){
        System.out.println("Insira o nome da Agência da Conta:");
        agencia = scan.next();
        System.out.println();
    }

    /**<h2>inserirCriacao();</h2>
     * <p>Método que receberá a data de criação da conta e o armazenará na variável criacao</p>
     */
    public void inserirCriacao(){
        System.out.println("Insira a data de criação da Conta:");
        criacao = scan.next();
        System.out.println();
    }

    /**<h2>depositar();</h2>
     * <p>Método que receberá um valor e efetuará um depósito, somando o valor ao saldo</p>
     */
    public void depositar(){
        System.out.println("Digite o valor do depósito: ");
        double deposito = scan.nextDouble();
        saldo += deposito;
        System.out.println("--------Depósito Realizado--------");
        System.out.println("Valor depositado: R$"+deposito);
        System.out.println("Saldo atual: R$"+saldo);
        System.out.println();
    }

    /**<h2>sacar();</h2>
     * <p>Método que receberá um valor para realiar um saque.</p>
     * <p>Caso o valor for menor ou igual ao saldo, o saque será realizado</p>
     * <p>Caso contrário a operação será negada</p>
     */
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

    /**<h2>calcularSaldo();</h2>
     * <p>Método que mostrará o saldo atual da conta</p>
     */
    public void calcularSaldo(){
        System.out.println("---------SALDO---------");
        System.out.println("- R$"+saldo);
        System.out.println();
    }

    /**<h2>informacoesConta();</h2>
     * <p>Método que mostrará todos os dados da conta, como:</p>
     * <ul>
     * <li>Nome do Titular</li>
     * <li>Saldo</li>
     * <li>Agência da Conta</li>
     * <li>Número da Conta</li>
     * <li>Data de Criação</li>
     * </ul>
     */
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
