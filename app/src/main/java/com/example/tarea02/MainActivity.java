package com.example.tarea02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    EditText et_fechaNacimiento;
    Button btn_siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_fechaNacimiento = (EditText) findViewById(R.id.et_fechaNacimiento);
        btn_siguiente = (Button) findViewById(R.id.btn_button01);
    }

    public void onClick_BTN(View view){
        closeKeyboard();
        if (view == btn_siguiente ){
            openActivityEditData();
        }
    }

    public void openActivityEditData(){
        EditText xnombre   = (EditText) findViewById(R.id.et_nombre);
        EditText xfechaNac = (EditText) findViewById(R.id.et_fechaNacimiento);
        EditText xtelefono = (EditText) findViewById(R.id.et_telefono);
        EditText xemail    = (EditText) findViewById(R.id.et_email);
        EditText xdetaCont = (EditText) findViewById(R.id.et_detalleContacto);

        String nombre   = xnombre.getText().toString();
        String fechaNac = xfechaNac.getText().toString();
        String telefono = xtelefono.getText().toString();
        String email    = xemail.getText().toString();
        String detaCont = xdetaCont.getText().toString();

        Intent intent = new Intent(MainActivity.this, EditData.class);
        intent.putExtra( getResources().getString(R.string.p_nombre)   , nombre   );
        intent.putExtra( getResources().getString(R.string.p_fechaNac) , fechaNac );
        intent.putExtra( getResources().getString(R.string.p_telefono) , telefono );
        intent.putExtra( getResources().getString(R.string.p_email)    , email    );
        intent.putExtra( getResources().getString(R.string.p_detaCont) , detaCont );
        startActivityForResult(intent,1);;
    }

    // load the data


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, getResources().getString(R.string.Toast_msg), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // verify the date
    public void onClickFecha(View view){
        closeKeyboard();
        if (view == et_fechaNacimiento){
           final Calendar cal = Calendar.getInstance();
            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH);
            int ano = cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog =
                new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month++;
                    String date = day+"/"+month+"/"+year;
                    et_fechaNacimiento.setText(date);
                }
            }, ano, mes, dia);
            datePickerDialog.show();
        }
    }

    //close keyboard
    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}