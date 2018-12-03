package commands;

import java.awt.Color;

import graphicLayer.Morph;

public class color extends Command {

	public color(Morph target) {
		super(target);
	}

	@Override
	public void run() {
		this.target.setColor(new Color ((int) (Math.random() * 0x1000000)));
	}

}
