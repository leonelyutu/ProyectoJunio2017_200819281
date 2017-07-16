package edd.com.cliente_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class activity_prueba extends AppCompatActivity {
    ImageView ivImagen ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);


        ivImagen = (ImageView)findViewById(R.id.ivImagen);
        //Obteniendo la instancia del Intent
        Intent intent = getIntent();

//Extrayendo el extra de tipo cadena
        String url = intent.getStringExtra(botones_reporte_activity.EXTRA_NOMBRE);
//Seteando el valor del extra en el TextView
        new LoadImage(ivImagen).execute(url);

    }

}
