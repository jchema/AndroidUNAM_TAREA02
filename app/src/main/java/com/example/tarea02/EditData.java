package com.example.tarea02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditData extends AppCompatActivity {
    Button btn_regresar;
    String nombre;
    String fecNac;
    String telefono;
    String email;
    String detaCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);


        Bundle parametros   = getIntent().getExtras();
        nombre       = parametros.getString(getResources().getString(R.string.p_nombre));
        fecNac       = parametros.getString(getResources().getString(R.string.p_fechaNac));
        telefono     = parametros.getString(getResources().getString(R.string.p_telefono));
        email        = parametros.getString(getResources().getString(R.string.p_email));
        detaCont     = parametros.getString(getResources().getString(R.string.p_detaCont));

        TextView tv_nombre          = (TextView) findViewById(R.id.tv_nombre);
        TextView tv_fechaNacimiento = (TextView) findViewById(R.id.tv_fechaNacimiento);
        TextView tv_telefono        = (TextView) findViewById(R.id.tv_telefono);
        TextView tv_email           = (TextView) findViewById(R.id.tv_email);
        TextView tv_detaContacto    = (TextView) findViewById(R.id.tv_detaContacto);

        tv_nombre.setText(nombre);
        tv_fechaNacimiento.setText(fecNac);
        tv_telefono.setText(telefono);
        tv_email.setText(email);
        tv_detaContacto.setText(detaCont);

        btn_regresar = (Button) findViewById(R.id.btn_button02);

    }

    //on click in bottom regresar
    public void onClick_Btn_Regresar(View view){
        if (view == btn_regresar ){
            Intent goBack = new Intent(EditData.this, MainActivity.class);
            //startActivity(i);
            setResult(RESULT_OK, goBack);
            finish();
        }
    }

    //erase from memory activity  -- press btn back from panel --
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent goBack = new Intent(EditData.this, MainActivity.class);
            setResult(RESULT_OK, goBack);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }

}