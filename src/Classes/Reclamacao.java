package Classes;

import javax.swing.JOptionPane;
import java.util.List;

public class Reclamacao {

    // Função para adicionar a descrição à lista correspondente
    public static void adicionarFeedback(String descricao, List<String> lista) {
        lista.add(descricao);
        JOptionPane.showMessageDialog(null, "Feedback adicionado com sucesso!");
    }

    // Função para listar os feedbacks de uma determinada categoria
    public static void listarFeedbacks(List<String> lista, String categoria) {
        StringBuilder feedbacks = new StringBuilder("Feedbacks de " + categoria + ":\n\n");
        for (int i = 0; i < lista.size(); i++) {
            feedbacks.append(i + 1).append(". ").append(lista.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, feedbacks.toString());
    }

    // Função para apagar todas as Reclamações
    public static void apagarTodasReclamacoes(List<String> reclamacoes) {
        if (!reclamacoes.isEmpty()) {
            reclamacoes.clear();
            JOptionPane.showMessageDialog(null, "Todas as Reclamações foram apagadas com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não há Reclamações para apagar.");
        }
    }

    // Função para apagar uma Reclamação específica pelo índice da lista
    
    public static void apagarReclamacao(int indice, List<String> reclamacoes) {
        if (indice >= 0 && indice < reclamacoes.size()) {
            reclamacoes.remove(indice);
            JOptionPane.showMessageDialog(null, "Reclamação apagada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }
    
    // Função para editar uma Reclamação específica pelo índice da lista
    
    public static void editarReclamacao(int indice, String novaDescricao, List<String> reclamacoes) {
        if (indice >= 0 && indice < reclamacoes.size()) {
            reclamacoes.set(indice, novaDescricao);
            JOptionPane.showMessageDialog(null, "Reclamação editada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }
    
}
