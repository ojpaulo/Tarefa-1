package unyleya.mediaaluno;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import unyleya.mediaaluno.MainActivity;
import unyleya.mediaaluno.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

