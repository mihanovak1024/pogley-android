package com.mihanovak1024.pogley.inventory.domain.repository

import com.mihanovak1024.pogley.inventory.domain.model.InventoryItem
import kotlinx.coroutines.flow.Flow

interface InventoryItemRepository {

    fun getInventoryItems(): Flow<List<InventoryItem>>

    suspend fun getInventoryItemById(inventoryItemId: String): InventoryItem?

    suspend fun addInventoryItem(inventoryItem: InventoryItem)

    suspend fun deleteInventoryItem(inventoryItem: InventoryItem)
}