package com.example.christbarco.horizontalscrollviewejemplo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    HorizontalScrollView hsv = null;
    LinearLayout linear = null;
    TextView textViewDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hsv = (HorizontalScrollView) findViewById(R.id.horizontalScrollViewPrueba);
        linear = (LinearLayout) findViewById(R.id.linearLayoutPrueba);
        textViewDescripcion = (TextView) findViewById(R.id.txtViewDescripcion);

        //Crea dinamicamente 10 ImageButton
        for(int i = 1; i <= 10; i++)//For para la creacion de 10 ImageButton
        {
            final ImageButton ii= new ImageButton(this);
            ii.setBackgroundResource(R.drawable.programacion);
            ii.setTag("boton"+i);
            ii.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext(), "Boton " + v.getTag(), Toast.LENGTH_SHORT).show();
                    textViewDescripcion.setText("Boton Seleccionado: "+ii.getTag());
                }
            });
            linear.addView(ii);
        }
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
        if (id == R.id.menu_basico) {
            Intent intent = new Intent(this, HorizontalViewBasico.class);
            this.startActivity(intent);
            return true;
        }if (id == R.id.menu_imageButton) {
            Intent intent = new Intent(this, HorizontalViewWithImageButton.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
