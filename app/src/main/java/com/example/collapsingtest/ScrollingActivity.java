package com.example.collapsingtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;
    private RecyclerView recyclerView;
    private PlanetasAdapter planetasAdapter;
    private Menu collapsedMenu;
    private boolean appBarExpanded = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        final Toolbar toolbar = findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appBarLayout = findViewById(R.id.appbar);
        collapsingToolbar = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(R.string.android_planetas));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.sistemasolar);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {
                int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                collapsingToolbar.setContentScrimColor(vibrantColor);
                collapsingToolbar.setStatusBarScrimColor(R.color.colorPrimaryDark);
            }
        });

        recyclerView = findViewById(R.id.scrollableview);
        // Use quando o tamanho da lista é constante para melhorar desempenho
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        planetasAdapter = new PlanetasAdapter(this, onClickPlaneta());
        recyclerView.setAdapter(planetasAdapter);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                // Vertical offset == 0 indica que appBar
                // está totalmente expandido.
                if (Math.abs(verticalOffset) > 200) {
                    appBarExpanded = false;
                    invalidateOptionsMenu();
                } else {
                    appBarExpanded = true;
                    invalidateOptionsMenu();
                }
            }
        });

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (collapsedMenu != null && (!appBarExpanded || collapsedMenu.size() != 1)) {
            //recolhido (collapsed)
            collapsedMenu.add("Add") // adiciona a ação "+" no lugar do FAB
                    .setIcon(R.drawable.ic_baseline_add_24)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else {
            //expandido (expanded)
        }

        return super.onPrepareOptionsMenu(collapsedMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        collapsedMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_settings:
                return true;
        }

        if (item.getTitle() == "Add") { // no lugar do FAB no recolhimento
            Toast.makeText(this, "Você clicou no ADD, antigo FAB",
                    Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickFAB(View view) {
        Snackbar.make(view, "Você clicou no FAB",
                Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    protected PlanetasAdapter.ListenerPlaneta onClickPlaneta() {
        return new PlanetasAdapter.ListenerPlaneta() {
            @Override
            public void onClick(PlanetasAdapter.PlanetaViewHolder holder, int idx) {
                Planeta planeta = Planeta.getPlanetas().get(idx);
                Toast.makeText(getBaseContext(), "Você clicou no Planeta: " +
                        planeta.getNome(), Toast.LENGTH_LONG).show();
            }
        };
    }
}