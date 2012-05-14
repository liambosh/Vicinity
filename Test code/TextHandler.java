//TextHandler class/module created by yPanda, Group 2 of SWENG project, Department of Electronics, University of York
//Version 1.1
//Code written by: Tautvydas Mickus
//Code tested by: Raymond Wade/Georgy Markin and Tautvydas Mickus
//Code approved by: Robin Miller

//This code was made on Contract for Group 2 Pocket Shambles.
//This Class creates and Android Textview object from given string and parameters. (If parameters not given it sets them to default)

//There are several contructors
//TextHandler(Context context, String inputText) where context is set to context (can be used as this) and inputText is the InputString
//TextHandler(Context context, String inputText, int size) where additionally size is set
//TextHandler(Context context, String inputText, int size, int inColourHex) where additionally colour is set by using int hex #AARRGGBB
//TextHandler(Context context, String inputText, int size, String colourString) where additionally colour is set by using string hex RRGGBB
//Methods:
//setText(String inputText)
//setInTextStyle(char tag, int start, int end)
//setColourIntAARRGGBB(int inColourHex)
//setColourStringRRGGBB(String colourString)
//setSize(int size)
//getTextViewObject()

package ypanda.york.contract.texthandler;

//Imported Libraries
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.widget.TextView;

public class TextHandler extends TextView {
	TextView text;							//main variable that holds TextView object

	
	//Constructors for different inputs. If inputs are not inputted they are set to default.
	public TextHandler(Context context, String inputText) {           
		super(context);
		text=new TextView(context);				//all setting for textview object the name of methods are self explanatory
		text.setClickable(true);
		text.setSelectAllOnFocus(true);
		text.setTypeface(null, Typeface.NORMAL);
		text.setHorizontallyScrolling(false);
		text.setText(inputText);
	}
	public TextHandler(Context context, String inputText, int size) {
		super(context);
		text=new TextView(context);					//all setting for textview object the name of methods are self explanatory
		text.setClickable(true);
		text.setSelectAllOnFocus(true);
		text.setTypeface(null, Typeface.NORMAL);
		text.setHorizontallyScrolling(false);
		this.setSize(size);
		text.setText(inputText);
		
	}
	public TextHandler(Context context, String inputText, int size, int inColourHex) {
		super(context);
		text=new TextView(context);					//all setting for textview object the name of methods are self explanatory
		text.setClickable(true);
		text.setSelectAllOnFocus(true);
		text.setTypeface(null, Typeface.NORMAL);
		text.setHorizontallyScrolling(false);
		this.setSize(size);
		this.setColourIntAARRGGBB(inColourHex);
		text.setText(inputText);
		
	}
	public TextHandler(Context context, String inputText, int size, String inColourString) {
		super(context);
		text=new TextView(context);					//all setting for textview object the name of methods are self explanatory
		text.setClickable(true);
		text.setSelectAllOnFocus(true);
		text.setTypeface(null, Typeface.NORMAL);
		text.setHorizontallyScrolling(false);
		this.setSize(size);
		this.setColourStringRRGGBB(inColourString);
		text.setText(inputText);
		
	}
	
	//Method to set Text in case user wants to change text inside string
	public void setText(String inputText){
		text.setText(inputText);
	}
	
	//Method to set text styles by using tag character,  start and end integers
	public void setInTextStyle(char tag, int start, int end){
		SpannableString textString;
		textString=  new SpannableString(text.getText());
		if((textString.length()>=end)&&(end>start)){										//Check the tag chosen and sets the segment of String to the chosen tag using start and end values of the string. Flag integer is always set to 0.
			if(tag=='u')
					textString.setSpan(new UnderlineSpan(), start, end, 0);
			else if(tag=='b')
					textString.setSpan(new StyleSpan(Typeface.BOLD), start, end, 0);
			else if(tag=='i')
					textString.setSpan(new StyleSpan(Typeface.ITALIC), start, end, 0);		
			text.setText(textString);
		}
		else
			System.out.println("TextHandler module, method setInTextStyle says: Input is not correct");
		
	}
	
	//Method to set colour using hext integer AARRGGBB
	public void setColourIntAARRGGBB(int inColourHex){
		Paint paint = new Paint();
        String colourString, colourAlphaString, colourRedString, colourGreenString, colourBlueString;	//variables used for separation of integer to 4 integer values of Alpha, Red, Green and Blue
        int colourAlpha, colourRed, colourGreen, colourBlue;											//
        
    	colourString=Integer.toHexString(inColourHex);													//convert input integer to hex string	
    	while(true){if(colourString.length()==8) break; else colourString="0"+colourString;}
//    	System.out.println("hex string is:  " + colourString);											// if hex string is shorter then 8 bytes , add addition zeros in front
    	
    	colourAlphaString	=""+colourString.charAt(0)+colourString.charAt(1);							//separate each value for Alpha, Red, Green, Blue
    	colourRedString		=""+colourString.charAt(2)+colourString.charAt(3);
    	colourGreenString	=""+colourString.charAt(4)+colourString.charAt(5);
    	colourBlueString	=""+colourString.charAt(6)+colourString.charAt(7);
    	colourAlpha	= Integer.parseInt(colourAlphaString, 16);											//get integer values back from Hex values for each colour		
    	colourRed	= Integer.parseInt(colourRedString, 16);
    	colourGreen	= Integer.parseInt(colourGreenString, 16);
    	colourBlue	= Integer.parseInt(colourBlueString, 16);
        paint.setARGB(colourAlpha, colourRed, colourGreen, colourBlue);									//set colour using Alpha, Red, Green and Blue values
       
		
		text.setTextColor(paint.getColor());
	}
	
	//Method to set colour using string hex RRGGBB
	public void setColourStringRRGGBB(String inColourString){
        String colourRedString, colourGreenString, colourBlueString;	//variables used for separation of integer to 4 integer values of Alpha, Red, Green and Blue
        int colourRed, colourGreen, colourBlue;	
        Paint paint;													//variable for colours
        paint = new Paint();
																										//separate each value for Red, Green, Blue
    	colourRedString		=""+inColourString.charAt(0)+inColourString.charAt(1);
    	colourGreenString	=""+inColourString.charAt(2)+inColourString.charAt(3);
    	colourBlueString	=""+inColourString.charAt(4)+inColourString.charAt(5);
    																									//get integer values back from Hex values for each colour		
    	colourRed	= Integer.parseInt(colourRedString, 16);
    	colourGreen	= Integer.parseInt(colourGreenString, 16);
    	colourBlue	= Integer.parseInt(colourBlueString, 16);
        paint.setARGB(255,colourRed, colourGreen, colourBlue);									//set colour using Alpha, Red, Green and Blue values
        text.setTextColor(paint.getColor());
	}
	
	//Method to set size of the text in PT units
	public void setSize(int size){
		text.setTextSize( TypedValue.COMPLEX_UNIT_PT, size);									//set size of text using PT units
	}
	
	//Method to return the TextView Object
	public TextView getTextViewObject(){
		return text;																			//return TextView Object
		
	}
	

}
