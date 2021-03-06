package dataStructures;

import java.awt.Graphics;

/**
 * Extends the Stack class for graphical to output a visual version of the stack. 
 * @author Benjamin Wilson
 *
 */
public class StackGraphics extends Stack {
	protected boolean drawFlags;
	
	protected static int x;
	protected static int y;

	/**
	 * Sets coordinates using x,y.
	 * @param y 
	 * @param x 
	 */
	private void setGraphicsCoordinates(int x, int y) {
		StackGraphics.x = x;
		StackGraphics.y = y;
	}

	/**
	 *  Paints items in the structure.
	 */
	public void paint(Graphics g) {
		assembleBlocks(g);
	}

	/**
	 * Builds the stack with graphics.
	 */
	protected void assembleBlocks(Graphics g) {
		buildStrings();
		setGraphicsCoordinates(240 ,480);
		drawFlags = true;
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			if (drawFlags) {
				drawTopItemFlag(g);
			}
			buildBlock(g);
			y = y + 30;
		}
	}

	/**
	 * Builds the structure with graphics.
	 */
	protected void buildBlock(Graphics g) {
		buildBlock(g, x, yPixelHeightOffset());
	}
	/**
	 * Checks if the item is the "Top" item to place a indicator(Top->) next to it. 
	 */
	private void drawTopItemFlag(Graphics g) {
			setBlockFlag("Top");
			drawFlag(g, x - 35, y + 22 - getPixelHeight());
			drawFlags = false;
	}
	

	protected int yPixelHeightOffset() {
		return y - getPixelHeight();
	}
	
	/**
	 * Returns the blocks y height * the size of the Structure.
	 */
	protected int getPixelHeight(){
		return 30 * getSize();
	}
}
