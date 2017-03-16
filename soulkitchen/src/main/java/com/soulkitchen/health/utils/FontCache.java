package com.soulkitchen.health.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;
import java.util.UnknownFormatFlagsException;

/**
 * Created by serifenuruysal on 13/03/17.
 */

public class FontCache {
    private static Map<Integer, Typeface> fontMap = new HashMap<>();

    public static Typeface getFont(Context context, int fontCode) {

        if (fontMap.containsKey(fontCode)) {
            return fontMap.get(fontCode);
        } else {
            String fontName;
            switch (fontCode) {
                case 0:
                    fontName = "Linotype - VAGRoundedStd-Black.otf";
                    break;
                case 1:
                    fontName = "Linotype - VAGRoundedStd-Light.otf";
                    break;
                default:
                    throw new UnknownFormatFlagsException(
                            "Unknown format flag for custom font");
            }
            Typeface tf = Typeface.createFromAsset(context.getAssets(), fontName);
            fontMap.put(fontCode, tf);
            return tf;
        }
    }
}
