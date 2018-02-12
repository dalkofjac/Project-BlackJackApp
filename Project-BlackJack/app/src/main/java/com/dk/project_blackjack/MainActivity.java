package com.dk.project_blackjack;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dk.project_blackjack.fragments.GameFragment;
import com.dk.project_blackjack.fragments.SettingsFragment;
import com.dk.project_blackjack.helpers.FragmentStarter;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private FragmentStarter fragmentStarter;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentStarter = new FragmentStarter(this);
        mFragmentManager = getFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);

        GameFragment gf = new GameFragment();
        mFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentStarter.startFragment(gf);

        FlowManager.init(new FlowConfig.Builder(this).build());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            SettingsFragment sf = new SettingsFragment();
            fragmentStarter.startFragment(sf);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged(){}

    @Override
    public void onBackPressed(){
        int stackCount = mFragmentManager.getBackStackEntryCount();
        if (stackCount >= 2){
            mFragmentManager.popBackStack();
        }
        else{
            this.finish();
        }
    }
}
