package com.kelompok3.rsprima.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kelompok3.rsprima.model.Perlengkapan

@Database(entities = [Perlengkapan::class], version = 1, exportSchema = false)
abstract class PerlengkapanDb : RoomDatabase() {
    abstract fun perlengkapanDao(): PerlengkapanDao

    companion object{
        @Volatile
        private var INSTANCE: PerlengkapanDb? = null

        fun getDb(context: Context): PerlengkapanDb{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PerlengkapanDb::class.java,
                    "perlengkapan_rs"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}