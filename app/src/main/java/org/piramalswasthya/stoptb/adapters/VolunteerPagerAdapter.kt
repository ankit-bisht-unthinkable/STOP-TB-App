package org.piramalswasthya.stoptb.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.piramalswasthya.stoptb.ui.home_activity.dashboard.DashboardFragment
import org.piramalswasthya.stoptb.ui.volunteer.fragment.VolunteerIconsFragment

/**
 * Pass the host fragment's childFragmentManager and its *view* lifecycle. The Fragment
 * constructor of FragmentStateAdapter observes the fragment's own lifecycle, which outlives the
 * view, so every return to the home screen kept the previous ViewPager2 and its whole view tree
 * reachable (91 retained copies after one test session).
 */
class VolunteerPagerAdapter(
    fragmentManager: FragmentManager,
    viewLifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, viewLifecycle) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VolunteerIconsFragment()
            1 -> DashboardFragment()
            else -> throw IllegalStateException("Index >1 called!")
        }
    }
}