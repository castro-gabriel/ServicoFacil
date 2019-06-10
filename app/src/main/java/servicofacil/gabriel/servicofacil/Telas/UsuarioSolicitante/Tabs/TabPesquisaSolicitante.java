package servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante.Tabs;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import servicofacil.gabriel.servicofacil.R;

public class TabPesquisaSolicitante extends Fragment implements OnMapReadyCallback{

    MapView MapView;
    View vView;
    public TabPesquisaSolicitante(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vView = inflater.inflate(R.layout.tab_pesquisa_solicitante, container, false);

        return vView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapView = vView.findViewById(R.id.gmap);

        if(MapView != null){
            MapView.onCreate(null);
            MapView.onResume();
            MapView.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings();

        boolean success = googleMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_night)));

        if (!success) {
            Snackbar.make(getView(), "Style parsing failed", Snackbar.LENGTH_SHORT).show();
        }

    }

    public class SearchFiltro implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {


            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {


            return false;
        }
    }

    public void addMarkerVerde(GoogleMap googleMap, Double lat, Double lng, String title, String snippet){
        LatLng marker = new LatLng(lat, lng);

        googleMap.addMarker(new MarkerOptions()
                .position(marker)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_verde))
                .title(title)
                .snippet(snippet));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(marker)
                .zoom(16)
                //.bearing(0)
                //.tilt(45)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public void addMarkerCinza(GoogleMap googleMap, Double lat, Double lng, String title, String snippet){
        LatLng marker = new LatLng(lat, lng);

        googleMap.addMarker(new MarkerOptions()
                .position(marker)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_cinza))
                .title(title)
                .snippet(snippet));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(marker)
                .zoom(16)
                //.bearing(0)
                //.tilt(45)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

}
