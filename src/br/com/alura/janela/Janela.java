package br.com.alura.janela;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class Janela {
    private JFrame jframe = new JFrame();

    public Janela(int width, int height, String title, List<Map<String, String>> listaDeFilmes) {
        jframe.setTitle(title);
        jframe.setSize(width,height);
        jframe.setLocationRelativeTo(null);
        Conteudo(listaDeFilmes);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    public void Conteudo(List<Map<String, String>> listaDeFilmes) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Map<String, String> filme : listaDeFilmes) {
            String title = filme.get("title");
            String imageUrl = filme.get("image");
            String year = filme.get("year");
            String crew = filme.get("crew");

            JLabel titleLabel = new JLabel(title);
            JLabel yearLabel = new JLabel("Ano: " + year);
            JLabel crewLabel = new JLabel("Autor: " + crew);

            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(scaledImageIcon);

            JPanel moviePanel = new JPanel();
            moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));
            moviePanel.setPreferredSize(new Dimension(300, 250));
            moviePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
            moviePanel.add(titleLabel);
            moviePanel.add(imageLabel);
            moviePanel.add(yearLabel);
            moviePanel.add(crewLabel);

            panel.add(moviePanel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        jframe.add(scrollPane);
    }

    }

