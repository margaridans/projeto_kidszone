package pt.ipp.estg.projeto_kidszone.Retrofit;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pt.ipp.estg.projeto_kidszone.R;


/**
 * Created by margarida on 21/12/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<POI> poiList;

    public RecyclerAdapter(List<POI> poiList) {
        this.poiList = poiList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Location.setText(poiList.get(position).getLocation());
        holder.Category.setText(poiList.get(position).getCategory());
        holder.Name.setText(poiList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return poiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Location, Category, Name;
        public MyViewHolder(View itemView) {
            super(itemView);
            Location=(TextView)itemView.findViewById(R.id.location);
            Category=(TextView)itemView.findViewById(R.id.category);
            Name=(TextView)itemView.findViewById(R.id.name);


        }
    }


}
