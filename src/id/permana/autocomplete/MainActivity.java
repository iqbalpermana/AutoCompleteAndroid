package id.permana.autocomplete;

import android.opengl.Visibility;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
 
@SuppressLint("ShowToast")
public class MainActivity extends Activity implements  OnItemClickListener, OnItemSelectedListener  {
  
     
    // Initialize variables
      
    AutoCompleteTextView textView=null;
    private ArrayAdapter<String> adapter;
     
    //These values show in autocomplete
    String item[]={
              "January", "February", "March", "April",
              "May", "June", "July", "August",
              "September", "October", "November", "December"
            };
    Toast t;
    TextView errorText;
        
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
         
        setContentView(R.layout.activity_main);
         
        // Initialize AutoCompleteTextView values
         
            // Get AutoCompleteTextView reference from xml
        	errorText = (TextView)findViewById(R.id.error);
        	errorText.setVisibility(100);
            textView = (AutoCompleteTextView) findViewById(R.id.Months);
             
            //Create adapter    
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
             
            textView.setThreshold(1);
             
           //Set adapter to AutoCompleteTextView
            textView.setAdapter(adapter);
            textView.setOnItemSelectedListener(this);
            textView.setOnItemClickListener(this);
            textView.addTextChangedListener(new TextWatcher() {
	            @Override
	            public void onTextChanged(CharSequence s, int start, int before, int count) {
	              if (!textView.isPerformingCompletion()) {
	            	  errorText.setVisibility(0);
//	                  t = Toast.makeText(getApplicationContext(), "No Item Found", Toast.LENGTH_SHORT);
//	                  t.setGravity(Gravity.CENTER, 0, 0);
//	                  t.show();
	                  
//	            	  AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//	            	  alertDialog.setTitle("Alert");
//	            	  alertDialog.setMessage("Keyword not found");
//	            	  alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//	            	      new DialogInterface.OnClickListener() {
//	            	          public void onClick(DialogInterface dialog, int which) {
//	            	              dialog.dismiss();
//	            	          }
//	            	      });
//	            	  alertDialog.show();
	                  
	            	  return;
	                 } else {
	                	 errorText.setVisibility(100);
	                	 return;
	                 }
	               }
	
	             @Override
	             public void beforeTextChanged(CharSequence s, int start, int count, int after) {                
	            	
	             }
	
	             @Override
	             public void afterTextChanged(Editable s) {
		              
	             }
            });          
    }
    
 
     
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
            long arg3) {
    	errorText.setVisibility(0);
        // TODO Auto-generated method stub
        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
    }
 
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    	errorText.setVisibility(100);
         
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
 
    }
 
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
         
        // Show Alert       
        Toast.makeText(getBaseContext(), "Position:"+arg2+" Month:"+arg0.getItemAtPosition(arg2),
                Toast.LENGTH_LONG).show();
         
        Log.d("AutocompleteContacts", "Position:"+arg2+" Month:"+arg0.getItemAtPosition(arg2));
         
    }
        
     
    protected void onResume() {
        super.onResume();
    }
  
    protected void onDestroy() {
        super.onDestroy();
    }
    
}