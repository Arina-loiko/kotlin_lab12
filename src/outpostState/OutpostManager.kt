package outpostState

class OutpostManager {
    private val resources = mutableListOf<ObservableResource>()

    init {
        println("OutpostManager создан")
    }

    fun add(resource: ObservableResource) {
        resources.add(resource)
    }

    fun getAll(): List<ObservableResource> = resources.toList()
}
