package xyz.webflutter.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataDeskripsi;
    private String[] dataStatus;
    private String[] dataTanggalRilis;
    private String[] dataBudget;
    private String[] dataRevenue;
    private String[] dataBahasa;
    private String[] dataActor1;
    private String[] dataActor2;
    private String[] dataActor3;
    private String[] dataGenre;
    private TypedArray dataPoster;
    private Adapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new Adapter(this);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        initArray();
        addFilm();

        //OnClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, pojos.get(position).getJudul(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                try {
                    Pojo pojo = new Pojo();
                    pojo.setJudul(dataJudul[position]);
                    pojo.setDeskripsi(dataDeskripsi[position]);
                    pojo.setTanggalRilis(dataTanggalRilis[position]);
                    pojo.setBahasa(dataBahasa[position]);
                    pojo.setBudget(dataBudget[position]);
                    pojo.setRevenue(dataRevenue[position]);
                    pojo.setStatus(dataStatus[position]);
                    pojo.setActor1(dataActor1[position]);
                    pojo.setActor2(dataActor2[position]);
                    pojo.setActor3(dataActor3[position]);
                    pojo.setGenre(dataGenre[position]);
                    pojo.setPoster(dataPoster.getResourceId(position, -1));
                    intent.putExtra(DetailActivity.EXTRA_DATA, pojo);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void addFilm() {
        ArrayList<Pojo> pojos = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Pojo pojo = new Pojo();
            pojo.setJudul(dataJudul[i]);
            pojo.setStatus(dataStatus[i]);
            pojo.setTanggalRilis(dataTanggalRilis[i]);
            pojo.setActor1(dataActor1[i]);
            pojo.setActor2(dataActor2[i]);
            pojo.setActor3(dataActor3[i]);
            pojo.setPoster(dataPoster.getResourceId(i, -1));
            pojos.add(pojo);
        }
        adapter.setAdapter(pojos);
    }

    private void initArray() {
        dataJudul = getResources().getStringArray(R.array.title);
        dataDeskripsi = getResources().getStringArray(R.array.overview);
        dataBahasa = getResources().getStringArray(R.array.language);
        dataStatus = getResources().getStringArray(R.array.statue);
        dataBudget = getResources().getStringArray(R.array.budget);
        dataRevenue = getResources().getStringArray(R.array.revenue);
        dataTanggalRilis = getResources().getStringArray(R.array.release_date);
        dataActor1 = getResources().getStringArray(R.array.array_actor1);
        dataActor2 = getResources().getStringArray(R.array.array_actor2);
        dataActor3 = getResources().getStringArray(R.array.array_actor3);
        dataGenre = getResources().getStringArray(R.array.genre);
        dataPoster = getResources().obtainTypedArray(R.array.array_poster);
    }
}
