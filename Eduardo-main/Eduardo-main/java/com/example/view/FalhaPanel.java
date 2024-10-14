package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.FalhaController; // Certifique-se de ter um controlador para Falha
import com.example.models.Falha;

public class FalhaPanel extends JPanel {
    // ATRIBUTOS
    private FalhaController falhaController; // Controlador para gerenciar falhas
    private JTable falhasTable;               // Tabela para exibir falhas
    private DefaultTableModel tableModel;     // Modelo da tabela
    private JButton btnSalvarAlteracoes;      // Botão para salvar alterações
    private JButton btnCadastrarFalha;        // Botão para cadastrar nova falha

    // Construtor
    public FalhaPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController(); // Inicializa o controlador

        // Define o modelo da tabela com os nomes das colunas
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Máquina ID", "Data", "Problema", "Prioridade", "Operador"
        }, 0);
        falhasTable = new JTable(tableModel);

        // Criar a tabela
        List<Falha> falhas = falhaController.headFalhas(); // Obtém a lista de falhas
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[]{
                falha.getId(),
                falha.getMaquinaId(),
                falha.getData(),
                falha.getPoblema(),
                falha.getPrioridade(),
                falha.getOperador()
            });
        }

        // Adiciona a tabela ao painel
        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões (ainda não implementadas)
    }
}
