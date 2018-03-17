package wpos.com.br.alarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.util.GregorianCalendar;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
//import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;






public class MainActivity extends AppCompatActivity {

//   @Override
//   protected void onCreate(Bundle savedInstanceState) {
//       super.onCreate(savedInstanceState);
//       setContentView(R.layout.activity_main);
//   }

//public class MainActivity extends ActionBarActivity {

    // será usado para registrar o gerenciador do alarme
    PendingIntent pendingIntent;
    // usado par armazenar a instância de Alarm Manager em funcionamento
    AlarmManager alarmManager;
    BroadcastReceiver mReceiver;
    DatePicker datAlarm;
    TimePicker timAlarm;
    EditText txtEvent;
    MediaPlayer player;




        @Override
        public  void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
//Register AlarmManager Broadcast receive.
            RegisterAlarmBroadcast();
            datAlarm = (DatePicker) findViewById(R.id.datAlarm);
            timAlarm = (TimePicker) findViewById(R.id.timAlarm);
            txtEvent = (EditText) findViewById(R.id.txtEvent);
        }


        public void onClickSetAlarm(View v) {
            GregorianCalendar data = new
                    GregorianCalendar(datAlarm.getYear(), datAlarm.getMonth(), datAlarm.getDayOfMonth(), timAlarm.getCurrentHour(), timAlarm.getCurrentMinute());
            alarmManager.set(AlarmManager.RTC_WAKEUP, data.getTimeInMillis(), pendingIntent);
        }


        private void RegisterAlarmBroadcast() {
// Esta é uma função de CallBack quando o alarme
// responder através do BroadcastReceiver
            mReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent
                        intent) {
                    emitirAvisoSonoro();
                    gerarNotification (context, txtEvent.getText().toString());
                }

            };
// registrando o alarm broadcast aqui
            registerReceiver(mReceiver, new IntentFilter("br.com.wpos.alarme"));
            pendingIntent = PendingIntent.getBroadcast(this, 0,
                    new Intent("br.com.wpos.alarme"), 0);
            alarmManager = (AlarmManager) (this.getSystemService(Context.ALARM_SERVICE));
        }

        public void emitirAvisoSonoro() {
            try {
// Localizando o MP3 em assets
                AssetFileDescriptor afd = getAssets().
                        openFd("alarme.mp3");
                player = new MediaPlayer();
                player.setDataSource(afd.getFileDescriptor(),
                        afd.getStartOffset(), afd.getLength());
                player.prepare();
                player.start();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        public void gerarNotification(Context context, String mensagem)
        {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setContentTitle("Alarme!");
            mBuilder.setContentText(mensagem);
            Intent resI = new Intent(context, MainActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(resI);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, mBuilder.build());
        }

    }


