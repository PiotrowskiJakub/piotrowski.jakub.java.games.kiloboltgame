package piotrowski.jakub.java.games.kiloboltgame;

public class Robot
{
	// Constants are Here
    final int JUMPSPEED = -15;
    final int MOVESPEED = 5;
    final int GROUND = 382;
    
	private int centerX = 100, centerY = GROUND;
	private boolean jumped = false;
	private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean ducked = false;
	private int speedX = 0, speedY = 1;
	
	private static Background bg1 = StartingClass.getBg1();                 
    private static Background bg2 = StartingClass.getBg2();
	
	public void update()
	{
		// Moves character or scrolls background accordingly
		if (speedX < 0)
            centerX += speedX;
        if (speedX == 0 || speedX < 0) 
        {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);
        }
        if (centerX <= 200 && speedX > 0)
            centerX += speedX;
        if (speedX > 0 && centerX > 200)
        {
            bg1.setSpeedX(-MOVESPEED);
            bg2.setSpeedX(-MOVESPEED);
        }
		
		// Updates Y position
		if(centerY + speedY >= GROUND)
			centerY = GROUND;
		else
			centerY += speedY;
		
		// Handles jumping
		if(jumped == true)
		{
			speedY++;
			
			if(centerY + speedY >= GROUND)
			{
				centerY = GROUND;
				speedY = 0;
				jumped = false;
			}
		}
		
		// Prevents going beyond X coordinate of 0
		if(centerX + speedX <= 60)
			centerX = 61;
	}
	
	public void moveRight()
	{
		if(ducked == false)
			speedX = MOVESPEED;
	}
	
	public void moveLeft()
	{
		if(ducked == false)
			speedX = -MOVESPEED;
	}
	
	public void stopRight()
	{
		setMovingRight(false);
		stop();
	}
	
	public void stopLeft()
	{
		setMovingLeft(false);
		stop();
	}
	
	public void stop()
	{
		if(isMovingRight() == false && isMovingLeft() == false)
			speedX = 0;
		
		if(isMovingRight() == false && isMovingLeft() == true)
			moveLeft();
		
		if(isMovingRight() == true && isMovingLeft() == false)
			moveRight();
	}
	
	public void jump()
	{
		if(jumped == false)
		{
			speedY = JUMPSPEED;
			jumped = true;
		}
	}

	// Getters and setters
	
	public int getCenterX()
	{
		return centerX;
	}

	public int getCenterY()
	{
		return centerY;
	}

	public boolean isJumped()
	{
		return jumped;
	}

	public void setJumped(boolean jumped)
	{
		this.jumped = jumped;
	}

	public boolean isMovingLeft()
	{
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft)
	{
		this.movingLeft = movingLeft;
	}

	public boolean isMovingRight()
	{
		return movingRight;
	}

	public void setMovingRight(boolean movingRight)
	{
		this.movingRight = movingRight;
	}

	public boolean isDucked()
	{
		return ducked;
	}

	public void setDucked(boolean ducked)
	{
		this.ducked = ducked;
	}

	public int getSpeedX()
	{
		return speedX;
	}

	public void setSpeedX(int speedX)
	{
		this.speedX = speedX;
	}

	public int getSpeedY()
	{
		return speedY;
	}

	public void setSpeedY(int speedY)
	{
		this.speedY = speedY;
	}

	public static Background getBg1()
	{
		return bg1;
	}

	public static void setBg1(Background bg1)
	{
		Robot.bg1 = bg1;
	}

	public static Background getBg2()
	{
		return bg2;
	}

	public static void setBg2(Background bg2)
	{
		Robot.bg2 = bg2;
	}

	public int getJUMPSPEED()
	{
		return JUMPSPEED;
	}

	public int getMOVESPEED()
	{
		return MOVESPEED;
	}

	public int getGROUND()
	{
		return GROUND;
	}

	public void setCenterX(int centerX)
	{
		this.centerX = centerX;
	}

	public void setCenterY(int centerY)
	{
		this.centerY = centerY;
	}
}