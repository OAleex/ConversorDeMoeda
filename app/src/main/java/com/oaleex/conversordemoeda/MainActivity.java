package com.oaleex.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;
import static com.oaleex.conversordemoeda.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder mViewHolder = new ViewHolder();

    Spinner sp1, sp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.activity_main);

        this.mViewHolder.editValue = findViewById(id.edit_value);
        this.mViewHolder.textValor = findViewById(id.valorDaMoeda);
        this.mViewHolder.btnCalculate = findViewById(id.btn_calculate);

        this.mViewHolder.btnCalculate.setOnClickListener(this);

        this.clearValues();


        sp1 = findViewById(id.spinner1);
        sp2 = findViewById(id.spinner2);



        String[] from = {"BRL"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"USD", "JPY", "BRL", "AUD"};
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == id.btn_calculate){
            String value = this.mViewHolder.editValue.getText().toString();

            if (value.equals("")){
                Toast.makeText(this, this.getString(string.value_input), Toast.LENGTH_LONG).show();
            } else if(sp1.getSelectedItem().toString().equals("BRL") && sp2.getSelectedItem().toString().equals("USD")) {
                double valor = Double.parseDouble(value)/5.32;
                this.mViewHolder.textValor.setText(String.format(Locale.ENGLISH,"%.2f",valor));

            } else if(sp1.getSelectedItem().toString().equals("BRL") && sp2.getSelectedItem().toString().equals("JPY")) {
                double valor = Double.parseDouble(value)/0.04;
                this.mViewHolder.textValor.setText(String.format(Locale.ENGLISH,"%.2f",valor));

            } else if(sp1.getSelectedItem().toString().equals("BRL") && sp2.getSelectedItem().toString().equals("BRL")) {
                double valor = Double.parseDouble(value);
                this.mViewHolder.textValor.setText(String.format(Locale.ENGLISH,"%.2f",valor));

            }else if(sp1.getSelectedItem().toString().equals("BRL") && sp2.getSelectedItem().toString().equals("AUD")) {
                double valor = Double.parseDouble(value)/3.56;
                this.mViewHolder.textValor.setText(String.format(Locale.ENGLISH,"%.2f",valor));
            }
        }
    }

    private void clearValues(){
        this.mViewHolder.textValor.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textValor;
        Button btnCalculate;
    }
}