package com.example.take.spinnerapp;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    Spinner spinner_country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_country = (Spinner)findViewById(R.id.spinner_country);

        final String[] countries = getResources().getStringArray(R.array.country_array);

        ArrayAdapter<String> adapterCountry = new ArrayAdapter(MainActivity.this, android.R.layout.simple_dropdown_item_1line,countries);
                //<Type> String,Int????                                 //Adap
        spinner_country.setAdapter(adapterCountry);


        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                                            //for check selectitem

                String test = countries[position];
                Toast.makeText(getApplicationContext(),test,Toast.LENGTH_SHORT);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            { //Nothingtodo but must have
                }
        });

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryName = spinner_country.getSelectedItem().toString();
                //Toast.makeText(MainActivity.this, countryName,Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Country");
                builder.setMessage(countryName);
                builder.show();



            }
        });

    }
}
