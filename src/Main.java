import javax.swing.JOptionPane;
import Classes.Reclamacao;
import Classes.Elogio;
import Classes.Sugestao;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String user;
		String descricao;
		int apagar;
		int resp;
		int opcao;
		
		List<String> Reclamacoes = new ArrayList<>();
		List<String> Elogios = new ArrayList<>();
		List<String> Sugestoes = new ArrayList<>();
		
		
		JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema de Ouvidoria da Unifacisa! ");
		

		user = JOptionPane.showInputDialog("Digite o seu nome: ");

		JOptionPane.showMessageDialog(null, "Seja Bem-Vindo! " + user);
		
		do {
			
			String opcaoStr = JOptionPane.showInputDialog(
					"O que você deseja fazer ?\n\n"
					+ "(1) Inserir\n"
					+ "(2) Listar\n"
					+ "(3) Apagar\n"
					+ "(4) Editar\n"
					+ "(5) Sair");
			opcao = Integer.parseInt(opcaoStr);
			
			if(opcao == 1) {
				 String respStr = JOptionPane.showInputDialog(null, "Escolha uma categoria : \n(1) Reclamação \n(2) Elogio \n(3) Sugestões" );
				 resp = Integer.parseInt(respStr);
				 
				 if (resp == 1) {
					 descricao =  JOptionPane.showInputDialog(null, "Digite sua reclamação: " );
					 Reclamacao.adicionarFeedback(descricao, Reclamacoes);
				 }
				 else if (resp == 2) {
					 descricao =  JOptionPane.showInputDialog(null, "Digite seu Elogio: " );
					 Elogio.adicionarFeedback(descricao, Elogios);
				 }
				 else if (resp == 3) {
					 descricao =  JOptionPane.showInputDialog(null, "Digite sua Sugestão: " );
					 Sugestao.adicionarFeedback(descricao, Sugestoes);
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Erro! Categoria não encontrada" );
				 }
			}
			else if(opcao == 2) { 
				JOptionPane.showMessageDialog(null, "Você deseja ? Listar" );
				Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações : ");
				Elogio.listarFeedbacks(Elogios, "Elogios : ");
				Sugestao.listarFeedbacks(Sugestoes, "Sugestões : ");
			}
			else if (opcao == 3) {
			    String respStr = JOptionPane.showInputDialog(null, "Escolha uma categoria : \n(1) Reclamação \n(2) Elogio \n(3) Sugestões" );
			    resp = Integer.parseInt(respStr);
			    
			    if (resp == 1) {
			        Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações ");
			        String apagarStr = JOptionPane.showInputDialog(null, "Escolha uma opção para apagar: \n(1) Apagar todas as reclamações \n(2) Apagar uma reclamação específica");
			        apagar = Integer.parseInt(apagarStr);
			        if (apagar == 1) {
			            Reclamacao.apagarTodasReclamacoes(Reclamacoes);
			        } else if (apagar == 2) {
			            Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações  ");
			            String reclamacao = JOptionPane.showInputDialog(null, "Digite o número da reclamação que deseja apagar : ");
			            int indice = Integer.parseInt(reclamacao) - 1;
			            Reclamacao.apagarReclamacao(indice, Reclamacoes);
			            Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações  ");
			        } else {
			            JOptionPane.showMessageDialog(null, "Opção inválida");
			        }
			    }
			    if (resp == 2) {
			        Reclamacao.listarFeedbacks(Elogios, "Elogios : ");
			        String apagarStr = JOptionPane.showInputDialog(null, "Escolha uma opção para apagar: \n(1) Apagar todos os elogios \n(2) Apagar um elogio específico");
			        apagar = Integer.parseInt(apagarStr);
			        if (apagar == 1) {
			            Elogio.apagarTodosELogios(Elogios);
			        } else if (apagar == 2) {
			            Reclamacao.listarFeedbacks(Elogios, "Elogios  ");
			            String elogio = JOptionPane.showInputDialog(null, "Digite o número do Elogio que deseja apagar : ");
			            int indice = Integer.parseInt(elogio) - 1;
			            Elogio.apagarElogio(indice, Elogios);
			            Elogio.listarFeedbacks(Elogios, "Elogios  ");
			        } else {
			            JOptionPane.showMessageDialog(null, "Opção inválida");
			        }
			    }
			    if (resp == 3) {
			        Reclamacao.listarFeedbacks(Sugestoes, "Sugestões ");
			        String apagarStr = JOptionPane.showInputDialog(null, "Escolha uma opção para apagar: \n(1) Apagar todas as sugestçoes \n(2) Apagar uma sugestão específica");
			        apagar = Integer.parseInt(apagarStr);
			        if (apagar == 1) {
			            Sugestao.apagarTodasSugestoes(Sugestoes);
			        } else if (apagar == 2) {
			            Reclamacao.listarFeedbacks(Sugestoes, "Sugestões  ");
			            String sugestao = JOptionPane.showInputDialog(null, "Digite o número da Sugestão que deseja apagar : ");
			            int indice = Integer.parseInt(sugestao) - 1;
			            Sugestao.apagarSugestao(indice, Sugestoes);
			            Reclamacao.listarFeedbacks(Sugestoes, "Sugestões  ");
			        } else {
			            JOptionPane.showMessageDialog(null, "Opção inválida");
			        }
			    }
			    
				 
				
			}
			else if (opcao == 4) {
			    String respStr = JOptionPane.showInputDialog(null, "Escolha uma categoria : \n(1) Reclamação \n(2) Elogio \n(3) Sugestões" );
			    resp = Integer.parseInt(respStr);
			    
			    if (resp == 1) {
			        Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações ");
			        String editarStr = JOptionPane.showInputDialog(null, "Digite o número da reclamação que deseja editar : ");
			        int indice = Integer.parseInt(editarStr) - 1;
			        if (indice >= 0 && indice < Reclamacoes.size()) {
			            String novaDescricao = JOptionPane.showInputDialog(null, "Digite a nova descrição: ");
			            Reclamacao.editarReclamacao(indice, novaDescricao, Reclamacoes);
			        } else {
			            JOptionPane.showMessageDialog(null, "Índice inválido.");
			        }
			    } else if (resp == 2) {
			        Reclamacao.listarFeedbacks(Elogios, "Elogios ");
			        String editarStr = JOptionPane.showInputDialog(null, "Digite o número do elogio que deseja editar : ");
			        int indice = Integer.parseInt(editarStr) - 1;
			        if (indice >= 0 && indice < Elogios.size()) {
			            String novaDescricao = JOptionPane.showInputDialog(null, "Digite a nova descrição: ");
			            Elogio.editarElogio(indice, novaDescricao, Elogios);
			        } else {
			            JOptionPane.showMessageDialog(null, "Índice inválido.");
			        }
			    } else if (resp == 3) {
			        Reclamacao.listarFeedbacks(Sugestoes, "Sugestões ");
			        String editarStr = JOptionPane.showInputDialog(null, "Digite o número da sugestão que deseja editar : ");
			        int indice = Integer.parseInt(editarStr) - 1;
			        if (indice >= 0 && indice < Sugestoes.size()) {
			            String novaDescricao = JOptionPane.showInputDialog(null, "Digite a nova descrição: ");
			            Sugestao.editarSugestao(indice, novaDescricao, Sugestoes);
			        } else {
			            JOptionPane.showMessageDialog(null, "Índice inválido.");
			        }
			    }	
					
			}
			else if(opcao == 5) {
				JOptionPane.showMessageDialog(null, "Você deseja ? Sair" );
			}
			else {
				JOptionPane.showMessageDialog(null, "ERRO : Opção Invalida!" );
			}
		
		
		} while (opcao !=5);
		
			JOptionPane.showMessageDialog(null, "Obrigado por ultilizar nossa Ouvidoria!  \n   © 2024 Babigol | Unifacisa" );
	} 
}
