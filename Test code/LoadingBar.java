//LoadingBar class/module created by yPanda, Group 2 of SWENG project, Department of Electronics, University of York
//Version 1.1
//Code written by: Tautvydas Mickus
//Code tested by: Raymond Wade/Georgy Markin and Tautvydas Mickus
//Code approved by: Robin Miller

//This code was made on Contract for Group 2 Pocket Shambles.
//This class extends View class to supply method to draw a loading bar to a canvas using vector graphics on Android 2.2 or later.
//There are two constructors:
//LoadingBar(Context context, int inpercents, int inColourHex,  int inHeight) where context is context in which loading bar is put in, inpercents is the setting for percentage to show, inColourHex is color value #AARRGGBB, inHeight is the height of loading bar
//LoadingBar(Context context, int inpercents, int inColourHex,  int inHeight, int inWidth) in the need of adjusting width manually inWidth value can be passed in as well
//LoadingBar(Context context, int inColourHex,  int inHeight) where percents are set to default 0
//Methods:
//drawBar(Canvas canvas) 
//setColourAARRGGBB(int inColourHex) 


//Imported Libraries
package learn.learn.learn;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

//Code

public class LoadingBar extends View {
    private Paint paint = new Paint(); 										//variable to hold colour
    private int percents;													//variable to hold percentage value of Loading Bar
    private int height,width;												//variables to hold height and max width of loading bar
    private boolean widthInput;												//variable to let class know if width was inputted or canvas widht should be taken

    //Constructors as defined in the top of code.
    public LoadingBar(Context context, int inColourHex,  int inHeight) {
        super(context);
        height = inHeight;								//set height
        widthInput=false;								//set that no width was inputted
        percents = 0;									//set percentage to default 0
        this.setColourIntAARRGGBB(inColourHex);  			//set colour from inputted hex int
    }    
    public LoadingBar(Context context, String inColourString,  int inHeight) {
        super(context);
        height = inHeight;								//set height
        widthInput=false;								//set that no width was inputted
        percents = 0;									//set percentage to default 0
        this.setColourStringRRGGBB(inColourString);  			//set colour from inputted hex int
    }    
    public LoadingBar(Context context, int inpercents, int inColourHex,  int inHeight) {
        super(context);
        height = inHeight;								//set height
        widthInput=false;								//set that no width was inputted
        percents = inpercents;							//set percents
        this.setColourIntAARRGGBB(inColourHex);  			//set colour
    }
    public LoadingBar(Context context, int inpercents, String inColourString,  int inHeight) {
        super(context);
        height = inHeight;								//set height
        widthInput=false;								//set that no width was inputted
        percents = inpercents;							//set percents
        this.setColourStringRRGGBB(inColourString);  			//set colour
    }
    public LoadingBar(Context context, int inpercents, int inColourHex,  int inHeight, int inWidth) {
        super(context);
        height = inHeight;								//set height
        percents = inpercents;							//set percents
        width=inWidth;									//set width
        if(inWidth>=0)									//check if inputted width is valid. In some cases using automatic get functions to get width of layout if its "fill_parent" it gives -1 which can cause error later
        widthInput=true;								//if its valid let program know it was inputted
        else widthInput=false;							//else assume it was not inputted and use default from canvas
        this.setColourIntAARRGGBB(inColourHex);   			//set colour
    }
    public LoadingBar(Context context, int inpercents, String inColourString,  int inHeight, int inWidth) {
        super(context);
        height = inHeight;								//set height
        percents = inpercents;							//set percents
        width=inWidth;									//set width
        if(inWidth>=0)									//check if inputted width is valid. In some cases using automatic get functions to get width of layout if its "fill_parent" it gives -1 which can cause error later
        widthInput=true;								//if its valid let program know it was inputted
        else widthInput=false;							//else assume it was not inputted and use default from canvas
        this.setColourStringRRGGBB(inColourString);   			//set colour
    }

    
    //Method that draws the bar
    @Override
    public void onDraw(Canvas canvas) {
    	        if(widthInput)
    	        	canvas.drawRect(0, 0, (int)(width*percents/100), height, paint);					//if width was inputted draw percentage of bar from inputted value
    	        else
    	        	canvas.drawRect(0, 0, (int)(canvas.getWidth()*percents/100), height, paint);		//else draw the bar using canvas width

    }
    
    //Method that sets the percent value and refreshes drawing
    public void drawBar(int inpercent){
    	percents=inpercent;						//simply change percents to one inputted
    	if(percents>100)percents=100;
    	this.invalidate();						//make sure onDraw is called
    }
    
    //Method to set value of colour using int (inputted as hexidecimal)
    public void setColourIntAARRGGBB(int inColourHex){
    	
        String colourString, colourAlphaString, colourRedString, colourGreenString, colourBlueString;	//variables used for separation of integer to 4 integer values of Alpha, Red, Green and Blue
        int colourAlpha, colourRed, colourGreen, colourBlue;											//
        
    	colourString=Integer.toHexString(inColourHex);													//convert input integer to hex string	
    	while(true){if(colourString.length()==8) break; else colourString="0"+colourString;}
    	System.out.println("hex string is:  " + colourString);											// if hex string is shorter then 8 bytes , add addition zeros in front
    	
    	colourAlphaString	=""+colourString.charAt(0)+colourString.charAt(1);							//separate each value for Alpha, Red, Green, Blue
    	colourRedString		=""+colourString.charAt(2)+colourString.charAt(3);
    	colourGreenString	=""+colourString.charAt(4)+colourString.charAt(5);
    	colourBlueString	=""+colourString.charAt(6)+colourString.charAt(7);
    	colourAlpha	= Integer.parseInt(colourAlphaString, 16);											//get integer values back from Hex values for each colour		
    	colourRed	= Integer.parseInt(colourRedString, 16);
    	colourGreen	= Integer.parseInt(colourGreenString, 16);
    	colourBlue	= Integer.parseInt(colourBlueString, 16);
        paint.setARGB(colourAlpha, colourRed, colourGreen, colourBlue);									//set colour using Alpha, Red, Green and Blue values
       
        
        //lines below used for testing and debugging
    	//System.out.println("Alpha: " + colourAlphaString +"  Red: " + colourRedString + "  Green: " + colourGreenString +"  Blue: " + colourBlueString);
    	//System.out.println("Alpha: " + colourAlpha +"  Red: " + colourRed + "  Green: " + colourGreen +"  Blue: " + colourBlue);   
    }


//Method to set colour using string hex RRGGBB
    public void setColourStringRRGGBB(String colourString){
	    String colourRedString, colourGreenString, colourBlueString;	//variables used for separation of integer to 4 integer values of Alpha, Red, Green and Blue
	    int colourRed, colourGreen, colourBlue;													//variables for colours
	
																										//separate each value for Red, Green, Blue
		colourRedString		=""+colourString.charAt(0)+colourString.charAt(1);
		colourGreenString	=""+colourString.charAt(2)+colourString.charAt(3);
		colourBlueString	=""+colourString.charAt(4)+colourString.charAt(5);
																										//get integer values back from Hex values for each colour		
		colourRed	= Integer.parseInt(colourRedString, 16);
		colourGreen	= Integer.parseInt(colourGreenString, 16);
		colourBlue	= Integer.parseInt(colourBlueString, 16);
	    paint.setARGB(255,colourRed, colourGreen, colourBlue);									//set colour using Alpha, Red, Green and Blue values

}

}
