package outpostState

import kotlin.properties.Delegates

class ObservableResource(val name: String, initialAmount: Int, private val observer: ResourceObserver? = null) {
    var amount: Int by Delegates.observable(initialValue = initialAmount) { _, old, new ->
        println("Ресурс $name изменён: $old -> $new")
        observer?.onChanged(name, old, new)
    }
}
