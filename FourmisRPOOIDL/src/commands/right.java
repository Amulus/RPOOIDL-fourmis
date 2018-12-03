package commands;

import graphicLayer.Morph;

public class right extends Command {

	public right(Morph target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveRight(80);
		
	}

	
}
