package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010391

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // anh xa view bang findViewById
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            validateLogin()
        }
    }

    private fun validateLogin() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        // kiem tra rong
        if (email.isEmpty() && password.isEmpty()) {
            showError(getString(R.string.err_empty_both))
            return
        }
        if (email.isEmpty()) {
            showError(getString(R.string.err_empty_email))
            return
        }
        if (password.isEmpty()) {
            showError(getString(R.string.err_empty_password))
            return
        }

        // kiem tra dinh dang email va do dai mat khau
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError(getString(R.string.err_invalid_email))
            return
        }
        if (password.length < 6) {
            showError(getString(R.string.err_short_password))
            return
        }

        tvStatus.setTextColor(Color.parseColor("#2E7D32"))
        tvStatus.text = getString(R.string.validation_success)
    }

    private fun showError(message: String) {
        tvStatus.setTextColor(Color.parseColor("#D32F2F"))
        tvStatus.text = message
    }
}
