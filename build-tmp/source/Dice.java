import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die bob;
public void setup()
{
	size(750,400);
	noLoop();
	textAlign(CENTER);
}
public void draw()
{
	background((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	//your code here
	int sum=0;
	for(int x=(int)37.5f;x<=765;x+=75){
		for(int y=(int)37.5f;y<=300;y+=75){

			bob= new Die(x,y);
			bob.roll();
			bob.show();
			if(bob.numberDie<7){
				sum=sum+bob.numberDie;
			}
		}
	}
	textAlign(CENTER);
	text("Total roll is "+ sum,375,390);
	
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{	
	int numberDie;
	int myX;
	int myY;
	
	//variable declarations here
	Die(int x, int y) //constructor
	{
		//variable initializations here
		
		myX= x;
		myY=y;

	}
	public void roll()
	{
		numberDie=(int)(Math.random()*6)+1;
		
	}
	public void show()
	{
		//your code here
		fill(255);
		rectMode(CENTER);
		rect(myX,myY,75,75,20);
		fill(0);
		if(numberDie==6)
		{
			for(int x=myX-15; x<=myX+15;x+=30)
			{
			    for(int y=myY-15; y<=myY+15;y+=15)
			    {
			        ellipse(x,y,12.5f,12.5f);
				}			    
			}
		}
		if(numberDie==5)
		{
			for(int x=myX-15; x<=myX+15;x+=30)
			{
			    for(int y=myY-15; y<=myY+15;y+=30)
			    {
			        ellipse(x,y,12.5f,12.5f);
				}			    
			}
			ellipse(myX,myY,12.5f,12.5f);
		}
		if(numberDie==4)
		{
			for(int x=myX-15; x<=myX+15;x+=30)
			{
			    for(int y=myY-15; y<=myY+15;y+=30)
			    {
			        ellipse(x,y,12.5f,12.5f);
				}			    
			}
		}
		if(numberDie==3)
		{
			ellipse(myX-15,myY-15,12.5f,12.5f);
			ellipse(myX,myY,12.5f,12.5f);
			ellipse(myX+15,myY+15,12.5f,12.5f);
		}
		if(numberDie==2)
		{
			ellipse(myX-15,myY-15,12.5f,12.5f);
			ellipse(myX+15,myY+15,12.5f,12.5f);
		}
		if(numberDie==1)
		{
			ellipse(myX,myY,12.5f,12.5f);
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
