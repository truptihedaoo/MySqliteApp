package com.example.rubixapplication.RubixApp;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rubixapplication.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hyogeun.github.com.colorratingbarlib.ColorRatingBar;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<Child>> expandableListDetail;


    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<Child>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get( this.expandableListTitle.get( listPosition ) )
                .get( expandedListPosition );
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = (Child) getChild( listPosition, expandedListPosition );

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = layoutInflater.inflate( R.layout.list_item, null );
        }
        TextView txtDate = (TextView) convertView
                .findViewById( R.id.txtDate );
        TextView txtTitle = (TextView) convertView
                .findViewById( R.id.txtTitle );
        TextView txtQuality = (TextView) convertView
                .findViewById( R.id.txtQuality );
        ColorRatingBar ratingbar = (ColorRatingBar) convertView
                .findViewById( R.id.rating_1 );
        ImageView imageView = (ImageView) convertView
                .findViewById( R.id.image );
        txtDate.setText( child.getDate() );
        txtTitle.setText( child.getTitle() );
        txtQuality.setText( "Quantity : " + child.getQuantity() );
        ratingbar.setRating(Float.parseFloat(child.getRating()));
        Log.d( "child.getImage()",child.getImage() );
            Picasso.with(context).load(child.getImage()).resize(250, 250).placeholder( R.drawable.apple ).into(imageView);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {

        return this.expandableListDetail.get( this.expandableListTitle.get( listPosition ) )
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get( listPosition );
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup( listPosition );
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = layoutInflater.inflate( R.layout.list_group, null );
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById( R.id.listTitle );
        listTitleTextView.setTypeface( null, Typeface.BOLD );
        listTitleTextView.setText( listTitle );
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
