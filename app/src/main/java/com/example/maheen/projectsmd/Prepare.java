package com.example.maheen.projectsmd;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;


public class Prepare extends Fragment {


    private OnFragmentInteractionListener mListener;

    public Prepare() {
        // Required empty public constructor
    }





    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<prepareItem> prepareList;

    private Button btnSelection;




    public void initialisepreparedate(){
        prepareList = new ArrayList<prepareItem>();


        prepareItem st = new prepareItem("Ahram" , "Keep a spare ahram that can be used as an alternate. Get right size and keep in carry on." , false);
        prepareItem st1 = new prepareItem("Detergent" , "Keep detergents to use while in ahram. \n Should be unperfumed" , false);
        prepareItem st2= new prepareItem("Sunglasses and earplugs" , "Useful to sleep in noisy areas" , false);
        prepareItem st3 = new prepareItem("Charger" , "Plug adapters and chargers and \n also sim tray card." , false);
        prepareItem st4 = new prepareItem("Lanyar" , "Helpful for handsfree phone handling, \n especially in Tawaf" , false);

        prepareList.add(st);
        prepareList.add(st1);
        prepareList.add(st2);
        prepareList.add(st3);
        prepareList.add(st4);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        btnSelection = (Button) view.findViewById(R.id.btnShow);

        initialisepreparedate();




        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // create an Object for Adapter
        mAdapter = new prepareItemrvDataAdapter(prepareList);

        // set the adapter object to the Recyclerview
        mRecyclerView.setAdapter(mAdapter);

        btnSelection.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = "";
                String dat="";
                List<prepareItem> stList = ((prepareItemrvDataAdapter) mAdapter)
                        .getStudentist();
                int count=0;

                for (int i = 0; i < stList.size(); i++) {
                    prepareItem singleStudent = stList.get(i);
                    if (singleStudent.isSelected() == true) {

                        data = data + "\n" + singleStudent.getName().toString();
                        count=count+1;

                    }
                    else{
                        dat=dat + singleStudent.getName().toString();
                    }

                }
                String datacontent;

                if(count==5){
                    datacontent ="Congratulation!! you have all prepare items";
                    startNotification(datacontent);
                }
                else{
                    datacontent="please do add these items too"+dat;
                    startNotification(datacontent);
                }



            }
        });



        // Inflate the layout for this fragment
        return view;
    }

    private void startNotification(String text) {
        Log.i("NextActivity", "startNotification");

        // Sets an ID for the notification
        int mNotificationId = 001;

        // Build Notification , setOngoing keeps the notification always in status bar
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext());

        mBuilder.setSmallIcon(R.drawable.logo);
        mBuilder.setContentTitle("Pilgrimguide");
        mBuilder.setContentText(text);

        // Create pending intent, mention the Activity which needs to be
        //triggered when user clicks on notification(StopScript.class in this case)

        PendingIntent contentIntent = PendingIntent.getActivity(getContext(), 0,
                new Intent(getContext(), Prepare.class), PendingIntent.FLAG_UPDATE_CURRENT);


        mBuilder.setContentIntent(contentIntent);


        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager)getContext().getSystemService(NOTIFICATION_SERVICE);

        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
