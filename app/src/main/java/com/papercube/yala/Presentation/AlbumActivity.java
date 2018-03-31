package com.papercube.yala.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.papercube.yala.Adapter.FiguraList_Adapter;
import com.papercube.yala.DB.helper.DatabaseHelper;
import com.papercube.yala.Model.Figura.Figura;
import com.papercube.yala.Model.Figura.FiguraEntity;
import com.papercube.yala.R;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    final DatabaseHelper db = new DatabaseHelper(this);

    private ArrayList<Figura> figuraList = new ArrayList<Figura>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


        figuraList.clear();
        figuraList.addAll(getCarList());
        //figuraList.addAll(db.getAllCarsDNI(usuario));

        //figuraList.add(new Figura(0,"Hugo Deudor",0,"Peru","Dorado"));
        //  figuraList.add(new CarEntity("YX123","Nissan","GTL", R.drawable.ic_dcar));


        final FiguraList_Adapter adapterFigura = new FiguraList_Adapter(this, figuraList);


        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapterFigura);


    }

    private ArrayList<Figura> getCarList() {

        List<Figura> figuras = db.getAllFiguras();

        for (Figura cn : figuras) {

            Figura figura = new Figura();

            figura.setIdFigura(cn.getIdFigura());
            figura.setNombreFigura(cn.getNombreFigura());
            figura.setCantidadFigura(cn.getCantidadFigura());
            figura.setPais(cn.getPais());
            figura.setTipo(cn.getTipo());

            figuraList.add(figura);
        }
        return figuraList;
    }
}
