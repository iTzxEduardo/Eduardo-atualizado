package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    // ATRIBUTOS
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    // Construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Código", "Nome", "Modelo", "Fabricante", "Data de Aquisição", "Tempo de Vida", "Localização", "Detalhes", "Manual"
        }, 0);
        maquinasTable = new JTable(tableModel);

        // Criar a tabela
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getCodigo(),
                maquina.getNome(),
                maquina.getModelo(),
                maquina.getFabricante(),
                maquina.getDataAquisicao(),
                maquina.getTempoVidaEstimado(),
                maquina.getLocalizacao(),
                maquina.getDetalhes(),
                maquina.getManual()
            });
        }
        JScrollPane scrollPane = new JScrollPane(maquinasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        btnCadastrarMaquina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMaquina();
            }
        });

        btnSalvarAlteracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Salva todas as máquinas através do controlador
                    maquinaController.saveAllMaquinas();

                    // Exibe uma mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Todas as máquinas foram salvas com sucesso!");
                } catch (Exception ex) {
                    // Tratar exceções e mostrar mensagem de erro
                    JOptionPane.showMessageDialog(null, "Erro ao salvar máquinas: " + ex.getMessage());
                }
            }
        });
    }

    private void cadastrarMaquina() {
        // Criar um diálogo para coletar os dados da nova máquina
        JTextField nomeField = new JTextField();
        JTextField codigoField = new JTextField();
        JTextField fabricanteField = new JTextField();
        JTextField modeloField = new JTextField();
        JTextField detalhesField = new JTextField();
        JTextField localizacaoField = new JTextField();
        JTextField tempoVidaField = new JTextField();
        JTextField dataAquisicaoField = new JTextField(); // Novo campo
        JTextField manualField = new JTextField(); // Campo para o manual

        Object[] message = {
            "Código:", codigoField,
            "Nome:", nomeField,
            "Fabricante:", fabricanteField,
            "Modelo:", modeloField,
            "Data de Aquisição:", dataAquisicaoField,
            "Tempo de Vida Estimado:", tempoVidaField,
            "Localização:", localizacaoField,
            "Detalhes:", detalhesField,
            "Manual:", manualField // Adicionando o campo manual
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Cadastrar Máquina", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Captura os dados
            String codigo = codigoField.getText();
            String nome = nomeField.getText();
            String fabricante = fabricanteField.getText();
            String modelo = modeloField.getText();
            String detalhes = detalhesField.getText();
            String localizacao = localizacaoField.getText();
            int tempoVida = Integer.parseInt(tempoVidaField.getText());
            LocalDate dataAquisicao = LocalDate.parse(dataAquisicaoField.getText());
            String manual = manualField.getText(); // Capturando o valor do manual

            // Criar a nova máquina
            Maquina novaMaquina = new Maquina(null, codigo, nome, modelo, fabricante, dataAquisicao, tempoVida, localizacao, detalhes, manual); // Incluindo o manual

            // Salvar a máquina usando o controlador
            maquinaController.saveMaquina(novaMaquina);
            
            // Adicionar à tabela
            tableModel.addRow(new Object[]{
                novaMaquina.getId(), // Se a ID for gerada automaticamente
                novaMaquina.getCodigo(),
                novaMaquina.getNome(),
                novaMaquina.getModelo(),
                novaMaquina.getFabricante(),
                novaMaquina.getDataAquisicao(),
                novaMaquina.getTempoVidaEstimado(),
                novaMaquina.getLocalizacao(),
                novaMaquina.getDetalhes(),
                novaMaquina.getManual()
            });
        }
    }
}
