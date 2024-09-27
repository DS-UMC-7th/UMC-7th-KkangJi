package com.example.umc7thapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.umc7thapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 통해 레이아웃을 inflate
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        // 이미지 클릭 이벤트 설정
        binding.gooddayBtn.setOnClickListener {
            navigateToFragment(enjoyFragment()) // 더없이 행복한 하루
        }
        binding.excitingBtn.setOnClickListener {
            navigateToFragment(excitingFragment()) // 들뜨고 흥분돼요
        }
        binding.commonBtn.setOnClickListener {
            navigateToFragment(commonFragment()) // 평범한 하루
        }
        binding.anxietyBtn.setOnClickListener {
            navigateToFragment(anxietyFragment()) // 생각이 많아지고 불안해요
        }
        binding.angryBtn.setOnClickListener {
            navigateToFragment(angryFragment()) // 부글부글 화가 나요
        }

        return binding.root
    }

    // 프래그먼트 전환을 처리하는 함수
    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment) // fragment_container는 MainActivity의 프래그먼트 호스트
            .addToBackStack(null) // 뒤로 가기 시 이전 프래그먼트로 돌아갈 수 있도록
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 메모리 누수를 방지하기 위해 뷰 해제
    }
}
