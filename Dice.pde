Die bob;
void setup()
{
	size(750,400);
	noLoop();
	textAlign(CENTER);
}
void draw()
{
	background((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	//your code here
	int sum=0;
	for(int x=(int)37.5;x<=765;x+=75){
		for(int y=(int)37.5;y<=300;y+=75){

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
void mousePressed()
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
	void roll()
	{
		numberDie=(int)(Math.random()*6)+1;
		
	}
	void show()
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
			        ellipse(x,y,12.5,12.5);
				}			    
			}
		}
		if(numberDie==5)
		{
			for(int x=myX-15; x<=myX+15;x+=30)
			{
			    for(int y=myY-15; y<=myY+15;y+=30)
			    {
			        ellipse(x,y,12.5,12.5);
				}			    
			}
			ellipse(myX,myY,12.5,12.5);
		}
		if(numberDie==4)
		{
			for(int x=myX-15; x<=myX+15;x+=30)
			{
			    for(int y=myY-15; y<=myY+15;y+=30)
			    {
			        ellipse(x,y,12.5,12.5);
				}			    
			}
		}
		if(numberDie==3)
		{
			ellipse(myX-15,myY-15,12.5,12.5);
			ellipse(myX,myY,12.5,12.5);
			ellipse(myX+15,myY+15,12.5,12.5);
		}
		if(numberDie==2)
		{
			ellipse(myX-15,myY-15,12.5,12.5);
			ellipse(myX+15,myY+15,12.5,12.5);
		}
		if(numberDie==1)
		{
			ellipse(myX,myY,12.5,12.5);
		}
	}
}
