package ioembyunofficial.github.httpferezvi.embyunofficial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.content.Intent;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView emby_url=(TextView) findViewById(R.id.emby_url);
        emby_url.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void get_emby(View v){

        Uri uri = Uri.parse("https://emby.media/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void start_login(View view){
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}