package com.coclearapp.pdm_project.Activities

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.coclearapp.pdm_project.R
import com.coclearapp.pdm_project.Room.Entity.Patient
import com.coclearapp.pdm_project.ViewModel.PatientViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_form_pacient.*
import java.util.*
import kotlin.collections.HashMap


@Suppress("DEPRECATION")
class NewPatientActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var mDatabase: DatabaseReference? = null
    private var id:String = ""

    private lateinit var patientViewModel: PatientViewModel


    var calendar = Calendar.getInstance()

    var yearCurrent = calendar.get(Calendar.YEAR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_form_pacient)
        var patientDate = this.findViewById(R.id.id_patient_date) as EditText
        patientDate.setOnClickListener{
            var day = calendar.get(Calendar.DAY_OF_MONTH);
            var month = calendar.get(Calendar.MONTH);
            var year = calendar.get(Calendar.YEAR);
            val dpd= DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                patientDate.setText("" + day + "/" + (month+1) + "/" + year)

            },year,month,day)
            dpd.show()
        }
        mDatabase = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel::class.java)

        Submit_Patient.setOnClickListener {
            savePatient()

        }
    }

    private fun savePatient() {

        if (!validate()) {
            return
        }

        showProgressDialog()


        //Firebase
        val user = auth.currentUser
        val childUpdates = HashMap<String, Any>()

        Log.d("userid", user!!.uid)

        val patient = Patient(
            Name_Patient = input_name_patient.text.toString(),
            Date = "${id_patient_date.text}",
            Level = 0,
            idUser = user.uid
        )

        //Guarda data en room
        patientViewModel.insertPatient(patient)



        //Guarda datos en Firebase

        val viewModel = ViewModelProviders.of(this).get(PatientViewModel::class.java)
        viewModel.getLastid().observe(this, androidx.lifecycle.Observer {Users ->

            if (Users != null){
                id = Users.toString()
                Log.d("idPatient",id)

                childUpdates.put("/Patient/${id}+${user.uid}", patient)
                mDatabase!!.updateChildren(childUpdates)

            }



      })

        hideProgressDialog()
        //Pasa a la actividad de pacientes
        action()

        finish()

    }
    val progressDialog by lazy {
        ProgressDialog(this, R.style.AppTheme_Dark_Dialog)
    }

    private fun showProgressDialog() {
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Registrando...")
        progressDialog.show()
    }

    private fun hideProgressDialog() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }


    private fun action() {
        startActivity(Intent(this, PatientsActivity::class.java))
    }
    private fun validate(): Boolean {
        var valid = true

        val name = input_name_patient.text.toString()
        val date = id_patient_date.text.toString()

        if (name.isEmpty() || name.length < 3) {
            input_name_patient!!.error = "Al menos 3 caracteres"
            valid = false
        } else {
            input_name_patient!!.error = null
        }
        if (id_patient_date.text.isEmpty()) {
            id_patient_date!!.error = "Introduce alguna fecha"
            valid = false
        } else {
            id_patient_date!!.error = null
        }



        return valid


    }


}