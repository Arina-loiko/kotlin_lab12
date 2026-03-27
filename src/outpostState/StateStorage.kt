package outpostState

import java.io.File

object StateStorage {
    private const val FILE_NAME = "outpostState_state.txt"

    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        file.writeText(
            resources.joinToString("\n") { "${it.name};${it.amount}" }
        )
        println("Состояние сохранено в файл")
    }

    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()
        println("Загрузка состояния из файла")
        return file.readLines().map {
            val (name, amount) = it.split(";")
            ObservableResource(name, amount.toInt())
        }
    }
}
