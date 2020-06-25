package com.example.toppoland;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.example.toppoland.model.Item;
import com.squareup.picasso.Picasso;


import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_row_user, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.identifier.setText(items.get(i).getHtmlUrl());
        viewHolder.name.setText(items.get(i).getLogin());

        Picasso.with(context)
                .load(items.get(i).getAvatarUrl())
                .into(viewHolder.avatar);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView identifier, name;
        private ImageView avatar;


        public ViewHolder(View view) {
            super(view);
            identifier = (TextView) view.findViewById(R.id.identifier);
            name = (TextView) view.findViewById(R.id.name);
            avatar = (ImageView) view.findViewById(R.id.avatar);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://github.com/"+name.getText());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                }

            });
        }
    }
}
