package edd.com.cliente01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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
            acceso comprobar = new acceso();
                String nombre = txtname.getText().toString();
                String password = txtpassword.getText().toString();

                if(nombre.equals("admin") && txtpassword.equals("admin")){

                    Intent i = new Intent(this,activity_prueba.class);
                    startActivity(i);

                }

        }
    }
}
