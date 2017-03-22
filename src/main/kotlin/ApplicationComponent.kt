interface ApplicationComponent {
    val trainingReader: TrainingReader
}

class ApplicationComponentImpl() : ApplicationComponent {

    override val trainingReader: TrainingReader by lazy {
        TrainingReaderImpl()
    }
}