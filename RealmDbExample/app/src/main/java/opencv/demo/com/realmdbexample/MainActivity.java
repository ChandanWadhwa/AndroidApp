package opencv.demo.com.realmdbexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    Realm myRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        myRealm = Realm.getInstance(mContext);

        myRealm.beginTransaction();
        // Create an object
        Country country1 = myRealm.createObject(Country.class);
        // Set its fields
        country1.setName("India");
        country1.setPopulation(9000000);
        myRealm.commitTransaction();

    }

    public void showDB(View v)
    {
        RealmResults<Country> results1 =
                myRealm.where(Country.class).findAll();

        for(Country c:results1) {
            Log.d("results1", c.getName());
            Log.d("results1", c.getPopulation()+"");
        }
    }

    public void showSelectedRecord(View v)
    {
        RealmResults<Country> results2 =
                myRealm.where(Country.class)
                        .greaterThan("population", 7000000)
                        .findAll();
        for(Country c:results2) {
            Log.d("results1", c.getName());
            Log.d("results1", c.getPopulation()+"");
        }
    }
    public void updateRecord(View v)
    {
        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Country country3 = realm.where(Country.class).equalTo("name", "India").findFirst();
                country3.setName("Australia");
            }
        });

    }
}
