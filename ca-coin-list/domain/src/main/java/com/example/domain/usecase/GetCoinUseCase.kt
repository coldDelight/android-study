package com.example.domain.usecase

import javax.inject.Inject
import com.example.domain.repository.CoinRepository
import retrofit2.HttpException
import com.example.domain.Resource
import com.example.domain.model.DomainCoin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

// 유스케이스 도메인이 아니라 ㅁ앱에 있어야 하나다 .! !! ! ! !
// or domain 에 mapper 추가하 ! ! 기
//binding adpter !!!! !!!
// 프레그 먼트트로 상세 페이지 ! ! ! !! !! !
// 생명 주기
// activty에 ㅍ 리사이클러 뷰 제외 -> intent XX 프레그먼트로 ! !

