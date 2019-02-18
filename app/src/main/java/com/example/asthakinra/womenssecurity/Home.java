package com.example.asthakinra.womenssecurity;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Home extends Fragment{
    ImageView play,pause;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.home,container,false);
        View rootView=inflater.inflate(R.layout.home,container,false);
        play=(ImageView)rootView.findViewById(R.id.play);
        pause=(ImageView)rootView.findViewById(R.id.pause);
        final MediaPlayer sound=MediaPlayer.create(getActivity(),R.raw.siren);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.setLooping(true);
                sound.start();
            }
        });
pause.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (sound.isPlaying()){
            sound.pause();
        }
    }
});
return rootView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "http://www.SafeWomen.com";
                Intent i7 = new Intent(Intent.ACTION_VIEW);
                i7.setData(Uri.parse(str));
                startActivity(i7);//implicit intent
            }
        });




        view.findViewById(R.id.sm).setOnClickListener(new View.OnClickListener() {
              @Override
            public void onClick(View view) {
                          Intent i = new Intent(getActivity(), Sms.class);
                          startActivity(i);
             }
            });
        view.findViewById(R.id.pol).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i2 = new Intent(Intent.ACTION_DIAL);
                        i2.setData(Uri.parse("tel:100"));
                        startActivity(i2);
                    }
                });
        view.findViewById(R.id.amb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent i1 = new Intent(Intent.ACTION_DIAL);
                        i1.setData(Uri.parse("tel:112"));
                        startActivity(i1);
            }

        });
    }
}
