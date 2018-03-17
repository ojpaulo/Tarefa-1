package wpos.com.br.camerav2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {

    // Atributo que representará o ImagemView da foto
    ImageView imagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Captura o ImagemView da tela e relaciona com o atributo.
        imagem = (ImageView) findViewById(R.id.imageView);
        imagem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Chamada para a função que abrira a camera
                open();
            }
        });
    }


    public void open() {
        // Intent que chamara o aplicativo da camera
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
// Programando o retorno do aplicativo de câmera
        super.onActivityResult(requestCode, resultCode, data);
// Pega a foto da camera e abre o ImagemView como Bitmap
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imagem.setImageBitmap(bp);
    }



}



