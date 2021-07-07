package com.coclearapp.pdm_project.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.coclearapp.pdm_project.R
import com.coclearapp.pdm_project.ViewModel.LevelViewModel
import kotlinx.android.synthetic.main.fragment_levels_excersices.view.*

class LevelsExcersicesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity.run {
            ViewModelProviders.of(this!!).get(LevelViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_levels_excersices, container, false).apply {
            ib_excersises_level1.setOnClickListener {

                var fragment = RVExercisesFragment.newInstance(1)


            }

            ib_excersises_level2.setOnClickListener {

                var fragment = RVExercisesFragment.newInstance(2)


            }

            ib_excersises_level3.setOnClickListener {

                var fragment = RVExercisesFragment.newInstance(3)


            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                LevelsExcersicesFragment()

    }

    private lateinit var model: LevelViewModel
}