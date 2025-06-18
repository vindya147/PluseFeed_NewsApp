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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileFragment extends Fragment {

    private EditText editName, editEmail, editUserName, editPassword;
    private Button btnUpdateProfile;
    private DatabaseReference reference;

    // Assume you have the current logged-in username stored somewhere (e.g., SharedPreferences)
    private String currentUsername = "vindya147"; // Replace with actual username retrieval logic

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        // Initialize Firebase reference to "users" node
        reference = FirebaseDatabase.getInstance().getReference("users");

        // Initialize UI elements
        editName = view.findViewById(R.id.editName);
        editEmail = view.findViewById(R.id.editEmail);
        editUserName = view.findViewById(R.id.editUserName);
        editPassword = view.findViewById(R.id.editPassword);
        btnUpdateProfile = view.findViewById(R.id.btnUpdateProfile);

        // Disable editing username if it's unique and shouldn't change
        editUserName.setEnabled(true);

        // Fetch user data from Firebase and display
        fetchUserData();

        // Set update button click listener
        btnUpdateProfile.setOnClickListener(v -> updateUserData());

        return view;
    }

    private void fetchUserData() {
        reference.child(currentUsername).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String name = snapshot.child("name").getValue(String.class);
                    String email = snapshot.child("email").getValue(String.class);
                    String username = snapshot.child("username").getValue(String.class);
                    String password = snapshot.child("password").getValue(String.class);

                    editName.setText(name);
                    editEmail.setText(email);
                    editUserName.setText(username);
                    editPassword.setText(password);
                } else {
                    Toast.makeText(requireContext(), "User data not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(requireContext(), "Failed to load user data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUserData() {
        String newName = editName.getText().toString();
        String newEmail = editEmail.getText().toString();
        String newPassword = editPassword.getText().toString();

        // Update Firebase with new values
        reference.child(currentUsername).child("name").setValue(newName);
        reference.child(currentUsername).child("email").setValue(newEmail);
        reference.child(currentUsername).child("password").setValue(newPassword);

        Toast.makeText(requireContext(), "Profile updated successfully", Toast.LENGTH_SHORT).show();
    }
}
