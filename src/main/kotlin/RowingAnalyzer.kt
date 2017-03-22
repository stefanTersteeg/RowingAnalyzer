import io.reactivex.disposables.CompositeDisposable
import org.omg.CORBA.portable.UnknownException
import wrapper.RowTraining

class RowingAnalyzer(
      val applicationComponent: ApplicationComponent
) {
    private val disposables = CompositeDisposable()

    fun init() {
        disposables += applicationComponent.trainingReader.readTraining("training1.csv").subscribe { string ->
            try {
                val training =  RowTraining(string)
                println(string)
            } catch (e: UnknownException) {
                println("Invalid input")
                println(string)
            }
        }
    }

}