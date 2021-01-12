package com.example.muvi.ui.setting

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import com.example.muvi.R
import com.example.muvi.base.BaseFragment
import com.example.muvi.databinding.FragmentSettingBinding
import com.example.muvi.ui.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    override val layoutResource: Int
        get() = R.layout.fragment_setting

    override val viewModel by sharedViewModel<FavoriteViewModel>()

    override fun initData() {
        binding.apply {
            lifecycleOwner = this@SettingFragment
        }
        initListener()
    }

    private fun initListener() {
        binding.textAboutApp.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle(getString(R.string.text_dialog_about_app))
            builder.setMessage(getString(R.string.text_about_app_by_ht))
            //Nút Cancel
            builder.setNegativeButton("OK"
            ) { dialog, _ -> dialog.cancel() }
            val al: AlertDialog = builder.create()
            al.show()
        }
        binding.textFeedback.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse(getString(R.string.uri_mail_to))
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.text_feedback_subject))
            if (context?.packageManager?.let { it1 -> intent.resolveActivity(it1) } != null) {
                startActivity(intent)
            }
        }
        binding.textShareFriend.setOnClickListener {
            val share = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/hoan.ben.21")
                putExtra(Intent.EXTRA_TITLE, "Introducing a great movie app for you, would you like to try it out?")
                data = Uri.parse("https://i.pinimg.com/originals/4a/75/ec/4a75ec3c0a51b5df2d352e1d79c20b68.jpg")
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }, null)
            startActivity(share)
        }
    }
}
