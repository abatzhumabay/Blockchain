package com.eagb.blockchainexample.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.eagb.blockchainexample.BuildConfig;
import com.eagb.blockchainexample.R;
import com.eagb.blockchainexample.databinding.FragmentMoreInfoBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MoreInfoFragment extends DialogFragment implements View.OnClickListener {

    private FragmentMoreInfoBinding viewBinding;

    private Context mContext;

    public MoreInfoFragment() {
        // Required empty public constructor
    }

    public static MoreInfoFragment newInstance() {
        return new MoreInfoFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mContext = context.getApplicationContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewBinding = FragmentMoreInfoBinding.inflate(getLayoutInflater(), container, false);
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String appVersion = "v." + BuildConfig.VERSION_NAME + " - Build " + BuildConfig.VERSION_CODE;
        viewBinding.txtAppVersion.setText(appVersion);

        viewBinding.btnClose.setOnClickListener(this);
        viewBinding.llCheckBlockchain.setOnClickListener(this);
        viewBinding.llCheckWhitePaper.setOnClickListener(this);
        viewBinding.llCheckBook1.setOnClickListener(this);
        viewBinding.llCheckBook2.setOnClickListener(this);
        viewBinding.llCheckRepo.setOnClickListener(this);
        viewBinding.llCheckWeb.setOnClickListener(this);
        viewBinding.txtHeart.setOnClickListener(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public void onClick(@NonNull View view) {
        String url;

        if (R.id.btn_close == view.getId()) {
            dismiss();
        } else if (R.id.ll_check_blockchain == view.getId()) {
            // Checking a Blockchain tutorial
            url = "https://zen.yandex.ru/media/znaki/top13-luchshih-birj-kriptovaliut-reiting-kriptobirj-2022-626c74c1668e4d3020d74526?utm_source=yandex&utm_medium=cpc&utm_campaign=search|73898554&utm_content=phrase_id|38505095688|gid|4899260152|aid|12079395742&utm_term=crypto&added=no&block=premium&pos=1&device=desktop&region=region_name|%D0%9D%D1%83%D1%80-%D0%A1%D1%83%D0%BB%D1%82%D0%B0%D0%BD|region_id|163&etext=2202.6Z1-uyYiZtfg17STlmJJrfJTZSL6J-Cu21_jFrlL5qFzaWJtZXdpenNqYnpuZWRv.59ae3a8f7cf42819bdd7e56fa2d78190e7ab13f7";
            openUrl(url);
        } else if (R.id.ll_check_white_paper == view.getId()) {
            // Checking the White Paper of Bitcoin
            url = "https://medium.com/coinmonks/bitcoin-white-paper-explained-part-1-4-16cba783146a";
            openUrl(url);
        } else if (R.id.ll_check_book_1 == view.getId()) {
            // Checking Blockchain Revolution book
            url = "https://itig-iraq.iq/wp-content/uploads/2019/05/Blockchain_Revolution.pdf";
            openUrl(url);
        } else if (R.id.ll_check_book_2 == view.getId()) {
            // Checking The Science of the Blockchain book
            url = "https://www.goodreads.com/book/show/28919062-the-science-of-the-blockchain";
            openUrl(url);
        } else if (R.id.ll_check_repo == view.getId()) {
            // Checking the official repo to fork
            url = "https://";
            openUrl(url);
        } else if (R.id.ll_check_web == view.getId()) {
            // Checking the official web site
            url = "https://www.instagram.com/abatzhumabay";
            openUrl(url);
        } else if (R.id.txt_heart == view.getId()) {
            // Showing an EasterEgg
            Toast.makeText(mContext, R.string.text_thank_you, Toast.LENGTH_SHORT).show();
        }
    }

    private void openUrl(@NonNull String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        viewBinding = null;
        mContext = null;
    }
}
