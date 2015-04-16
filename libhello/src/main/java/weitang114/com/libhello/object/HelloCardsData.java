package weitang114.com.libhello.object;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import weitang114.com.libhello.R;

/**
 * Created by weitang114 on 15/4/16.
 */
public class HelloCardsData {

    public List<HelloData> data;

    public static final Locale[] LOCALES = {
            Locale.ENGLISH,
            Locale.TRADITIONAL_CHINESE,
            Locale.SIMPLIFIED_CHINESE,
            Locale.JAPANESE
    };

    public HelloCardsData(Context context) {
        data = new ArrayList<>();
        for (Locale loc : LOCALES) {
            data.add(new HelloData("Language: " + loc.getDisplayName(), getStringLocale(context, R.string.hello, loc)));
        }
    }

    public List<HelloData> getData() { return data; }


    private String getStringLocale(Context context, int rId, Locale locale) {
        Resources res = context.getResources();
        Configuration conf = res.getConfiguration();
        Locale savedLocale = conf.locale;
        conf.locale = locale; // whatever you want here
        res.updateConfiguration(conf, null); // second arg null means don't change

        // retrieve resources from desired locale
        String str = res.getString(rId);

        // restore original locale
        conf.locale = savedLocale;
        res.updateConfiguration(conf, null);

        return str;
    }


    public static class HelloData {
        public HelloData(String title, String hello) {
            this.title = title;
            this.hello = hello;
        }
        public String title;
        public String hello;
    }


}
