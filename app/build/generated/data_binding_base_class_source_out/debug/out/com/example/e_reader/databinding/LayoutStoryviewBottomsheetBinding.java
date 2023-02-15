// Generated by view binder compiler. Do not edit!
package com.example.e_reader.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.e_reader.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutStoryviewBottomsheetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnReadNow;

  @NonNull
  public final MaterialCardView materialCardView;

  @NonNull
  public final TextView reviewCount;

  @NonNull
  public final TextView storyTitle;

  @NonNull
  public final TextView textRating;

  @NonNull
  public final TextView textStoryContent;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  private LayoutStoryviewBottomsheetBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnReadNow, @NonNull MaterialCardView materialCardView,
      @NonNull TextView reviewCount, @NonNull TextView storyTitle, @NonNull TextView textRating,
      @NonNull TextView textStoryContent, @NonNull TextView textView, @NonNull TextView textView2,
      @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6,
      @NonNull TextView textView7) {
    this.rootView = rootView;
    this.btnReadNow = btnReadNow;
    this.materialCardView = materialCardView;
    this.reviewCount = reviewCount;
    this.storyTitle = storyTitle;
    this.textRating = textRating;
    this.textStoryContent = textStoryContent;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.textView7 = textView7;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutStoryviewBottomsheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutStoryviewBottomsheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_storyview_bottomsheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutStoryviewBottomsheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_read_now;
      MaterialButton btnReadNow = ViewBindings.findChildViewById(rootView, id);
      if (btnReadNow == null) {
        break missingId;
      }

      id = R.id.materialCardView;
      MaterialCardView materialCardView = ViewBindings.findChildViewById(rootView, id);
      if (materialCardView == null) {
        break missingId;
      }

      id = R.id.review_count;
      TextView reviewCount = ViewBindings.findChildViewById(rootView, id);
      if (reviewCount == null) {
        break missingId;
      }

      id = R.id.story_title;
      TextView storyTitle = ViewBindings.findChildViewById(rootView, id);
      if (storyTitle == null) {
        break missingId;
      }

      id = R.id.text_rating;
      TextView textRating = ViewBindings.findChildViewById(rootView, id);
      if (textRating == null) {
        break missingId;
      }

      id = R.id.text_story_content;
      TextView textStoryContent = ViewBindings.findChildViewById(rootView, id);
      if (textStoryContent == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      return new LayoutStoryviewBottomsheetBinding((ConstraintLayout) rootView, btnReadNow,
          materialCardView, reviewCount, storyTitle, textRating, textStoryContent, textView,
          textView2, textView4, textView5, textView6, textView7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
