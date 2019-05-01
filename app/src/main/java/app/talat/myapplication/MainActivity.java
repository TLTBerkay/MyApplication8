package app.talat.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView2;
    private TextView textView;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private TextView textView7;
    private Button button;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editTextName);
        editText2 = findViewById(R.id.editTextEmail);
        editText3 = findViewById(R.id.pass);
        editText4 = findViewById(R.id.cpass);
        textView7 = findViewById(R.id.textView7);
        button = findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        //kayıt sayfasında  olması gerekenler password match edilelcekler isim mail girilmesi lazım

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editText3.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        String pass = editText3.getText().toString();
                        String cpass = editText4.getText().toString();
//                        String name = editText.getText().toString();
//                        String email = editText2.getText().toString();

                        if (pass.equals(cpass) && editText.getText().toString().trim().equals("") && editText2.getText().toString().trim().equals("")) {
                            Intent login_page = new Intent(MainActivity.this, Login_page.class);
                            startActivity(login_page);
                            finish();

                        } else if (!pass.equals(cpass)) {
                            textView7.setText("şifreler aynı değil");
                        }

                    }else

                    {
                        textView7.setText("hata iligili alanları doldurun");
                    }


                }
            });


        }
    });


    //sorun yok aşağısı çalısıyor


        textView2.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){

        progressBar.setVisibility(View.INVISIBLE);
        Thread thread = new Thread() {
            public void run() {

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent newPage = new Intent(MainActivity.this, Login_page.class);
                    startActivity(newPage);
                    finish();
                }

            }

        };
        thread.start();


        progressBar.setVisibility(View.VISIBLE);

    }


    });


}
}