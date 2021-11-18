package com.example.task.data.local.repository

import com.example.task.data.local.dao.GardenPlantingDao
import com.example.task.data.local.entities.GardenPlanting
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GardenPlantingRepository @Inject constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {

    suspend fun createGardenPlanting(plantId: String) {
        val gardenPlanting = GardenPlanting(plantId)
        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    fun isPlanted(plantId: String) =
        gardenPlantingDao.isPlanted(plantId)

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()
}
