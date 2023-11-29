class Greeting {
    fun greet(): String {
        return "Hello! ${getPlatform().name}"
    }
}