package com.example.vmac.WatBot;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";

    private static final int ERROR_DIALOG_REQUEST =9001;
    CardView card, maps;
    CardView cardt;
    TextView frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if(isServicesOK()){
            init();
        }
        frase=findViewById(R.id.txtview);

        Typeface customFont=Typeface.createFromAsset(getAssets(),"fonts/oswald.ttf");
        frase.setTypeface(customFont);

        card = this.findViewById(R.id.card4);
        cardt = this.findViewById(R.id.card3);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Trabajos.class);
                startActivity(intent);
            }
        });



    }
    private void init(){
        maps = this.findViewById(R.id.maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available =GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Main2Activity.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOK: an error occured");
            Dialog dialog =GoogleApiAvailability.getInstance().getErrorDialog(Main2Activity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "no puedo conectar boludo", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
