package profitBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		List<Dados> dadosCliente = new ArrayList<>();
		
		
	
		Dados dad = new Dados();
		int opcao;
		
		
		do {
		
			System.out.println("********** ====PROFIT BANK==== **********");
			System.out.println("**1- Criar conta corrente:             **");
			System.out.println("**2- Mostrar todas as contas:          **");
			System.out.println("**3- Selecionar e mostrar correntista: **");
			System.out.println("**4- Alterar dados da conta corrente:  **");
			System.out.println("**5- Excluir conta corrente:           **");
			System.out.println("**6- Efetuar Depósito:                 **");
			System.out.println("**7- Efetuar pagamento:                **");
			System.out.println("**8- Traferir entre contas:            **");
			System.out.println("**9- Finaliza sistema.                 **");
			System.out.println("**=====================================**");
			System.out.println("**===== TOTAL DE CORRENTISTAS: " +  Dados.getQtCorrentista()   +" ======**");
			System.out.println("**=====================================**");
			
			try {
			opcao = leitor.nextInt();
			switch (opcao) {
			
			
			case 1:
				dad.cadastrar(leitor,dadosCliente);
				break;
			case 2:
			    dad.mostrarTodos(dadosCliente);
				break;	
			case 3:
				dad.mostrarCorrentistaDesejado(leitor, dadosCliente);
				break;
			case 4:
				dad.alterarCadastro(leitor, dadosCliente);
				break;
			case 5:
				dad.excluirConta(leitor, dadosCliente);
				break;
				
			case 6:
				dad.efetuarDeposito(leitor, dadosCliente);
				break;
			case 7:
				dad.efetuarPagamento(leitor, dadosCliente);
				break;
			case 8:
				dad.transferirEntreContas(leitor, dadosCliente);
				break;	
			case 9:
				dad.encerrarSistema(leitor);
				break;
				
		
            default:
                System.out.println("Opção inválida");
			}
		
		   } catch (Exception e) {
	            System.out.println("Opção inválida");
	            leitor.next();//em caso de opçoes erradas ele não fecha o programa
	            opcao = 0;
		   }
			
			
			} while (opcao != 9);
		
	
	}

}
