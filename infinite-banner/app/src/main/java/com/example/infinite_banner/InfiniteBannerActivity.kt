package com.example.infinite_banner

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.infinite_banner.databinding.ActivityInfiniteBannerBinding

class InfiniteBannerActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityInfiniteBannerBinding
    //리소스 이미지
    private val list = mutableListOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    //최대 크기
    private val numBanner = 3
    //왼쪽 오른쪽 Int 최대값 중간
    private var currentPosition = Int.MAX_VALUE / 2


    private val myHandler = MyHandler()
    //시간
    private var intervalTime = 2000.toLong() //기본값 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        val time = intent.getLongExtra("intervalTime",2000)
        intervalTime = time

        super.onCreate(savedInstanceState)
        binding = ActivityInfiniteBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //최대크기
        binding.textViewTotalBanner.text = numBanner.toString()

        binding.autoScrollViewPager.adapter = InfiniteAdapter(list)
        binding.autoScrollViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.autoScrollViewPager.setCurrentItem(currentPosition, false)

        binding.autoScrollViewPager.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
//                    currentPosition++
                    binding.textViewCurrentBanner.text = "${(position % 3) + 1}"
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        //CROLL_STATE_DRAGGING -> SCROLL_STATE_SETTLING -> SCROLL_STATE_IDLE

                        // 멈춤 상태
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }

    private fun autoScrollStart(intervalTime: Long) {
//        Log.d("testet", "autoScrollStart: $currentPosition")
        myHandler.removeMessages(0) // 핸들러 제거
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // 반복 실행
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                binding.autoScrollViewPager.setCurrentItem(++currentPosition, true) // 다음 페이지
                autoScrollStart(intervalTime) // 스크롤
            }
        }
    }
    //액티비티 라이프 사이클
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

}