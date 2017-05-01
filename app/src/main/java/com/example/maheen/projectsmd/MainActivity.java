package com.example.maheen.projectsmd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements Hajj.OnFragmentInteractionListener,Umrah.OnFragmentInteractionListener,Prepare.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLiteHelper db = new MySQLiteHelper(this);

        /**
         * CRUD Operations
         * */
        // add Books
        db.addUmrahitem(new Umrahclass("tawaf", "Enter Al-Haram gate on your right foot",R.drawable.masjidalharam),"umrah");
        db.addUmrahitem(new Umrahclass("tawaf", "Uncover right shoulder",R.drawable.uncoverrightshoulder),"umrah");
        db.addUmrahitem(new Umrahclass("tawaf", "Read dua \n بِسم الله،والصّلاة والسّلام على َرسول الله،الّلهُم افتَح لي أبوابَ رَحْمَتِك ",R.drawable.intention),"umrah");

        db.addUmrahitem(new Umrahclass("tawaf", "Start each round while touching or raising hands towards Hajr-e-aswad",R.drawable.hajreaswad1),"umrah");
        db.addUmrahitem(new Umrahclass("Nafal", "Behind maqam ibrahim pray two raka",R.drawable.makameibrahimif),"umrah");
        db.addUmrahitem(new Umrahclass("Nafal", "Recite surah Kaafiroon in first raka \n Recite surah Ikhlas in second raka ",R.drawable.nawafilatibrahimi),"umrah");

        db.addUmrahitem(new Umrahclass("Zamzam", "Drink zamzam after performing Raka",R.drawable.zamzamwater),"umrah");
        db.addUmrahitem(new Umrahclass("Zamzam", "Drink in 1 gulp",R.drawable.persondrinkingzamazam),"umrah");
        db.addUmrahitem(new Umrahclass("Zamzam", "recite \n   آللّهُمَ اِنِّىْ اَسْعَلُكَ عِلْماً نَّافَعِاً وَّرِزْقًا وَّاسِعاً وَشِفَائً مِّنْ كُلِ دَائً",R.drawable.intention),"umrah");

        db.addUmrahitem(new Umrahclass("Saaee", "While going for Saaee Raise hands towards Hajr-e-aswad and Recite \n بِسمِ اللّهِ اللّهُ اَكْبَر",R.drawable.hijreaswad),"umrah");
        db.addUmrahitem(new Umrahclass("Saaee", "Recite when reached saffa \n إِنَّ الصَّفَا وَالْمَرْوَةَ مِنْ شَعَا ئِرِاللّهِ\n أَبْدَأُ بِمَا بَدَأَاللّهُ بِه",R.drawable.safatomarwa),"umrah");
        db.addUmrahitem(new Umrahclass("Haircut", "Shave or trim hair ",R.drawable.scissorsf),"umrah");

        db.addUmrahitem(new Umrahclass("umrah-completion", "Your umrah has completed!",R.drawable.umrahcom),"umrah");


        db.addUmrahitem(new Umrahclass("8Zilhajj", "Bath and put on Ihram",R.drawable.ihram_man_women),"hajj");
        db.addUmrahitem(new Umrahclass("8Zilhajj", "Read the dua to make intention",R.drawable.intention),"hajj");

        db.addUmrahitem(new Umrahclass("8Zilhajj", "Here on contineously read talbiyah",R.drawable.talbiyah),"hajj");
        db.addUmrahitem(new Umrahclass("8Zilhajj", "Go to minnah",R.drawable.minnah),"hajj");

        db.addUmrahitem(new Umrahclass("8Zilhajj", "Pray qasr prayers",R.drawable.namaz),"hajj");






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout.addTab(tabLayout.newTab().setText("Prepare"));
        tabLayout.addTab(tabLayout.newTab().setText("Umrah"));
        tabLayout.addTab(tabLayout.newTab().setText("Hajj"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);






        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent i = new Intent(this, MyPreferencesActivity.class);
            startActivity(i);
            // Display the fragment as the main content.
           /* FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager
                    .beginTransaction();
            PrefsFragment mPrefsFragment = new PrefsFragment();
            mFragmentTransaction.replace(android.R.id.content, mPrefsFragment);
            mFragmentTransaction.commit();*/

           /* getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new PrefsFragment()).commit();
*/

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFragmentInteraction(Uri uri){

    }


   /* public static class PrefsFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = super.onCreateView(inflater, container, savedInstanceState);
            view.setBackgroundColor(getResources().getColor(android.R.color.white));
            return view;
        }
    }*/
}
