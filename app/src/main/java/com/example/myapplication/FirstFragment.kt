package com.example.myapplication

import android.os.Bundle
import android.view.*
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        val rootView: View = inflater.inflate(R.layout.fragment_first, container, false)

        val webview = rootView.findViewById(R.id.web_view) as WebView


        webview.loadUrl("https://pasteurian-visitors.000webhostapp.com/sibilla/client/helloWork.php")
        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true
        webSettings.mixedContentMode=WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
        webview.webViewClient = WebViewClient()
        binding.root.addView(rootView)


        return binding.root
       // return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}