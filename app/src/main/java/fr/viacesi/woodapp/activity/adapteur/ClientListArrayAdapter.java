package fr.viacesi.woodapp.activity.adapteur;

/**
 * Created by 1797531 on 03/02/2018.
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import fr.viacesi.woodapp.R;
import fr.viacesi.woodapp.model.Client;

public class ClientListArrayAdapter extends ArrayAdapter<Client> {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

    public ClientListArrayAdapter(@NonNull Context context, @NonNull List<Client> objects) {
        super(context, R.layout.list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Client client = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Lookup view for data
        TextView textView = (TextView) convertView.findViewById(R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.text2);

        // Populate the data into the template view using the data object
        textView.setText(client.getNom());
        textView2.setText(client.getAdresse());

        return convertView;

    }


}