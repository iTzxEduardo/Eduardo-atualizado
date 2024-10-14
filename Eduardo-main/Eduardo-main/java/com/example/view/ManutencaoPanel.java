package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.HistoricoManutencaoController; // Certifique-se de ter um controlador para Histórico de Manutenção
import com.example.models.HistoricoManutencao;

public class ManutencaoPanel extends JPanel {
    // ATRIBUTOS
    private HistoricoManutencaoController manutencaoController; // Controlador para gerenciar manutenções
    private JTable manutencaoTable; // Tabela para exibir o histórico de manutenções
    private DefaultTableModel tableModel; // Modelo da tabela
    private JButton btnSalvarAlteracoes; // Botão para salvar alterações
    private JButton btnCadastrarManutencao; // Botão para cadastrar nova manutenção

    // Construtor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new HistoricoManutencaoController(); // Inicializa o controlador

        // Define o modelo da tabela com os nomes das colunas
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0);
        manutencaoTable = new JTable(tableModel);

        // Criar a tabela
        List<HistoricoManutencao> manutenções = manutencaoController.headHistoricoManutencao(); // Obtém a lista de manutenções
        for (HistoricoManutencao manutencao : manutenções) {
            tableModel.addRow(new Object[]{
                manutencao.getId(),
                manutencao.getMaquinaId(),
                manutencao.getData(),
                manutencao.getTipo(),
                manutencao.getPecasTrocadas(),
                manutencao.getTempoDeParada(),
                manutencao.getTecnicoId(),
                manutencao.getObservacoes()
            });
        }

        // Adiciona a tabela ao painel
        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões (ainda não implementadas)
    }
}
