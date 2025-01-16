package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.modeel.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment


class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),// H - matriz
                100.0f, // S - saturação
                100.0f, // V - valor
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }

        view.showCategories(categories)
    }
    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}