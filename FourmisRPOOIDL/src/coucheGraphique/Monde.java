package coucheGraphique;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Monde extends JPanel {
	private static final long serialVersionUID = 1L;
	private List<Transformateur> drawables = new LinkedList<Transformateur>();
	protected boolean TableauFeromones[][];
	String name = "";
	
	public Monde(String name) {
		this.name = name;
	}
	
	public List<Transformateur> contents() {
		return drawables;
	}
	
	public void open() {
		JFrame frame = new JFrame(name);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(wa);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		initialiserTableau();
		requestFocus();
		
	}
	private void initialiserTableau(){
		this.TableauFeromones = new boolean[this.getWidth()][this.getHeight()];
		for(int i=0;i<this.getWidth();i++)
			for(int j=0;j<this.getHeight();j++)
				TableauFeromones[i][j]=false;
	}
     public void add(Transformateur d) {
        drawables.add(d);
        d.setWorld(this);
     }

     public void remove(Transformateur d) {
    	d.setWorld(null);
        drawables.remove(d);
     }

    public void paint(Graphics g) {
        super.paint(g);
        for (Iterator<Transformateur> iter = drawables.iterator(); iter.hasNext();) {
            iter.next().draw(g);
        }
    }
    
    public void clear() {
        for (Iterator<Transformateur> iter = drawables.iterator(); iter.hasNext();) {
            iter.next().setWorld(null);
        }
        drawables.clear();
     }

}