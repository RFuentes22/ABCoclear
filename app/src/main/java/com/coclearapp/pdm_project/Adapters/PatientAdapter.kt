package com.coclearapp.pdm_project.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.coclearapp.pdm_project.Activities.NewPatientActivity
import com.coclearapp.pdm_project.Activities.PatientsActivity
import com.coclearapp.pdm_project.R
import com.coclearapp.pdm_project.Room.Entity.Patient
import kotlinx.android.synthetic.main.cardview_patient.view.*

class PatientAdapter(var items: List<Patient>, val clickListener: (Patient) -> Unit) :
    RecyclerView.Adapter<PatientAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_patient, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }


    fun dataChange(lista_patients: List<Patient>) {
        items = lista_patients
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Patient, clickListener: (Patient) -> Unit) = with(itemView) {
            patient_name.text = item.Name_Patient

            edit_patient.setOnClickListener {
                //Log.d("Editar","Editar")
                patient_name.isVisible = isGone
                edit_patient.isVisible = isGone
                et_patient_name.isVisible = true
                delete_patient.isVisible = isGone

                et_patient_name.setText(item.Name_Patient)
                et_patient_date.setText(item.Date)

                et_patient_date.isVisible = true
                et_patient_date.isClickable = true

                ok_edit_patient.isVisible = true

            }

            ok_edit_patient.setOnClickListener {
                patient_name.isVisible = true
                et_patient_name.isVisible = isGone
                edit_patient.isVisible = true
                delete_patient.isVisible = true
                et_patient_date.isVisible = isGone
                ok_edit_patient.isVisible = isGone

                item.Name_Patient = et_patient_name.text.toString()
                item.Date = et_patient_date.text.toString()

                PatientsActivity.patientEditClicked(item)
            }

            delete_patient.setOnClickListener {
                PatientsActivity.patientDeleteClicked(item.idPatient)
            }

            this.setOnClickListener { clickListener(item) }
        }
    }

}