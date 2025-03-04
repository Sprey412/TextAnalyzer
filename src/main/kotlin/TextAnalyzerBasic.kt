import java.io.File

open class TextAnalyzerBasic(val filePath: String) {
    // Изменим на protected, чтобы доступ был у наследников
    protected val text: String = File(filePath).readText()

    fun countCharactersWithSpaces(): Int = text.length

    fun countCharactersWithoutSpaces(): Int = text.replace(" ", "").length

    fun countWords(): Int = text.split("\\s+".toRegex()).size

    fun mostFrequentWord(): String {
        val words = text.split("\\s+".toRegex())
        val wordCount = HashMap<String, Int>()
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
        return wordCount.maxByOrNull { it.value }?.key ?: "Нет данных"
    }

    fun searchWord(word: String): Boolean = text.contains(word, ignoreCase = true)
}
