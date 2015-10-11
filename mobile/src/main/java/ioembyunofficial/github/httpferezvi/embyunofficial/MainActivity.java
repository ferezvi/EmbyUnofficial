package ioembyunofficial.github.httpferezvi.embyunofficial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG = "Hi" ;
    private Cursor c;
    private ListView listView;
    private android.support.v4.widget.SimpleCursorAdapter adapter;
    private DataBaseManager manager;
    private EditText etBuscar;
    public static final String PREFS_NAME = "settings";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Create shared preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        if (settings.getInt("isFirstRun", 0 )!= 1){

            /*
            // Writing data to SharedPreferences
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("isFirstRun", 1);
            editor.apply();*/

            Intent intent= new Intent(this,WelcomeActivity.class);
            startActivity(intent);

        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("isFirstRun", 0);
        editor.apply();



        // Reading from SharedPreferences

        int value = settings.getInt("isFirstRun", 0 );
        String server = settings.getString("server", "");
        String port = settings.getString("port","");
        Log.d(TAG, String.valueOf(value));
        Log.d(TAG, String.valueOf(server));
        Log.d(TAG, String.valueOf(port));




        /*
        manager = new DataBaseManager(this);
        listView = (ListView) findViewById(R.id.listView);
        etBuscar = (EditText) findViewById(R.id.editText2);

        manager.insert("Jaime", "11111111111");
        manager.insert("Juan", "222222222");
        manager.insert("Ana", "3333333");

        String[] from = new String[]{manager.NAME, manager.VALUE};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};

        c = manager.loadSettings();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, c, from, to, 0);
        listView.setAdapter(adapter);

        */

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void get_emby(View v){

        Uri uri = Uri.parse("https://emby.media/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void welcome_activity(View view){
        Intent intent= new Intent(this,WelcomeActivity.class);
        startActivity(intent);
    }

    public void reset(View v){




    }

    public void search(View v){


        String name = etBuscar.getText().toString();
        //  System.out.println(name);
        //  String value = manager.value(name,2);
        //    System.out.println(value);
        c = manager.loadSettings();
        c.moveToPosition(2);
        int count=c.getCount();
        Toast.makeText(
                this,
                "id: " + c.getString(0) + "\n" + "Name: " + c.getString(1)
                        + "\n" + "Value:  " + c.getString(2) +"\n" + "Count: " + count, Toast.LENGTH_LONG)
                .show();

        //adapter.changeCursor(cursor);


    }

    public void DisplayValue(Cursor c) {
        Toast.makeText(
                this,
                "id: " + c.getString(0) + "\n" + "Name: " + c.getString(1)
                        + "\n" + "Email:  " + c.getString(2), Toast.LENGTH_LONG)
                .show();
    }


}
