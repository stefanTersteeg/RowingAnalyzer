import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

infix operator fun CompositeDisposable.plusAssign(subscribe: Disposable?) {
    subscribe?.let { add(it) }
}