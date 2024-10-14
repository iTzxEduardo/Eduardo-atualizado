package com.example.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.example.controllers.TecnicoController; // Certifique-se de que o controlador está implementado
import com.example.models.Tecnico; // Certifique-se de que a model está implementada

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicoController tecnicoController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;
    private JButton btnDeletarTecnico; // Novo botão para deletar técnico

    public TecnicosPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        tecnicoController = new TecnicoController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[]{
                "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        tecnicoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tecnicoTable); // Aqui adiciona a JTable ao JScrollPane
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Atualizar");
        btnDeletarTecnico = new JButton("Deletar");

        // Estilizando os botões
        estilizarBotao(btnCadastrarTecnico);
        estilizarBotao(btnSalvarAlteracoes);
        estilizarBotao(btnDeletarTecnico);

        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        painelInferior.add(btnDeletarTecnico);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Adicionando ActionListeners para os botões
        addActionListeners();
        carregarTecnicos(); // Carregar técnicos na inicialização
    }

    private void estilizarBotao(JButton button) {
        button.setBackground(new Color(70, 130, 180)); // Azul
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }

    private void carregarTecnicos() {
        // Recupera a lista de técnicos e preenche a tabela
        List<Tecnico> tecnicos = tecnicoController.readTecnicos();
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                    tecnico.getId(),
                    tecnico.getNome(),
                    tecnico.getEspecialidade(),
                    tecnico.getDisponibilidade()
            });
        }
    }

    private void addActionListeners() {
        // ActionListener para o botão "Cadastrar"
        btnCadastrarTecnico.addActionListener(e -> abrirDialogCadastro());

        // ActionListener para o botão "Salvar"
        btnSalvarAlteracoes.addActionListener(e -> editarTecnico());

        // ActionListener para o botão "Deletar"
        btnDeletarTecnico.addActionListener(e -> deletarTecnico());
    }

    private void abrirDialogCadastro() {
        JDialog dialog = new JDialog((JDialog) null, "Cadastrar Novo Técnico", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(0, 2));

        JTextField txtNome = new JTextField();
        JTextField txtEspecialidade = new JTextField();
        JTextField txtDisponibilidade = new JTextField();

        dialog.add(new JLabel("Nome:"));
        dialog.add(txtNome);
        dialog.add(new JLabel("Especialidade:"));
        dialog.add(txtEspecialidade);
        dialog.add(new JLabel("Disponibilidade:"));
        dialog.add(txtDisponibilidade);

        JButton btnSubmit = new JButton("Cadastrar");
        dialog.add(btnSubmit);

        btnSubmit.addActionListener(ev -> {
            try {
                String nome = txtNome.getText();
                String especialidade = txtEspecialidade.getText();
                String disponibilidade = txtDisponibilidade.getText();

                Tecnico novoTecnico = new Tecnico(null, nome, especialidade, disponibilidade);
                Tecnico tecnicoCriado = tecnicoController.createTecnico(novoTecnico);

                if (tecnicoCriado != null) {
                    tableModel.addRow(new Object[]{
                            tecnicoCriado.getId(),
                            nome,
                            especialidade,
                            disponibilidade
                    });
                    JOptionPane.showMessageDialog(dialog, "Técnico cadastrado com sucesso!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar técnico.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
            }
        });

        dialog.setVisible(true);
    }

    private void editarTecnico() {
        int selectedRow = tecnicoTable.getSelectedRow();
        if (selectedRow != -1) {
            JDialog dialog = new JDialog((JDialog) null, "Editar Técnico", true);
            dialog.setSize(400, 400);
            dialog.setLayout(new GridLayout(0, 2));

            String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
            String nome = (String) tableModel.getValueAt(selectedRow, 1);
            String especialidade = (String) tableModel.getValueAt(selectedRow, 2);
            String disponibilidade = (String) tableModel.getValueAt(selectedRow, 3);

            JTextField txtNome = new JTextField(nome);
            JTextField txtEspecialidade = new JTextField(especialidade);
            JTextField txtDisponibilidade = new JTextField(disponibilidade);

            dialog.add(new JLabel("Nome:"));
            dialog.add(txtNome);
            dialog.add(new JLabel("Especialidade:"));
            dialog.add(txtEspecialidade);
            dialog.add(new JLabel("Disponibilidade:"));
            dialog.add(txtDisponibilidade);

            JButton btnSubmit = new JButton("Salvar");
            dialog.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                try {
                    String newNome = txtNome.getText();
                    String newEspecialidade = txtEspecialidade.getText();
                    String newDisponibilidade = txtDisponibilidade.getText();

                    Tecnico tecnicoAtualizado = new Tecnico(id, newNome, newEspecialidade, newDisponibilidade);
                    tecnicoController.updateTecnico(tecnicoAtualizado);

                    JOptionPane.showMessageDialog(dialog, "Alterações salvas com sucesso!");

                    tableModel.setValueAt(newNome, selectedRow, 1);
                    tableModel.setValueAt(newEspecialidade, selectedRow, 2);
                    tableModel.setValueAt(newDisponibilidade, selectedRow, 3);

                    dialog.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
                }
            });

            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um técnico para salvar alterações.");
        }
    }

    private void deletarTecnico() {
        int selectedRow = tecnicoTable.getSelectedRow();
        if (selectedRow != -1) {
            String[] options = {"Sim", "Não"};
            int confirm = JOptionPane.showOptionDialog(
                    this,
                    "Tem certeza que deseja deletar este técnico?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[1]
            );

            if (confirm == 0) { // 0 corresponde a "Sim"
                String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));
                tecnicoController.deleteTecnico(id);
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Técnico deletado com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um técnico para deletar.");
        }
    }
}
