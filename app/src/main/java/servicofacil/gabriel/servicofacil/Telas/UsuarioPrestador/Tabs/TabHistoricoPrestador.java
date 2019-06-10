package servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador.Tabs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import servicofacil.gabriel.servicofacil.R;


public class TabHistoricoPrestador extends Fragment{

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> servicosPesquisados;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Instânciar osobjetos
//        servicosPesquisados = new ArrayList<>();

        View rootView = inflater.inflate(R.layout.tab_historico_prestador, container, false);

        //Monta o lisView e adapter
//        listView = (ListView) rootView.findViewById(R.id.list_historico);
//        adapter = new ArrayAdapter(
//                getActivity(),
//                android.R.layout.simple_expandable_list_item_1,
//                servicosPesquisados
//        );
//        listView.setAdapter(adapter);

        return rootView;

    }
}

