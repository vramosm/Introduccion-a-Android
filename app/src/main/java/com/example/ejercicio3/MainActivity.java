package com.example.ejercicio3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //establezco todas las variables
    ImageView title;
    ImageView imagen;
    EditText name;
    EditText surnames;
    EditText age;
    RadioGroup gender;
    CheckBox terms;
    ImageButton confirmation;
    boolean condition;
    EditText competition;
    Switch preview;
    int ageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Pulsa el icono de abajo para completar el registro", Toast.LENGTH_LONG).show();

    //Se enlazan los recursos de la interfaz de usuario con las variables en el código
        title = findViewById(R.id.title);
        imagen = findViewById(R.id.imagen);
        name = findViewById(R.id.name);
        surnames = findViewById(R.id.surnames);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        terms = findViewById(R.id.terms);
        confirmation = findViewById(R.id.confirmation);
        preview = findViewById(R.id.preview);
        competition = findViewById(R.id.competition);
    //Se establece un onClicker en el Switch
        preview.setOnClickListener(this);
    }

    @Override
        // Desarrollo este onClick para ocultar y visualizar el campo de concursos antiguos según este o no checkeado el switch
        public void onClick (View view) {
            if (preview.isChecked()) {
                competition.setVisibility(View.VISIBLE);
            } else {
                competition.setVisibility(view.INVISIBLE);
            }

        }


    public void check(View view) {
        condition = false;
        //Comprobar que los campos nombre, apellidos y edad no estén vacíos, términos este checkeado y en el radiobutton de los géneros
        // este un valor seleccionado, si no hay un valor seleccionado en el radiogroup este devuelve -1
        if(name.getText().toString().trim().isEmpty() ||
                surnames.getText().toString().trim().isEmpty() ||
                age.getText().toString().trim().isEmpty() || !terms.isChecked() || gender.getCheckedRadioButtonId() == -1)
        {
            condition = true;
        }
        //En el caso de que no se introduzca ninguna edad se añade este try para ejecutarlo como excepción
        try {
            ageInput = Integer.parseInt(age.getText().toString());
        } catch (Exception e) {
        }
        //A traves del if se implantan los distintos mensajes finales según sea mayor de edad o no y según falten campos por rellenar o no
        if (ageInput < 18) {
            Toast.makeText(this, "No se permite la participación de menores de edad", Toast.LENGTH_LONG).show();
        }
        else {
            if (condition ) {
                Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Inscripcion realizada", Toast.LENGTH_LONG).show();
            }
        }
    }
}
