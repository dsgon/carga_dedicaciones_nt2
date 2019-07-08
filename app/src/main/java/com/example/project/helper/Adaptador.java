package com.example.project.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project.R;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context context;
    private String[][] data;

    public Adaptador(Context contexto, String[][] datos){
        context = contexto;
        data = datos;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        //Not necessary
        return null;
    }

    @Override
    public long getItemId(int position) {
        //Not necessary
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view =  inflater.inflate(R.layout.historic_list, null);
        TextView periodo = (TextView) view.findViewById(R.id.periodo);
        TextView horasCarcagas = (TextView) view.findViewById(R.id.horasCargadas);
        TextView horasEstimadas = (TextView) view.findViewById(R.id.horasEstimadas);

        periodo.setText(data[position][0]);
        horasCarcagas.setText(data[position][1]);
        horasEstimadas.setText(data[position][2]);

        return view;
    }
}
