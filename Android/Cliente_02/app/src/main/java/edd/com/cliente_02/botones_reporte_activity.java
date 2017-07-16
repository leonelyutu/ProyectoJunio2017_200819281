package edd.com.cliente_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class botones_reporte_activity extends AppCompatActivity implements View.OnClickListener {

    Button btnReporteArbol,btnReporteArbolB,btnReporteTH;

    public final static String EXTRA_NOMBRE = "edd.com.cliente_02.url";
    public final static String EXTRA_NOMBRE_DOS = "edd.com.cliente_02.url.dos";

    public String urlABB = "http://192.168.43.42:8080/example1/setearImagen"; ////ArbolBB Asignar Direccion IP de servidor web del servlet que contiene la imagen
    public String urlAB = "http://192.168.43.42:8080/example1/setearImagenAB";//ARBOLB
    public String urlTH = "http://192.168.43.42:8080/example1/setearImagenHash";//tblaHash

    //public String url = "http://192.168.43.42:8080/example1/setearImagenAB";
    //public String url = "http://192.168.43.42:8080/example1/setearImagenAB";
    //public String url = "http://192.168.43.42:8080/example1/setearImagenAB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_reporte_activity);
        btnReporteArbol = (Button)findViewById(R.id.btnReporteArbol);
        btnReporteArbolB = (Button)findViewById(R.id.btnReporteArbolB);
        btnReporteTH = (Button)findViewById(R.id.btnReporteTH);



        btnReporteArbol.setOnClickListener(this);
        btnReporteArbolB.setOnClickListener(this);
        btnReporteTH.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnReporteArbol:
                //enviar URL desde PUT_EXTRAS

                //Iniciando la actividad Visor
                Intent intent = new Intent(this,activity_prueba.class);
                //Adhesión de nuestra cadena
                intent.putExtra(EXTRA_NOMBRE,urlABB);
                startActivity(intent);
                break;

            case R.id.btnReporteArbolB:
                //Iniciando la actividad Visor
                Intent intentAB = new Intent(this,activity_prueba.class);
                //Adhesión de nuestra cadena
                intentAB.putExtra(EXTRA_NOMBRE,urlAB);
                startActivity(intentAB);
                break;

            case R.id.btnReporteTH:
                //Iniciando la actividad Visor
                Intent intentTH = new Intent(this,activity_prueba.class);
                //Adhesión de nuestra cadena
                intentTH.putExtra(EXTRA_NOMBRE,urlTH);
                startActivity(intentTH);
                break;


        }
    }
}
