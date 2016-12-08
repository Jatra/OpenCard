package uk.co.jatra.opencard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Data data = (Data)getIntent().getSerializableExtra("data");
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(data.imageResourceId);
        ((TextView)findViewById(R.id.textView3)).setText(data.text1);
        ((TextView)findViewById(R.id.textView4)).setText(data.text2);
    }
}
