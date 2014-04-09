package com.anandbibek.ishaanya2k14;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Anand on 1/18/14.
 */
public class TextViewC extends TextView {

    private static Typeface typeface;

    public TextViewC(final Context context){
        this(context, null);
    }

    public TextViewC(final Context context, final AttributeSet att){
        this(context,att,0);
    }

    public TextViewC(final Context context, final AttributeSet att, final int def){
        super(context,att,def);
        if(!this.isInEditMode()){
            if(typeface==null)
                typeface = Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Light.ttf");
            setTypeface(typeface);
        }
    }


}
