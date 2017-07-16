package edd.com.cliente_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class arbolB_activity extends AppCompatActivity {
    ImageView ivImagenB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arbol_b_activity);


        ivImagenB = (ImageView)findViewById(R.id.ivImagenB);
        //Obteniendo la instancia del Intent
        Intent intent = getIntent();

//Extrayendo el extra de tipo cadena
        String url = intent.getStringExtra(botones_reporte_activity.EXTRA_NOMBRE_DOS);
//Seteando el valor del extra en el TextView
        new LoadImage(ivImagenB).execute(url);
    }
}
