package in.pantheon18.pantheon18;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoOptionView;

/**
 * Created by root on 23/8/18.
 */

public class MenuAdapter extends BaseAdapter{
        private ArrayList<String> mOptions = new ArrayList<>();
        private ArrayList<DuoOptionView> mOptionViews = new ArrayList<>();

    MenuAdapter(ArrayList<String> options) {
        mOptions = options;
    }

    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return mOptions.get(position);
    }

    public void setViewSelected(int position, boolean selected) {

            // Looping through the options in the menu
            // Selecting the chosen option
            for (int i = 0; i < mOptionViews.size(); i++) {
                if (i == position) {
                    mOptionViews.get(i).setSelected(selected);
                } else {
                    mOptionViews.get(i).setSelected(!selected);
                }
            }
        }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String option = mOptions.get(position);

        // Using the DuoOptionView to easily recreate the demo
        final DuoOptionView optionView;
        if (convertView == null) {
            optionView = new DuoOptionView(parent.getContext());
        } else {
            optionView = (DuoOptionView) convertView;
        }

        // Using the DuoOptionView's default selectors
        optionView.bind(option, null, null);

        // Adding the views to an array list to handle view selection
       // optionView.setBackgroundColor(Color.parseColor("#009999"));
        //optionView.setBottom(50);
        optionView.setAlpha(1);
        //optionView.setTranslationZ(500);
        mOptionViews.add(optionView);

        return optionView;
    }
}
