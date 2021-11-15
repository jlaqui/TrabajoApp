package com.proyectofinal.trabajoseguro;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.proyectofinal.trabajoseguro.databinding.ActivityInterfazUsuarioBinding;
import com.proyectofinal.trabajoseguro.model.ConexionSQLite;
import com.proyectofinal.trabajoseguro.model.Empresa;

import java.util.ArrayList;

public class InterfazUsuarioActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityInterfazUsuarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInterfazUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarInterfazUsuario.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_crear_anuncio)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_interfaz_usuario);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // PARA VER EN CONSOLA LAS EMPRESAS REGISTRADAS
       /* ArrayList<Empresa> EmpresasRegistradas = new ArrayList<>();
        ConexionSQLite c = new ConexionSQLite(this, "bd_trabajaseguro", null, 1, null);
        SQLiteDatabase bd = c.getReadableDatabase();
        Cursor cursor = bd.rawQuery(" SELECT*FROM Empresa ", null);
        while(cursor.moveToNext()) {
            Empresa aux = new Empresa();
            aux.setId_empresa(cursor.getInt(0));
            aux.setNombre(cursor.getString(1));
            aux.setEncargado(cursor.getString(2));
            aux.setCorreo(cursor.getString(3));
            aux.setTelefono(cursor.getString(4));
            aux.setRuc(cursor.getString(5));
            aux.setUsuario(cursor.getString(6));
            aux.setContrasenia(cursor.getString(7));
            aux.setDescripcion(cursor.getString(8));
            aux.setDireccion(cursor.getString(9));
            aux.setDepartamento(cursor.getString(10));
            EmpresasRegistradas.add(aux);
        }
        bd.close();
        for (int i = 0; i < EmpresasRegistradas.size(); ++i) {
            Log.i("Empresa ", EmpresasRegistradas.get(i).toString());
        }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.interfaz_usuario, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_interfaz_usuario);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}