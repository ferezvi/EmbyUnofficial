package ioembyunofficial.github.httpferezvi.embyunofficial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectToServerActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_to_server);

        //Retrieving preferences if exist and fill host and port value
        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE);
        TextView server=(TextView) findViewById(R.id.host_name);
        TextView port=(TextView) findViewById(R.id.port_name);
        server.setText(settings.getString("server", ""));


    }

    public void connect(View w){

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE);
        TextView server=(TextView) findViewById(R.id.host_name);
        TextView port=(TextView) findViewById(R.id.port_name);


        // Writing data to SharedPreferences
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("server",server.getText().toString());
        editor.putString("port", port.getText().toString());
        editor.putInt("isFirstRun", 1);
        editor.apply();

        //Launch MainActivity
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void cancel(View w){
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}