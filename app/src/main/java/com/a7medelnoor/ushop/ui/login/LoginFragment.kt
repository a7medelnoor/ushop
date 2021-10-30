package com.a7medelnoor.ushop.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.data.model.response.LoginResponse
import com.a7medelnoor.ushop.data.network.ApiClient
import com.a7medelnoor.ushop.databinding.FragmentLoginBinding
import com.a7medelnoor.ushop.util.AppConstants.Companion.SERVER_KEY
import com.a7medelnoor.ushop.util.LoginSessionManager
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response

class LoginFragment : Fragment() {
    private lateinit var apiClient: ApiClient
    lateinit var loginSession: LoginSessionManager
    private lateinit var viewModel: LoginViewModel
    private  var _binding: FragmentLoginBinding? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        apiClient = ApiClient()
        loginSession = LoginSessionManager(requireContext())
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

    }

    private fun userLogin() {
        val user_name =
            view?.findViewById<TextInputEditText>(R.id.email_address_text_field_input)?.text.toString()
        val password =
            view?.findViewById<TextInputEditText>(R.id.password_edit_text_field_input)?.text.toString()
        apiClient = ApiClient()
        apiClient.getApiService().userLogin(SERVER_KEY, user_name, password)
            .enqueue(object : retrofit2.Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()
                    if (loginResponse?.code == 200 && loginResponse.data != null) {
                        loginSession.saveAuthToken(loginResponse.data.access_token)
                        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()

                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.loginButton.setOnClickListener {
            val username =
                binding.emailAddressTextFieldInput.text.toString()
            val password =
                binding.passwordEditTextFieldInput.text.toString()
            if (TextUtils.isEmpty(username)){
                binding.emailAddressTextFieldInput.setError("Please enter email")
                binding.emailAddressTextFieldInput.requestFocus()
            }else if (TextUtils.isEmpty(password)){
                binding.passwordEditTextFieldInput.setError("Please enter password")
                binding.passwordEditTextFieldInput.requestFocus()
            }else{
                if (loginSession.fetchAuthToken() != null){
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }else {
                   userLogin()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }

            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}