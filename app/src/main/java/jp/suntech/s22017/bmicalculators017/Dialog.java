package jp.suntech.s22017.bmicalculators017;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {
    public static class OrderConfirmDialogFragment extends DialogFragment{
        @Override
        public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("警告");
            builder.setMessage("適切な肥満を求めるためには、6歳未満の場合はカウブ指数が、6歳から15歳まではローレル指数が使われます。本アプリはBMIのみに対応しています。");
            builder.setPositiveButton("確認", new DialogButtonClickListener());
            AlertDialog dialog = builder.create();
            return dialog;
        }
    }

    public static class DialogButtonClickListener implements DialogInterface.OnClickListener{

        @Override
        public  void onClick(DialogInterface dialog, int which) {
            String msg="";
            switch(which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = "OK";
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = "OK";
                    break;
            }

        }
    }
}
