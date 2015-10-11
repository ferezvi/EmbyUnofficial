package ioembyunofficial.github.httpferezvi.embyunofficial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void forgot_password(View v){

        Uri uri = Uri.parse("http://emby.media/community/index.php?app=core&module=global&section=lostpass"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void sign_up(View v){

        Uri uri = Uri.parse("http://emby.media/community/index.php?app=core&module=global&section=register"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void manual_connect(View v){
        Intent intent= new Intent(this,ManualConnectActivity.class);
        startActivity(intent);
    }


}