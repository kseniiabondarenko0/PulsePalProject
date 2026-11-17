package com.example.pulsepal

// One interval of an ECG recording that the user wants to look at.
// recordingId - recording number in VitalDB (1 or more)
// startSec    - where the interval starts, in seconds (0 or more)
// lengthSec   - how long it is, in seconds (5 to 60)
data class EcgInterval(
    val recordingId: Int,
    val startSec: Int,
    val lengthSec: Int
)
