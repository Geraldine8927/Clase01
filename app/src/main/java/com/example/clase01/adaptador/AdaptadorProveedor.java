package com.example.clase01.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clase01.R;
import com.example.clase01.bean.ProveedorBean;

import java.util.List;

public class AdaptadorProveedor extends BaseAdapter {

    private List<ProveedorBean> ListaInterna;
    private Context contexto;

    public AdaptadorProveedor(List<ProveedorBean> listaInterna,Context contexto){
        ListaInterna=listaInterna;
                this.contexto=contexto;
    }

    @Override
    public int getCount() {
        return ListaInterna.size();
    }

    @Override
    public Object getItem(int position) {
        return ListaInterna.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ListaInterna.get(position).getCodigo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View pVistaProveedorItem=convertView;
        if (pVistaProveedorItem==null)
        {
            LayoutInflater vi=LayoutInflater.from(contexto);
            pVistaProveedorItem=vi.inflate(R.layout.registroprovedoor,null);
        }
        TextView otvRuc=pVistaProveedorItem.findViewById(R.id.TV_RUC_ITEM);
        TextView otvRazonSocial=pVistaProveedorItem.findViewById(R.id.TV_RAZONSOCIAL_ITEM);

        otvRuc.setText(ListaInterna.get(position).getRuc());
        otvRazonSocial.setText(ListaInterna.get(position).getRazonSocial());

        return pVistaProveedorItem;
    }
}
