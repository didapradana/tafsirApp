package com.example.tafsir;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TafsirAdapter extends RecyclerView.Adapter<TafsirAdapter.ViewHolder> {

    private ArrayList<DataTafsirModel> dataTafsir;
    private int listItemLayout;
    private Context context;

    public TafsirAdapter(Context c, int layoutId, ArrayList<DataTafsirModel> dataTafsir) {
        context = c;
        listItemLayout = layoutId;
        this.dataTafsir = dataTafsir;
    }

    @Override
    public TafsirAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final TafsirAdapter.ViewHolder holder, int position) {
        final int arrayPosition = position;
        final String textPosition = dataTafsir.get(position).getText();
        holder.tvText.setText(textPosition);
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

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvText = itemView.findViewById(R.id.text_list);
        }

        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + tvText.getText());
        }
    }
}
