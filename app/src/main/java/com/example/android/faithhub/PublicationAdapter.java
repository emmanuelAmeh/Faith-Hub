package com.example.android.faithhub;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PublicationAdapter extends PagedListAdapter<Publication, PublicationAdapter.PublicationViewHolder> {
    public PublicationAdapter(){
        super(DIFF_CALLBACK);
    }

    public static DiffUtil.ItemCallback<Publication> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Publication>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(Publication oldPublication, Publication newPublication) {
                    return oldPublication.getId() == newPublication.getId();
                }

                @Override
                public boolean areContentsTheSame(Publication oldPublication,
                                                  Publication newPublication) {
                    return oldPublication.getAuthor().equals(newPublication.getAuthor()) &&
                            oldPublication.getTitle().equals(newPublication.getTitle()) &&
                            oldPublication.getSeries().equals(newPublication.getSeries()) &&
                            oldPublication.getSummary().equals(newPublication.getSummary()) &&
                            oldPublication.getDatePublished() == newPublication.getDatePublished() &&
                            oldPublication.getImageSrc().equals(newPublication.getImageSrc()) &&
                            oldPublication.getPages() == newPublication.getPages() &&
                            oldPublication.getSize() == newPublication.getSize() &&
                            oldPublication.isArticle() == newPublication.isArticle() &&
                            oldPublication.isBook() == newPublication.isBook();
                }
            };

    @NonNull
    @Override
    public PublicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.publication_layout, parent, false);
        return new PublicationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicationViewHolder holder, int position) {
        Publication publication = getItem(position);
        if (publication != null) {
            Log.d("TESTER", publication.getTitle());
            Toast.makeText(holder.itemView.getContext(), publication.getTitle(), Toast.LENGTH_SHORT).show();
            holder.tvTitle.setText(publication.getTitle());
            holder.tvAuthor.setText(publication.getAuthor());
            holder.tvSize.setText(publication.getSize() + " mb");
            holder.tvPubYear.setText(publication.getPub_year() + "");
        } else {
            // Null defines a placeholder item - PagedListAdapter automatically
            // invalidates this row when the actual object is loaded from the
            // database.
           // holder.clear();
        }
    }


    public  class PublicationViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvSize;
        private TextView tvPubYear;

        public PublicationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.pub_title);
            tvAuthor = itemView.findViewById(R.id.pub_author);
            tvSize = itemView.findViewById(R.id.pub_size);
            tvPubYear = itemView.findViewById(R.id.pub_year);
        }
    }


}
