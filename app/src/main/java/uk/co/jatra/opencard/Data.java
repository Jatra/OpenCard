package uk.co.jatra.opencard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Data implements Serializable {

    public static Data data1 = new Data(R.drawable.eastbournepier, "Eastbourne", "1870");
    public static Data data2 = new Data(R.drawable.brightonpier, "Brighton", "1899");

    int imageResourceId;
    String text1;
    String text2;

    public Data(int imageResourceId, String text1, String text2) {
        this.imageResourceId = imageResourceId;
        this.text1 = text1;
        this.text2 = text2;
    }

    public void setData(View card) {
        ((ImageView)card.findViewById(R.id.imageView)).setImageResource(imageResourceId);
        ((TextView)card.findViewById(R.id.textView)).setText(text1);
        ((TextView)card.findViewById(R.id.textView2)).setText(text2);
    }

}
