package ioembyunofficial.github.httpferezvi.embyunofficial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ManualConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_connect);
    }

    public void sign_in(View v){

        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);

    }

    public void help(View v){

        Uri uri = Uri.parse("https://github.com/MediaBrowser/Wiki/wiki/Emby%20Connect"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void connect_to_server(View view){
        Intent intent= new Intent(this,ConnectToServerActivity.class);
        startActivity(intent);
    }
}