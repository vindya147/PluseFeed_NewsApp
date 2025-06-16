package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileFragment extends Fragment {

    private EditText editName, editEmail, editUserName, editPassword;
    private Button btnUpdateProfile;
    private String nameUser, emailUser, usernameUser, passwordUser;
    private DatabaseReference reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        // Initialize Firebase reference
        reference = FirebaseDatabase.getInstance().getReference("users");

        // Initialize UI elements
        editName = view.findViewById(R.id.editName);
        editEmail = view.findViewById(R.id.editEmail);
        editUserName = view.findViewById(R.id.editUserName);
        editPassword = view.findViewById(R.id.editPassword);
        btnUpdateProfile = view.findViewById(R.id.btnUpdateProfile);

        // Display user data
        showData();

        // Handle profile update button click
        btnUpdateProfile.setOnClickListener(v -> {
            if (isNameChanged() || isPasswordChanged() || isEmailChanged()) {
                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "No Changes Found", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private boolean isNameChanged() {
        String newName = editName.getText().toString();
        if (!nameUser.equals(newName)) {
            reference.child(usernameUser).child("name").setValue(newName);
            nameUser = newName;
            return true;
        }
        return false;
    }

    private boolean isEmailChanged() {
        String newEmail = editEmail.getText().toString();
        if (!emailUser.equals(newEmail)) {
            reference.child(usernameUser).child("email").setValue(newEmail);
            emailUser = newEmail;
            return true;
        }
        return false;
    }

    private boolean isPasswordChanged() {
        String newPassword = editPassword.getText().toString();
        if (!passwordUser.equals(newPassword)) {
            reference.child(usernameUser).child("password").setValue(newPassword);
            passwordUser = newPassword;
            return true;
        }
        return false;
    }

    private void showData() {
        if (getArguments() != null) {
            nameUser = getArguments().getString("name");
            emailUser = getArguments().getString("email");
            usernameUser = getArguments().getString("username");
            passwordUser = getArguments().getString("password");

            editName.setText(nameUser);
            editEmail.setText(emailUser);
            editUserName.setText(usernameUser);
            editPassword.setText(passwordUser);

            // Make username field non-editable since it's unique
            editUserName.setEnabled(false);
        }
    }
}
