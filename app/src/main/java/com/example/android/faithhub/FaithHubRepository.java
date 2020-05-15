package com.example.android.faithhub;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.List;

public class FaithHubRepository {
    private AudioVisualDao mAudioVisualDao;
    private PublicationDao mPublicationDao;

    private LiveData<List<AudioVisual>> mAllAudioVisuals;
    private LiveData<List<Publication>> mAllPublications;

    public  LiveData<PagedList<Publication>> publicationList;

    public FaithHubRepository(Application application) {
        FaithHubDatabase db = FaithHubDatabase.getDatabase(application);
        mAudioVisualDao = db.audioVisualDao();
        mPublicationDao = db.publicationDao();

        mAllAudioVisuals = mAudioVisualDao.getAllAudioVisuals();
        mAllPublications = mPublicationDao.getAllPublication();

        //using paging
        publicationList = new LivePagedListBuilder<>(
                mPublicationDao.getPublicationById(), 50)
                .build();
    }

    LiveData<List<AudioVisual>> getAllAudioVisuals(){
        return mAllAudioVisuals;
    }
    LiveData<List<Publication>> getAllPublications(){
        return mAllPublications;
    }

    LiveData<PagedList<Publication>> getPublicationList(){
        return publicationList;
    }


    public void insertAudioVisual (AudioVisual audioVisual) {
        new insertAudioVisualAsyncTask(mAudioVisualDao).execute(audioVisual);
    }

    private static class insertAudioVisualAsyncTask extends AsyncTask<AudioVisual, Void, Void> {

        private AudioVisualDao  mAsyncTaskDao;

        insertAudioVisualAsyncTask(AudioVisualDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(AudioVisual... audioVisual) {
            mAsyncTaskDao.insertAudioVisual(audioVisual[0]);
            return null;
        }
    }

    public void deleteAudioVisual (AudioVisual audioVisual) {
        new deleteAudioVisualAsyncTask(mAudioVisualDao).execute(audioVisual);
    }

    private static class deleteAudioVisualAsyncTask extends AsyncTask<AudioVisual, Void, Void> {

        private AudioVisualDao  mAsyncTaskDao;

        deleteAudioVisualAsyncTask(AudioVisualDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(AudioVisual... audioVisual) {
            mAsyncTaskDao.deleteAudioVisual(audioVisual[0]);
            return null;
        }
    }

    public void updateAudioVisual (AudioVisual audioVisual) {
        new updateAudioVisualAsyncTask(mAudioVisualDao).execute(audioVisual);
    }

    private static class updateAudioVisualAsyncTask extends AsyncTask<AudioVisual, Void, Void> {

        private AudioVisualDao  mAsyncTaskDao;

        updateAudioVisualAsyncTask(AudioVisualDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(AudioVisual... audioVisual) {
            mAsyncTaskDao.updateAudioVisual(audioVisual[0]);
            return null;
        }
    }

   /* public void audioVisualBySpeaker (DataSource.Factory<Integer, AudioVisual>  audioVisual) {
        new audioVisualBySpeakerAsyncTask(mAudioVisualDao).execute(audioVisual);
    }

    private static class audioVisualBySpeakerAsyncTask extends AsyncTask<DataSource.Factory<Integer, AudioVisual> , Void, Void> {

        private AudioVisualDao  mAsyncTaskDao;

        audioVisualBySpeakerAsyncTask(AudioVisualDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(DataSource.Factory<Integer, AudioVisual> ... audioVisuals) {
            mAsyncTaskDao.getAudioVisualById(audioVisuals[0]);
            return null;
        }
    }
*/
  /*  public void audioVisualBySpeaker2 (DataSource.Factory<Integer, AudioVisual>  audioVisual) {
        new audioVisualBySpeakerAsyncTask2(mAudioVisualDao).execute(audioVisual);
    }

    private static class audioVisualBySpeakerAsyncTask2 extends AsyncTask<DataSource.Factory<Integer, AudioVisual> , Void, Void> {

        private AudioVisualDao  mAsyncTaskDao;
        public  LiveData<PagedList<Publication>> publicationList;

        audioVisualBySpeakerAsyncTask2(AudioVisualDao dao) {
            mAsyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(DataSource.Factory<Integer, AudioVisual> ... audioVisuals) {
            publicationList = new LivePagedListBuilder<>(
                    mAsyncTaskDao.getAudioVisualById(), 50)
                    .build();
            return null;
        }
    }*/

    public void deleteAllAudioVisual () {
        new deleteAllAudioVisualAsyncTask(mAudioVisualDao).execute();
    }

    private static class deleteAllAudioVisualAsyncTask extends AsyncTask<Void, Void, Void> {

        private AudioVisualDao  mAsyncTaskDao;

        deleteAllAudioVisualAsyncTask(AudioVisualDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAllAudioVisuals();
            return null;
        }
    }

    //for Publication
    public void insertPublication (Publication publication) {
        new insertPublicationAsyncTask(mPublicationDao).execute(publication);
    }

    private static class insertPublicationAsyncTask extends AsyncTask<Publication, Void, Void> {

        private PublicationDao  mAsyncTaskDao;

        insertPublicationAsyncTask(PublicationDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Publication... publications) {
            mAsyncTaskDao.insertPublication(publications[0]);
            return null;
        }
    }

    public void deletePublication (Publication publication) {
        new deletePublicationAsyncTask(mPublicationDao).execute(publication);
    }

    private static class deletePublicationAsyncTask extends AsyncTask<Publication, Void, Void> {

        private PublicationDao  mAsyncTaskDao;

        deletePublicationAsyncTask(PublicationDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Publication... publications) {
            mAsyncTaskDao.deletePublication(publications[0]);
            return null;
        }
    }

    public void updatePublication (Publication publication) {
        new updatePublicationAsyncTask(mPublicationDao).execute(publication);
    }

    private static class updatePublicationAsyncTask extends AsyncTask<Publication, Void, Void> {

        private PublicationDao  mAsyncTaskDao;

        updatePublicationAsyncTask(PublicationDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Publication... publications) {
            mAsyncTaskDao.updatePublication(publications[0]);
            return null;
        }
    }

    public void deleteAllPublication () {
        new deleteAllPublicationAsyncTask(mPublicationDao).execute();
    }

    private static class deleteAllPublicationAsyncTask extends AsyncTask<Void, Void, Void> {

        private PublicationDao  mAsyncTaskDao;

        deleteAllPublicationAsyncTask(PublicationDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAllPublication();
            return null;
        }
    }
}
