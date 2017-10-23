package com.senamoviles.alcayata.alcayatanew.Fragments;


import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.droidbyme.dialoglib.DroidDialog;
import com.senamoviles.alcayata.alcayatanew.MainActivity;
import com.senamoviles.alcayata.alcayatanew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SabiasFragment extends Fragment {

    int algo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sabias, container, false);


        /*switch (MainActivity.opcion){
            case "San Juan Evangelista":
                frameLayout.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.juan));


                break;
            case "El señor del Huerto":
                frameLayout.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.huerto));
                break;
            case "El Crucifijo":
                frameLayout.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.crucifijo));
                break;
            case "Virgen de los Dolores":
                frameLayout.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.virgen));
                break;
        }*/

        return view;
    }

}
