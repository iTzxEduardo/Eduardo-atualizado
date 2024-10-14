package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
    // ATRIBUTOS
    private ManutencaoController manutencaoController;
    private JTable manutencaosTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarManutencao;

    // Construtor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "MaquinaID", "Data" ,"Tipo", "Peças Trocadas", "Tempo de Parada", "Tecnico", "Observações"
        }, 0);
        manutencaosTable = new JTable(tableModel);

        // criar a tabela
        List<Manutencao> manutencaos = manutencaoController.readManutencoes();
        for (Manutencao manutencao : manutencaos) {
            tableModel.addRow(new Object[] {
                    manutencao.getId(),
                    manutencao.getMaquinaId(),
                    manutencao.getData(),
                    manutencao.getTipo(),
                    manutencao.getPecasTrocadas(),
                    manutencao.getTempoParada(),
                    manutencao.getTecnicoId(),
                    manutencao.getObservacao()
            });
        }
        JScrollPane scrollPane = new JScrollPane(manutencaosTable);
        this.add(scrollPane,BorderLayout.CENTER);

        //adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior,BorderLayout.SOUTH);

        //Criar as ActionListener para Botões
        btnCadastrarManutencao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //criar o método de Cadastrar
                //pegar as informações em um formulário
                // gravar o objeto de maquinas
                // chamar p controller
            }
            
        });
        //metodo para atualizar info
        btnSalvarAlteracoes.addActionListener(e-> {
            
        });
        

    }
}
