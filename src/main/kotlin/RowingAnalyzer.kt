import io.reactivex.disposables.CompositeDisposable

class RowingAnalyzer(
      val applicationComponent: ApplicationComponent
) {
    private val disposables = CompositeDisposable()

    fun init() {
        disposables += applicationComponent.trainingReader.readTraining("training1.csv").subscribe {
            println(it)
        }
    }
}
