package piotrowski.jakub.java.games.kiloboltgame;

public class Background
{
	private int bgX, bgY, speedX;

	public Background(int bgX, int bgY)
	{
		this.bgX = bgX;
		this.bgY = bgY;
		speedX = 0;
	}
	
	public void update()
	{
		bgX += speedX;
		
		if(bgX <= -2160)
			bgX += 4320;
	}

	// Getters and Setters
	
	public int getBgX()
	{
		return bgX;
	}

	public int getBgY()
	{
		return bgY;
	}

	public void setSpeedX(int speedX)
	{
		this.speedX = speedX;
	}
}
