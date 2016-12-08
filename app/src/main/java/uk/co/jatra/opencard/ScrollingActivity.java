package uk.co.jatra.opencard;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;
import static uk.co.jatra.opencard.Data.data1;
import static uk.co.jatra.opencard.Data.data2;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new DataAdapter());

        //If a divider is wanted....
//        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
//                layoutManager.getOrientation());
//        recyclerView.addItemDecoration(mDividerItemDecoration);
        //no divider in this example, since the list is using cards with distinct edges
    }

    private void launchDataActivity(View sharedView, Data data) {
        Intent intent = new Intent(this, DataActivity.class);
        //Pass the data to the new activity
        intent.putExtra("data", data);
        //tell the activity transition to share the layout, using the name "content"
        ActivityOptions options = makeSceneTransitionAnimation(this, sharedView, "content");
        startActivity(intent, options.toBundle());
    }

    private class DataAdapter extends RecyclerView.Adapter {
        List<Data> data = Arrays.asList(data1, data2, data1, data2, data1, data2);

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final Data dataItem = data.get(position);
            dataItem.setData(holder.itemView);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View cardContent = view.findViewById(R.id.cardContent);
                    launchDataActivity(cardContent, dataItem);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

}
