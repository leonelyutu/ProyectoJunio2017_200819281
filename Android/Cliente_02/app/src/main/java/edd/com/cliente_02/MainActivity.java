package edd.com.cliente_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtname;
    EditText txtpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finishActivity(R.layout.activity_prueba);
        finishActivity(R.layout.activity_arbol_b_activity);

        txtname = (EditText)findViewById(R.id.txtname);
        txtpassword = (EditText)findViewById(R.id.txtpassword);
        btnlogin = (Button)findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlogin:
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Login", Toast.LENGTH_SHORT);

                toast1.show();
                Conexion conexion = new Conexion();

                String nombre = txtname.getText().toString();
                String password = txtpassword.getText().toString();

                if(conexion.validar_login(nombre, password)){

                    Intent i = new Intent(this,botones_reporte_activity.class);
                    startActivity(i);
                }
        }
    }
}
