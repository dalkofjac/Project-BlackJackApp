package com.dk.project_blackjack.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dk.project_blackjack.R;
import com.dk.project_blackjack.helpers.FragmentStarter;
import com.dk.webservice.WebServiceRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 14.2.2018..
 */

public class ContactFragment extends Fragment {
    private String title = "";
    private String serviceAnswer = "";
    private WebServiceRequestBuilder builder;

    @BindView(R.id.eT_name)
    EditText etName;

    @BindView(R.id.eT_email)
    EditText etEmail;

    @BindView(R.id.eT_msg)
    EditText etMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);
        title = getResources().getString(R.string.contact_fragment_title);
        builder = new WebServiceRequestBuilder();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.button_send_mail)
    public void onButtonSendMailClicked(){
        serviceAnswer = builder.sendEmail(etName.getText().toString(),
                etEmail.getText().toString(), etMsg.getText().toString());
        if(serviceAnswer.matches("done")){
            Toast.makeText(getActivity().getApplicationContext(),
                    "Message sent!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etEmail.setText("");
            etMsg.setText("");
        }
        else{
            Toast.makeText(getActivity().getApplicationContext(),
                    "Error occurred while sending a message.", Toast.LENGTH_SHORT).show();
        }
    }
}
