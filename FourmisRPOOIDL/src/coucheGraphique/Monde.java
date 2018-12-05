package coucheGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import proie.Proie;


public class Monde extends JPanel {
	private static final long serialVersionUID = 1L;
	private List<Fourmi> fourmies = new ArrayList<Fourmi>();
	private List<Proie> proies = new ArrayList<Proie>();
	private List<Transformateur> dessins = new LinkedList<Transformateur>();
	private Pheromone TableauPheromones[][];
	String name = "";
	
	public Monde(String name) {
		this.name = name;
	}
	
	public List<Fourmi> getFourmies() {
		return fourmies;
	}
	public List<Proie>  getProies() {
		return proies;
	}
	
	public void open() {
		JFrame frame = new JFrame(name);
		frame.setResizable(false);
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
		this.setTableauFeromones(new Pheromone[this.getWidth()][this.getHeight()]);
		for(int i=0;i<this.getWidth();i++)
			for(int j=0;j<this.getHeight();j++)
				getTableauFeromones()[i][j]=new Pheromone();
	}
     public void add(Fourmi fourmie) {
    	 fourmies.add(fourmie);
    	 Rect carre = new Rect(Color.RED,fourmie.getCalculDeplacement().getPoint(),fourmie.getCalculDeplacement().getSize(),fourmie);
    	 dessins.add(carre);
    	 carre.setWorld(this);
     }

     public void remove(Fourmi fourmie) {
    	boolean trouve = find(fourmie);
    	if(trouve){
    		fourmies.remove(fourmie);
    	}
     }
     public void add(Proie proie) {
    	 proies.add(proie);
    	 Rect carre = new Rect(Color.black,proie.getPoint(),proie.getSize(),proie);
    	 dessins.add(carre);
    	 carre.setWorld(this);
     }

     public void remove(Proie proie) {
    	Rect carre = find(proie);
    	if(carre !=null){
    		carre.setWorld(null);
    		proies.remove(proie);
    	}
     }

    private boolean find(Fourmi fourmie) {
    	for (int i=1; i < dessins.size();i++){
    		if(dessins.get(i).getClass() != Rect.class) return false;
    		if(((Rect)dessins.get(i)).object.equals(fourmie)){
    			Rect carre =  ((Rect)dessins.get(i));
        		carre.setWorld(null);
        		dessins.remove(i);
    			return true;
    		}
    	}
		return false;
	}
    private Rect find(Proie proie) {
    	for (int i=1; i < dessins.size();i++)
    		if(((Rect)dessins.get(i)).object.equals(proie))
    			return ((Rect)dessins.get(i));
		return null;
	}

	public void paint(Graphics g) {
        super.paint(g);
        for (Iterator<Transformateur> iter = dessins.iterator(); iter.hasNext();) {
            iter.next().draw(g);
        }
    }
    
    public void clear() {
        for (Iterator<Transformateur> iter = dessins.iterator(); iter.hasNext();) {
            iter.next().setWorld(null);
        }
        fourmies.clear();
     }

	public Pheromone[][] getTableauFeromones() {
		return TableauPheromones;
	}

	public void setTableauFeromones(Pheromone tableauFeromones[][]) {
		TableauPheromones = tableauFeromones;
	}

	public int getPheromoneChasse(int xPoint, int yPoint) {
		return TableauPheromones[xPoint][yPoint].avoirPheromoneChasse();
	}
	public int getPheromoneRetour(int xPoint, int yPoint) {
		return TableauPheromones[xPoint][yPoint].avoirPheromoneRetour();
	}

	public void uptade() {
		for (int i =0; i<dessins.size();i++ ) {
			dessins.get(i).Update();
		}
		Transformateur test = dessins.get(0);
		dessins.set(0, dessins.get(dessins.size()-1));
		dessins.set(dessins.size()-1,test);
	}

	public void add(Fourmilliere colonie) {
		Ovale fourmilliere = new Ovale(new Color(150, 50, 0), new Point(250, 250), new Dimension(10, 10), true);
		dessins.add(fourmilliere);
		fourmilliere.setWorld(this);
	}

	public void ajoutPheromoneRetour(int xPoint, int yPoint) {
		TableauPheromones[xPoint][yPoint].ajouterPheromoneRetour();
	}
	public void ajoutPheromoneChasse(int xPoint, int yPoint,int quantite) {
		TableauPheromones[xPoint][yPoint].ajouterPheromoneChasse(quantite);
	}
	public void afficherPheromones(){
		for(int i=0;i<TableauPheromones.length;i++){
			for(int j=0;j<TableauPheromones.length;j++)
				System.out.print("| "+TableauPheromones[i][j].avoirPheromoneRetour());
			System.out.println("");
		}
	}


}