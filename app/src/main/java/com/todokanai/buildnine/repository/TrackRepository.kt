package com.todokanai.buildnine.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.todokanai.buildnine.activity.WorkerRunnable
import com.todokanai.buildnine.room.RoomHelper
import com.todokanai.buildnine.room.RoomTrack
import com.todokanai.buildnine.room.RoomTrackDao
import com.todokanai.buildnine.service.ForegroundPlayService.Companion.mCurrent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class TrackRepository(helper:RoomHelper) {



}
