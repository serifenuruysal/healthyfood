package com.soulkitchen.health.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.soulkitchen.health.R;
import com.soulkitchen.health.utils.FontCache;

/**
 * Created by serifenuruysal on 13/03/17.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        init(null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomWidgetExt);
            int fontCode = typedArray.getInteger(R.styleable.CustomWidgetExt_MyFont, 0);

            try {
                Typeface myTypeface = FontCache.getFont(getContext(), fontCode);
                setTypeface(myTypeface);
            } catch (Exception e) {
                e.printStackTrace();
            }
            typedArray.recycle();
        }
    }

}
