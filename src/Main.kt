import resources.OutpostResource
import resources.ResourceManager

object SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }

    fun log(message: String) {
        println("[LOG] $message")
    }
}

val logger by lazy { SystemLogger }
val manager by lazy { ResourceManager() }

fun main() {
    logger.log("Запуск базы")

    val loadedResources = FileStorage.load()
    loadedResources.forEach { manager.add(it) }

    if (loadedResources.isEmpty()) {
        manager.add(OutpostResource(id = 1, name = "Minerals", amountInit = 300))
        manager.add(OutpostResource(id = 2, name = "Gas", amountInit = 100))
    }

    FileStorage.save(resources = manager.getAll())
}
