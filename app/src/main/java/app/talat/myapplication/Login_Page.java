package app.talat.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Login_Page extends AppCompatActivity {
    private TextView textView6;
    private ProgressBar progressBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        textView6 = findViewById(R.id.textView6);
        progressBar2 = findViewById(R.id.progressBar2);


        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                progressBar2.setVisibility(View.INVISIBLE);
                Thread thread = new Thread() {
                    public void run() {

                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Intent newPage = new Intent(Login_Page.this, MainActivity.class);
                            startActivity(newPage);
                            finish();
                        }

                    }

                };
                thread.start();


                progressBar2.setVisibility(View.VISIBLE);

            }
        });


    }
}

