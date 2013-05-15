package edu.ucsb.cs56.projects.games.pacman;

/**
 A Pacman arcade game
 @author Brian Postma
 @author Dario Castellanos
 @version CS56 S13
 */

import javax.swing.JFrame;

import edu.ucsb.cs56.projects.games.pacman.Board;


public class PacMan extends JFrame
{

    /**
       Constructor for PacMan object       
     */
    public PacMan()
    {
	add(new Board());
	setTitle("Pacman");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(380, 420);
	setLocationRelativeTo(null);
	setVisible(true);
    }

    public static void main(String[] args){
	new PacMan();
    }
}
