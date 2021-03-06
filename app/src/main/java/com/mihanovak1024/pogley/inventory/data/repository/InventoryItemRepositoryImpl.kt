package com.mihanovak1024.pogley.inventory.data.repository

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

// TODO: replace dummy hardcoded list with actual data sources
class InventoryItemRepositoryImpl @Inject constructor() : InventoryItemRepository {

    private val temporaryList = MutableStateFlow(
        listOf(
            InventoryItem(
                "lele123",
                "Screw Head (2x2)",
                10,
                "Screws for wood environments with good grip that stays put for all eternity and ever and ever and ever."
            ),
            InventoryItem(
                "456lele",
                "Wood Stick(10x2)",
                20,
                "Wooden stick for various different situations."
            )
        )
    )

    override fun getInventoryItems(): Flow<List<InventoryItem>> {
        return temporaryList
    }

    override suspend fun getInventoryItemById(inventoryItemId: String): InventoryItem? {
        return temporaryList.value.firstOrNull { it.id == inventoryItemId }
    }

    override suspend fun addInventoryItem(inventoryItem: InventoryItem) {
        val list = temporaryList.value.toMutableList()
        list.find { it.id == inventoryItem.id }?.let {
            list.remove(it)
        }
        list.add(inventoryItem)
        temporaryList.emit(list)
    }

    override suspend fun deleteInventoryItem(inventoryItem: InventoryItem) {
        val list = temporaryList.value.toMutableList()
        list.remove(inventoryItem)
        temporaryList.emit(list)
    }
}