package com.example.tafsir.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tafsir.DataTafsirModel;
import com.example.tafsir.R;
import com.example.tafsir.model.TafsirWajizModel;

import java.util.List;

public class NewTafsirAdapter extends RecyclerView.Adapter<NewTafsirAdapter.ViewHolder> {

    private List<TafsirWajizModel> dataTafsir;
    private int listItemLayout;
    private Context context;

    public NewTafsirAdapter(Context c, int layoutId, List<TafsirWajizModel> dataTafsir) {
        context = c;
        listItemLayout = layoutId;
        this.dataTafsir = dataTafsir;
    }

    @Override
    public NewTafsirAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final NewTafsirAdapter.ViewHolder holder, int position) {
        int arrayPosition = position;
        String textPosition = dataTafsir.get(position).getText();
        int ayatPosition = dataTafsir.get(position).getAya();
        holder.tvText.setText(textPosition);
        holder.tvAya.setText("Ayat " + ayatPosition);
    }

    @Override
    public int getItemCount() {
        return dataTafsir == null ? 0 : dataTafsir.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvText;
        public TextView tvAya;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvText = itemView.findViewById(R.id.text_list);
            tvAya = itemView.findViewById(R.id.tv_ayat);
        }

        @Override
        public void onClick(View v) { }
    }
}
