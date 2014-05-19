package piotrowski.jakub.java.games.kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener
{
	private static final long serialVersionUID = 438855577255416055L;
	private Robot robot;
	private Image image, character, background;
	private static Background bg1, bg2;
	private URL base;
	private Graphics second;
	
	@Override
	public void init()
	{
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
		
		base = getDocumentBase();
		character = getImage(base, "data/character.png");
		background = getImage(base, "data/background.png");
	}

	@Override
	public void start()
	{
		bg1 = new Background(0, 0);
		bg2 = new Background(2160, 0);
		
		robot = new Robot();
		
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop()
	{
		super.stop();
	}

	@Override
	public void destroy()
	{
		super.destroy();
	}

	@Override
	public void run()
	{
		while(true)
		{
			robot.update();
			bg1.update();
			bg2.update();
			repaint();
			try
			{
				Thread.sleep(17);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Graphics g)
	{
		if(image == null)
		{
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);
		
		g.drawImage(image, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
		g.drawImage(character, robot.getCenterX()-61, robot.getCenterY()-63, this);
	}

	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				System.out.println("Move up");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Move down");
				break;
			case KeyEvent.VK_LEFT:
				robot.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				robot.moveRight();
				break;
			case KeyEvent.VK_SPACE:
				robot.jump();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				System.out.println("Stop moving up");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Stop moving down");
				break;
			case KeyEvent.VK_LEFT:
				robot.stop();
				break;
			case KeyEvent.VK_RIGHT:
				robot.stop();
				break;
			case KeyEvent.VK_SPACE:
				System.out.println("Stop jumping");
				break;
		}
	}

	// Getters and Setters
	
	public static Background getBg1()
	{
		return bg1;
	}

	public static Background getBg2()
	{
		return bg2;
	}
}