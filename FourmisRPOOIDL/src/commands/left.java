package commands;

import graphicLayer.Morph;

public class left extends Command {

	public left(Morph target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.moveLeft(80);
		
	}

}
