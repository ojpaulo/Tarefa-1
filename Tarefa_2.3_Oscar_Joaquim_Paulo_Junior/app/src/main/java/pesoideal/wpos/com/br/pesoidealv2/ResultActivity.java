package pesoideal.wpos.com.br.pesoidealv2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;


public class ResultActivity extends Activity {
    // Atributo para representar o rótulo lblResultado.
    private TextView lblResultado;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        Intent intent = getIntent();


        lblResultado.setText(intent.getStringExtra(MainActivity.RESULTADO));
    }
}





