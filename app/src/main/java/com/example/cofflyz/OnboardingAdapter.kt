package com.example.cofflyz


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cofflyz.ui.onboardingfragment.OnboardingFragment1
import com.example.cofflyz.ui.onboardingfragment.OnboardingFragment2
import com.example.cofflyz.ui.onboardingfragment.OnboardingFragment3

class OnboardingAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment1()
            1 -> OnboardingFragment2()
            2 -> OnboardingFragment3()
            else -> throw IndexOutOfBoundsException("Invalid position $position")
        }
    }
}
