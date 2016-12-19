package email.send.sendemail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText emailAddressEt, subjectEt,textEt;
    String[] address;
    Button sendEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailAddressEt = (EditText) findViewById(R.id.emailAddressEt);
        subjectEt = (EditText) findViewById(R.id.subjectEt);
        textEt = (EditText) findViewById(R.id.textEt);
        sendEmailBtn = (Button) findViewById(R.id.sendEmailBtn);
        sendEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddressSt = emailAddressEt.getText().toString();
                address = new String[]{emailAddressSt};
                String subjectSt = subjectEt.getText().toString();
                String textSt = textEt.getText().toString();
                Email email = new Email(MainActivity.this,address,subjectSt,textSt);
                email.composeEmail();
            }
        });
    }
}
