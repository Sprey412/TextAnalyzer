import java.io.File
import kotlin.collections.HashMap

class TextAnalyzerAdvanced(filePath: String) : TextAnalyzerBasic(filePath) {

    // Подсчет количества предложений
    fun countSentences(): Int {
        // Разделение текста по точке, восклицательному знаку или вопросительному знаку
        return text.split("[.!?]".toRegex()).size
    }

    // Подсчет частоты употребления введенного слова
    fun wordFrequency(word: String): Int {
        // Разделение текста по пробелам и другим разделителям (например, табуляции, знаки препинания)
        return text.split("\\s+".toRegex()).count { it.equals(word, ignoreCase = true) }
    }

    // Генерация Word Cloud (облачного тега)
    fun generateWordCloud(): Map<String, Int> {
        // Разделение текста по пробелам
        val words = text.split("\\s+".toRegex())
        val wordCount = HashMap<String, Int>()
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
        // Сортировка по частоте и возвращение результата
        return wordCount.toList().sortedByDescending { (_, value) -> value }.toMap()
    }

    // Сохранение результатов в файл
    fun saveResultsToFile(results: String, outputFilePath: String) {
        // Запись результатов в файл
        File(outputFilePath).writeText(results)
    }
}
