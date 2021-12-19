package VIewpager_2frg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tnsfl.R;

public class Fragment2_slide3 extends Fragment {
    private View view;

    public static Fragment2_slide3 newinstance(){
        Fragment2_slide3 fragment2_slide3 = new Fragment2_slide3();
        return fragment2_slide3;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame2_3p,container,false);
        return view;
    }
}
