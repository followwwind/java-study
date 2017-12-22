package com.javase.gui.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author wind
 */
public class SetGridBagLayout {

    public SetGridBagLayout(){
        JFrame frame = new JFrame("GridBagLayout");

        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);

        JLabel faceLabel = new JLabel("face:");
        JComboBox<String> face = new JComboBox<>(new String[] { "serif", "sansSerif", "Monospaced",
                "Dialog", "DialogInput", });


        JLabel sizeLabel = new JLabel("Size:");
        JComboBox<String> size = new JComboBox<>(new String[] { "8", "10", "12", "15", "18", "24",
                "36", "48" });

        JCheckBox bold = new JCheckBox("Bold");


        JCheckBox italic = new JCheckBox("Italic");


        JTextArea sample = new JTextArea();
        sample.setText("The quick brown fox jump over the lazy dog.");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        frame.add(faceLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 100;
        gbc.weighty = 0;
        gbc.insets = new Insets(1,1,1,1);
        frame.add(face, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(sizeLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 100;
        gbc.weighty = 0;
        gbc.insets = new Insets(1,1,1,1);
        frame.add(size, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 100;
        gbc.weighty = 100;
        frame.add(bold, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 100;
        gbc.weighty = 100;
        frame.add(italic, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 100;
        gbc.weighty = 100;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(sample, gbc);



        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SetGridBagLayout();
    }
}
