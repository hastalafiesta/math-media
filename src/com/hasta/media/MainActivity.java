package com.hasta.media;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static int N=0, c=0;
			private static int i;
	private float s=0, med=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        final EditText n=(EditText)findViewById(R.id.n);
        Button b=(Button)findViewById(R.id.avanti);
        final TextView tv=(TextView)findViewById(R.id.tv);
        tv.setTextSize(20);
        
        
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick( View view) {
            	tv.setText("");
            	N=Integer.parseInt(n.getText().toString());
            	
            	for(i=0; i<N; i++){
        	 LayoutInflater inflater = MainActivity.this.getLayoutInflater();
 		    
 		    final View v=inflater.inflate(R.layout.dialog, null);
 		    
         	new AlertDialog.Builder 
				(MainActivity.this)
	           .setView(v)
	           .setTitle("Ancora "+(i+1)+" numeri su "+N+" da inserire.")
	           .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
	               @Override
	               
	               public void onClick(DialogInterface dialog, int id) {
	            	   c++;
	            	   EditText edit=(EditText)v.findViewById(R.id.number);
	                   s=s+Float.parseFloat(edit.getText().toString());
	                   if(!(c==N)){
	                   tv.append(edit.getText().toString()+"+");
	                   }
	                   else {
	                	   med=s/N;
	                	   tv.append(edit.getText().toString()+"/"+N+"="+String.valueOf(med));
	                   }
	                   dialog.dismiss();
	                   
	               }
	               
	           }).show();
         	
         }
            	
            	c=0;
            	s=0;
        
        }
            
	});
        
	}
	
}

	

