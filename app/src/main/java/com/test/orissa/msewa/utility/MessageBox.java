package com.test.orissa.msewa.utility;

import android.app.Activity;


/**
 * Created by Navya on 25-02-2016.
 */
public class MessageBox {


    android.app.Dialog dd;
    //    android.app.Dialog dd;
//    public   void loading(String title,Activity act)
//    {
//
//
//        dd = new android.app.Dialog(act);
//        try {
//            dd.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//            dd.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//            dd.setContentView(R.layout.custom_loading);
//            dd.getWindow().setLayout(-1, -2);
//            dd.setCancelable(false);
////            ((MyTextView)dd.findViewById(R.id.title)).setText(title);
////            ((MyTextView)dd.findViewById(R.id.yes)).setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    dd.dismiss();
////                }
////            });
//            dd.show();
//
//        }catch (Exception e){e.printStackTrace();}
//
//    }
    public  void dismiss_loading(String title,Activity act)
    {



        dd.dismiss();

//        if(dd!=null)
//        {
//            dd.dismiss();
//        }
    }


//    public static android.app.Dialog show_msg(String title,Context appContext){
//
//        final android.app.Dialog dd = new android.app.Dialog(appContext, R.style.customDialog);
//        //final android.app.Dialog dd = new android.app.Dialog(appContext, R.style.customDialogAnimation);
//        //  final android.app.Dialog dd = new android.app.Dialog(appContext);
//        try {
//            dd.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//            dd.getWindow().setBackgroundDrawableResource (android.R.color.transparent);
//
//            dd.setContentView (R.layout.message_box);
//            dd.getWindow().setLayout(-1, -2);
//            dd.setCancelable(false);
//            dd.getWindow ().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            ((CustomTextView)dd.findViewById(R.id.title)).setText(title);
//            ((CustomTextView)dd.findViewById(R.id.yes)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dd.dismiss();
//                }
//            });
//            dd.show();
//
//        }catch (Exception e){e.printStackTrace();}
//        return dd;
//    }

//    public static void show_msg(final String msg,final Context mContext) {
//        android.support.v7.app.AlertDialog.Builder alertDialog = new android.support.v7.app.AlertDialog.Builder(mContext);
//        // Setting Dialog Title
//        //      alertDialog.setTitle("FlyerPlane");
//
//        View view = LayoutInflater.from(mContext).inflate(R.layout.msg_popup,null);
//        alertDialog.setView(view);
//        ((CustomTextView)view.findViewById(R.id.txt_note)).setText(msg);
//        // Setting Dialog Message
//        // Setting Icon to Dialog
//        //  alertDialog.setIcon(R.drawable.);
//        alertDialog.setCancelable(false);
//        // On pressing Settings button
////        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////            public void onClick(DialogInterface dialog, int which) {
////                if (msg.equals("1")) {
////                    activity.finish();
////                } else {
////
////                    removekey(mContext, activity);
////                }
////
////            }
////        });
//
////        // on pressing cancel button
////        alertDialog.setNegativeButton(mContext.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
////            public void onClick(DialogInterface dialog, int which) {
////                dialog.cancel();
////            }
////        });
//
//        // Showing Alert Message
//        alertDialog.show();
//    }






}
