package com.kabby.Smiley;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import android.widget.*;

@DesignerComponent(
        version = 1,
        description = "Smileeey Aix by Rudra",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "")

@SimpleObject(external = true)

public class Smileeey extends AndroidNonvisibleComponent {

    private Context context;
    private Activity activity;
    private SmileyRating smileyRating;

    public Smileeey(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
        smileyRating = new SmileyRating(context);
    }

    @SimpleFunction
    public void AddToLayout(AndroidViewComponent view){
    FrameLayout mm = (FrameLayout) view.getView();
    mm.addView(smileyRating);
    smileyRating.setSmileySelectedListener(new SmileyRating.OnSmileySelectedListener() {
            @Override
            public void onSmileySelected(SmileyRating.Type type) {
                int rating = type.getRating();
                SmileySelected(rating);
            }
        });
    }
    @SimpleFunction
    public void GetRating(){
        SmileyRating.Type smiley = smileyRating.getSelectedSmiley();
        int rating = smiley.getRating();
        GotRating(rating);
    }

    @SimpleEvent
    public void SmileySelected(int rating){
        EventDispatcher.dispatchEvent(this, "SmileySelected", rating);
    }
    @SimpleEvent
    public void GotRating(int rating){
        EventDispatcher.dispatchEvent(this, "GotRating", rating);
    }
    @SimpleFunction
    public void SetRating(int rating, boolean animate){
    if(rating == 1){
    smileyRating.setRating(SmileyRating.Type.TERRIBLE, animate);
    } else if(rating == 2){
    smileyRating.setRating(SmileyRating.Type.BAD, animate);
    }
    else if(rating == 3){
    smileyRating.setRating(SmileyRating.Type.OKAY, animate);
    }
    else if(rating == 4){
    smileyRating.setRating(SmileyRating.Type.GOOD, animate);
    }
    else if(rating == 5){
    smileyRating.setRating(SmileyRating.Type.GREAT, animate);
    }
    }
    @SimpleProperty
    public void DisallowSelection(boolean pitus){
        smileyRating.disallowSelection(pitus);
    }
    @SimpleFunction
    public void SetTitle(int rating, String title){
    if(rating == 1){
    smileyRating.setTitle(SmileyRating.Type.TERRIBLE, title);
    } else if(rating == 2){
    smileyRating.setTitle(SmileyRating.Type.BAD, title);
    }
    else if(rating == 3){
    smileyRating.setTitle(SmileyRating.Type.OKAY, title);
    }
    else if(rating == 4){
    smileyRating.setTitle(SmileyRating.Type.GOOD, title);
    }
    else if(rating == 5){
    smileyRating.setTitle(SmileyRating.Type.GREAT, title);
    }
    }
    @SimpleFunction
    public void SetFaceColor(int rating, int color){
    if(rating == 1){
    smileyRating.setFaceColor(SmileyRating.Type.TERRIBLE, color);
    } 
    else if(rating == 2){
    smileyRating.setFaceColor(SmileyRating.Type.BAD, color);
    }
    else if(rating == 3){
    smileyRating.setFaceColor(SmileyRating.Type.OKAY, color);
    }
    else if(rating == 4){
    smileyRating.setFaceColor(SmileyRating.Type.GOOD, color);
    }
    else if(rating == 5){
    smileyRating.setFaceColor(SmileyRating.Type.GREAT, color);
    }
    }
    @SimpleFunction
    public void SetFaceBackgroundColor(int rating, int color){
    if(rating == 1){
    smileyRating.setFaceBackgroundColor(SmileyRating.Type.TERRIBLE, color);
    } else if(rating == 2){
    smileyRating.setFaceBackgroundColor(SmileyRating.Type.BAD, color);
    }
    else if(rating == 3){
    smileyRating.setFaceBackgroundColor(SmileyRating.Type.OKAY, color);
    }
    else if(rating == 4){
    smileyRating.setFaceBackgroundColor(SmileyRating.Type.GOOD, color);
    }
    else if(rating == 5){
    smileyRating.setFaceBackgroundColor(SmileyRating.Type.GREAT, color);
    }
    }
    @SimpleProperty
    public int Great(){
    return 5;
    }
    @SimpleProperty
    public int Good(){
    return 4;
    } 
    @SimpleProperty
    public int Okay(){
    return 3;
    } 
    @SimpleProperty
    public int Bad(){
    return 2;
    } 
    @SimpleProperty
    public int Terrible(){
    return 1;
    } 
}