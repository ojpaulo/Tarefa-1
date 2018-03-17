package camera.wpos.com.br.pesoideal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText txtPeso, txtAltura, txtIdade;
    public final static String RESULTADO = "";
    String avaliacao = "";
    String txtSexo = "";
    private RadioGroup radio_Sexo;
    private RadioGroup rg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtIdade = (EditText) findViewById(R.id.txtIdade);


        RadioGroup  rg = (RadioGroup) findViewById(R.id.radio_Sexo);
        if (rg.getCheckedRadioButtonId() == R.id.radio_Masculino) {
           txtSexo ="Masculino";
        } else if (rg.getCheckedRadioButtonId() == R.id.radio_Feminino) {
           txtSexo = "Feminino";
        }




    }


    public void calcularIMC(View v) {
        float floIMC;

        float floPeso = Float.parseFloat(txtPeso.getText().toString());
        float floAltura = Float.parseFloat(txtAltura.getText().toString());
        float floIdade = Float.parseFloat(txtIdade.getText().toString());
        floIMC = floPeso / (floAltura * floAltura);


        if (floIdade >= 16) {

            if (floIMC < 17) {
                avaliacao = "Muito abaixo do peso";
            } else if (floIMC >= 17 && floIMC < 18.5) {
                avaliacao = "Abaixo do peso";
            } else if (floIMC >= 18.5 && floIMC < 25) {
                avaliacao = "Peso normal";
            } else if (floIMC >= 25 && floIMC < 30) {
                avaliacao = "Acima do peso";
            } else if (floIMC >= 30 && floIMC < 35) {
                avaliacao = "Obesidade I";
            } else if (floIMC >= 35 && floIMC < 40) {
                avaliacao = "Obesidade II (severa)";
            } else if (floIMC >= 40) {
                avaliacao = " Obesidade III (mórbida)";
            }
        } else if (floIdade < 16 && floIdade >= 6) {

            if (txtSexo=="Masculino"){

                if (floIdade==6) {

                   if (floIMC <= 16.6) {
                       avaliacao = "Normal";
                   } else if (floIMC > 16.6 && floIMC <= 18) {
                       avaliacao = "Sobrepeso";
                   } else if (floIMC > 18) {
                       avaliacao = "Obesidade";
                   }

               } else if (floIdade==7) {

                    if (floIMC <= 17.3) {
                        avaliacao = "Normal";
                    } else if (floIMC > 17.3 && floIMC <= 19.1) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 19.1) {
                        avaliacao = "Obesidade";
                    }


               } else if (floIdade==8) {



                    if (floIMC <= 16.7) {
                        avaliacao = "Normal";
                    } else if (floIMC > 16.7 && floIMC <= 20.3) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 20.3) {
                        avaliacao = "Obesidade";
                    }



               } else if (floIdade==9) {


                    if (floIMC <= 18.8) {
                        avaliacao = "Normal";
                    } else if (floIMC > 18.8 && floIMC <= 21.4) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 21.4) {
                        avaliacao = "Obesidade";
                    }




               } else if (floIdade==10) {


                    if (floIMC <= 19.6) {
                        avaliacao = "Normal";
                    } else if (floIMC > 19.6 && floIMC <= 22.5) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 22.5) {
                        avaliacao = "Obesidade";
                    }




               } else if (floIdade==11) {



                    if (floIMC <= 20.3) {
                        avaliacao = "Normal";
                    } else if (floIMC > 20.3 && floIMC <= 23.7) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 23.7) {
                        avaliacao = "Obesidade";
                    }




               } else if (floIdade==12) {

                    if (floIMC <= 21.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 21.1 && floIMC <= 24.8) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 24.8) {
                        avaliacao = "Obesidade";
                    }

                } else if (floIdade==13) {

                    if (floIMC <= 21.9) {
                        avaliacao = "Normal";
                    } else if (floIMC > 21.9 && floIMC <= 25.9) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 25.9) {
                        avaliacao = "Obesidade";
                    }

                } else if (floIdade==14) {

                    if (floIMC <= 22.7 ) {
                        avaliacao = "Normal";
                    } else if (floIMC > 22.7 && floIMC <= 26.9) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 26.9) {
                        avaliacao = "Obesidade";
                    }
                } else if (floIdade==15) {

                   if (floIMC <= 23.6) {
                        avaliacao = "Normal";
                    } else if (floIMC > 23.6 && floIMC <= 27.7) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 27.7) {
                        avaliacao = "Obesidade";
                    }

               }
            } else {


                if (floIdade==6) {

                    if (floIMC <= 16.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 16.1 && floIMC <= 17.4) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 17.4) {
                        avaliacao = "Obesidade";
                    }

                } else if (floIdade==7) {


                    if (floIMC <= 17.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 17.1 && floIMC <= 18.9) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 18.9) {
                        avaliacao = "Obesidade";
                    }


                } else if (floIdade==8) {

                    if (floIMC <= 18.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 18.1 && floIMC <= 20.3) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 20.3) {
                        avaliacao = "Obesidade";
                    }



                } else if (floIdade==9) {


                    if (floIMC <= 19.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 19.1 && floIMC <= 21.7) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 21.7) {
                        avaliacao = "Obesidade";
                    }




                } else if (floIdade==10) {

                    if (floIMC <= 20.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 20.1 && floIMC <= 23.2) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 23.2) {
                        avaliacao = "Obesidade";
                    }




                } else if (floIdade==11) {

                    if (floIMC <= 21.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 21.1 && floIMC <= 24.5) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 24.5) {
                        avaliacao = "Obesidade";
                    }


                } else if (floIdade==12) {

                    if (floIMC <= 22.1) {
                        avaliacao = "Normal";
                    } else if (floIMC > 22.1 && floIMC <= 25.9) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 25.9) {
                        avaliacao = "Obesidade";
                    }

                } else if (floIdade==13) {

                    if (floIMC <= 23) {
                        avaliacao = "Normal";
                    } else if (floIMC > 23 && floIMC <= 27.7) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 27.7) {
                        avaliacao = "Obesidade";
                    }

                } else if (floIdade==14) {


                    if (floIMC <= 23.8) {
                        avaliacao = "Normal";
                    } else if (floIMC > 23.8 && floIMC <= 27.9) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 27.9) {
                        avaliacao = "Obesidade";
                    }
                } else if (floIdade==15) {

                    if (floIMC <= 24.2) {
                        avaliacao = "Normal";
                    } else if (floIMC > 24.2 && floIMC <= 28.8) {
                        avaliacao = "Sobrepeso";
                    } else if (floIMC > 28.2) {
                        avaliacao = "Obesidade";
                    }

                }
            }

        }


        Intent intent = new Intent(this, ResultActivity.class);


        intent.putExtra(RESULTADO, "Olá, seu IMC é " + floIMC + " e sua situação é  " + avaliacao+" - "+txtSexo);



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









        // Linhas inibidas originais */
        startActivity(intent);








    }

}


