package life.league.challenge.kotlin.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import life.league.challenge.kotlin.databinding.FragmentHomeBinding
import life.league.challenge.kotlin.presentation.view.PostsAdapter
import life.league.challenge.kotlin.presentation.viewmodel.AppViewModel

@AndroidEntryPoint
class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        configureList()

        viewModel.init()

        observeViewModel()

        return binding.root
    }

    private fun configureList() {
        binding.postsList.apply {
            adapter = PostsAdapter(
                viewModel.posts
            )
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeViewModel() = with(viewModel) {
        postsRetrieved.observe(viewLifecycleOwner) {
            binding.postsList.adapter?.notifyDataSetChanged()
        }
    }
}
