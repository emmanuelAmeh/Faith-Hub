package com.example.android.faithhub.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.faithhub.FaithHubViewModel;
import com.example.android.faithhub.Publication;
import com.example.android.faithhub.PublicationAdapter;
import com.example.android.faithhub.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        FaithHubViewModel viewModel =
                new ViewModelProvider(this).get(FaithHubViewModel.class);
        RecyclerView recyclerView = root.findViewById(R.id.pub_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final PublicationAdapter adapter = new PublicationAdapter();

        viewModel.getPublicationList().observe(requireActivity(), new Observer<PagedList<Publication>>() {
            @Override
            public void onChanged(PagedList<Publication> publications) {
                adapter.submitList(publications);
            }
        });

        recyclerView.setAdapter(adapter);

        /*final TextView textView = root.findViewById(R.id.section_label);

        pageViewModel.getText().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}