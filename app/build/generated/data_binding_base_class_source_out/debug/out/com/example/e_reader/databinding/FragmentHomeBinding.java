// Generated by view binder compiler. Do not edit!
package com.example.e_reader.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.e_reader.R;
import com.google.android.material.appbar.MaterialToolbar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView reyclerviewMain;

  @NonNull
  public final MaterialToolbar toolbarMainMenu;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView reyclerviewMain, @NonNull MaterialToolbar toolbarMainMenu) {
    this.rootView = rootView;
    this.reyclerviewMain = reyclerviewMain;
    this.toolbarMainMenu = toolbarMainMenu;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.reyclerview_main;
      RecyclerView reyclerviewMain = ViewBindings.findChildViewById(rootView, id);
      if (reyclerviewMain == null) {
        break missingId;
      }

      id = R.id.toolbarMainMenu;
      MaterialToolbar toolbarMainMenu = ViewBindings.findChildViewById(rootView, id);
      if (toolbarMainMenu == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, reyclerviewMain, toolbarMainMenu);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
