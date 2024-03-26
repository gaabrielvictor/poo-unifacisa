package Classes;

import javax.swing.JOptionPane;
import java.util.List;

public class Sugestao {

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

    // Função para apagar todas as Sugestões
    public static void apagarTodasSugestoes(List<String> sugestoes) {
        if (!sugestoes.isEmpty()) {
        	sugestoes.clear();
            JOptionPane.showMessageDialog(null, "Todas as Sugestões foram apagadas com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não há Sugestões para apagar.");
        }
    }

    // Função para apagar uma Sugestão específica pelo índice da lista
    
    public static void apagarSugestao(int indice, List<String> sugestoes) {
        if (indice >= 0 && indice < sugestoes.size()) {
        	sugestoes.remove(indice);
            JOptionPane.showMessageDialog(null, "Sugestão apagada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }
    
    // Função para editar uma Reclamação específica pelo índice da lista
    
    public static void editarSugestao(int indice, String novaDescricao, List<String> sugestoes) {
        if (indice >= 0 && indice < sugestoes.size()) {
            sugestoes.set(indice, novaDescricao);
            JOptionPane.showMessageDialog(null, "Sugestão editada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }
}
