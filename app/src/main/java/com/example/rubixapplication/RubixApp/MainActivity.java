package com.example.rubixapplication.RubixApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.example.rubixapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<Child>> expandableListDetail;
    RubixDBHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mydb = new RubixDBHelper( this );


        expandableListView = (ExpandableListView) findViewById( R.id.expandableListView );

        expandableListDetail = ExpandableListDataPump.getData( this );

        expandableListTitle = new ArrayList<String>( expandableListDetail.keySet() );


        expandableListAdapter = new CustomExpandableListAdapter( this, expandableListTitle, expandableListDetail );
        expandableListView.setAdapter( expandableListAdapter );


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.mobile_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected( item );

        switch (item.getItemId()) {
            case R.id.item2:
                expandableListDetail = ExpandableListDataPump.getDataDate( this );
                expandableListTitle = new ArrayList<String>( expandableListDetail.keySet() );
                expandableListAdapter = new CustomExpandableListAdapter( this, expandableListTitle, expandableListDetail );
                expandableListView.setAdapter( expandableListAdapter );

                return true;
            case R.id.item3:
                expandableListDetail = ExpandableListDataPump.getDataQuantity( this );
                expandableListTitle = new ArrayList<String>( expandableListDetail.keySet() );
                expandableListAdapter = new CustomExpandableListAdapter( this, expandableListTitle, expandableListDetail );
                expandableListView.setAdapter( expandableListAdapter );

                return true;
            case R.id.item4:
                expandableListDetail = ExpandableListDataPump.getDataRate( this );
                expandableListTitle = new ArrayList<String>( expandableListDetail.keySet() );
                expandableListAdapter = new CustomExpandableListAdapter( this, expandableListTitle, expandableListDetail );
                expandableListView.setAdapter( expandableListAdapter );

                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack( true );
        }
        return super.onKeyDown( keycode, event );
    }
}