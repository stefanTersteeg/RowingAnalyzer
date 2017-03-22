import io.reactivex.Observable
import java.io.BufferedReader
import java.io.FileReader

interface TrainingReader {
    fun readTraining(file: String): Observable<String>
}

class TrainingReaderImpl() : TrainingReader {

    override fun readTraining(file: String): Observable<String> {
        return Observable.just(file)
              .map(::FileReader)
              .map(::BufferedReader)
              .flatMap {
                  var line: String? = ""
                  val output = mutableListOf<String>()
                  while (line != null) {
                      if (line.isNotBlank()) {
                          output.add(line)
                      }
                      line = it.readLine()
                  }
                  Observable.fromIterable(output.asIterable())
              }
    }
}