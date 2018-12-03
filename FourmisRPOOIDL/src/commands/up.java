package commands;

import graphicLayer.Morph;

public class up extends Command {

	public up(Morph target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveUp(80);
		
	}

}
