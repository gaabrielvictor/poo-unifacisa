package Classes;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Feedback {
    private static Map<String, String> codigoFeedback = new HashMap<>();

    // Função para adicionar a descrição à lista correspondente
    public static void adicionarFeedback(String descricao, List<String> lista) {
        String codigo = gerarCodigo();
        lista.add(descricao);
        codigoFeedback.put(codigo, descricao);
        JOptionPane.showMessageDialog(null, "Feedback adicionado com sucesso! Código: " + codigo);
    }

 // Função para listar os feedbacks de uma determinada categoria
    public static void listarFeedbacks(List<String> lista, String categoria) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há feedbacks para a categoria " + categoria);
            return;
        }

        StringBuilder feedbacks = new StringBuilder("Feedbacks de " + categoria + ":\n\n");
        for (int i = 0; i < lista.size(); i++) {
            String descricao = lista.get(i);
            String codigo = buscarCodigoPorDescricao(descricao);
            feedbacks.append("Código: ").append(codigo).append(" - ").append(descricao).append("\n");
        }
        JOptionPane.showMessageDialog(null, feedbacks.toString());
    }

    // Função para apagar todos os feedbacks de uma categoria
    public static void apagarTodosFeedbacks(List<String> lista, String categoria) {
        if (!lista.isEmpty()) {
            lista.clear();
            codigoFeedback.clear();
            JOptionPane.showMessageDialog(null, "Todos os(as) " + categoria + " foram apagados(as) com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não há " + categoria + " para apagar.");
        }
    }

    // Função para apagar um feedback específico pelo índice da lista
    public static void apagarFeedback(int indice, List<String> lista, String categoria) {
        if (indice >= 0 && indice < lista.size()) {
            String descricao = lista.get(indice);
            String codigo = buscarCodigoPorDescricao(descricao);
            lista.remove(indice);
            codigoFeedback.remove(codigo);
            JOptionPane.showMessageDialog(null, categoria + " apagado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }

 // Função para editar feedbacks
    public static void editarFeedback(List<String> reclamacoes, List<String> elogios, List<String> sugestoes, String categoria) {
        JOptionPane.showMessageDialog(null, "Você deseja editar " + categoria + ":");

        List<String> lista;
        switch (categoria) {
            case "Reclamações":
                lista = reclamacoes;
                break;
            case "Elogios":
                lista = elogios;
                break;
            case "Sugestões":
                lista = sugestoes;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Categoria inválida.");
                return;
        }

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há " + categoria + " para editar.");
            return;
        }

        int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do " + categoria + " que deseja editar:")) - 1;
        if (indice >= 0 && indice < lista.size()) {
            String descricaoAntiga = lista.get(indice);
            String codigo = buscarCodigoPorDescricao(descricaoAntiga);
            String novaDescricao = JOptionPane.showInputDialog(null, "Digite a nova descrição para o " + categoria + ":");
            lista.set(indice, novaDescricao);
            codigoFeedback.put(codigo, novaDescricao);
            JOptionPane.showMessageDialog(null, categoria + " editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
        }
    }

    // Função para buscar feedback por código
    public static void buscarFeedback(String codigo) {
        String descricao = codigoFeedback.get(codigo);
        if (descricao != null) {
            JOptionPane.showMessageDialog(null, "Código: " + codigo + "\nDescrição: " + descricao);
        } else {
            JOptionPane.showMessageDialog(null, "Feedback não encontrado com o código fornecido.");
        }
    }

    // Função para gerar um código único para cada feedback
    private static String gerarCodigo() {
        return "" + (codigoFeedback.size() + 1);
    }

    // Função para buscar o código de um feedback pela descrição
    private static String buscarCodigoPorDescricao(String descricao) {
        for (Map.Entry<String, String> entry : codigoFeedback.entrySet()) {
            if (entry.getValue().equals(descricao)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
