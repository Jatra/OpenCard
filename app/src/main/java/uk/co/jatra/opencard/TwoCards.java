package uk.co.jatra.opencard;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;
import static uk.co.jatra.opencard.Data.data1;
import static uk.co.jatra.opencard.Data.data2;

public class TwoCards extends AppCompatActivity {

    //Just two views, to remove the extraneous scaffolding required for a real list.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View card1 = findViewById(R.id.card1);
        data1.setData(card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View cardContent = card1.findViewById(R.id.cardContent);
                launchDataActivity(cardContent, data1);
            }
        });

        final View card2 = findViewById(R.id.card2);
        data2.setData(card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View cardContent = card2.findViewById(R.id.cardContent);
                launchDataActivity(cardContent, data2);
            }
        });
    }

    private void launchDataActivity(View sharedView, Data data) {
        Intent intent = new Intent(this, DataActivity.class);
        //pass the data to populate the DataActivity
        intent.putExtra("data", data);
        //tell the activity transition to share the layout "sharedView" using the name "content"
        ActivityOptions options = makeSceneTransitionAnimation(this, sharedView, "content");
        startActivity(intent, options.toBundle());
    }

}
