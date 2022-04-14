package com.example.linkshelf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class ViewImageFragment extends Fragment {
    View view;
    Button view_images_bt1;
    Button view_images_bt2;
    Button view_images_bt3;
    Button view_images_bt4;
    ImageView view_images_iv;

    Bitmap bitmap;

    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    ArrayList<String> mylinks;
    int count=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_images, container, false);


        view_images_bt1 = (Button) view.findViewById(R.id.view_images_bt1);
        view_images_bt2 = (Button) view.findViewById(R.id.view_images_bt2);
        view_images_bt3 = (Button) view.findViewById(R.id.view_images_bt3);
        view_images_bt4 = (Button) view.findViewById(R.id.view_images_bt4);
        view_images_iv = (ImageView) view.findViewById(R.id.view_images_iv);

        view_images_bt1.setOnClickListener(new PreviousImage());
        view_images_bt2.setOnClickListener(new NextImage());
        view_images_bt3.setOnClickListener(new GoBackHome());
        view_images_bt4.setOnClickListener(new Remove());

        mylinks = new ArrayList<>();

        sharedPreferences = getActivity().getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        Map<String,?> keys = sharedPreferences.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            mylinks.add(entry.getValue().toString());
        }


        if(!mylinks.isEmpty()) {
            Download(mylinks.get(0));
        }else{
            Toast.makeText(getContext(),"nothing to show",Toast.LENGTH_SHORT).show();

        }
        return view;
    }
    public void Download(String url) {
       DownloadImage downloadImage = new DownloadImage();
        try {
            Bitmap bitmap = downloadImage.execute(url).get();
            view_images_iv.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    class DownloadImage extends AsyncTask<String,Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                try {
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.connect();

                    InputStream inputStream=connection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;



                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }



     class NextImage implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(mylinks!= null && !mylinks.isEmpty()) {
                if (count + 1 < mylinks.size()) {
                    count++;
                    Download(mylinks.get(count));
                    return;
                }
            }
            Toast.makeText(getContext(),"No next image",Toast.LENGTH_SHORT).show();



        }
    }
     class PreviousImage implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(mylinks!= null && !mylinks.isEmpty()) {
                if (count - 1 > -1) {
                    count--;
                    Download(mylinks.get(count));
                    return;
                }
            }
            Toast.makeText(getContext(),"No previous image",Toast.LENGTH_SHORT).show();

        }
    }
    class Remove implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Do you want to remove this item")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //remove from list
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove(mylinks.get(count));
                            editor.commit();
                            mylinks.remove(mylinks.get(count));
                            view_images_iv.setImageResource(0);
                            if (count==0){
                                count++;
                            }else{
                                count--;
                            }
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
        }
    }
     class GoBackHome implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();
        }
    }
}
