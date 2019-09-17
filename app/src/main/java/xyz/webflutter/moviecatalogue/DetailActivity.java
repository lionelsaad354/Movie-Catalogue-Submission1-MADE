package xyz.webflutter.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "data_film";
    String tvTitle, tvOverview, tvReleased, tvStatue, tvBudget, tvRevenue, tvLanguage, tvActor1, tvActor2, tvActor3, tvGenre;
    TextView title, overview, releasedDate, statue, budget, revenue, language, actor1, actor2, actor3, genre;
    ImageView poster;
    CardView cvActor1, cvActor2, cvActor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.title_film);
        overview = findViewById(R.id.overview_film);
        releasedDate = findViewById(R.id.date_film);
        statue = findViewById(R.id.release_statue);
        budget = findViewById(R.id.budget_film);
        revenue = findViewById(R.id.revenue_film);
        language = findViewById(R.id.language);
        actor1 = findViewById(R.id.actor_1_detail);
        actor2 = findViewById(R.id.actor_2_detail);
        actor3 = findViewById(R.id.actor_3_detail);
        genre = findViewById(R.id.genre);
        poster = findViewById(R.id.poster);
        cvActor1 = findViewById(R.id.cv_actor1);
        cvActor2 = findViewById(R.id.cv_actor2);
        cvActor3 = findViewById(R.id.cv_actor3);

        Pojo pojo = getIntent().getParcelableExtra(EXTRA_DATA);
        tvTitle = pojo.getJudul();
        tvOverview = pojo.getDeskripsi();
        tvReleased = pojo.getTanggalRilis();
        tvStatue = pojo.getStatus();
        tvBudget = pojo.getBudget();
        tvRevenue = pojo.getRevenue();
        tvLanguage = pojo.getBahasa();
        tvActor1 = pojo.getActor1();
        tvActor2 = pojo.getActor2();
        tvActor3 = pojo.getActor3();
        tvGenre = pojo.getGenre();
        int ivPoster = pojo.getPoster();

        title.setText(tvTitle);
        overview.setText(tvOverview);
        releasedDate.setText(tvReleased);
        statue.setText(tvStatue);
        budget.setText(tvBudget);
        revenue.setText(tvRevenue);
        language.setText(tvLanguage);
        actor1.setText(tvActor1);
        actor2.setText(tvActor2);
        actor3.setText(tvActor3);
        genre.setText(tvGenre);
        poster.setImageResource(ivPoster);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cvActor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, tvActor1 + " is one of the actors in the film " + tvTitle, Toast.LENGTH_SHORT).show();
            }
        });
        cvActor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, tvActor2 + " is one of the actors in the film " + tvTitle, Toast.LENGTH_SHORT).show();
            }
        });
        cvActor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, tvActor3 + " is one of the actors in the film " + tvTitle, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
