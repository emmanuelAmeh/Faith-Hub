package com.example.android.faithhub;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {AudioVisual.class, Publication.class}, version = 4, exportSchema = false)
public abstract class FaithHubDatabase extends RoomDatabase {

    public abstract AudioVisualDao audioVisualDao();
    public abstract PublicationDao publicationDao();

    private static volatile FaithHubDatabase INSTANCE;

    public static FaithHubDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FaithHubDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FaithHubDatabase.class, "faithhub_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            //.addMigrations(MIGRATION_2_3)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };


    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AudioVisualDao mAudioVisualDao;
        private final PublicationDao mPublicationDao;

        String[] words = {"dolphin", "crocodile", "cobra"};
        String[] answers = {"This is a sea animal", "A kind of reptile that looks like a big lizard", "cobra"};

        PopulateDbAsync(FaithHubDatabase db) {
            mAudioVisualDao = db.audioVisualDao();
            mPublicationDao = db.publicationDao();
        }


        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
            mAudioVisualDao.deleteAllAudioVisuals();
            mPublicationDao.deleteAllPublication();

           Publication publication1 = new Publication("Kenneth Copeland", "The Believer's Authority - part 1", "The Believer's Authority",
                   "It is all Victory ...", "source1", 2030, 100l, 22, 13, false, true);
           mPublicationDao.insertPublication(publication1);
            Publication publication2 = new Publication("Kenneth Copeland", "The Believer's Authority - part 2", "The Believer's Authority",
                    "It is all Victory ...", "source1", 2030, 100l, 23, 14, false, true);
            mPublicationDao.insertPublication(publication2);
            Publication publication3 = new Publication("Kenneth Copeland", "The Believer's Authority - part 3", "The Believer's Authority",
                    "It is all Victory ...", "source1", 2030, 100l, 33, 21, false, true);
            mPublicationDao.insertPublication(publication3);

            AudioVisual audioVisual1 = new AudioVisual("Kenneth Copeland", "The Believer's Authority - part 1", "The Believer's Authority",
                    "It is all Victory ...", "source1", "source2", "source3", 100l, 22, 13, 54);
            mAudioVisualDao.insertAudioVisual(audioVisual1);

            AudioVisual audioVisual2 = new AudioVisual("Kenneth Copeland", "The Believer's Authority - part 2", "The Believer's Authority",
                    "It is all Victory ...", "source1", "source2", "source3", 100l, 22, 13, 54);
            mAudioVisualDao.insertAudioVisual(audioVisual2);

            AudioVisual audioVisual3 = new AudioVisual("Kenneth Copeland", "The Believer's Authority - part 3", "The Believer's Authority",
                    "It is all Victory ...", "source1", "source2", "source3", 100l, 22, 13, 54);
            mAudioVisualDao.insertAudioVisual(audioVisual3);


            return null;
        }
    }

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE publication_table "
                    + " ADD COLUMN pub_year INTEGER NOT NULL DEFAULT 2002");
        }
    };

}