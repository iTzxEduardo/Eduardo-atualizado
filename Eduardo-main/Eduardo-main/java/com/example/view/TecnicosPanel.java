package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.TecnicoController; // Certifique-se de ter um controlador para Técnicos
import com.example.models.Tecnico;

public class TecnicosPanel extends JPanel {
    // ATRIBUTOS
    private TecnicoController tecnicoController; // Controlador para gerenciar técnicos
    private JTable tecnicosTable; // Tabela para exibir a lista de técnicos
    private DefaultTableModel tableModel; // Modelo da tabela
    private JButton btnSalvarAlteracoes; // Botão para salvar alterações
    private JButton btnCadastrarTecnico; // Botão para cadastrar novo técnico

    // Construtor
    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicoController = new TecnicoController(); // Inicializa o controlador

        // Define o modelo da tabela com os nomes das colunas
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);
        tecnicosTable = new JTable(tableModel);

        // Criar a tabela
        List<Tecnico> tecnicos = tecnicoController.headTecnicos(); // Obtém a lista de técnicos
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                tecnico.getId(),
                tecnico.getNome(),
                tecnico.getEspecialidade(),
                tecnico.getDisponibilidade()
            });
        }

        // Adiciona a tabela ao painel
        JScrollPane scrollPane = new JScrollPane(tecnicosTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões (ainda não implementadas)
    }
}
