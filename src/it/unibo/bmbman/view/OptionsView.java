package it.unibo.bmbman.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;

import com.sun.org.apache.bcel.internal.generic.LoadInstruction;

import it.unibo.bmbman.controller.MainMenuOption;
import it.unibo.bmbman.controller.OptionsList;
import it.unibo.bmbman.view.utilities.ImageLoader;

/**
 * View of the options menu.
 */
public class OptionsView {

    // private final Map<JButton, OptionsList > jbMap = new HashMap<>();
    // private final OptionsMenuController omc = new OptionMenuControllerImpl();
    private JPanel centerP; 
    private GridBagConstraints c;
    private JFrame f;
    private final MyGUIFactory gui;

    /**
     * Create options menu view.
     */
    public OptionsView() {
        this.gui = new MyGUIFactory();
        this.f = gui.createFrame();
        loadOptionsView();
    }

    /**
     * Customize the options view frame.
     */
    private void loadOptionsView() {
        f.setTitle("BOMBERMAN - Options Menu");
        f.setBackground(Color.black);
        loadPanels();
        loadLabels();
        loadButtons();
    }

/**
 * Used to loadLabels.
 */
    private void loadLabels() {
        for (int i = 0; i < OptionsList.values().length; i++) {
            final JLabel music = gui.createLabel(OptionsList.values()[i].toString());
            c.gridx = 0;
            c.gridy = i;
            centerP.add(music, c);
        }
    }

/**
 * Used to load panels.
 */
    private void loadPanels() {
        centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(Color.black);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.insets = new Insets(0, 50, 0, 0); 
        f.add(centerP, BorderLayout.CENTER);
    }

/**
 * Used to load buttons.
 */
    private void loadButtons() {
        final JButton returnB = gui.createReturnButton(this.f);
        returnB.addActionListener(e -> {
            this.f.setVisible(false);
            new MainMenuView().loadMainMenuView();
        });
        final JRadioButtonMenuItem musicOn = gui.createRadioButton("ON");
        c.gridx = 1;
        c.gridy = 0; 
        c.weightx = 0; //mi serve per spostare i tasti in fondo
        centerP.add(musicOn, c);
        //jbMap.put(musicB, OptionsList.values()[0]);
        final ButtonGroup music = new ButtonGroup();
        final JRadioButtonMenuItem musicOff = gui.createRadioButton("OFF");
        c.gridx = 2;
        c.gridy = 0;
        centerP.add(musicOff, c);
        music.add(musicOn);
        music.add(musicOff);
    }
    /**
     * Getter method.
     * @return the options view frame
     */
    public JFrame getFrame() {
        return this.f;
    }
}
