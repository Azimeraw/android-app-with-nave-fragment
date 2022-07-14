package com.example.prote;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerL;
    ActionBarDrawerToggle toggl;
    NavigationView navigation;
    TabLayout tabLayoutm;
    TabItem mhome,five5,ten10,contactt;
    ViewPager page;
    PagerAdapter adapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tool=findViewById(R.id.toolbarmain);
        setSupportActionBar(tool);
        page=findViewById(R.id.viewpage);
        tabLayoutm=findViewById(R.id.tabs);
        mhome=findViewById(R.id.home);
        five5=findViewById(R.id.fiveyear);
        ten10=findViewById(R.id.tenyear);
        contactt=findViewById(R.id.contact);

        drawerL=findViewById(R.id.drawermain);
        navigation=findViewById(R.id.na_view);
        toggl=new ActionBarDrawerToggle(this,drawerL,tool,R.string.open,R.string.close);
        drawerL.addDrawerListener(toggl);
        navigation.setNavigationItemSelectedListener(this);
        toggl.setDrawerIndicatorEnabled(true);
        toggl.syncState();

        adapt=new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayoutm.getTabCount());
        page.setAdapter(adapt);

        tabLayoutm.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        page.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutm));


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerL.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()){
            case R.id.profile:
                startActivity(new Intent(MainActivity.this,Profile.class));
                break;
            case R.id.menurateus:
                Uri uri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                try {
                   startActivity(intent);
                } catch (Exception e) {
                   Toast.makeText(this,"unable to open\n"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
                //Toast.makeText(this,"rating is success",Toast.LENGTH_LONG).show();
                break;
            case R.id.menuabout:
                Toast.makeText(this,"About",Toast.LENGTH_LONG).show();
                break;
            case R.id.menushare:
                try {
                    Intent i=new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT,"Prot");
                    i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    startActivity(Intent.createChooser(i,"share with"));

                } catch (Exception e) {
                    Toast.makeText(this,"unable to share\n"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
                // Toast.makeText(this,"Share",Toast.LENGTH_LONG).show();
                break;
            case R.id.menorder:
                Toast.makeText(this,"ordering",Toast.LENGTH_LONG).show();
                break;
            case R.id.menusupport:
                startActivity(new Intent(MainActivity.this,DetialContactaz.class));

                break;
        }
        drawerL.closeDrawer(GravityCompat.START);
        return true;
    }
}