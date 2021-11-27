package VIewpager_2frg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tnsfl.R;

public class Fragment2_slide2 extends Fragment {
    private View view;

    public static Fragment2_slide2 newinstance(){
        Fragment2_slide2 fragment2_slide2 = new Fragment2_slide2();
        return fragment2_slide2;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame2_2p,container,false);
        return view;
    }
}
