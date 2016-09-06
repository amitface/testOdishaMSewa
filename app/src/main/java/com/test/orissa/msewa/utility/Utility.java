package com.test.orissa.msewa.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.Html;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mseva.R;
import com.mseva.constant.Constant;
import com.mseva.customeView.CustomTextView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {

    public static Context appContext;
    private static String PREFERENCE = "Woodbazarr";
    private static int MAX_IMAGE_DIMENSION = 720;
    public static Utility utility;


    public static Utility getInstant() {

        if (utility == null) {
            utility = new Utility();
        }
        return utility;
    }


    // for username string preferences
    public static void setSharedPreference(Context context, String name, String value) {
        appContext = context;
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putString(name, value);
        editor.commit();
    }

    // for username string preferences
    public static void setIntegerSharedPreference(Context context, String name, int value) {
        appContext = context;
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putInt(name, value);
        editor.commit();
    }

    //Drawable
    public static void setDrawableSharedPreference(Context context, String name, int value) {
        appContext = context;
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putInt(name, value);
        editor.commit();
    }

    public static String getSharedPreferences(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        return settings.getString(name, "");
    }


    public static int getIngerSharedPreferences(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        return settings.getInt(name, 0);
    }

    public static void setSharedPreferenceBoolean(Context context, String name, boolean value) {
        appContext = context;
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }

    public static boolean getSharedPreferencesBoolean(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        return settings.getBoolean(name, false);
    }


//    public static void setSaveAddress(Context context, String key, Address value) {
//
//        try {
//            appContext = context;
//            SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
//            SharedPreferences.Editor editor = settings.edit();
//            Gson gson = new Gson();
//            String json = gson.toJson(value);
//            editor.putString(key, json);
//            editor.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


//    public static Address getSaveAddress(Context context, String key) {
//        Address address = new Address();
//        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE, 0);
//        Gson gson = new Gson();
//        String json = prefs.getString(key, "");
//        address = gson.fromJson(json,
//                new TypeToken<Address>() {
//                }.getType());
//        return address;
//    }


//    public static void setSaveProduct(Context context, String key, Product value) {
//
//        try {
//            appContext = context;
//            SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
//            SharedPreferences.Editor editor = settings.edit();
//            Gson gson = new Gson();
//            String json = gson.toJson(value);
//            editor.putString(key, json);
//            editor.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static Product getSaveProduct(Context context, String key) {
//
//
//        Product product = new Product();
//
//        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE, 0);
//        Gson gson = new Gson();
//        String json = prefs.getString(key, "");
//        product = gson.fromJson(json,
//                new TypeToken<Address>() {
//                }.getType());
//        return product;
//    }


//    public static void removeSharedPreKey(Context appContext,String name)
//    {
//        SharedPreferences settings = appContext.getSharedPreferences(PREFERENCE, 0);
//        //settings.edit().remove(name).commit();
//        settings.edit().clear();
//    }

//    public static void removekey(Context appcontext, Activity activity) {
//        setSharedPreferenceBoolean(appcontext, Constant.LOGIN, false);
//        setSharedPreferenceBoolean(appcontext, Constant.LANGUAGE_SELECTION, false);
//        setSharedPreference(appcontext, Constant.EVENT_TYPE, "");
//        setSharedPreference(appcontext, Constant.AUTH_TOKEN, "");
//        setSharedPreference(appcontext, Constant.NAME, "");
//        setSharedPreference(appcontext, Constant.CITY_NAME, "");
//        setSharedPreference(appcontext, Constant.PLACE_NAME, "");
//        setSharedPreference(appcontext, Constant.LAT, "");
//        setSharedPreference(appcontext, Constant.LNG, "");
//        setSharedPreference(appcontext, Constant.ENGLISH, "");
//        setSharedPreference(appcontext, Constant.FRANCH, "");
//        setSharedPreference(appcontext, Constant.SPANISH, "");
//        setSharedPreference(appcontext, Constant.PROFILE_PIC, "");
//        setSharedPreference(appcontext, Constant.USER_GENDER, "");
//        setSharedPreference(appcontext, Constant.USER_DOB, "");
//        setSharedPreference(appcontext, Constant.USER_MOB, "");
//        setSharedPreference(appcontext, Constant.USER_NAME, "");
//        setSharedPreference(appcontext, Constant.USER_EMAIL, "");
//        setSharedPreference(appcontext, Constant.LANGUAGE_ID, "");
//        setSharedPreference(appcontext, Constant.USER_MOB, "");
//        setSharedPreference(appcontext,Constant.USER_IMAGE,"");
//        Intent intent = new Intent(appcontext, SpleshActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//        activity.startActivity(intent);
//        activity.finish();
//    }


    public static Bitmap decodeSampledBitmapFromResource(String path, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

//    public static Drawable getImageFromURL(String photoDomain) {
//        Drawable drawable = null;
//        try {
//            DefaultHttpClient httpClient = new DefaultHttpClient();
//            HttpGet request = new HttpGet(photoDomain.trim());
//            HttpResponse response = httpClient.execute(request);
//            InputStream is = response.getEntity().getContent();
//            drawable = Drawable.createFromStream(is, "src");
//        } catch (MalformedURLException e) {
//        } catch (IOException e) {
//        }
//        return drawable;
//    }

//    public static String postParamsAndfindJSON(String url, ArrayList<NameValuePair> params) {
//        String result = "";
//
//        System.out.println("URL comes in jsonparser class is:  " + url + params);
//        try {
//            int TIMEOUT_MILLISEC = 100000; // = 10 seconds
//            HttpParams httpParams = new BasicHttpParams();
//            HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
//            HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
//
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost httpPost = new HttpPost(url);
//            httpPost.setEntity(new UrlEncodedFormEntity(params));
//            // httpGet.setURI(new URI(url));
//
//            HttpResponse httpResponse = httpClient.execute(httpPost);
//            InputStream is = httpResponse.getEntity().getContent();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//
//            is.close();
//            result = sb.toString();
//
//        } catch (Exception e) {
//            System.out.println("exception in jsonparser class ........");
//            e.printStackTrace();
//            result = "";
//            return result;
//        }
//        return result;
//    }

    public static void log(String str) {
        // System.out.println(str);
        // Log.i("LOG",str);
    }

    static Locale myLocale;

    public static void setLocale(String lang, Context context) {

        myLocale = new Locale(lang);
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }
/*	public static String multiPart(String url,MultipartEntity entity) {
        String result="";
		HttpClient httpclient;

		try {
	    httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(url);

	    httppost.setEntity(entity);
		System.out.println("cvsc" + httppost);
		HttpResponse response = httpclient.execute(httppost);
		result = EntityUtils.toString(response.getEntity());
		System.out.println("Given Result to photo  " + result);

	} catch (Exception e) {
		// TODO: handle exception
	}
		return result;

	}*/


    public static Bitmap DownloadImageDirect(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String encodeTobase64(Bitmap image) {
        Bitmap immagex = image;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        // String imageEncoded = Base64Coder.encodeTobase64(image);

        // Log.d("LOOK", imageEncoded);
        return imageEncoded;
    }

    public static void alertBoxShow(Context context, int msg) {
        // set dialog for user's current location set for searching theaters.
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Alert");
        dialog.setMessage(msg);
        dialog.setPositiveButton(" Ok ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void ShowStringAlertWithMessage(Context context, int alerttitle,
                                                  int locationvalidation) {
        // Assign the alert builder , this can not be assign in Click events
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setMessage(locationvalidation);
        builder.setTitle(alerttitle);
        // Set behavior of negative button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void ShowStringAlert2WithMessage(final Context context, int alerttitle,
                                                   int locationvalidation) {
        // Assign the alert builder , this can not be assign in Click events
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setMessage(locationvalidation);
        builder.setTitle(alerttitle);
        // Set behavior of negative button
        builder.setPositiveButton("GET STARTED", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
                //((HomeActivity) appContext).moveToNextActivity("GET STARTED");
                //Intent intent=new Intent(appContext,GetStartedActivity.class);
            }
        });
        builder.setNegativeButton("FAQ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
                //((HomeActivity) appContext).moveToNextActivity("FAQ");
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

//    public static String findJSONFromUrl(String url) {
//        String result = "";
//
//        System.out.println("URL comes in jsonparser class is:  " + url);
//        try {
//            int TIMEOUT_MILLISEC = 100000; // = 10 seconds
//            HttpParams httpParams = new BasicHttpParams();
//            HttpConnectionParams.setConnectionTimeout(httpParams,
//                    TIMEOUT_MILLISEC);
//            HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet httpGet = new HttpGet(url);
//            // httpGet.setURI(new URI(url));
//
//            HttpResponse httpResponse = httpClient.execute(httpGet);
//            InputStream is = httpResponse.getEntity().getContent();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//
//            is.close();
//            result = sb.toString();
//            System.out.println("result  in jsonparser class ........" + result);
//
//        } catch (Exception e) {
//            System.out.println("exception in jsonparser class ........");
//            result = null;
//        }
//        return result;
//    }

    public static Bitmap getBitmap(String url) {
        Bitmap imageBitmap = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            try {
                imageBitmap = BitmapFactory.decodeStream(new FlushedInputStream(is));
            } catch (OutOfMemoryError error) {
                error.printStackTrace();
                System.out.println("exception in get bitma putility");
            }

            bis.close();
            is.close();
            final int IMAGE_MAX_SIZE = 50;
            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            int scale = 1;
            while ((o.outWidth * o.outHeight) * (1 / Math.pow(scale, 2)) > IMAGE_MAX_SIZE) {
                scale++;
            }
            if (scale > 1) {
                scale--;
                // scale to max possible inSampleSize that still yields an image
                // larger than target
                o = new BitmapFactory.Options();
                o.inSampleSize = scale;
                // b = BitmapFactory.decodeStream(in, null, o);

                // resize to desired dimensions
                int height = imageBitmap.getHeight();
                int width = imageBitmap.getWidth();

                double y = Math.sqrt(IMAGE_MAX_SIZE / (((double) width) / height));
                double x = (y / height) * width;
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(imageBitmap, (int) x, (int) y, true);
                imageBitmap.recycle();
                imageBitmap = scaledBitmap;

                System.gc();
            } else {
                // b = BitmapFactory.decodeStream(in);
            }

        } catch (OutOfMemoryError error) {
            error.printStackTrace();
            System.out.println("exception in get bitma putility");
        } catch (Exception e) {
            System.out.println("exception in get bitma putility");
            e.printStackTrace();
        }
        return imageBitmap;
    }

    static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }
    }

    public static byte[] scaleImage(Context context, Uri photoUri)
            throws IOException {
        InputStream is = context.getContentResolver().openInputStream(photoUri);
        BitmapFactory.Options dbo = new BitmapFactory.Options();
        dbo.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, dbo);
        is.close();

        int rotatedWidth, rotatedHeight;
        int orientation = 0;// getOrientation(appContext, photoUri);

        if (orientation == 90 || orientation == 270) {
            rotatedWidth = dbo.outHeight;
            rotatedHeight = dbo.outWidth;
        } else {
            rotatedWidth = dbo.outWidth;
            rotatedHeight = dbo.outHeight;
        }

        Bitmap srcBitmap;
        is = context.getContentResolver().openInputStream(photoUri);
        if (rotatedWidth > MAX_IMAGE_DIMENSION
                || rotatedHeight > MAX_IMAGE_DIMENSION) {
            float widthRatio = ((float) rotatedWidth)
                    / ((float) MAX_IMAGE_DIMENSION);
            float heightRatio = ((float) rotatedHeight)
                    / ((float) MAX_IMAGE_DIMENSION);
            float maxRatio = Math.max(widthRatio, heightRatio);

            // Create the bitmap from file
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = (int) maxRatio;
            srcBitmap = BitmapFactory.decodeStream(is, null, options);
        } else {
            srcBitmap = BitmapFactory.decodeStream(is);
        }
        is.close();

		/*
         * if the orientation is not 0 (or -1, which means we don't know), we
		 * have to do a rotation.
		 */
        if (orientation > 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(orientation);

            srcBitmap = Bitmap.createBitmap(srcBitmap, 0, 0,
                    srcBitmap.getWidth(), srcBitmap.getHeight(), matrix, true);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        srcBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        /*
         * if (type.equals("image/png")) {
		 * srcBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos); } else if
		 * (type.equals("image/jpg") || type.equals("image/jpeg")) {
		 * srcBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); }
		 */
        byte[] bMapArray = baos.toByteArray();
        baos.close();
        return bMapArray;
    }

    static int mMaxWidth, mMaxHeight;

    @SuppressWarnings("deprecation")
    public static Bitmap loadResizedImage(Context mContext, final File imageFile) {
        WindowManager windowManager = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        mMaxWidth = display.getWidth();
        mMaxHeight = display.getHeight();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
        int scale = calculateInSampleSize(options, mMaxWidth, mMaxHeight);
        while (options.outWidth / scale > mMaxWidth
                || options.outHeight / scale > mMaxHeight) {
            scale++;
        }
        Bitmap bitmap = null;
        Bitmap scaledBitmap = null;
        if (scale > 1) {
            try {
                scale--;
                options = new BitmapFactory.Options();
                options.inSampleSize = scale;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inPurgeable = true;
                options.inTempStorage = new byte[16 * 100];
                bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(),
                        options);
                if (bitmap == null) {
                    return null;
                }

                // resize to desired dimensions
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                double newWidth;
                double newHeight;
                if ((double) width / mMaxWidth < (double) height / mMaxHeight) {
                    newHeight = mMaxHeight;
                    newWidth = (newHeight / height) * width;
                } else {
                    newWidth = mMaxWidth;
                    newHeight = (newWidth / width) * height;
                }

                scaledBitmap = Bitmap.createScaledBitmap(bitmap,
                        Math.round((float) newWidth),
                        Math.round((float) newHeight), true);
                bitmap.recycle();
                bitmap = scaledBitmap;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            }
            System.gc();
        } else {
            bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        }

        return rotateImage(bitmap, imageFile);
    }

    public static Bitmap rotateImage(final Bitmap bitmap,
                                     final File fileWithExifInfo) {
        if (bitmap == null) {
            return null;
        }
        Bitmap rotatedBitmap = bitmap;
        int orientation = 0;
        try {
            orientation = getImageOrientation(fileWithExifInfo
                    .getAbsolutePath());
            if (orientation != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(orientation, (float) bitmap.getWidth() / 2,
                        (float) bitmap.getHeight() / 2);
                rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                        bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                bitmap.recycle();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rotatedBitmap;
    }

    public static int getImageOrientation(final String file) throws IOException {
        ExifInterface exif = new ExifInterface(file);
        int orientation = exif
                .getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        switch (orientation) {
            case ExifInterface.ORIENTATION_NORMAL:
                return 0;
            case ExifInterface.ORIENTATION_ROTATE_90:
                return 90;
            case ExifInterface.ORIENTATION_ROTATE_180:
                return 180;
            case ExifInterface.ORIENTATION_ROTATE_270:
                return 270;
            default:
                return 0;
        }
    }

    public static Typeface Appttf(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "AE100132.TTF");

    }

    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }


    // remove for preferences

    public static void removepreference(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        settings.edit().remove(name).commit();
    }

    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isFullname(String str) {
        String expression = "^[a-zA-Z\\s]+";
        return str.matches(expression);
    }

    /* public static void ShowAlertDialog(String msg)
     {
         AlertDialog.Builder builder = new AlertDialog.Builder(appContext);
         builder.setTitle("SwipeMe");
         builder.setMessage(msg);
         builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int id) {
                 dialog.dismiss();
             }
         });

 // Create the AlertDialog
         AlertDialog dialog = builder.create();
         dialog.show();

     }
 */
    public static boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]*");
    } // end

    /**
     * Function to show settings alert dialog
     */
    public static void showSettingsAlert(final Context context) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    //    public static void showExit(final Context mContext, final Activity activity, final String msg) {
//        android.support.v7.app.AlertDialog.Builder alertDialog = new android.support.v7.app.AlertDialog.Builder(mContext);
//        // Setting Dialog Title
//        alertDialog.setTitle("FlyerPlane");
//
//        // Setting Dialog Message
//        if (msg.equals("1")) {
//
//            alertDialog.setMessage(mContext.getResources().getString(R.string.msg_exit));
//        } else {
//            alertDialog.setMessage(mContext.getResources().getString(R.string.msg_logut));
//
//        }
//        // Setting Icon to Dialog
//        //  alertDialog.setIcon(R.drawable.);
//        alertDialog.setCancelable(false);
//        // On pressing Settings button
//        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                if (msg.equals("1")) {
//                    activity.finish();
//                } else {
//
//                    removekey(mContext, activity);
//                }
//
//            }
//        });
//
//        // on pressing cancel button
//        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        // Showing Alert Message
//        alertDialog.show();
//    }
    public static void showExit(final Context mContext, final Activity activity, final String msg) {
        android.support.v7.app.AlertDialog.Builder alertDialog = new android.support.v7.app.AlertDialog.Builder(mContext);
        // Setting Dialog Title
        View view = LayoutInflater.from(mContext).inflate(R.layout.msg_popup, null);
        alertDialog.setView(view);

        // Setting Dialog Message
        if (msg.equals("1")) {
            ((CustomTextView) view.findViewById(R.id.txt_note)).setText(mContext.getResources().getString(R.string.msg_exit));

        }
        if (msg.equals("2")) {
            ((CustomTextView) view.findViewById(R.id.txt_note)).setText(mContext.getResources().getString(R.string.msg_logut));
        }
        if (msg.equals("3")) {
            ((CustomTextView) view.findViewById(R.id.txt_note)).setText(mContext.getResources().getString(R.string.msg_delete));
        }
        // Setting Icon to Dialog
        //  alertDialog.setIcon(R.drawable.);
        alertDialog.setCancelable(true);
        // On pressing Settings button
        alertDialog.setPositiveButton(mContext.getResources().getString(R.string.msg_yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (msg.equals("1")) {
                    activity.finish();
                } else {

                    //removekey(mContext, activity);
                }

            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton(mContext.getResources().getString(R.string.msg_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    public static void app_msg00(final Context mContext, final String msg) {
        final android.support.v7.app.AlertDialog alertDialognew;
        android.support.v7.app.AlertDialog.Builder alertDialog = new android.support.v7.app.AlertDialog.Builder(mContext);
        // Setting Dialog Title
        //      alertDialog.setTitle("FlyerPlane");
        // alertDialog.setMessage(msg);

        View view = LayoutInflater.from(mContext).inflate(R.layout.msg_popup, null);
        alertDialog.setView(view);
        ((CustomTextView) view.findViewById(R.id.txt_note)).setText(msg);
        // Setting Dialog Message
        // Setting Icon to Dialog
        //  alertDialog.setIcon(R.drawable.);
        alertDialog.setCancelable(true);
        // On pressing Settings button
//        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                if (msg.equals("1")) {
//                    activity.finish();
//                } else {
//
//                    removekey(mContext, activity);
//                }
//
//            }
//        });

        // on pressing cancel button
//        alertDialog.setNegativeButton(mContext.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
        alertDialognew = alertDialog.create();
        ((CustomTextView) view.findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialognew.dismiss();
            }
        });
        // alertDialognew.getButton(alertDialognew.BUTTON_NEGATIVE).setTextColor(mContext.getResources().getColor(R.color.wood));
        //  alertDialognew.getButton(alertDialognew.BUTTON_POSITIVE).setTextColor(mContext.getResources().getColor(R.color.wood));
        // Showing Alert Message
        alertDialognew.show();
    }

    public static void app_msg(final Context mContext, final String msg,final  String typeMsg)
    {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);

        alertDialogBuilder.setMessage(Html.fromHtml(/*"<font color='#D35400'>" +*/ msg + " "   /*+ "</font>"*/));
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //       submitData();
                if(msg.equals(Constant.NEWS)) {


                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://timesofindia.indiatimes.com/"));
                    mContext.startActivity(browserIntent);
                }

                // startActivity(new Intent(appContext,VerificationActivity.class));
            }
        });

        alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog;
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(alertDialog.BUTTON_POSITIVE).setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        alertDialog.getButton(alertDialog.BUTTON_NEGATIVE).setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
    }

    public static void setMSG(String str, Context appContext) {
        // Toast.makeText(appContext, str, Toast.LENGTH_SHORT).show();


    }

    public static String readContacts(Context appContext) {

        String phoneNumber = null;
        String email = null;
        String number = null;

        Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
        String _ID = ContactsContract.Contacts._ID;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
        String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

        Uri EmailCONTENT_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
        String DATA = ContactsContract.CommonDataKinds.Email.DATA;

        StringBuffer output = new StringBuffer();

        ContentResolver contentResolver = appContext.getContentResolver();

        Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null);

        // Loop for every contact in the phone
        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                String contact_id = cursor.getString(cursor.getColumnIndex(_ID));
                String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));

                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(HAS_PHONE_NUMBER)));

                if (hasPhoneNumber > 0) {

                    output.append("\n First Name:" + name);

                    // Query and loop for every phone number of the contact
                    Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[]{contact_id}, null);
                    int i = 0;

                    System.out.println("total number " + phoneNumber);
                    while (phoneCursor.moveToNext()) {
                        phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
                        output.append("\n Phone number:" + phoneNumber);
                        System.out.println(output);


                        number = phoneNumber + ",";


                    }

                    phoneCursor.close();

                    // Query and loop for every email of the contact
//                    Cursor emailCursor = contentResolver.query(EmailCONTENT_URI,	null, EmailCONTACT_ID+ " = ?", new String[] { contact_id }, null);
//
//                    while (emailCursor.moveToNext()) {
//
//                        email = emailCursor.getString(emailCursor.getColumnIndex(DATA));
//
//                        output.append("\nEmail:" + email);
//
//                    }
//
//                    emailCursor.close();
                }

                output.append("\n");
            }

            //  outputText.setText(output);
        }
        return number;
    }

    public static void exportDB() {
        // TODO Auto-generated method stub

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//" + "com.ebabu.flyerplane"
                        + "//databases//" + "FlyerplaneDatabase";
                String backupDBPath = "/FlyerplaneDatabase";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (!backupDB.exists()) {
                    backupDB.createNewFile();
                }
                Log.d("DBPath", "backupDB: " + backupDB.getAbsolutePath());

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                System.out.println("the data table is " + backupDB.toString());

            }
        } catch (Exception e) {

            System.out.println("exp " + e.toString());
//            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG)
//                    .show();

        }
    }

    File flyerFolder;

    public String makeFile() {

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String path = "Flyerplane/Media/FlyerplaneImages/sent";
                flyerFolder = new File(sd, path);

                if (!flyerFolder.exists()) {
                    flyerFolder.mkdirs();
                    flyerFolder.getAbsolutePath();
                    System.out.println("fly path " + flyerFolder.getAbsolutePath());


                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flyerFolder.getAbsolutePath();
    }

    public static String getMediaFile() {

        try {
            File flyerFolder = null;
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String path = "Flyerplane/Media/FlyerplaneImages/sent";
                flyerFolder = new File(sd, path);
                if (!flyerFolder.exists()) {
                    flyerFolder.mkdirs();
                    flyerFolder.getAbsolutePath();
                    System.out.println("fly path " + flyerFolder.getAbsolutePath());
                }

            }
            return flyerFolder.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAudioFile() {

        try {
            File flyerFolder = null;
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String path = "Flyerplane/Media/FlyerplaneImages/media";
                flyerFolder = new File(sd, path);
                if (!flyerFolder.exists()) {
                    flyerFolder.mkdirs();
                    flyerFolder.getAbsolutePath();
                    System.out.println("fly path " + flyerFolder.getAbsolutePath());
                }
            }
            return flyerFolder.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File getFile() {

        try {
            File flyerFolder = null;
            File myFile = null;
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String path = "Flyerplane/Media/FlyerplaneImages/sent";
                flyerFolder = new File(sd, path);
                if (!flyerFolder.exists()) {

                    //flyerFolder.mkdirs();
                    //flyerFolder.getParentFile().mkdirs();
                    // flyerFolder.createNewFile();
                    System.out.println("flyerfolder path" + flyerFolder.getAbsolutePath());
                    return flyerFolder;
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String makeFile01(String imgPath) {

        try {
            File flyerFolder = null;
            File myFile = null;
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String path = "Flyerplane/Media/FlyerplaneImages/sent";
                flyerFolder = new File(sd, path);

                if (!flyerFolder.exists()) {
                    flyerFolder.mkdirs();
                    //flyerFolder.getParentFile().mkdirs();
                    // flyerFolder.createNewFile();
                }

            }

//            File file = new File("/storage/emulated/0/WhatsApp/Media/WhatsApp Images/IMG-20160513-WA0003.jpg");
            File file = new File(imgPath);
            if (!file.exists()) {
                return null;
            }

            if (flyerFolder.exists()) {
                FileChannel source = null;
                FileChannel destination = null;
                source = new FileInputStream(file).getChannel();
                myFile = new File(flyerFolder, "my_image_" + System.currentTimeMillis() + ".jpg");
                destination = new FileOutputStream(myFile).getChannel();
                if (destination != null && source != null) {
                    destination.transferFrom(source, 0, source.size());
                }
                if (source != null) {
                    source.close();
                }
                if (destination != null) {
                    destination.close();
                }
            }

            return myFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void startTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void finishTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public static void Log(String msg) {
        Log.d("TAG", msg);
    }

    //    private void copyFile() throws IOException {
//        File file = new File("/storage/emulated/0/WhatsApp/Media/WhatsApp Images/IMG-20160513-WA0003.jpg");
//        if (!file.exists()) {
//            return;
//        }
//
//        if (flyerFolder.exists()) {
//
//            FileChannel source = null;
//            FileChannel destination = null;
//            source = new FileInputStream(file).getChannel();
//            File myFile = new File(flyerFolder, "my_image_" + System.currentTimeMillis() + ".jpg");
//            destination = new FileOutputStream(myFile).getChannel();
//            if (destination != null && source != null) {
//                destination.transferFrom(source, 0, source.size());
//            }
//            if (source != null) {
//                source.close();
//            }
//            if (destination != null) {
//                destination.close();
//            }
//        }
//
//
//    }
    public static Drawable buildCounterDrawable(Context appContext, int count, int bgResourceId) {
        LayoutInflater inflater = LayoutInflater.from(appContext);
        View view = inflater.inflate(R.layout.layout_menu_counter, null);
        ImageView imgCounterBackground = (ImageView) view.findViewById(R.id.img_counter_background);
        imgCounterBackground.setImageResource(bgResourceId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.tv_count);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.tv_count);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(((Activity) appContext).getResources(), bitmap);
    }

    public static void logout(Context appContext) {
//     getSharedPreferences(appContext, Constants.)


    }


    public static MyDialog myDialog = null;






}// final class ends here

