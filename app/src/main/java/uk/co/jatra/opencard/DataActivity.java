package uk.co.jatra.opencard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class DataActivity extends AppCompatActivity {

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = (Data)getIntent().getSerializableExtra("data");
        setContentView(R.layout.activity_data);
        data.setData(findViewById(R.id.cardContent));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DataActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDisplayActivity();
            }
        });
    }

    private void launchDisplayActivity() {
        Intent intent = new Intent(this, DisplayActivity.class);
        //pass the data to populate the DataActivity
        intent.putExtra("data", data);
        //tell the activity transition to share the layout "sharedView" using the name "content"
        ActivityOptionsCompat options = makeSceneTransitionAnimation(this,
                Pair.create(findViewById(R.id.imageView), "image"),
                Pair.create(findViewById(R.id.textView), "where"),
                Pair.create(findViewById(R.id.textView2), "when"));
        startActivity(intent, options.toBundle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
