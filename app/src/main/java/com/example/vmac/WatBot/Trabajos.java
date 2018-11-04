package com.example.vmac.WatBot;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Trabajos extends AppCompatActivity {
    Spinner carreras, exp, sueldo;
    TextView profesion ,expt, sueldot;
    ImageButton buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);


        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

       carreras = findViewById(R.id.spinner);
        exp = findViewById(R.id.spinner2);
        sueldo = findViewById(R.id.spinner3);

        profesion =findViewById(R.id.textView);
        expt =findViewById(R.id.textView2);
        sueldot =findViewById(R.id.textView3);

        buscar =findViewById(R.id.imageButton);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Trabajos.this, Busqueda_trabajos.class);
                startActivity(intent);
            }
        });


        Typeface customFont=Typeface.createFromAsset(getAssets(),"fonts/oswald.ttf");
        profesion.setTypeface(customFont);
        expt.setTypeface(customFont);
        sueldot.setTypeface(customFont);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.carreras,android.R.layout.simple_spinner_item);
        carreras.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this, R.array.exp,android.R.layout.simple_spinner_item);
        exp.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.sueldo,android.R.layout.simple_spinner_item);
        sueldo.setAdapter(adapter2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent = new Intent(Trabajos.this, incognito.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}
