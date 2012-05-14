package learn.learn.learn;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Startingpoint extends Activity {
    /** Called when the activity is first created. */
    FrameLayout demoLayout;
    TextView demoText;
    Button demoButton, demoButton2;
    EditText demoInput;
    
    
    
    int percents=0, height = 30, colourHex=0xFF00FF00;
    LoadingBar demoBar;
    
    
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main); 
          	
    	demoLayout= (FrameLayout) findViewById(R.id.testtest);
    	
    	
    	
    	demoBar = new LoadingBar(demoLayout.getContext(),"00ffff", 50);
//    	demoBar = new LoadingBar(demoLayout.getContext(), percents, colourHex, height, demoLayout.getLayoutParams().width);    	
    	
    	
    	demoLayout.addView(demoBar);  
    	
    	
    	
    	//demoBar.setColourStringRRGGBB("00FFFF");

    	
//add the created Bar to the layout you want on Android    	

  	
// Text panel for testing purposes on android phone    	
    	demoText = (TextView) findViewById(R.id.testtext);
		demoText.setText("Bar shows: " + percents +"%"); 
// Inputs for Testing
		demoInput = (EditText) findViewById(R.id.editText1);
// Buttons for testing purposes      
       demoButton= (Button) findViewById(R.id.testButton);
       demoButton.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				percents=percents+1;		
				demoBar.drawBar(percents);
				demoText.setText("Bar shows: " + percents +"%");
			}
		});

       
       demoButton2= (Button) findViewById(R.id.button1);
       demoButton2.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			if(demoInput.getText()!=null){
			System.out.println("Number typed: " + Integer.parseInt(demoInput.getText().toString()));
			percents=(int)Integer.parseInt(demoInput.getText().toString());
			demoBar.drawBar(percents);
			demoText.setText("Bar shows: " + percents +"%");
			
			
			
			}
		}
	});
    	}
    	

    }
    
    
