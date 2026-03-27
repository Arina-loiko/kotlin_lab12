package resources

class ResourceManager {
    private val resources = mutableListOf<OutpostResource>()

    fun add(resource: OutpostResource) {
        resources.add(resource)
    }

    fun getAll(): List<OutpostResource> = resources.toList()
}
