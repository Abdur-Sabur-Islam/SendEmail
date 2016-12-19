package email.send.sendemail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by acer on 12/19/2016.
 */

public class Email {
    private Context context;
    private String subject;
    private String text;
    private String[] emailAddress;

    public Email(Context context, String[] emailAddress, String subject, String text) {
        this.context = context;
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.text = text;
    }

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,text);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
