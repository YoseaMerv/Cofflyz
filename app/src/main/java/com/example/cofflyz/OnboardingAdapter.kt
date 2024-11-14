package com.example.cofflyz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cofflyz.ui.onboardingfragment.OnboardingFragment1
import com.example.cofflyz.ui.onboardingfragment.OnboardingFragment2
import com.example.cofflyz.ui.onboardingfragment.OnboardingFragment3

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Menyimpan fragmen dalam list agar lebih fleksibel
    private val fragments: List<Fragment> = listOf(
        OnboardingFragment1(),
        OnboardingFragment2(),
        OnboardingFragment3()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        // Mengembalikan fragmen dari list berdasarkan posisi
        return fragments.getOrElse(position) { throw IllegalStateException("Unexpected position $position") }
    }
}
