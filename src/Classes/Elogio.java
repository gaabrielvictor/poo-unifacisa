package Classes;

import javax.swing.JOptionPane;
import java.util.List;

public class Elogio {

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

    // Função para apagar todas os Elogios
    public static void apagarTodosELogios(List<String> elogios) {
        if (!elogios.isEmpty()) {
            elogios.clear();
            JOptionPane.showMessageDialog(null, "Todas os Elogios foram apagadas com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não há Elogios para apagar.");
        }
    }

    // Função para apagar um Elogio específico pelo índice da lista
    public static void apagarElogio(int indice, List<String>  elogios) {
        if (indice >= 0 && indice <  elogios.size()) {
        	 elogios.remove(indice);
            JOptionPane.showMessageDialog(null, "Elogio apagado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
        
        
    }
    // Função para editar uma Reclamação específica pelo índice da lista
    
    public static void editarElogio(int indice, String novaDescricao, List<String> elogios) {
        if (indice >= 0 && indice < elogios.size()) {
            elogios.set(indice, novaDescricao);
            JOptionPane.showMessageDialog(null, "Elogio editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }
}
