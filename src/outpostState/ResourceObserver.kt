package outpostState

class ResourceObserver {
    fun onChanged(name: String, old: Int, new: Int) {
        println("[Observer] $name изменился: $old -> $new")
    }
}
