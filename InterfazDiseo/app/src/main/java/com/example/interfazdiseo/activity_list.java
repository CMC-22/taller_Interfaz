package com.example.interfazdiseo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_list extends AppCompatActivity {
    ListView listaProducto;
    Button btnVolver, btnArticulos;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listaProducto = (ListView) findViewById(R.id.lista);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnArticulos = (Button) findViewById(R.id.btnArticulos);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayProducto,android.R.layout.simple_list_item_1);
        listaProducto.setAdapter(adaptador);

        listaProducto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Selecciona: "+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish elimina o cierra la actividad actual
                finish();
            }
        });

        btnArticulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se configura
                Intent intent =  new Intent(activity_list.this, activity_news.class);
                //se ejecuta la actividad
                startActivity(intent);
            }
        });
    }

}
