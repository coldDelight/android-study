package com.colddelight.myapplication.utils
data class CityInfo(
    val Incheon: TransLocation = TransLocation(55.0, 124.0),
    val Daejeon: TransLocation = TransLocation(67.0, 100.0),
    val Daegu: TransLocation = TransLocation(89.0, 90.0),
    val Busan: TransLocation = TransLocation(98.0, 76.0),
    val Ulsan: TransLocation = TransLocation(102.0, 84.0),
    val Err: TransLocation = TransLocation(0.0, 0.0),
)
//val CityInfo2 = mutableMapOf(
//    "Incheon" to TransLocation(55.0, 124.0),
//    "Daejeon" to TransLocation(67.0, 100.0),
//    "Daegu" to TransLocation(89.0, 90.0),
//    "Busan" to TransLocation(98.0, 76.0),
//    "Ulsan" to TransLocation(102.0, 84.0),
//)
//
////object CityInfo {
////    val Incheon: TransLocation = TransLocation(55.0, 124.0),
////    val Daejeon: TransLocation = TransLocation(67.0, 100.0),
////    val Daegu: TransLocation = TransLocation(89.0, 90.0),
////    val Busan: TransLocation = TransLocation(98.0, 76.0),
////    val Ulsan: TransLocation = TransLocation(102.0, 84.0),
////}
data class TransLocation(
    val nx: Double,
    val ny: Double)