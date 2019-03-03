package fm.finch.unitsample

import org.junit.Assert
import org.junit.Test

class NewsMapperTest {

    private val mapper = NewsMapper()

    @Test
    fun mapToNewsViewData() {
        val inputData = listOf(
            News("Super News. Some description and bla bla bla", 1551637424401)
        )

        val outputData = mapper.mapToNewsViewData(inputData)

        Assert.assertEquals(outputData.size, inputData.size)

        outputData.forEach {
            Assert.assertEquals(it.id, "1551637424401")
            Assert.assertEquals(it.title, "Super News")
            Assert.assertEquals(it.description, "Some description and bla bla bla")
            Assert.assertEquals(it.date, "2019-03-03 21:23")
        }
    }
}