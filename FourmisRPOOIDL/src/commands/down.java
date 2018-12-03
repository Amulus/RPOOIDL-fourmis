package commands;

import graphicLayer.Morph;

public class down extends Command {

	public down(Morph target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveDown(80);
		
	}

}
