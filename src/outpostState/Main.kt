package outpostState

val manager by lazy { OutpostManager() }

fun main() {
    val loadedResources = StateStorage.load()
    loadedResources.forEach { manager.add(it) }

    if (loadedResources.isEmpty()) {
        val observer = ResourceObserver()
        val minerals = ObservableResource("Minerals", 100, observer)
        val gas = ObservableResource("Gas", 200, observer)
        manager.add(minerals)
        manager.add(gas)
    }

    println("\nИзменяем количество ресурсов:")
    manager.getAll()[0].amount = 120
    manager.getAll()[1].amount = 150

    StateStorage.save(manager.getAll())

    println("\nЗагружаем состояние:")
    val loaded = StateStorage.load()
    loaded.forEach { println("${it.name}: ${it.amount}") }
}
