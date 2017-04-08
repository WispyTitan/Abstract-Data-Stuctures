package dataStructures;

import java.awt.Graphics;

/**
 * Extends the Stack class for graphical to output a visual version of the stack. 
 * @author Benjamin Wilson
 *
 */
public class StackGraphics extends Stack {
	//private String stackItemString;
	private boolean isFirstItem;
	
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
	 * Builds and paints stack items.
	 */
	public void paintStack(Graphics g) {
		assembleStackBlocks(g);
	}

	/**
	 * Builds the stack with graphics.
	 */
	private void assembleStackBlocks(Graphics g) {
		buildStrings();
		setGraphicsCoordinates(240 ,480);
		isFirstItem = true;
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			if (isFirstItem) {
				drawTopItemFlag(g);
			}
			buildStackBlock(g);
			y = y + 30;
		}
	}

	/**
	 * Builds the block for each item in the stack.
	 */
	private void buildStackBlock(Graphics g) {
		buildBlock(g, x, y - getStackPixelHeight());
	}

	/**
	 * Checks if the item is the top item to place a indicator(top->) next to it. 
	 */
	private void drawTopItemFlag(Graphics g) {
			setBlockFlag("Top");
			drawFlag(g, x - 35, y + 22 - getStackPixelHeight());
			isFirstItem = false;
	}
	
	/**
	 * Returns the blocks y height * the size of the stack.
	 */
	private int getStackPixelHeight(){
		return 30 * getSize();
	}
}
