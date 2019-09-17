package xyz.webflutter.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pojo> pojos;

    void setAdapter(ArrayList<Pojo> pojos){
        this.pojos = pojos;
    }

    Adapter(Context context){
        this.context = context;
        pojos = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return pojos.size();
    }

    @Override
    public Object getItem(int position) {
        return pojos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Pojo pojo = (Pojo) getItem(position);
        viewHolder.bind(pojo);
        return convertView;
    }
    private class ViewHolder {

        private TextView tvTitle, tvReleased, tvReleaseDate, tvActor1, tvActor2, tvActor3;
        private ImageView ivPoster;

        ViewHolder(View convertView) {
            tvTitle = convertView.findViewById(R.id.title_film_home);
            tvReleased = convertView.findViewById(R.id.statue_film_home);
            tvReleaseDate = convertView.findViewById(R.id.release_film_home);
            tvActor1 = convertView.findViewById(R.id.actor_1);
            tvActor2 = convertView.findViewById(R.id.actor_2);
            tvActor3 = convertView.findViewById(R.id.actor_3);
            ivPoster = convertView.findViewById(R.id.poster_home);
        }

        void bind (Pojo pojo){
            tvTitle.setText(pojo.getJudul());
            tvReleased.setText(pojo.getStatus());
            tvReleaseDate.setText(pojo.getTanggalRilis());
            tvActor1.setText(pojo.getActor1());
            tvActor2.setText(pojo.getActor2());
            tvActor3.setText(pojo.getActor3());
            ivPoster.setImageResource(pojo.getPoster());
        }
    }
}
