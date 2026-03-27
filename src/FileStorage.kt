import resources.OutpostResource
import java.io.File

object FileStorage {
    private const val FILE_NAME = "outpost_state.txt"

    fun save(resources: List<OutpostResource>) {
        val file = File(pathname = FILE_NAME)
        file.writeText(
            text = resources.joinToString(separator = "\n") {
                "${it.id};${it.name};${it.amount}"
            }
        )
        println("Состояние базы сохранено в файл")
    }

    fun load(): List<OutpostResource> {
        val file = File(pathname = FILE_NAME)
        if (!file.exists()) return emptyList()
        println("Загрузка состояния базы из файла")
        return file.readLines().map {
            val (id, name, amount) = it.split(";")
            OutpostResource(id.toInt(), name, amountInit = amount.toInt())
        }
    }
}
