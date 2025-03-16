data class Items(
    val itemName: String,
    val price: Double
)

data class Stores(
    val storeNum: Int,
    val storeName: String,
    var items: MutableList<Items>
)

fun main() {
    val item0 = Items("Dummy", 0.0)
    var item1 = Items("Item1", 10.0)
    var item2 = Items("Item2", 20.0)
    var item3 = Items("Item3", 30.0)

    var newStoreItemsInit: MutableList<Items> = mutableListOf(item0)
    var allItems: MutableList<Items> = mutableListOf(item1, item2, item3)

    var store1 = Stores(1, "Store#1", allItems)
    var store2 = Stores(2, "Store#2", allItems)
    //var store3 = Stores(3, allItems)

    var allStores: MutableList<Stores> = mutableListOf(store1, store2)

    var strNums: MutableList<Int> = mutableListOf()
    allStores.forEach { strNums.add(it.storeNum) }
    println(strNums)



}

