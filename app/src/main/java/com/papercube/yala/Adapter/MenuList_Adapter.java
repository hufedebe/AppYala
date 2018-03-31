package com.papercube.yala.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.papercube.yala.Model.MenuList;
import com.papercube.yala.R;

import java.util.ArrayList;

/**
 * Created by Hudeya on 31/03/2018.
 */

public class MenuList_Adapter extends ArrayAdapter {
    private int amImageResourceId;
    public MenuList_Adapter (Context context, ArrayList<MenuList> menuList, int mImageResourceId ){
        super(context, 0 , menuList);
        amImageResourceId =mImageResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        MenuList currentMenu = (MenuList) getItem(position);

        TextView menuTextView = listItemView.findViewById(R.id.menu_text_view);
        menuTextView.setText(currentMenu.getmName());

        ImageView iconView = (ImageView)listItemView.findViewById(R.id.image);
        if (currentMenu.hasImage()){
            iconView.setImageResource(currentMenu.getmImageResourceId());
        }else{
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),amImageResourceId);

        return listItemView;

    }
}
