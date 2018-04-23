package cat.grandallapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Fichar extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fichar);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            //Bitmap photo = (Bitmap) data.getExtras().get("data");
            //imageView.setImageBitmap(photo);
            SharedPreferences sharedPref = getSharedPreferences(Utilidad.PREFERENCIAS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(Utilidad.FICHADOHOY, new SimpleDateFormat("HH:mm:ss").format(new Date()));
            editor.commit();
            //Toast.makeText(getApplicationContext(),new SimpleDateFormat("dd HH:mm:ss").format(new Date()),Toast.LENGTH_SHORT).show();

            Intent i = new Intent(Fichar.this, Listado.class);
            this.startActivity(i);
            this.finish();
        }
    }

    public void onClick(View v){
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
        //Toast.makeText(getApplicationContext(),accion,Toast.LENGTH_SHORT).show();
    }
}