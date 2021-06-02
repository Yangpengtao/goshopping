package com.go.lib_base1.map.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.*;
import com.go.lib_base1.R;

import java.util.ArrayList;
import java.util.List;

public class RouteOverlay {
    private List<Marker> stationMarkers = new ArrayList<Marker>();
    private List<Polyline> allPolyLines = new ArrayList<Polyline>();
    private Marker startMarker;
    private Marker endMarker;
    LatLng startPoint;
    LatLng endPoint;
    AMap mAMap;
    private Context mContext;
    private Bitmap startBit, endBit, busBit, walkBit, driveBit;
    boolean nodeIconVisible = true;

    RouteOverlay(Context context) {
        mContext = context;
    }

    /**
     * 去掉BusRouteOverlay上所有的Marker。
     *
     * @since V2.1.0
     */
    public void removeFromMap() {
        if (startMarker != null) {
            startMarker.remove();

        }
        if (endMarker != null) {
            endMarker.remove();
        }
        for (Marker marker : stationMarkers) {
            marker.remove();
        }
        for (Polyline line : allPolyLines) {
            line.remove();
        }
        destroyBit();
    }

    private void destroyBit() {
        if (startBit != null) {
            startBit.recycle();
            startBit = null;
        }
        if (endBit != null) {
            endBit.recycle();
            endBit = null;
        }
        if (busBit != null) {
            busBit.recycle();
            busBit = null;
        }
        if (walkBit != null) {
            walkBit.recycle();
            walkBit = null;
        }
        if (driveBit != null) {
            driveBit.recycle();
            driveBit = null;
        }
    }

    /**
     * 给起点Marker设置图标，并返回更换图标的图片。如不用默认图片，需要重写此方法。
     *
     * @return 更换的Marker图片。
     * @since V2.1.0
     */
    private BitmapDescriptor getCurrBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_ride);
    }

    /**
     * 给起点Marker设置图标，并返回更换图标的图片。如不用默认图片，需要重写此方法。
     *
     * @return 更换的Marker图片。
     * @since V2.1.0
     */
    private BitmapDescriptor getStartBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_start1);
    }

    /**
     * 给终点Marker设置图标，并返回更换图标的图片。如不用默认图片，需要重写此方法。
     *
     * @return 更换的Marker图片。
     * @since V2.1.0
     */
    private BitmapDescriptor getEndBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_end1);
    }

    /**
     * 给公交Marker设置图标，并返回更换图标的图片。如不用默认图片，需要重写此方法。
     *
     * @return 更换的Marker图片。
     * @since V2.1.0
     */
    protected BitmapDescriptor getBusBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_bus);
    }

    /**
     * 给步行Marker设置图标，并返回更换图标的图片。如不用默认图片，需要重写此方法。
     *
     * @return 更换的Marker图片。
     * @since V2.1.0
     */
    protected BitmapDescriptor getWalkBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_man);
    }

    protected BitmapDescriptor getDriveBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_car);
    }

    BitmapDescriptor getRideBitmapDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_ride);
    }

    private BitmapDescriptor getCurrDescriptor() {
        return BitmapDescriptorFactory.fromResource(R.drawable.amap_ride1);
    }


    void addStartAndEndMarker() {
        startMarker = mAMap.addMarker((new MarkerOptions())
                .position(startPoint).icon(getStartBitmapDescriptor())
                .title("\u8D77\u70B9"));
        // startMarker.showInfoWindow();

        endMarker = mAMap.addMarker((new MarkerOptions()).position(endPoint)
                .icon(getEndBitmapDescriptor()).title("\u7EC8\u70B9"));
        // mAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint,
        // getShowRouteZoom()));
    }

    void addCurrMarker() {
        startMarker = mAMap.addMarker((new MarkerOptions())
                .position(startPoint).icon(getCurrDescriptor())
                .title("当前位置"));
    }

    /**
     * 移动镜头到当前的视角。
     *
     * @since V2.1.0
     */
    public void zoomToSpan() {
        if (startPoint != null) {
            if (mAMap == null)
                return;
            try {
                LatLngBounds bounds = getLatLngBounds();
                mAMap.animateCamera(CameraUpdateFactory
                        .newLatLngBounds(bounds, 50));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    private LatLngBounds getLatLngBounds() {
        LatLngBounds.Builder b = LatLngBounds.builder();
        b.include(new LatLng(startPoint.latitude, startPoint.longitude));
        b.include(new LatLng(endPoint.latitude, endPoint.longitude));
        for (Polyline polyline : allPolyLines) {
            for (LatLng point : polyline.getPoints()) {
                b.include(point);
            }
        }
        return b.build();
    }

    /**
     * 路段节点图标控制显示接口。
     *
     * @param visible true为显示节点图标，false为不显示。
     * @since V2.3.1
     */
    public void setNodeIconVisibility(boolean visible) {
        try {
            nodeIconVisible = visible;
            if (this.stationMarkers != null && this.stationMarkers.size() > 0) {
                for (int i = 0; i < this.stationMarkers.size(); i++) {
                    this.stationMarkers.get(i).setVisible(visible);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    void addStationMarker(MarkerOptions options) {
        if (options == null) {
            return;
        }
        Marker marker = mAMap.addMarker(options);
        if (marker != null) {
            stationMarkers.add(marker);
        }

    }

    void addPolyLine(PolylineOptions options) {
        if (options == null) {
            return;
        }
        Polyline polyline = mAMap.addPolyline(options);
        if (polyline != null) {
            allPolyLines.add(polyline);
        }
    }

      float getRouteWidth() {
        return 18f;
    }

      int getToBuyerColor() {
        return Color.parseColor("#666666");
    }

      int getToShopColor() {
        return Color.parseColor("#fd3344");
    }


    protected int getWalkColor() {
        return Color.parseColor("#6db74d");
    }

    /**
     * 自定义路线颜色。
     * return 自定义路线颜色。
     *
     * @since V2.2.1
     */
    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    protected int getDriveColor() {
        return Color.parseColor("#666666");
    }

    protected int getRideColor() {
        return Color.parseColor("#fd3344");
    }

    // protected int getShowRouteZoom() {
    // return 15;
    // }
}