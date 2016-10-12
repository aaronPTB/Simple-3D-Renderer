import java.awt.*;
import java.util.ArrayList;

public class Workspace extends java.applet.Applet {
    
    /** Initialization method that will be called after the applet is loaded
     *  into the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }

    public void paint(Graphics g)
    {
    	//setting Workspace parameters
    	double sleepTime   = .03; //sleep time in seconds
    	double elapsedTime = 0.0; //total elapsed game time
    	
    	//setting rendering parameters
		Graphics2D g2 = (Graphics2D) g;	  
		g2.setStroke(new BasicStroke(5));
   		
   		//creating camera
   		Observer camera = new Observer();
   		
   		//creating part
    	TriangularPyramid part = new TriangularPyramid(new Vector3(0, 0, 5), 2.0);	
    	
    	while (true)
    	{
    		try
    		{
		      	//modifying the part
		      	
		      	//rotates the model .03 radians each frame update around the Y axis
				part.rotate(new Vector3(0,1,0),.03);
				
				//moves the object back and forth using a sine wave.
				part.move(new Vector3(0,0,Math.sin(elapsedTime)/5));
				
				//Drawing the part
		        ArrayList<ScreenCoordinate[]> renderPoints = camera.lookAt(part);
		        for (ScreenCoordinate[] points : renderPoints)
		        {
		         	g2.drawLine(points[0].getX(), points[0].getY(), points[1].getX(), points[1].getY()); 
		        }
		
				//Waiting then clearing the screen
		    	Thread.sleep((int) (sleepTime * 1000));
		        g.clearRect(0, 0, 500, 500);
		        
		        //updating Workspace time
		        elapsedTime += sleepTime;
    		}
    		catch(InterruptedException e)
    		{	
    			System.out.println(e);
    		}
    	}
    }
}