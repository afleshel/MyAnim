package com.song.myAnim.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.song.myAnim.R;
import com.song.myAnim.customer.view.BitmapMesh;
import com.song.myAnim.customer.view.InhaleMesh.InhaleDir;


public class Anim8Activity extends Activity {
	 private static final boolean DEBUG_MODE = false;
	    private BitmapMesh.SampleView mSampleView = null;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        
	        LinearLayout linearLayout = new LinearLayout(this);
	        
	        mSampleView = new BitmapMesh.SampleView(this);
	        mSampleView.setIsDebug(DEBUG_MODE);
	        mSampleView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
	        Button btn = new Button(this);
	        btn.setText("Run");
	        btn.setTextSize(20.0f);
	        btn.setLayoutParams(new LinearLayout.LayoutParams(150, -2));
	        btn.setOnClickListener(new View.OnClickListener()
	        {
	            boolean mReverse = false;
	            
	            @Override
	            public void onClick(View v)
	            {
	                if (mSampleView.startAnimation(mReverse))
	                {
	                    mReverse = !mReverse;
	                }
	            }
	        });
	        
	        linearLayout.setOrientation(LinearLayout.VERTICAL);
	        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
	        linearLayout.addView(btn);
	        linearLayout.addView(mSampleView);
	        
	        setContentView(linearLayout);
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) 
	    {
	        getMenuInflater().inflate(R.menu.activity_main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	        switch(item.getItemId())
	        {
	        case R.id.menu_inhale_down:
	            mSampleView.setInhaleDir(InhaleDir.DOWN);
	            break;
	            
	        case R.id.menu_inhale_up:
	            mSampleView.setInhaleDir(InhaleDir.UP);
	            break;
	            
	        case R.id.menu_inhale_left:
	            mSampleView.setInhaleDir(InhaleDir.LEFT);
	            break;
	            
	        case R.id.menu_inhale_right:
	            mSampleView.setInhaleDir(InhaleDir.RIGHT);
	            break;
	        }
	        
	        return super.onOptionsItemSelected(item);
	    }
}
                    