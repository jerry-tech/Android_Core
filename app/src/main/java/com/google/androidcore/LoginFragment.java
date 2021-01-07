package com.google.androidcore;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    TextView txtAccount;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        txtAccount = view.findViewById(R.id.regAccount);
        //do no use lambda's for createNavigateOnClickListener
//        txtAccount.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment));

        TextInputEditText textEmail = view.findViewById(R.id.email);
        TextInputEditText textPassword = view.findViewById(R.id.password);
        Button btnLogin = view.findViewById(R.id.button);

        btnLogin.setOnClickListener(v -> createToast(view, textEmail.getText().toString(), textPassword.getText().toString())
        );

        txtAccount.setOnClickListener(v -> createSnackBar(view, textEmail.getText().toString(), textPassword.getText().toString()));

        return view;
    }

    //creating toast message
    @SuppressLint("SetTextI18n")
    public void createToast(View view, String email, String password){
//        Toast toast = Toast.makeText(getContext(), "Email :- "+ email + " Password :- " + password, Toast.LENGTH_LONG);
//        toast.show();
//        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);//showing gravity

        //creating custom toast
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.toast_layout, view.findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.text);
        text.setText("Email :- "+ email + " Password :- " + password);

        Toast toast = new Toast(view.getContext());
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    public void createSnackBar(View view, String email, String password){
        Snackbar.make(view, "Email :- "+ email + "Password :- " + password, Snackbar.LENGTH_LONG).show();
    }
}