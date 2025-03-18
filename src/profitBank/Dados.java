package profitBank;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Dados {

	public Dados(String numeroConta, String titular, double saldoInicial, double limiteConta) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldoInicial = saldoInicial;
		this.limiteConta = limiteConta;
		Dados.qtCorrentista++; // adiciona o total de correntista

	}

	public Dados() {
	}

	// ATRIBUTOS
	private double limiteConta;
	private double saldoInicial;
	private String titular;
	private String numeroConta;
	private static int qtCorrentista;

//MÉTODOS DO MENU
	// -----1
	public void cadastrar(Scanner leitor, List<Dados> dadosCliente) {
		try {// acha o erro ao digitar valores errados
			System.out.println("*********************");
			System.out.println(" CADASTRANDO CLIENTE ");
			System.out.println("*********************");
			System.out.println();

			System.out.print("Numero Da conta: ");
			String numeroConta = leitor.next();

			System.out.print("Nome do titular: ");
			String titular = leitor.next();

			System.out.print("Saldo inicial: ");
			double saldoInicial = leitor.nextDouble();

			System.out.println("Limite da Conta: ");
			double limiteConta = leitor.nextDouble();

			// Cria o objeto e insere as informações dentro dele
			Dados dad = new Dados(numeroConta, titular, saldoInicial, limiteConta);

			// Adiciona o objeto dentro do vetor (simulando o banco de dados)
			dadosCliente.add(dad);

			System.out.println("*** Correntista Cadastrado com Sucesso!!! ***");
		} catch (InputMismatchException erro) {
			System.out.println("Erro tente novamente");
			leitor.next();
		}

	}

	// -----2
	public void mostrarTodos(List<Dados> dadosCliente) {
		System.out.println("***********************************");
		System.out.println("  MOSTRANDO TODOS OS CORRENTISTAS ");
		System.out.println("***********************************");

		for (Dados numeroConta : dadosCliente) {
			System.out.println("Numero Da conta: " + numeroConta.getNumeroConta());
			System.out.println("Nome do titular: " + numeroConta.getTitular());
			System.out.println("Saldo: " + numeroConta.getSaldoInicial());
			System.out.println("limite da conta: " + numeroConta.getLimiteConta());
			System.out.println("--------------------------");
		}
	}

	// -----3
	public void mostrarCorrentistaDesejado(Scanner leitor, List<Dados> dadosCliente) {
		System.out.println("*********************************");
		System.out.println("  MOSTRANDO CORRENTISTA DESEJADO ");
		System.out.println("*********************************");
		System.out.println();
		System.out.println("digite o Numero da conta: ");
		String pesquisarCorrentista = leitor.next();

		for (Dados numeroConta : dadosCliente) {

			if (pesquisarCorrentista.equals(numeroConta.getNumeroConta())) {
				System.out.println("Numero Da conta: " + numeroConta.getNumeroConta());
				System.out.println("nome Do titular: " + numeroConta.getTitular());
				System.out.println("Saldo: " + numeroConta.getSaldoInicial());
				System.out.println("limite da conta: " + numeroConta.getLimiteConta());
				System.out.println("--------------------------");
				break;
			} else {
				System.out.println("Numero Da conta invalido, tente novamente.");
			}
		}

	}

	// -----4
	public void alterarCadastro(Scanner leitor, List<Dados> dadosCliente) {
		System.out.println("****************************");
		System.out.println("     ALTERANDO CADASTRO     ");
		System.out.println("****************************");
		System.out.println();
		System.out.println("Digite o numero da conta:");
		String alterar = leitor.next();
		for (Dados numeroConta : dadosCliente) {
			if (alterar.equals(numeroConta.getNumeroConta())) {
				System.out.println("Numero Da conta: " + numeroConta.getNumeroConta());
				System.out.println("nome Do titular: " + numeroConta.getTitular());
				System.out.println("Saldo: " + numeroConta.getSaldoInicial());
				System.out.println("limite da conta: " + numeroConta.getLimiteConta());
				System.out.println("--------------------------");

				System.out.println("");
				System.out.println("Digite o novo nome do titular:");
				numeroConta.setTitular(leitor.next());

				System.out.println("Digite o novo limite:");
				numeroConta.setLimiteConta(leitor.nextDouble());

			}
		}

	}

	// -----5
	public void excluirConta(Scanner leitor, List<Dados> dadosCliente) {
		System.out.println("****************************");
		System.out.println("       EXCLUIR CONTA        ");
		System.out.println("****************************");
		System.out.println();
		System.out.println("Digite o numero da conta");
		String contaExcluir = leitor.next();

		for (Dados numeroConta : dadosCliente) {
			if (contaExcluir.equals(numeroConta.getNumeroConta())) {
				System.out.println("Número da conta: " + numeroConta.getNumeroConta());
				System.out.println("Nome do titular: " + numeroConta.getTitular());
				System.out.println("Saldo: " + numeroConta.getSaldoInicial());
				System.out.println("Limite da conta: " + numeroConta.getLimiteConta());
				System.out.println("--------------------------");
				System.out.println();
				System.out.println("*****************************************************");
				System.out.println("VOCE TEM CERTEZA DE QUE GOSTARIA DE EXCLUIR A CONTA?");
				System.out.println("1- SIM");
				System.out.println("2- NÃO");
				System.out.println("*****************************************************");
				String excluir = leitor.next();

				if (excluir.equals("1")) {
					if (numeroConta.getSaldoInicial() == 0) {
						dadosCliente.remove(numeroConta);
						setQtCorrentista(qtCorrentista - 1); // quando executado reduz o numero de correntistas
						System.out.println("Conta excluída com sucesso!");
						return;
					} else {
						System.out.println("Esta conta não pode ser excluída devido ao saldo atual.");
					}
				} else if (excluir.equals("2")) {
					return;
				} else {
					System.out.println("Opção inválida. Digite 1 para SIM ou 2 para NÃO.");
				}

			} else {
				System.out.println("opção invalida");
			}

		}
		return;
	}

	// -----6
	public void efetuarDeposito(Scanner leitor, List<Dados> dadosCliente) {

		if (getQtCorrentista() >= 1) { // só roda se houver 1 correntista ou mais
			System.out.println("****************************");
			System.out.println("          DEPOSITAR         ");
			System.out.println("****************************");
			System.out.println();
			System.out.println("Digite o numero da conta");
			String contaDepositar = leitor.next();

			try {// acha o erro ao digitar valores errados
				for (Dados numeroConta : dadosCliente) {
					if (contaDepositar.equals(numeroConta.getNumeroConta())) {
						System.out.println("Número da conta: " + numeroConta.getNumeroConta());
						System.out.println("Nome do titular: " + numeroConta.getTitular());
						System.out.println("Saldo: " + numeroConta.getSaldoInicial());
						System.out.println("--------------------------");
						System.out.println();
						System.out.println("*****************************************************");
						System.out.println("               valor a depositar");
						System.out.println("*****************************************************");
						double valorDepositar = leitor.nextDouble();

						double novoSaldo = numeroConta.getSaldoInicial() + valorDepositar;
						numeroConta.setSaldoInicial(novoSaldo);
						System.out.println("Novo Saldo: " + numeroConta.getSaldoInicial());

						return;
					}
				}
			} catch (InputMismatchException erro) {
				System.out.println("VALOR INVALIDO!");
				leitor.next();
			}
		} else { 
			System.out.println("quantidade de correntistas insuficiente.");
			return;

		}

	}

	// -----7
	public void efetuarPagamento(Scanner leitor, List<Dados> dadosCliente) {
		if (getQtCorrentista() >= 1) { // só roda se houver 1 correntista ou mais
			System.out.println("****************************");
			System.out.println("      EFETUAR PAGAMENTO     ");
			System.out.println("****************************");
			System.out.println();
			System.out.println("Digite o numero da conta");
			String contaRetirar = leitor.next();
			try {
				for (Dados numeroConta : dadosCliente) {
					if (contaRetirar.equals(numeroConta.getNumeroConta())) {
						System.out.println("Número da conta: " + numeroConta.getNumeroConta());
						System.out.println("Nome do titular: " + numeroConta.getTitular());
						System.out.println("Saldo: " + numeroConta.getSaldoInicial());
						System.out.println("Limite da conta: " + numeroConta.getLimiteConta());
						System.out.println("--------------------------");
						System.out.println();
						System.out.println("*****************************************************");
						System.out.println("               valor a pagar");
						System.out.println("*****************************************************");
						double valorRetirar = leitor.nextDouble();

						double novoSaldo1 = numeroConta.getSaldoInicial() - valorRetirar;
						numeroConta.setSaldoInicial(novoSaldo1);
						System.out.println("Novo Saldo: " + numeroConta.getSaldoInicial());

						return;
					}
				}
			} catch (InputMismatchException erro) {
				System.out.println("VALOR INVALIDO!");
				leitor.next();
			}
		} else {
			System.out.println("quantidade de correntistas insuficiente.");
			return;
		}
	}

	// -----8
	public void transferirEntreContas(Scanner leitor, List<Dados> dadosCliente) {
		if (getQtCorrentista() >= 2) { // só roda se houver 2 correntistas ou mais

			System.out.println("****************************");
			System.out.println("    EFETUAR TRANFERENCIA   ");
			System.out.println("****************************");
			System.out.println();
			System.out.println("Digite o numero da conta de origem");
			String contaOrigem = leitor.next();

			for (Dados numeroConta1 : dadosCliente) {
				if (contaOrigem.equals(numeroConta1.getNumeroConta())) {
					System.out.println("Número da conta: " + numeroConta1.getNumeroConta());
					System.out.println("Nome do titular: " + numeroConta1.getTitular());
					System.out.println("Saldo: " + numeroConta1.getSaldoInicial());
					System.out.println("Limite da conta: " + numeroConta1.getLimiteConta());
					System.out.println("--------------------------");
					System.out.println();
					System.out.println("*****************************************************");
					System.out.println("          digite o número da conta destino          ");
					System.out.println("*****************************************************");
					String contaDestino = leitor.next();

					for (Dados numeroConta2 : dadosCliente) {
						if (contaDestino.equals(numeroConta2.getNumeroConta())) {
							System.out.println("Número da conta: " + numeroConta2.getNumeroConta());
							System.out.println("Nome do titular: " + numeroConta2.getTitular());
							System.out.println("Saldo: " + numeroConta2.getSaldoInicial());
							System.out.println("Limite da conta: " + numeroConta2.getLimiteConta());
							System.out.println("--------------------------");
							System.out.println();
							System.out.println("Digite o valor para tranferir para " + numeroConta2.getTitular());

							double valorTransferir = leitor.nextDouble();//verifica se o saldo é suficiente
							if (valorTransferir > numeroConta1.getSaldoInicial()) {
								System.out.println("saldo insuficiente");
								return;
							} else {
								double retirado = numeroConta1.getSaldoInicial() - valorTransferir;
								numeroConta1.setSaldoInicial(retirado);
								//subtrai de uma conta e soma na outra
								double depositado = numeroConta2.getSaldoInicial() + valorTransferir;
								numeroConta2.setSaldoInicial(depositado);
								System.out.println("tranferencia concluida!!");

							}

						}
					}
				}
			}
		} else {
			System.out.println("Quantidade de correntistas insuficiente.");
			return;
		}
	}

	// -----9
	public void encerrarSistema(Scanner leitor) {
		System.out.println("SISTEMA FINZALIZADO.");
	}

	public static int getQtCorrentista() {
		return qtCorrentista;
	}

	public static void setQtCorrentista(int qtCorrentista) {
		Dados.qtCorrentista = qtCorrentista;
	}

	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

}