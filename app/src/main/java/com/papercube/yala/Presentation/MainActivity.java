package com.papercube.yala.Presentation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.papercube.yala.Adapter.MenuList_Adapter;
import com.papercube.yala.Model.MenuList;
import com.papercube.yala.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private Button btn_salir;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView uidTextView;
    private TextView lbl_usunombre;
    private  TextView lbl_usucorreo;
    private Button social_media;

    private DrawerLayout mDrawerLayout;
    final ArrayList<MenuList> menuLists = new ArrayList<MenuList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView= findViewById(R.id.nameTextView);
        emailTextView= findViewById(R.id.emailTextView);
        uidTextView=findViewById(R.id.uidTextView);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user!=null){

            uidTextView.setText(user.getUid());
        }else{
            goLoginScreen();
        }

        lbl_usunombre = headerView.findViewById(R.id.lbl_usunombre);
        lbl_usucorreo = headerView.findViewById(R.id.lbl_usucorreo);

        social_media = findViewById(R.id.socialMensaje);

        social_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Me  Faltan estas figuritas");
                try {
                        startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(),"Whatsapp no está instalado",Toast.LENGTH_LONG).show();

                }
            }
        });


    if(user ==null){


    }else{
        if (user.getDisplayName().trim()!=null){
            lbl_usunombre.setText(user.getDisplayName());
        }

        /*
        if (user.getEmail().trim()!=null){
            lbl_usucorreo.setText(user.getEmail());
        }
        */

    }



        btn_salir = findViewById(R.id.btn_salir);

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                goLoginScreen();
            }
        });


        //-----Menú List ------//
        menuLists.add(new MenuList("Álbum ", R.drawable.ic_menu_album));
        menuLists.add (new MenuList("Intercambiar", R.drawable.ic_store_menu));
        menuLists.add(new MenuList("Market", R.drawable.ic_store_menu));
        menuLists.add(new MenuList("Eventos",R.drawable.ic_store_menu));
        menuLists.add(new MenuList("Salir", R.drawable.ic_store_menu));

        MenuList_Adapter adapterMenu = new MenuList_Adapter(this, menuLists, R.color.colorPrimary);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapterMenu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent album = new Intent(getApplicationContext(),AlbumActivity.class);
                        startActivity(album);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        FirebaseAuth.getInstance().signOut();
                        LoginManager.getInstance().logOut();
                        goLoginScreen();
                        break;
                }
            }
        });

    }

    private void goLoginScreen(){

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_perfil) {

        } else if (id == R.id.nav_album) {

        } else if (id == R.id.nav_tienda) {

        } else if (id == R.id.nav_sesion) {
            FirebaseAuth.getInstance().signOut();
            LoginManager.getInstance().logOut();
            goLoginScreen();
        } else if (id == R.id.nav_compartir) {

        } else if (id == R.id.nav_terminos) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
