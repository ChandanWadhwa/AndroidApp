package opencv.demo.com.fragmentbackstack;




import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.logging.Logger;

import opencv.demo.com.fragmentbackstack.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        MainActivityBinding binding=  DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.addA.setOnClickListener(this);
        binding.addB.setOnClickListener(this);
        binding.addC.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addA:
                addFragment("A",new FragmentA());
                break;
            case R.id.addB:
                addFragment("B",new FragmentB());
                break;
            case R.id.addC:
                addFragment("C",new FragmentC());
                break;
        }
       // addFragment("sdsd");
    }


    private void addFragment(String fragmentName,Fragment frg)
    {
        Fragment frag_A=frg;
        if(getSupportFragmentManager().findFragmentByTag(fragmentName)==null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.layout_fragment, frag_A, fragmentName);
            //ft.replace(resId, fragmentB);
            ft.addToBackStack(fragmentName);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("MainActivity", "onBackPressed: "+getSupportFragmentManager().getBackStackEntryCount());
        for(int i=getSupportFragmentManager().getBackStackEntryCount()-1;i>=0;i--) {
            Log.d("MainActivity", "onBackPressed: "+getSupportFragmentManager().getBackStackEntryAt(i).getName());
        }

    }
}
