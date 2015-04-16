package weitang114.com.libhello.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import weitang114.com.libhello.R;
import weitang114.com.libhello.object.HelloCardsData;

/**
 * Created by weitang114 on 15/4/16.
 */
public class HelloAdapter extends RecyclerView.Adapter<HelloAdapter.HelloViewHolder> {

    List<HelloCardsData.HelloData> data;

    public HelloAdapter(List<HelloCardsData.HelloData> data) {
        this.data = data;
    }


    @Override
    public HelloViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.libhello__cardview, parent, false);
        return new HelloViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(HelloViewHolder holder, int position) {
        holder.titleView.setText(data.get(position).title);
        holder.helloView.setText(data.get(position).hello);
    }

    public static class HelloViewHolder extends RecyclerView.ViewHolder {
        protected TextView titleView;
        protected TextView helloView;

        public HelloViewHolder(View v) {
            super(v);
            titleView =  (TextView) v.findViewById(R.id.libhello__txt_title);
            helloView = (TextView)  v.findViewById(R.id.libhello__txt_hello);
        }
    }

}
