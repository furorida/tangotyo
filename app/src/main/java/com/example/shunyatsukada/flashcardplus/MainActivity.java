package com.example.shunyatsukada.flashcardplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Card> mCards;
    CardAdapter mCardAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mCards = new ArrayList<Card>();

        mCards.add(new Card(R.drawable.angry, getString(R.string.angry_title),
                getString(R.string.angry_content), getString(R.string.angry_meaning)));

        mCards.add(new Card(R.drawable.sing, getString(R.string.sing_title),
                getString(R.string.sing_content), getString(R.string.sing_meaning)));

        mCards.add(new Card(R.drawable.cry, getString(R.string.cry_title),
                getString(R.string.cry_content), getString(R.string.cry_meaning)));

        mCards.add(new Card(R.drawable.basuke, getString(R.string.basketball_title),
                getString(R.string.basketball_content), getString(R.string.basketball_meaning)));

        mCards.add(new Card(R.drawable.happy, getString(R.string.happy_title),
                getString(R.string.happy_content), getString(R.string.happy_meaning)));

        mCardAdapter = new CardAdapter(this, R.layout.card, mCards);
        mListView.setAdapter(mCardAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
