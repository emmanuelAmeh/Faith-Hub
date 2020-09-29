package com.example.android.faithhub;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import java.util.List;

public class FaithHubViewModel extends AndroidViewModel {
    private FaithHubRepository mFaithHubRepository;
    private LiveData<List<AudioVisual>> mAllAudioVisuals;
    private LiveData<List<Publication>> mAllPublications;
    private LiveData<PagedList<Publication>> publicationList;
    private LiveData<PagedList<AudioVisual>> audioVisualList;

    public FaithHubViewModel(@NonNull Application application) {
        super(application);
        mFaithHubRepository = new FaithHubRepository(application);
        mAllAudioVisuals = mFaithHubRepository.getAllAudioVisuals();
        mAllPublications = mFaithHubRepository.getAllPublications();
        publicationList = mFaithHubRepository.getPublicationList();
        audioVisualList = mFaithHubRepository.getAudioVisualList();
    }

    public LiveData<PagedList<Publication>> getPublicationList() {
        return publicationList;
    }

    public LiveData<PagedList<AudioVisual>> getAudioVisualList() {
        return audioVisualList;
    }
}
