package unyleya.mediaaluno;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    private EditText txtNome, txtNota1, txtNota2, txtNota3;
    public final static String RESULTADO = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        txtNota3 = (EditText) findViewById(R.id.txtNota3);
    }



    public void calcularMedia(View v) {
        float floMedia;
        String strNome = txtNome.getText().toString();
        float floNota1 = Float.parseFloat(txtNota1.getText().toString());
        float floNota2 = Float.parseFloat(txtNota2.getText().toString());
        float floNota3 = Float.parseFloat(txtNota3.getText().toString());
        floMedia = (floNota1 + floNota2 + floNota3) / 3;



        String situacao="";

        if(floMedia >=7) {
            situacao = "aprovado";
        } else  {
            situacao = "reprovado";
        }


        Intent intent = new Intent(this, ResultActivity.class);



        intent.putExtra(RESULTADO, "Olá, "+strNome+" você foi "+situacao+" com a média "+floMedia);
        // Linhas inibidas originais */
       // startActivity(intent);

        // Alternativa */


        byte mId = 1;

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Média Aluno")
                        .setContentText("Situação Calculada!");
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, ResultActivity.class);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(ResultActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(mId, mBuilder.build());

        startActivity(intent);





      //  NotificationCompat.Builder
      //          Builder = new NotificationCompat.Builder(this)
       //         .setSmallIcon(R.mipmap.ic_launcher)
       //         .setContentTitle("Média Aluno")
       //         .setContentText("Situação Calculada!");


 //       TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(ResultActivity.class);



        // Adicionando a Intent queliga as duas activities
  //      stackBuilder.addNextIntent(intent);
// AdicionandoumaPendingIntent
    //    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
/* Acessa o gerenciador de notificações do Android e dispara a notificação */
      //  byte mId = 1;
      //  Builder.setContentIntent(resultPendingIntent);
      //  NotificationManager NotificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      //  NotificationManager.notify(mId, Builder.build());
    }

    }


