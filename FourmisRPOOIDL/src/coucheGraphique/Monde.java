package coucheGraphique;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Monde extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private List<Transformateur> drawables = new LinkedList<Transformateur>();
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
		frame.addMouseListener(this);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		requestFocus();
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
/*		if(this.drawables.get(0).contains(this.getMousePosition())){
			text = new Rect(Color.WHITE, this.getMousePosition(),new Dimension(50, 50));
			this.drawables.add(text);
		}*/
	}

	@Override
	public void mouseExited(MouseEvent e) {
	/*	if(!this.drawables.get(0).contains(this.getMousePosition())&&this.drawables.contains(text))
			this.drawables.remove(text);*/
	}

}