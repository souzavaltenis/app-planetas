package com.example.collapsingtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetasAdapter extends RecyclerView.Adapter<PlanetasAdapter.PlanetaViewHolder> {

    private List<Planeta> planetas;
    private Context context;
    private final ListenerPlaneta listenerPlaneta;

    public interface ListenerPlaneta {
        public void onClick(PlanetaViewHolder holder, int idx);
    }

    public PlanetasAdapter(Context context, ListenerPlaneta listenerPlaneta) {
        this.context = context;
        this.listenerPlaneta = listenerPlaneta;
        this.planetas = Planeta.getPlanetas();
    }

    @Override
    public PlanetaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_planeta, parent, false);
        return new PlanetaViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return planetas == null ? 0 : planetas.size();
    }

    @Override
    public void onBindViewHolder(final PlanetaViewHolder holder, final int position) {

        Planeta planeta = this.planetas.get(position);
        holder.txt_nome.setText(planeta.getNome());
        holder.txt_desc.setText(planeta.getDescricao());
        holder.ivImgPlaneta.setImageResource(planeta.getImg());

        // Click
        if (listenerPlaneta != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chama o listener para informar que clicou no Estado
                    listenerPlaneta.onClick(holder, position);
                }
            });
        }
    }

    public static class PlanetaViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_nome;
        private TextView txt_desc;
        private ImageView ivImgPlaneta;

        public PlanetaViewHolder(View itemView) {
            super(itemView);
            txt_nome = itemView.findViewById(R.id.txt_nome);
            txt_desc = itemView.findViewById(R.id.txt_desc);
            ivImgPlaneta = itemView.findViewById(R.id.ivImgPlaneta);
        }
    }

}
