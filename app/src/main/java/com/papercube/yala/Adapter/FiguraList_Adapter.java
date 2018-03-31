package com.papercube.yala.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.papercube.yala.DB.helper.DatabaseHelper;
import com.papercube.yala.Model.Figura.Figura;
import com.papercube.yala.R;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Hudeya on 31/03/2018.
 */

public class FiguraList_Adapter extends ArrayAdapter {
    private DatabaseHelper dbHelper;
    private Context context ;

    public FiguraList_Adapter (Context context, ArrayList<Figura> figuraEntity ){
        super(context, 0 , figuraEntity);

        this.dbHelper = new DatabaseHelper(context.getApplicationContext());
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_figurita, parent, false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list
        final Figura currentFigura = (Figura) getItem(position);


        TextView cantidadFigura = listItemView.findViewById(R.id.txt_cantidadFigura);
        TextView nombreFigura = listItemView.findViewById(R.id.txt_nombreFigura);


        cantidadFigura.setText(String.valueOf(currentFigura.getCantidadFigura()));
        nombreFigura.setText(currentFigura.getNombreFigura());


        //Cogiendo botoenes:
        final Button btn_modificar = listItemView.findViewById(R.id.btn_save);



        btn_modificar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


            }
        });

        return listItemView;

    }

}
