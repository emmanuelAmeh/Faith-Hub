package com.example.android.faithhub;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class AudioVisualAdapter extends PagedListAdapter<AudioVisual, AudioVisualAdapter.AudioVisualViewHolder> {
    public static DiffUtil.ItemCallback<AudioVisual> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<AudioVisual>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(AudioVisual oldAudioVisual, AudioVisual newAudioVisual) {
                    return oldAudioVisual.getId() == newAudioVisual.getId();
                }

                @Override
                public boolean areContentsTheSame(AudioVisual oldAudioVisual,
                                                  AudioVisual newAudioVisual) {
                    return oldAudioVisual.getSpeaker().equals(newAudioVisual.getSpeaker()) &&
                            oldAudioVisual.getTitle().equals(newAudioVisual.getTitle()) &&
                            oldAudioVisual.getSeries().equals(newAudioVisual.getSeries()) &&
                            oldAudioVisual.getSummary().equals(newAudioVisual.getSummary()) &&
                            oldAudioVisual.getImageSrc().equals(newAudioVisual.getImageSrc()) &&
                            oldAudioVisual.getAudioSrc().equals(newAudioVisual.getAudioSrc()) &&
                            oldAudioVisual.getVideoSrc().equals(newAudioVisual.getVideoSrc()) &&
                            oldAudioVisual.getDateCreated() == newAudioVisual.getDateCreated() &&
                            oldAudioVisual.getDuration() == newAudioVisual.getDuration() &&
                            oldAudioVisual.getAudioSize() == newAudioVisual.getAudioSize() &&
                            oldAudioVisual.getVideoSize() == newAudioVisual.getVideoSize();
                }
            };

    public AudioVisualAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public AudioVisualViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_visual_item, parent, false);
        return new AudioVisualViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioVisualViewHolder holder, int position) {
        AudioVisual audioVisual = getItem(position);
        if (audioVisual != null) {
            Log.d("TESTER", audioVisual.getTitle());
            Toast.makeText(holder.itemView.getContext(), audioVisual.getTitle(), Toast.LENGTH_SHORT).show();
            holder.tvTitle.setText(audioVisual.getTitle());
            //          holder.tvSpeaker.setText(audioVisual.getSpeaker());
            holder.tvSize.setText(audioVisual.getAudioSize() + " mb");
            holder.tvDateCreated.setText(audioVisual.getDateCreated() + "");
        } else {
            // Null defines a placeholder item - PagedListAdapter automatically
            // invalidates this row when the actual object is loaded from the
            // database.
            // holder.clear();
        }
    }


    public class AudioVisualViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivClipArt;
        private TextView tvTitle;

        //TODO include speaker
        private TextView tvSpeaker;

        private TextView tvSize;
        private TextView tvDateCreated;

        public AudioVisualViewHolder(@NonNull View itemView) {
            super(itemView);

            ivClipArt = itemView.findViewById(R.id.iv_av_clipart);
            // tvSpeaker = itemView.findViewById(R.id.tv);
            tvTitle = itemView.findViewById(R.id.tv_av_title);
            tvSize = itemView.findViewById(R.id.tv_av_size);
            tvDateCreated = itemView.findViewById(R.id.tv_av_release_date);
        }
    }


}
