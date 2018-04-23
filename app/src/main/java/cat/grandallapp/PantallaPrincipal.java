package cat.grandallapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);
        //this.getActionBar().setIcon(R.drawable.ic_launcher);
        SharedPreferences sharedPref = this.getSharedPreferences(Utilidad.PREFERENCIAS, Context.MODE_PRIVATE);
        String usuario = sharedPref.getString(Utilidad.USUARIO, "defecto");
        //Toast.makeText(getApplicationContext(),usuario,Toast.LENGTH_SHORT).show();
        if (!usuario.contentEquals("defecto")) {
            Intent i;
            if(!sharedPref.getString(Utilidad.FICHADOHOY, "defecto").contentEquals("defecto")){
                i = new Intent(PantallaPrincipal.this, Listado.class);
            }
            else{
                i = new Intent(PantallaPrincipal.this, Fichar.class);
            }
            this.startActivity(i);
            this.finish();
        }
    }

    public void iniciarSesion(View v) {
        //TODO lanzar peticion servidor y comprobar usuario y pass

        //Boolean inicioCorrecto = true;
        //if (usuario.contentEquals("defecto")) {
        SharedPreferences sharedPref = getSharedPreferences(Utilidad.PREFERENCIAS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Utilidad.USUARIO, ((TextView) findViewById(R.id.usuario)).getText().toString());
        editor.commit();

        Toast.makeText(getApplicationContext(),((TextView) findViewById(R.id.usuario)).getText().toString(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(PantallaPrincipal.this, Fichar.class);
        startActivity(i);
        this.finish();
        //}
       /* else{
            Intent i = new Intent(PantallaPrincipal.this, Fichar.class);
            this.startActivity(i);
        }*/
    }
}
