package com.jnu.myfirstapplication;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.jnu.myfirstapplication.recyclerview.HttpDataLoder;
import com.jnu.myfirstapplication.recyclerview.ShopLocation;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaiduMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaiduMapFragment extends Fragment {
    private MapView mapView;

    public BaiduMapFragment() {
        // Required empty public constructor
    }


    public static BaiduMapFragment newInstance() {
        BaiduMapFragment fragment = new BaiduMapFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_baidu_map, container, false);
        mapView=rootView.findViewById(R.id.bmapView);

        MapStatus.Builder builder=new MapStatus.Builder();
        builder.zoom(18.0f);
        mapView.getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

        LatLng cenpt=new LatLng(22.255925,113.541112);
        MapStatus mapStatus=new MapStatus.Builder().target(cenpt).zoom(18).build();
        mapView.getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(mapStatus));

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpDataLoder dataLoder=new HttpDataLoder();
                String shopJsonData= dataLoder.getHttpData("http://file.nidama.net/class/mobile_develop/data/bookstore2022.json");
                List<ShopLocation> locations=dataLoder.ParseJsonData(shopJsonData);
                BaiduMapFragment.this.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AddMarkersOnMap(locations, cenpt);
                    }
                });

            }
        }).start();


        return rootView;
    }

    private void AddMarkersOnMap(List<ShopLocation> locations, LatLng cenpt) {
        BitmapDescriptor bitmap= BitmapDescriptorFactory.fromResource(R.drawable.book_no_name);

        for(ShopLocation shopLocation: locations){
            LatLng shopPoint=new LatLng(shopLocation.getLatitude(), shopLocation.getLongitude());


            OverlayOptions options=new MarkerOptions().position(cenpt).icon(bitmap);
            mapView.getMap().addOverlay(options);
            mapView.getMap().addOverlay(new TextOptions().bgColor(0xAAFFFF00)
                    .fontSize(32)
                    .fontColor(0xFFFF00FF).text(shopLocation.getName()).position(shopPoint));
        }
    }

    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
    }
}