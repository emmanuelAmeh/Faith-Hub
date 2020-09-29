package com.example.android.faithhub.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.faithhub.AudioVisual;
import com.example.android.faithhub.AudioVisualAdapter;
import com.example.android.faithhub.FaithHubViewModel;
import com.example.android.faithhub.Publication;
import com.example.android.faithhub.PublicationAdapter;
import com.example.android.faithhub.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AudioVisualFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private FaithHubViewModel mFaithHubViewModel;


    public static AudioVisualFragment newInstance(int index) {
        AudioVisualFragment fragment = new AudioVisualFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFaithHubViewModel = new ViewModelProvider(this).get(FaithHubViewModel.class);


    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.pub_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final AudioVisualAdapter audioVisualAdapter = new AudioVisualAdapter();

        mFaithHubViewModel.getAudioVisualList().observe(requireActivity(), new Observer<PagedList<AudioVisual>>() {
            @Override
            public void onChanged(PagedList<AudioVisual> audioVisuals) {
                audioVisualAdapter.submitList(audioVisuals);
            }
        });

        recyclerView.setAdapter(audioVisualAdapter);

        return root;
    }
}