import javax.swing.JOptionPane;
import Classes.Reclamacao;
import Classes.Elogio;
import Classes.Feedback;
import Classes.Sugestao;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String user;
        int opcao;

        List<String> Reclamacoes = new ArrayList<>();
        List<String> Elogios = new ArrayList<>();
        List<String> Sugestoes = new ArrayList<>();

        JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema de Ouvidoria da Unifacisa!");

        user = JOptionPane.showInputDialog("Digite o seu nome: ");

        JOptionPane.showMessageDialog(null, "Seja Bem-Vindo! " + user);

        do {

            String opcaoStr = JOptionPane.showInputDialog(
                    "O que você deseja fazer ?\n\n"
                    + "(1) Inserir\n"
                    + "(2) Listar\n"
                    + "(3) Apagar\n"
                    + "(4) Pesquisar\n"
                    + "(5) Editar\n"
                    + "(6) Sair");
            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    inserirFeedback(Reclamacoes, Elogios, Sugestoes);
                    break;
                case 2:
                    listarFeedbacks(Reclamacoes, Elogios, Sugestoes);
                    break;
                case 3:
                    apagarFeedback(Reclamacoes, Elogios, Sugestoes);
                    break;
                case 4:
                	buscarFeedback(Reclamacoes, Elogios, Sugestoes);
                    break;
                case 5:
                    editarFeedback(Reclamacoes, Sugestoes, Elogios);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Você deseja sair ?");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERRO: Opção Inválida!");
            }

        } while (opcao != 6);

        JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossa Ouvidoria! \n   © 2024 Babigol | Unifacisa");
    }


	// Inserir feedbacks
    public static void inserirFeedback(List<String> Reclamacoes, List<String> Elogios, List<String> Sugestoes) {
        String respStr = JOptionPane.showInputDialog(null, "Escolha uma categoria:\n(1) Reclamação\n(2) Elogio\n(3) Sugestões");
        int resp = Integer.parseInt(respStr);

        switch (resp) {
            case 1:
                Reclamacao.adicionarFeedback(JOptionPane.showInputDialog(null, "Digite sua reclamação: "), Reclamacoes);
                break;
            case 2:
                Elogio.adicionarFeedback(JOptionPane.showInputDialog(null, "Digite seu Elogio: "), Elogios);
                break;
            case 3:
                Sugestao.adicionarFeedback(JOptionPane.showInputDialog(null, "Digite sua Sugestão: "), Sugestoes);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro! Categoria não encontrada");
        }
    }

    // Listar feedbacks
    public static void listarFeedbacks(List<String> Reclamacoes, List<String> Elogios, List<String> Sugestoes) {
        JOptionPane.showMessageDialog(null, "Você deseja listar:");
        Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações: ");
        Elogio.listarFeedbacks(Elogios, "Elogios: ");
        Sugestao.listarFeedbacks(Sugestoes, "Sugestões: ");
    }

 // Apagar feedbacks
    public static void apagarFeedback(List<String> Reclamacoes, List<String> Elogios, List<String> Sugestoes) {
        String categoria = JOptionPane.showInputDialog(null, "Escolha uma categoria:\n(1) Reclamações\n(2) Elogios\n(3) Sugestões\n(4) Todos");
        int opcao = Integer.parseInt(categoria);

        switch (opcao) {
            case 1:
                Reclamacao.listarFeedbacks(Reclamacoes, "Reclamações");
                int indiceReclamacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da reclamação que deseja apagar:")) - 1;
                Reclamacao.apagarFeedback(indiceReclamacao, Reclamacoes, "Reclamações");
                break;
            case 2:
                Elogio.listarFeedbacks(Elogios, "Elogios");
                int indiceElogio = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do elogio que deseja apagar:")) - 1;
                Elogio.apagarFeedback(indiceElogio, Elogios, "Elogios");
                break;
            case 3:
                Sugestao.listarFeedbacks(Sugestoes, "Sugestões");
                int indiceSugestao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da sugestão que deseja apagar:")) - 1;
                Sugestao.apagarFeedback(indiceSugestao, Sugestoes, "Sugestões");
                break;
            case 4:
                apagarTodosFeedbacks(Reclamacoes, Elogios, Sugestoes);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

    // Apagar todos os feedbacks de todas as categorias
    public static void apagarTodosFeedbacks(List<String> Reclamacoes, List<String> Elogios, List<String> Sugestoes) {
        Reclamacao.apagarTodosFeedbacks(Reclamacoes, "Reclamações");
        Elogio.apagarTodosFeedbacks(Elogios, "Elogios");
        Sugestao.apagarTodosFeedbacks(Sugestoes, "Sugetões");
    }

    
    // Editar feedbacks
    public static void editarFeedback(List<String> Reclamacoes, List<String> Elogios, List<String> Sugestoes) {
        String categoria = JOptionPane.showInputDialog(null, "Escolha uma categoria para editar:\n(1) Reclamações\n(2) Elogios\n(3) Sugestões");
        int opcao = Integer.parseInt(categoria);

        switch (opcao) {
            case 1:
                Feedback.editarFeedback(Reclamacoes, Elogios, Sugestoes, "Reclamações");
                break;
            case 2:
                Feedback.editarFeedback(Reclamacoes, Elogios, Sugestoes, "Elogios");
                break;
            case 3:
                Feedback.editarFeedback(Reclamacoes, Elogios, Sugestoes, "Sugestões");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

    // Buscar feedbacks
    public static void buscarFeedback(List<String> Reclamacoes, List<String> Elogios, List<String> Sugestoes) {
        String codigo = JOptionPane.showInputDialog(null, "Digite o código do feedback que deseja pesquisar:");
        Feedback.buscarFeedback(codigo);
    }
    

}
