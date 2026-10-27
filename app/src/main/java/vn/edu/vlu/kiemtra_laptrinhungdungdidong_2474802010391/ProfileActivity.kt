package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010391

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSkills = findViewById(R.id.lvSkills)

        // lay email tu Intent gui qua
        val email = intent.getStringExtra(EXTRA_EMAIL)
        tvEmail.text = email

        // dang xuat: dong man hinh hien tai, quay ve LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }

        // du lieu mau cho ListView
        val skills = arrayOf(
            "Kotlin Programming",
            "XML Layout Design",
            "Git/GitHub Management",
            "Intent Processing",
            "Android Architecture",
            "ListView & ArrayAdapter"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skills)
        lvSkills.adapter = adapter

        lvSkills.setOnItemClickListener { _, _, position, _ ->
            val selected = skills[position]
            Toast.makeText(this, getString(R.string.toast_selected, selected), Toast.LENGTH_SHORT).show()
        }
    }
}
