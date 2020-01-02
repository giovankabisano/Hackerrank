package interviewPreparationKit.hashMap

fun minimumBribes(q: List<String>): Unit {
    val hashMap: MutableMap<String, Int> = HashMap<String, Int>()

    q.forEach {
        if (!hashMap.containsKey(it)) {
            hashMap[it] = 1
        } else {
            val value = hashMap[it]
            if (value != null) {
                hashMap[it] = value + 1
            }
        }
    }

    var maxKey = ""
    var maxValue = 0
    for (i in hashMap.keys) {
        if (hashMap[i]!! > maxValue) {
            maxKey = i
            maxValue = hashMap[i]!!
        }
    }

    print(maxKey)
}

fun main() {
    val q = listOf("Fashion", "Gadget", "Gadget", "Gadget", "Gadget", "Fashion", "Fashion", "borb", "borb")
    minimumBribes(q)
}
