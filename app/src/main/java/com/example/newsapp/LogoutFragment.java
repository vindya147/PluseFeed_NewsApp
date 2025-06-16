package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LogoutFragment extends Fragment {

    private Button btnYes, btnNo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logout, container, false); // Ensure this matches the name of your XML file

        // Initialize buttons
        btnYes = view.findViewById(R.id.btnYes);
        btnNo = view.findViewById(R.id.btnNo);

        // Set listeners for buttons
        btnYes.setOnClickListener(v -> {
            // Redirect to login activity
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the back stack
            startActivity(intent);

            // Close current activity (if applicable)
            if (getActivity() != null) {
                getActivity().finish();
            }
        });

        btnNo.setOnClickListener(v -> {
            // Redirect to the HomeFragment
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new HomeFragment()) // Replace with your actual HomeFragment
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
