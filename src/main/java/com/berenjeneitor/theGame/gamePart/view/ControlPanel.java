package com.berenjeneitor.theGame.gamePart.view;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final JButton play;
    private final JButton pause;
    private final JSlider initialBalls;
    public ControlPanel(GameView father) {
        play = new JButton("Start");
        pause = new JButton("Pause");

        play.addActionListener(father);
        pause.addActionListener(father);
        initialBalls = new JSlider(1,15,1);
        initialBalls.setMajorTickSpacing(2);
        initialBalls.setMinorTickSpacing(1);
        initialBalls.setPaintTicks(true);
        initialBalls.setPaintLabels(true);
        JLabel initialBallsLabel = new JLabel("Initial Balls:");

        // layout distribution
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //play button constraints
        constraints.weightx = 0;
        constraints.weighty= 0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(0,5,2,5);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.BOTH;

        this.add(play, constraints);

        //stop button constraints
        constraints.gridx = 1;

        this.add(pause, constraints);

        //initial balls label constraints
        constraints.gridx = 2;
        this.add(initialBallsLabel, constraints);
        //slider constraints

        constraints.gridx = 3;
        constraints.weightx = 1;
        constraints.fill= GridBagConstraints.BOTH;
        this.add(initialBalls, constraints);

    }
    public int getSliderValue(){
        return initialBalls.getValue();
    }
}
