package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SistemaManutencaoGUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel painelMaquinas;
    private JPanel painelManutencao;
    private JPanel painelFalhas;
    private JPanel painelTecnicos;

    public SistemaManutencaoGUI() {
        super("Sistema de Manutenção");
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(800, 600)); // Tamanho mínimo da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // Inicialização dos paineis
        painelMaquinas = new MaquinasPanel();
        painelManutencao = new ManutencaoPanel();
        painelFalhas = new FalhasPanel();
        painelTecnicos = new TecnicosPanel();

        // Criar o JTabbedPane
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Máquinas", painelMaquinas);
        tabbedPane.add("Manutenções", painelManutencao);
        tabbedPane.add("Falhas", painelFalhas);
        tabbedPane.add("Técnicos", painelTecnicos);

        this.add(tabbedPane, BorderLayout.CENTER);
        
        // Adicionar um menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));
        menuArquivo.add(itemSair);
        menuBar.add(menuArquivo);
        this.setJMenuBar(menuBar);
        
        // Adicionar um listener para fechamento
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(SistemaManutencaoGUI.this,
                        "Deseja realmente sair?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaManutencaoGUI gui = new SistemaManutencaoGUI();
            gui.setVisible(true);
        });
    }
}
