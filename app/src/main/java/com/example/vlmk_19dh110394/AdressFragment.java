package com.example.vlmk_19dh110394;;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdressFragment extends Fragment {

    Button btnNext;
    NavController navController;
    TextInputEditText tvAddress, tvMobile;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdressFragment newInstance(String param1, String param2) {
        AdressFragment fragment = new AdressFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnNext = view.findViewById(R.id.btnNext);
        navController = Navigation.findNavController(view);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvMobile = view.findViewById(R.id.tvMobile);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(tvAddress.getText().toString()) && !TextUtils.isEmpty(tvMobile.getText().toString())) {
 //                   LatLng latLng = LocationServiceTask.getLatLngFromAddress(getContext(), tvAddress.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putString("address", tvAddress.getText().toString());
                    bundle.putString("mobile", tvMobile.getText().toString());
  //                  bundle.putDouble("latitude", latLng.latitude);
  //                  bundle.putDouble("longitude", latLng.longitude);
                    bundle.putString("firstname", getArguments().getString("firstname"));
                    bundle.putString("lastname", getArguments().getString("lastname"));
                    navController.navigate(R.id.action_adressFragment_to_usernamePasswordFragment, bundle);
                } else {
                    Toast.makeText(getContext(), "Vui lòng nhập thông tin đầy đủ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}